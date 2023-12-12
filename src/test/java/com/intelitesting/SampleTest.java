package test.java.com.intelitesting;

import main.java.com.intelitesting.pageEvents.HomePageEvents;
import main.java.com.intelitesting.pageEvents.LoginPageEvents;
import org.testng.annotations.Test;

public class SampleTest extends BaseTest{


    @Test
    public void sampleMethodForEmailEntering(){

        HomePageEvents homePageEvents = new HomePageEvents();
        homePageEvents.clickOnSignInButton();

        LoginPageEvents loginPageEvents = new LoginPageEvents();
        loginPageEvents.verifyLoginPageOpened();
        loginPageEvents.enterEmailId();
    }
}
