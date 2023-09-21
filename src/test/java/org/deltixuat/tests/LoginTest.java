package org.deltixuat.tests;

import org.deltixuat.utils.WebProperties;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class LoginTest extends BaseTest{
    @Test
    public void doLoginTest() throws InterruptedException {
        driver.get(WebProperties.getBaseUrl());
        loginPage.doLogin("selenium_chrome", "Axa@Demo");
        Thread.sleep(5000);
        assertEquals("Advanced eXecution Analytics", driver.getTitle());
    }


}
