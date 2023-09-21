package org.deltixuat.pages;

import org.openqa.selenium.By;

public class GridPage {
    private final static By GRID = By.xpath("//div[@class = 'flex-1 post-trade__grid post-trade__grid_fullscreen']");
    private final static By CELL_ID = By.xpath("//div[@col-id = 'orderId']");
    private final static By PLUS_LINES = By.xpath("//span[.='+ Lines']");
}
