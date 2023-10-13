package org.deltixuat.tests;

import org.deltixuat.enums.TabsEnum;
import org.deltixuat.pages.GridAndChartTab;
import org.deltixuat.pages.MainPage;
import org.deltixuat.utils.RetryAnalyzer;
import org.deltixuat.utils.TestResultListener;
import org.openqa.selenium.ElementNotInteractableException;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(TestResultListener.class)
public class TC5_OrdersGridColumnsVisibilityTest extends BaseTest {
    @DataProvider(name = "FiltersNames")
    public Object[][] getFilterName() {
        return new Object[][]{{"Type"}, {"Second-Value"}, {"Instrument"}, {"Side"}, {"End time"}};
    }

    @Test(dataProvider = "FiltersNames", retryAnalyzer = RetryAnalyzer.class)
    public void testIfColumnDisplayedWhenFilterUnchecked(String nameOfFilter) {
        MainPage mainPage = new MainPage();
        GridAndChartTab gridAndChartTab = new GridAndChartTab();
        mainPage.getMainMenuTabsSelector().openTab(TabsEnum.GRID);
        gridAndChartTab.openFiltersChecklist();
        WebElement checkBox = gridAndChartTab.getCheckbox(nameOfFilter);
        try {
            if (!checkBox.isSelected()) {
                gridAndChartTab.navigateAndClickToFilterCheckbox(nameOfFilter);
                Assert.assertFalse(gridAndChartTab.getGridColumn(nameOfFilter).isDisplayed());
            }
        } catch (ElementNotInteractableException exception) {
            log.error("Checkbox '" + checkBox.getText() + "' is already checked", exception);
        }
    }
}
