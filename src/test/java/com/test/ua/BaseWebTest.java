package com.test.ua;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import pages.BasePage;
import pages.ChekOutWindow;

import static constans.ConstantsData.HOME_PAGE_URL;
import static java.util.concurrent.TimeUnit.SECONDS;

public class BaseWebTest {
    protected WebDriver driver;
    private ChekOutWindow chekOutWindow;

    @BeforeSuite
    public void startTestSuite() {
        WebDriverManager.chromedriver().setup();
    }

    @BeforeClass
    public void openDriver() {
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(5, SECONDS);
        driver.manage().window().maximize();
        driver.get(HOME_PAGE_URL);
    }

    @AfterClass
    public void close() {
        BasePage basePage = new BasePage(driver);
        driver.get(HOME_PAGE_URL);
        basePage.cleanCart();
        basePage.logOut();
        driver.quit();
    }
}
