package firstSelenium;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import static java.util.concurrent.TimeUnit.SECONDS;

public class Main {
    public static void main(String[] args) {
        String addToCardButton = "//li[contains(@class, 'first-item-of-mobile-line')]//a[contains(@title,'T-shirts')]" +
                "/ancestor::div[@class='right-block']/descendant::a[@title='Add to cart']";
        String myPageName = "https://automationpractice.com";
        String moveToElement = "//img[@alt='Faded Short Sleeve T-shirts']";
        String proceedToCheckOut = "//a[@class='btn btn-default button button-medium']";

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get(myPageName);
        driver.manage().window().maximize();
        new Actions(driver)
                .moveToElement(driver.findElement(By.xpath(moveToElement)))
                .perform();
        driver.findElement(By.xpath(addToCardButton)).click();
        driver.manage().timeouts().implicitlyWait(2, SECONDS);
        driver.findElement(By.xpath(proceedToCheckOut)).click();
        driver.manage().timeouts().implicitlyWait(10, SECONDS);
        driver.get(myPageName);

        driver.quit();
    }
}
