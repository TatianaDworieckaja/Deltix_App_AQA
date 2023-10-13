package org.deltixuat.tests;

import org.deltixuat.pages.LoginPage;
import org.deltixuat.utils.Browser;
import org.deltixuat.utils.Settings;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.apache.log4j.Logger;

public class BaseTest {

    protected static Logger log = Logger.getLogger("deltixuat");

    @BeforeTest
    public void initDriver() {
        LoginPage loginPage = new LoginPage();
        loginPage.open();
        log.info("Login page is opened");
        loginPage.login(Settings.getUserName(), Settings.getPassword());
        log.info("Credentials were provided and submitted");
    }


    @AfterTest
    public void cleanUp() {
        Browser.close();
    }

}
