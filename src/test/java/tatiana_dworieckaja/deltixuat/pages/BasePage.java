package tatiana_dworieckaja.deltixuat.pages;
import tatiana_dworieckaja.deltixuat.utils.Browser;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.Collection;

public class BasePage {
    public final static int WAIT_TIMEOUT_IN_SECONDS = 20;

    protected void waitForElement(By locator) {
        WebDriverWait wait = new WebDriverWait(Browser.getDriver(), Duration.ofSeconds(WAIT_TIMEOUT_IN_SECONDS));
        wait.until(ExpectedConditions.presenceOfElementLocated(locator));
    }

    protected void waitForElementIsNotDisplayed(By loaderLocator) {
        WebDriverWait wait = new WebDriverWait(Browser.getDriver(), Duration.ofSeconds(WAIT_TIMEOUT_IN_SECONDS));
        wait.until(ExpectedConditions.invisibilityOfElementLocated(loaderLocator));
    }

    protected void waitForElementNotExist(By locator) {
        WebDriverWait wait = new WebDriverWait(Browser.getDriver(), Duration.ofSeconds(WAIT_TIMEOUT_IN_SECONDS));
        wait.until(webDriver -> webDriver.findElements(locator).size() == 0);
    }

    protected void waitForElements(By locator, int minimum) {
        WebDriverWait wait = new WebDriverWait(Browser.getDriver(), Duration.ofSeconds(WAIT_TIMEOUT_IN_SECONDS));
        wait.until(webDriver -> webDriver.findElements(locator).size() >= minimum);

    }

    public WebElement getElement(By locator) {
        waitForElement(locator);
        return Browser.getDriver().findElement(locator);
    }

    public Collection<WebElement> getElements(By locator, int count) {
        waitForElements(locator, count);
        return Browser.getDriver().findElements(locator);
    }

    public By getLocator(String pattern, String title) {
        return By.xpath(String.format(pattern, title));
    }

    public void navigateToElement(WebElement element) {
        Actions actions = new Actions(Browser.getDriver());
        actions.moveToElement(element);
        actions.build().perform();
    }

    public void navigateAndClickElement(WebElement element, int xOffset, int yOffset) {
        Actions actions = new Actions(Browser.getDriver());
        actions.moveToElement(element, xOffset, yOffset);
        actions.click().build().perform();
    }

    public void navigateAndClickElement(WebElement element) {
        Actions actions = new Actions(Browser.getDriver());
        actions.moveToElement(element);
        actions.click().build().perform();
    }
}
