package org.deltixuat.pages;

import org.openqa.selenium.By;

public class ScatterplotPage {
    private static final By SCATTER_PLOT = By.xpath("//div[@class = 'scatter-plot-container']");
    private static final By X_ATTRIBUTE = By.xpath("//div[.= 'X Attribute']//button");
    private static final By Y_ATTRIBUTE = By.xpath("//div[.= 'Y Attribute']//button");
    private static final By INTERVALS = By.xpath("//div[.='Intervals']//*[@class = 'autocomplete-container']");
}
