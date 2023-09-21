package org.deltixuat.tests;

import org.deltixuat.pages.HistogramPage;
import org.deltixuat.pages.LoginPage;
import org.deltixuat.pages.SummaryPage;
import org.deltixuat.utils.Browser;
import org.junit.After;
import org.junit.jupiter.api.AfterAll;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

public class BaseTest {
    protected final static WebDriver driver = Browser.getDriver();
    protected final static LoginPage loginPage = new LoginPage();
    protected final static SummaryPage summaryPage = new SummaryPage();
    protected final static HistogramPage histogramPage = new HistogramPage();
    protected final static Actions actions = new Actions(driver);

    @After
    public void cleanUp(){
        Browser.close();
    }

}
