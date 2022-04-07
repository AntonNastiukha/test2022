package com.test.ua;

import io.github.bonigarcia.wdm.WebDriverManager;
import jdk.jfr.Description;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.*;

import static java.util.concurrent.TimeUnit.SECONDS;
import static org.testng.Assert.assertTrue;


public class titleTest {
    WebDriver driver;
    String myHomePageName = "https://automationpractice.com";
    String searchInput = "//input [@id='search_query_top']";
    String textToSearch = "T-shirts";
    String priceProductElement = "//div [@class='right-block']//span [@itemprop ='price']";
    String expectedPrice = "16.51";
    String productContainer= "//img [@title='Faded Short Sleeve T-shirts']";
    String addToCardButton = "//a [@class='button ajax_add_to_cart_button btn btn-default']";
    String proceedToCheckOut ="//a [@class='btn btn-default button button-medium']";
    String goToCartButton = "//a [@title='View my shopping cart']";
    String expectedElementInCart = "//td [@class ='cart_unit']//span [contains(text(),'$')]";
    String shoppingCart = "//a [@title = 'View my shopping cart']";
    String removeItemFromCart = "//a [@class = 'ajax_cart_block_remove_link']";

    @BeforeClass
    public void createNewDriver (){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
    }

    @BeforeMethod
    public void openHomePage(){
        driver.get(myHomePageName);
        driver.manage().timeouts().implicitlyWait(5, SECONDS);
        driver.manage().window().maximize();
    }

    @Test
    @Description("Test to check home page")
    public void homePageAsswrt (){
        assertTrue(driver.getTitle().equals("My Store"));
    }

    @Test(dependsOnMethods = "homePageAsswrt")
    @Description("Test to search element and check price")
    public void searchElementAdAssertIt (){
        searchElement();
    }



    @Test(dependsOnMethods = "searchElementAdAssertIt")
    @Description("Test to add item and check it is in the cart")
    public void addToCard (){
        searchElement();
        new Actions(driver)
                .moveToElement(driver.findElement(By.xpath(productContainer)))
                .perform();

        driver.findElement(By.xpath(addToCardButton)).click();
        driver.findElement(By.xpath(proceedToCheckOut)).click();
        driver.findElement(By.xpath(goToCartButton)).click();
        WebElement element = driver.findElement(By.xpath(expectedElementInCart));
        String price = element.getText();
        assertTrue(price.contains(expectedPrice));
    }

    @AfterClass
    public void closeDriver (){
        driver.get(myHomePageName);
        new Actions(driver)
                .moveToElement(driver.findElement(By.xpath(shoppingCart)))
                .perform();
        driver.findElement(By.xpath(removeItemFromCart)).click();
        driver.quit();
    }

    private void searchElement() {
        WebElement InputField = driver.findElement(By.xpath(searchInput));
        InputField.sendKeys(textToSearch);
        InputField.sendKeys(Keys.ENTER);
        WebElement element = driver.findElement(By.xpath(priceProductElement));
        String price = element.getText();
        assertTrue(price.contains(expectedPrice));
    }
}
