package org.deltixuat.pages;

import org.deltixuat.elements.MainMenuTabsSelector;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class MainPage extends BasePage {

    private MainMenuTabsSelector mainMenuTabsSelector;
    public static final By SIGN_OUT_BUTTON_LOCATOR = By.xpath("//*[@title='Sign Out']");
    public static final By LOADER_LOCATOR = By.xpath("//*[@class='loader']");
    private static final By SETTINGS_BTN = By.xpath("//a[@title = 'Settings']");
    private static final By BENCHMARK_SELECTOR = By.xpath("//*[@title='Benchmark QWAP']");


    public MainPage() {
        waitForElement(SIGN_OUT_BUTTON_LOCATOR);
        waitForElementIsNotDisplayed(LOADER_LOCATOR);
        mainMenuTabsSelector = new MainMenuTabsSelector();
    }

    public MainMenuTabsSelector getMainMenuTabsSelector() {
        return mainMenuTabsSelector;
    }

    public WebElement getSettingsButton() {
        return getElement(SETTINGS_BTN);
    }

    public WebElement getBenchmarkSelector() {
        return getElement(BENCHMARK_SELECTOR);
    }


}
