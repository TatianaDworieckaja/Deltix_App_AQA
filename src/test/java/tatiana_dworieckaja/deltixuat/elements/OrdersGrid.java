package tatiana_dworieckaja.deltixuat.elements;

import tatiana_dworieckaja.deltixuat.enums.GridAndChartHeaderEnum;
import tatiana_dworieckaja.deltixuat.enums.SortOrderEnum;
import tatiana_dworieckaja.deltixuat.pages.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.stream.Collectors;

public class OrdersGrid extends BasePage {

    public static final int MINIMUM_NUMBER_OF_ELEMENTS = 33;
    private static final By TABLE_LOAD_INDICATOR_LOCATOR = By.xpath("//*[@class='ag-loading-text']");
    public static final String ROW_ELEMENT = "./../..";
    public static final String ROW_INDEX_ATTRIBUTE = "row-index";
    private static final String GRID_HEADER_PATTERN = "//div[@class = 'ag-header-row']//div[@col-id = '%s']";
    private static final String SORT_ORDER_PATTERN = ".//span[@ref='%s']";
    private static final String GRID_CELL_PATTERN = "//div[@role='gridcell'][@col-id='%s']/span";

    public OrdersGrid() {
        waitForElement(TABLE_LOAD_INDICATOR_LOCATOR);
    }

    public void sortBy(GridAndChartHeaderEnum gridAndChartHeaderEnum, SortOrderEnum sortOrderEnum) {
        WebElement sortableHeader = getElement(getLocator(GRID_HEADER_PATTERN, gridAndChartHeaderEnum.getColumnId()));
        while (!sortableHeader.findElement(getLocator(SORT_ORDER_PATTERN, sortOrderEnum.getOrder())).isDisplayed()) {
            sortableHeader.click();
            waitForElementNotExist(TABLE_LOAD_INDICATOR_LOCATOR);
        }
    }

    public List<String> getColumnCellsText(GridAndChartHeaderEnum gridAndChartHeaderEnum) {
        Collection<WebElement> cells = getElements(getLocator(GRID_CELL_PATTERN, gridAndChartHeaderEnum.getColumnId()), MINIMUM_NUMBER_OF_ELEMENTS);
        Map<Integer, String> rows = new TreeMap<>();
        cells.forEach(cell -> {
            if (cell.isDisplayed()) {
                String index = cell.findElement(By.xpath(ROW_ELEMENT)).getAttribute(ROW_INDEX_ATTRIBUTE);
                rows.put(Integer.valueOf(index), cell.getText());
            }
        });
        return rows.values().stream().map(String::strip).collect(Collectors.toList());
    }

}
