package org.deltixuat.utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.time.Duration;
public class BrowserFactory {
    private static WebDriver driver;

      public static WebDriver createDriver() {

          if (WebProperties.getBrowserType().equals("CHROME")) {
              System.setProperty("webdriver.chrome.driver", WebProperties.getDriverLocation());
              driver = new ChromeDriver();
          }
          else if(WebProperties.getBrowserType().equals("FIREFOX")){
              System.setProperty("webdriver.geckodriver.driver", WebProperties.getDriverLocation());
                driver = new FirefoxDriver();
          }
          else{
              throw new IllegalStateException("Browser Not Supported: ");
          }

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        return driver;
    }
}
