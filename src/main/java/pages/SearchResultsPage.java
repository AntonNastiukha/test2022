package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

public class SearchResultsPage extends BasePage {

    private WebDriver driver;


    @FindBy(xpath = "//div [@class='right-block']//span [@itemprop ='price']")
    private WebElement productPrice;

    @FindBy(xpath = "//img [@title='Faded Short Sleeve T-shirts']")
    private WebElement productContainer;

    @FindBy(xpath = "//a [@class='button ajax_add_to_cart_button btn btn-default']")
    private WebElement addToCardButton;

    public SearchResultsPage(WebDriver driver) {
        super(driver);
        this.driver=driver;
    }

    public String getItemPrice () {
        return productPrice.getText();
    }

    public void moveToElement(){
        new Actions(driver)
                .moveToElement(productContainer)
                .perform();
    }

    public ChekOutWindow clickToAddButton(){
        addToCardButton.click();
        return new ChekOutWindow(driver);
    }
}
