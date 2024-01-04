package tatiana_dworieckaja.deltixuat.pages;

import tatiana_dworieckaja.deltixuat.elements.OrdersGrid;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class GridAndChartTab extends BasePage {

    private final static By FILTERS_BUTTON = By.xpath("//button[@title = 'Filters']");
    private final static By FILTERS_CHECKLIST = By.xpath("//div[@class = 'ag-column-tool-panel-columns']");
    private final static String FILTERS_CHECKLIST_CHECKBOX_PATTERN = "//div[@class = 'ag-column-tool-panel-columns']//span[@title = '%s']/preceding-sibling::*";
    private final static String GRID_COLUMN_PATTERN = "//span[@class='ag-header-cell-text'][text()='%s']";
    private OrdersGrid ordersGrid;

    public GridAndChartTab() {
        ordersGrid = new OrdersGrid();
    }

    public OrdersGrid getOrdersGrid() {
        return ordersGrid;
    }

    public void openFiltersChecklist() {
        navigateAndClickElement(getElement(FILTERS_BUTTON));
    }

    public void navigateAndClickToFilterCheckbox(String filterName) {
        navigateAndClickElement(getCheckbox(filterName));
    }

    public WebElement getCheckbox(String filterName) {
        WebElement checklist = getElement(FILTERS_CHECKLIST);
        WebElement checkbox = checklist.findElement(getLocator(FILTERS_CHECKLIST_CHECKBOX_PATTERN, filterName));
        return checkbox;
    }

    public WebElement getGridColumn(String columnName) {
        return getElement(getLocator(GRID_COLUMN_PATTERN, "columnName"));
    }
}

