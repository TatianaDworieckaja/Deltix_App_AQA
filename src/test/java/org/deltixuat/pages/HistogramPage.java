package org.deltixuat.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.support.FindBy;

public class HistogramPage {

    private  final  static By HISTOGRAM_TAB  = By.xpath("//div[@title='Histogram']");
    private  final  static By HISTOGRAM = By.xpath("//div[@class = 'histogram-container']");
    private  final  static By ATTRIBUTE_BTN = By.xpath("//*[@class = 'autocomplete-caret-btn']");
    private  final  static By INTERVAL_DROP_DOWN = By.xpath ("//div[.='Interval']//*[@class = 'autocomplete-container']");

}
