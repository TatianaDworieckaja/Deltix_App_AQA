package tatiana_dworieckaja.deltixuat.pages;

import tatiana_dworieckaja.deltixuat.utils.Browser;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import java.util.Collection;

public class ScatterplotTab extends BasePage {

    private static final By SCATTER_PLOT = By.xpath("//div[@class = 'scatter-plot-container']");
    private static final By ATTRIBUTES_DROPDOWN = By.xpath("//ul[@class = 'autocomplete-dropdown-menu']");
    private static final String ATTRIBUTE_FIELD_PATTERN = "//div[text()='%s']/following-sibling::*";
    private static final String ATTRIBUTE_FIELD_INPUT = "//child::input";
    private String VALUE_FROM_DROPDOWN_PATTERN = "//li[@title = '%s']";
    private String LABEL_LOCATOR_PATTERN = "//*[@class='scatter-plot-" + "%s" + "-label']";
    private static final By SCATTER_ELEMENTS_LOCATOR = By.xpath("//*[@class='scatter_element']");
    private static final By LOADER = By.xpath("//div[@class='flex-1']//div[@class ='loader']");

    public ScatterplotTab() {
        waitForElement(SCATTER_PLOT);
    }

    public WebElement getAttributeField(String attribute) {
        return getElement(getLocator(ATTRIBUTE_FIELD_PATTERN, attribute));
    }

    public WebElement getAttributeFieldInput(String attribute) {
        return getElement(By.xpath(getLocator(ATTRIBUTE_FIELD_PATTERN, attribute) + ATTRIBUTE_FIELD_INPUT));
    }

    public void navigateAndClickToElement(WebElement element) {
        Actions actions = new Actions(Browser.getDriver());
        actions.moveToElement(element);
        actions.click().build().perform();
    }

    public WebElement chooseValueFromDropDownList(String value) {
        return getElement(ATTRIBUTES_DROPDOWN).findElement(By.xpath(String.format(VALUE_FROM_DROPDOWN_PATTERN, value)));
    }

    public WebElement getAxis(String axis) {
        return getElement(getLocator(LABEL_LOCATOR_PATTERN, axis));
    }

    public Collection<WebElement> getAllScatterElements() {
        return getElements(SCATTER_ELEMENTS_LOCATOR, 1);
    }

}
