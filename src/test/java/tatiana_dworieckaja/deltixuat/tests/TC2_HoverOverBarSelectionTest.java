package tatiana_dworieckaja.deltixuat.tests;

import tatiana_dworieckaja.deltixuat.enums.TabsEnum;
import tatiana_dworieckaja.deltixuat.pages.HistogramTab;
import tatiana_dworieckaja.deltixuat.pages.MainPage;
import tatiana_dworieckaja.deltixuat.utils.Browser;
import tatiana_dworieckaja.deltixuat.utils.RetryAnalyzer;
import tatiana_dworieckaja.deltixuat.utils.TestResultListener;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.util.Collection;

@Listeners(TestResultListener.class)
public class TC2_HoverOverBarSelectionTest extends BaseTest {

    private String AVG = "Avg fill price: [\\[,\\(]\\d+\\.\\d+, \\d+\\.\\d+[),\\]]";
    private String COUNT = "Count: \\d+";

    @Test(retryAnalyzer = RetryAnalyzer.class)
    public void testBordersAndCountWhenHoverOverBar() {
        MainPage mainPage = new MainPage();
        mainPage.getMainMenuTabsSelector().openTab(TabsEnum.HISTOGRAM);
        HistogramTab histogramTab = new HistogramTab();
        Collection<WebElement> barContainers = histogramTab.getAllBarContainers();
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(barContainers.size() > 0, "No barContainer found");
        barContainers.forEach(barContainer -> {
            WebElement bar = histogramTab.getBar(barContainer);
            histogramTab.navigateToElement(bar);
            String borders = histogramTab.getTooltipBorders();
            String count = histogramTab.getTooltipCount();
            Assert.assertTrue(borders.matches(AVG), "Average fill price borders type is not correct");
            Browser.saveScreenShot();
            Assert.assertTrue(count.matches(COUNT), "Count borders type is not correct");
        });
        softAssert.assertAll();
    }
}
