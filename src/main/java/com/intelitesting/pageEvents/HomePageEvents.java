package main.java.com.intelitesting.pageEvents;

import main.java.com.intelitesting.pageObjects.HomePageElements;
import main.java.com.intelitesting.utils.ElementFetch;

public class HomePageEvents {

    public void clickOnSignInButton() {
        ElementFetch elementFetch = new ElementFetch();
        elementFetch.getWebElement("XPATH", HomePageElements.signInButton).click();

    }
}
