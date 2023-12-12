package test.java.com.intelitesting;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.Markup;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import main.java.com.intelitesting.utils.Constants;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.ITestResult;
import org.testng.annotations.*;

import java.io.File;
import java.lang.reflect.Method;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

public class BaseTest {

    public static WebDriver driver;

    public ExtentSparkReporter spark;

    public static ExtentReports extent;
    public static ExtentTest logger;


//    @BeforeTest
//    public void beforeTestMethod() {
//        spark = new ExtentSparkReporter(System.getProperty(("user.dir") + File.separator + "reports" + "AutomationReportSpark.html"));
//        spark.config().setEncoding("utf-8");
//        spark.config().setDocumentTitle("Automation Report");
//        spark.config().setTheme(Theme.DARK);
//        extent = new ExtentReports();
//        extent.attachReporter(spark);
//        extent.setSystemInfo("Automation Tester", "Bruno Cohen");
//    }

    @BeforeMethod
    @Parameters(value={"browserName"})
    public void beforeMethodMethod(String browserName, Method testMethod) throws Exception {
        //logger = extent.createTest(testMethod.getName());
        setupDriver("chrome");
        if (browserName.equalsIgnoreCase("chrome") || browserName.equalsIgnoreCase("firefox") || browserName.equalsIgnoreCase("htmlunit")) {
            driver.manage().window().maximize();
            driver.get(Constants.url);
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        } else {
            System.out.println("Its APPIUM driver");
        }
    }

    @AfterMethod
    public void afterMethod(ITestResult result){
        if (result.getStatus()==ITestResult.SUCCESS){
            String methodName = result.getMethod().getMethodName();
            String logText = "Test Case " + methodName + " Passed";
            Markup m = MarkupHelper.createLabel(logText, ExtentColor.GREEN);
            logger.log(Status.PASS, m);
        } else if (result.getStatus()==ITestResult.FAILURE) {
            String methodName = result.getMethod().getMethodName();
            String logText = "Test Case " + methodName + " Failed";
            Markup m = MarkupHelper.createLabel(logText, ExtentColor.RED);
            logger.log(Status.FAIL, m);
        }
        driver.quit();
    }


//    @AfterTest
//    public void afterTestMethod(){
//        extent.flush();
//    }

    public void setupDriver(String browserName) throws Exception {
        if (browserName.equalsIgnoreCase("chrome")){
            ChromeOptions opt = new ChromeOptions();
            //opt.addArguments("--headless=new");
            driver = new ChromeDriver(opt);
        } else if(browserName.equalsIgnoreCase("firefox")){
            driver = new FirefoxDriver();
        } else if(browserName.equalsIgnoreCase("mobile")){
            URL url = new URL("http:127.0.0.0:4723");
            DesiredCapabilities caps = new DesiredCapabilities();
            caps.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
            caps.setCapability(MobileCapabilityType.DEVICE_NAME, "");
            caps.setCapability(MobileCapabilityType.UDID, "");
            caps.setCapability(MobileCapabilityType.PLATFORM_VERSION, "");
            caps.setCapability(MobileCapabilityType.AUTOMATION_NAME, "");
            driver = new AppiumDriver(url, caps);
        } else if(browserName.equalsIgnoreCase("htmlUnitDriver")) {
            driver = new HtmlUnitDriver();
        }else {
            driver = new ChromeDriver();
        }
    }
}
