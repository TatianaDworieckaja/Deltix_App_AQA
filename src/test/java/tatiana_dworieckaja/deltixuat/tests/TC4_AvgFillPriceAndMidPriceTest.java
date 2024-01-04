package tatiana_dworieckaja.deltixuat.tests;

import tatiana_dworieckaja.deltixuat.enums.GridAndChartHeaderEnum;
import tatiana_dworieckaja.deltixuat.enums.SortOrderEnum;
import tatiana_dworieckaja.deltixuat.enums.TabsEnum;
import tatiana_dworieckaja.deltixuat.pages.GridAndChartTab;
import tatiana_dworieckaja.deltixuat.pages.MainPage;
import tatiana_dworieckaja.deltixuat.utils.TestResultListener;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Listeners(TestResultListener.class)
public class TC4_AvgFillPriceAndMidPriceTest extends BaseTest {

    @Test
    public void testSortingOfDataInColumn() {
        MainPage mainPage = new MainPage();
        GridAndChartTab gridAndChartTab = new GridAndChartTab();
        mainPage.getMainMenuTabsSelector().openTab(TabsEnum.GRID);
        gridAndChartTab.getOrdersGrid().sortBy(GridAndChartHeaderEnum.END_TIME, SortOrderEnum.DESC);

        List<String> actualEndTimeColumnData = gridAndChartTab.getOrdersGrid().getColumnCellsText(GridAndChartHeaderEnum.END_TIME);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/dd/yyyy HH:mm:ss");
        for (int i = 0; i < actualEndTimeColumnData.size(); i++) {
            if (i > 0) {
                LocalDateTime currentRowDate = LocalDateTime.parse(actualEndTimeColumnData.get(i).trim(), formatter);
                LocalDateTime previousRowDate = LocalDateTime.parse(actualEndTimeColumnData.get(i - 1).trim(), formatter);
                Assert.assertTrue(currentRowDate.isBefore(previousRowDate), actualEndTimeColumnData.get(i - 1) + "<" + actualEndTimeColumnData.get(i) + "Row: " + i);
            }
        }
        gridAndChartTab.getOrdersGrid().sortBy(GridAndChartHeaderEnum.END_TIME, SortOrderEnum.NONE);
    }
}
