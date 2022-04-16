package com.test.ua;

import io.qameta.allure.Description;
import org.testng.annotations.Test;
import pages.CartPage;
import pages.ChekOutWindow;
import pages.HomePage;
import pages.SearchResultsPage;

import static constans.ConstantsData.EXPECTED_PRICE;
import static constans.ConstantsData.SEARCH_ITEM;
import static org.testng.Assert.assertTrue;

public class AddItemAndCheckCartTest extends BaseWebTest {
    @Test(priority = 3)
    @Description("Test to add item and check it is in the cart")
    public void addToCard() {
        SearchResultsPage searchResultsPage = new HomePage(driver).searchItemByText(SEARCH_ITEM);
        searchResultsPage.moveToElement();
        ChekOutWindow chekOutWindow = searchResultsPage.clickToAddButton();
        CartPage cartPage = chekOutWindow.clikToProceedButton();

        assertTrue(cartPage.getTextFromItem().contains(EXPECTED_PRICE),
                "There isn't item with expected price in the cart");
    }
}
