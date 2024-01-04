package tatiana_dworieckaja.deltixuat.utils;

import io.qameta.allure.Attachment;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.StandardOpenOption;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Browser {
    private static WebDriver driver;

    private Browser() {
    }

    public static void initDriver() {
        driver = BrowserFactory.createDriver();
    }

    public static WebDriver getDriver() {
        if (driver == null) {
            initDriver();
        }
        return driver;
    }

    public static void close() {
        if (driver != null) {
            driver.quit();
            driver = null;
        }
    }

    public static void saveScreenShot() {
        File screenShots = new File("./test-output/screenshots");

        if (!screenShots.exists()) {
            screenShots.mkdir();
        }
        Date date = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("MM-dd-yyyy-h-mm-ss-SS--a");
        String formattedDate = simpleDateFormat.format(date);
        String fileName = Settings.getBrowserType() + "_" + formattedDate + "screenshot.png";
        byte[] scrFile = takeScreenShot();
        try {
            Files.write(new File("src/test-output/screenshots/" + fileName).toPath(), scrFile, StandardOpenOption.CREATE);
        } catch (IOException e) {
        }
    }

    @Attachment
    public static byte[] takeScreenShot() {
        return ((TakesScreenshot) Browser.getDriver()).getScreenshotAs(OutputType.BYTES);
    }
}