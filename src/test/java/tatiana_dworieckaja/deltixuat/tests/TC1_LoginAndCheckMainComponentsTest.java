package tatiana_dworieckaja.deltixuat.tests;

import tatiana_dworieckaja.deltixuat.enums.TabsEnum;
import tatiana_dworieckaja.deltixuat.pages.MainPage;
import tatiana_dworieckaja.deltixuat.utils.Browser;
import tatiana_dworieckaja.deltixuat.utils.TestResultListener;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

@Listeners(TestResultListener.class)
public class TC1_LoginAndCheckMainComponentsTest extends BaseTest {

    @Test(groups = "Ready")
    public void testMainPageWithComponentsOpened() {
        MainPage mainPage = new MainPage();
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(mainPage.getSettingsButton().isDisplayed(), mainPage.getSettingsButton() + " is not found");
        Browser.saveScreenShot();
        softAssert.assertTrue(mainPage.getBenchmarkSelector().isDisplayed(), mainPage.getBenchmarkSelector() + " is not found");
        softAssert.assertTrue(mainPage.getMainMenuTabsSelector().getTab(TabsEnum.GRID).isDisplayed(), TabsEnum.GRID + " is not found");
        softAssert.assertTrue(mainPage.getMainMenuTabsSelector().getTab(TabsEnum.HISTOGRAM).isDisplayed(), TabsEnum.HISTOGRAM + " is not found");
        softAssert.assertTrue(mainPage.getMainMenuTabsSelector().getTab(TabsEnum.REPORTS).isDisplayed(), TabsEnum.REPORTS + " is not found");
        softAssert.assertTrue(mainPage.getMainMenuTabsSelector().getTab(TabsEnum.SCATTER_PLOT).isDisplayed(), TabsEnum.SCATTER_PLOT + " is not found");
        softAssert.assertTrue(mainPage.getMainMenuTabsSelector().getTab(TabsEnum.SUMMARY).isDisplayed(), TabsEnum.SUMMARY + " is not found");
        softAssert.assertAll();
    }
}
