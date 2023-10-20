package org.deltixuat.tests;

import org.deltixuat.enums.TabsEnum;
import org.deltixuat.pages.MainPage;
import org.deltixuat.pages.ScatterplotTab;
import org.deltixuat.utils.RetryAnalyzer;
import org.deltixuat.utils.TestResultListener;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.util.Collection;

@Listeners(TestResultListener.class)
public class TC3_CheckAttributesAndIntervalsTest extends BaseTest {

    @Test(retryAnalyzer = RetryAnalyzer.class)
    public void testScatterPlotWhenAttributesChanged() {
        MainPage mainPage = new MainPage();
        SoftAssert softAssert = new SoftAssert();
        mainPage.getMainMenuTabsSelector().openTab(TabsEnum.SCATTER_PLOT);
        ScatterplotTab scatterplotTab = new ScatterplotTab();
        WebElement intervalsField = scatterplotTab.getAttributeField("Intervals");
        scatterplotTab.navigateAndClickToElement(intervalsField);
        WebElement intervalsValue = scatterplotTab.chooseValueFromDropDownList("10");
        scatterplotTab.navigateAndClickToElement(intervalsValue);
        softAssert.assertTrue(scatterplotTab.getAttributeFieldInput("Intervals").getAttribute("title").matches("10"), "Interval value is incorrect.");

        WebElement xAttributeField = scatterplotTab.getAttributeField("X Attribute");
        scatterplotTab.navigateAndClickToElement(xAttributeField);
        WebElement xAttributeValue = scatterplotTab.chooseValueFromDropDownList("Exec size");
        scatterplotTab.navigateAndClickToElement(xAttributeValue);
        Collection<WebElement> scatterElements1 = scatterplotTab.getAllScatterElements();
        softAssert.assertTrue(scatterplotTab.getAttributeFieldInput("X Attribute").getAttribute("title").contains("Exec size"), "Displayed value of x attribute field is incorrect.");
        softAssert.assertTrue(scatterplotTab.getAxis("x").getText().matches("Exec size"), "The name of x axis is incorrect");
        softAssert.assertTrue(scatterElements1.size() > 0, "No scatter elements are displayed on ScatterPlot");

        WebElement yAttributeField = scatterplotTab.getAttributeField("Y Attribute");
        scatterplotTab.navigateAndClickToElement(yAttributeField);
        WebElement yAttributeValue = scatterplotTab.chooseValueFromDropDownList("Realized market impact");
        scatterplotTab.navigateAndClickToElement(yAttributeValue);
        Collection<WebElement> scatterElements2 = scatterplotTab.getAllScatterElements();
        softAssert.assertTrue(scatterplotTab.getAttributeFieldInput("Y Attribute").getAttribute("title").contains("Realized market impact"), "Displayed value of y attribute field is incorrect.");
        softAssert.assertTrue(scatterplotTab.getAxis("y").getText().matches("Realized market impact"), "The name of y axis is incorrect");
        softAssert.assertTrue(scatterElements2.size() > 0, "No scatter elements are displayed on ScatterPlot");
        softAssert.assertAll();
    }
}