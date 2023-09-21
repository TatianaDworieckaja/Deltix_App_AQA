package org.deltixuat.pages;

import org.deltixuat.utils.Browser;
import org.openqa.selenium.By;


public class LoginPage {

    private final static  By USERNAME_INPUT = By.xpath("//input[@formcontrolname= 'username']");
    private final static  By PASSWORD_INPUT = By.xpath("//input[@formcontrolname= 'password']");
    private final static By SUBMIT_BUTTON = By.xpath("//button");


    public void doLogin(String login, String password){
        fillLoginData(login, password);
        submitLoginForm();
    }

    public void fillLoginData(String userName, String password) {
        Browser.getDriver().findElement(USERNAME_INPUT).sendKeys(userName);
        Browser.getDriver().findElement(PASSWORD_INPUT).sendKeys(password);
    }

    public void submitLoginForm() {
        Browser.getDriver().findElement(SUBMIT_BUTTON).click();
    }

}