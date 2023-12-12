package main.java.com.intelitesting.pageEvents;

import main.java.com.intelitesting.pageObjects.LoginPageElements;
import main.java.com.intelitesting.utils.ElementFetch;
import org.testng.Assert;

public class LoginPageEvents {

    public void verifyLoginPageOpened() {
        ElementFetch elementFetch = new ElementFetch();
        Assert.assertTrue(elementFetch.getWebElements("XPATH", LoginPageElements.loginText).size()>0, "Login");
       //
    }

    public void enterEmailId(){
        ElementFetch elementFetch = new ElementFetch();
        elementFetch.getWebElement("ID",LoginPageElements.emailInput).sendKeys("brunokitas7@gmail.com");

    }
}
