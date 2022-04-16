package com.test.ua;

import io.qameta.allure.Description;
import org.testng.annotations.Test;
import pages.HomePage;

import static constans.ConstantsData.EXPECTED_PRICE;
import static constans.ConstantsData.SEARCH_ITEM;
import static org.testng.Assert.assertTrue;

public class SearchElementAndCheckPriceTest extends BaseWebTest {

    @Test(priority = 2)
    @Description("Test to search element and check price")
    public void searchElementAdAssertIt() {
        assertTrue(new HomePage(driver)
                        .searchItemByText(SEARCH_ITEM)
                        .getItemPrice()
                        .contains(EXPECTED_PRICE),
                "Expected price is different");
    }
}
