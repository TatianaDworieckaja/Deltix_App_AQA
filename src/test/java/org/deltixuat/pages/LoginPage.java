package org.deltixuat.pages;

import org.deltixuat.utils.Browser;
import org.deltixuat.utils.Settings;
import org.openqa.selenium.By;

public class LoginPage extends BasePage {

    private static final By LOGIN_LOCATOR = By.xpath("//input[@formcontrolname= 'username']");
    private static final By PASSWORD_LOCATOR = By.xpath("//input[@formcontrolname= 'password']");
    private static final By SUBMIT_BUTTON_LOCATOR = By.xpath("//button");

    public void login(String userName, String password) {
        getElement(LOGIN_LOCATOR).sendKeys(userName);
        getElement(PASSWORD_LOCATOR).sendKeys(password);
        getElement(SUBMIT_BUTTON_LOCATOR).submit();
    }

    public void open() {
        Browser.getDriver().get(Settings.getBaseUrl() + "/login");
    }

}