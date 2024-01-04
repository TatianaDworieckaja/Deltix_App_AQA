package tatiana_dworieckaja.deltixuat.tests;

import tatiana_dworieckaja.deltixuat.pages.LoginPage;
import tatiana_dworieckaja.deltixuat.utils.Browser;
import tatiana_dworieckaja.deltixuat.utils.Settings;
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
