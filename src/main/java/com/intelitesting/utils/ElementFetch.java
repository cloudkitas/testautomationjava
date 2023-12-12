package main.java.com.intelitesting.utils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import test.java.com.intelitesting.BaseTest;

import java.util.List;

public class ElementFetch {

    public WebElement getWebElement(String identifierType, String identifierValue ) {
        switch (identifierType) {
            case "ID":
                return BaseTest.driver.findElement(By.id(identifierValue));
            case "CSS":
                return BaseTest.driver.findElement(By.id(identifierValue));
            case "TAGNAME":
                return BaseTest.driver.findElement(By.id(identifierValue));
            case "XPATH":
                return BaseTest.driver.findElement(By.id(identifierValue));
            default:
                return null;
        }
    }

    public List<WebElement> getWebElements(String identifierType, String identifierValue ) {
        switch (identifierType) {
            case "ID":
                return BaseTest.driver.findElements(By.id(identifierValue));
            case "CSS":
                return BaseTest.driver.findElements(By.id(identifierValue));
            case "TAGNAME":
                return BaseTest.driver.findElements(By.id(identifierValue));
            case "XPATH":
                return BaseTest.driver.findElements(By.id(identifierValue));
            default:
                return null;
        }
    }
}
