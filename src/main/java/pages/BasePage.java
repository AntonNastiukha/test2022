package pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class BasePage {
    private WebDriver driver;

    @FindBy(xpath = "//input [@id='search_query_top']")
    private WebElement searchInput;

    @FindBy(xpath = "//a [@title ='Log in to your customer account']")
    private WebElement logInButton;

    @FindBy(xpath = "//a [@title = 'Log me out']")
    private WebElement logOutButton;

    @FindBy(xpath = "//a [@title = 'View my shopping cart']")
    private WebElement shoppingCartConteiner;

    @FindBy(xpath = "//a [@title = 'remove this product from my cart']")
    private WebElement removeFromCartButton;


    public BasePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public SearchResultsPage searchItemByText(String itemTextName) {
        searchInput.clear();
        searchInput.sendKeys(itemTextName);
        searchInput.sendKeys(Keys.ENTER);
        return new SearchResultsPage(driver);
    }

    public LogInPage clickToLogINButton() {
        logInButton.click();
        return new LogInPage(driver);
    }

    public void cleanCart() {
        moveToElement();

        try {
            if (removeFromCartButton.isDisplayed()) {
                removeFromCartButton.click();
            }
        } catch (NoSuchElementException e) {

        }
    }


    public void logOut() {
        try {
            if (logOutButton.isDisplayed()) {
                logOutButton.click();
            }
        } catch (NoSuchElementException e) {
        }
    }

    public void moveToElement() {
        new Actions(driver)
                .moveToElement(shoppingCartConteiner)
                .perform();
    }
}
