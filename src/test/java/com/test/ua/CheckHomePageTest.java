package com.test.ua;

import io.qameta.allure.Description;
import org.testng.annotations.Test;

import static org.testng.Assert.assertTrue;

public class CheckHomePageTest extends BaseWebTest {

    @Test(priority = 1)
    @Description("Test to check home page")
    public void homePageAssert() {
        assertTrue(driver.getTitle().equals("My Store"),
                "It's not expected page");
    }
}
