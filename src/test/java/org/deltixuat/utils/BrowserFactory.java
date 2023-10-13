package org.deltixuat.utils;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

public class BrowserFactory {

    private static WebDriver driver;
    private static Logger log = Logger.getLogger("BrowserFactory");

    public static WebDriver createDriver() {

        if (Settings.getBrowserType().equals("CHROME")) {
            System.setProperty("webdriver.chrome.driver", Settings.getDriverLocation());
            driver = new ChromeDriver();
        } else if (Settings.getBrowserType().equals("FIREFOX")) {
            System.setProperty("webdriver.geckodriver.driver", Settings.getDriverLocation());
            driver = new FirefoxDriver();
        } else if (Settings.getBrowserType().equals("RemoteWebDriver")) {
            try {
                FirefoxOptions firefoxOptions = new FirefoxOptions();
                driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), firefoxOptions);
            } catch (MalformedURLException e) {
                log.error("URL is not supported" + e.getMessage());
            }
        } else {
            throw new IllegalStateException("Browser Not Supported: ");
        }

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        return driver;
    }
}
