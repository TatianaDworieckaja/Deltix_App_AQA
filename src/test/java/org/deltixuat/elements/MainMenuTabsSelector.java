package org.deltixuat.elements;

import org.deltixuat.enums.TabsEnum;
import org.deltixuat.pages.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class MainMenuTabsSelector extends BasePage {
    private static final String MENU_TAB_PATTERN = "//div[@title='%s']";

    public void openTab(TabsEnum tabsEnum) {
        getTab(tabsEnum).click();
    }

    private By getTabLocator(TabsEnum tabsEnum) {
        return getLocator(MENU_TAB_PATTERN, tabsEnum.getTitle());
    }

    public WebElement getTab(TabsEnum tabsEnum) {
        return getElement(getTabLocator(tabsEnum));
    }
}
