package tatiana_dworieckaja.deltixuat.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class HistogramTab extends BasePage {
    public static final By HISTOGRAM = By.xpath("//div[@class = 'histogram-container']");
    public static final By ATTRIBUTE_BTN = By.xpath("//*[@class = 'autocomplete-caret-btn']");
    public static final By INTERVAL_DROP_DOWN = By.xpath("//div[.='Interval']//*[@class = 'autocomplete-container']");
    public static final By BAR_CONTAINERS = By.xpath("//*[@class = 'bar_container']");

    private By tooltipBordersLocator = By.xpath("//*[@class = 'tooltip']/div[1]");
    private By tooltipCountLocator = By.xpath("//*[@class = 'tooltip']/div[2]");
    private static final By BAR = By.xpath("./*[@class = 'bar']");
    private static final By tooltipLocator = By.xpath("//*[@class = 'tooltip']");

    public HistogramTab() {
        waitForElement(HISTOGRAM);
    }

    public List<WebElement> getAllBarContainers() {
        List<WebElement> list = new ArrayList<>(getElements(BAR_CONTAINERS, 1));
        return list;
    }

    public WebElement getBar(WebElement rootBarContainer) {
        return rootBarContainer.findElement(BAR);
    }

    public String getTooltipBorders() {
        return getElement(tooltipLocator).findElement(tooltipBordersLocator).getText();
    }

    public String getTooltipCount() {
        return getElement(tooltipLocator).findElement(tooltipCountLocator).getText();
    }

}
