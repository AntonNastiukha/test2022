package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ChekOutWindow {

    WebDriver driver;

    @FindBy(xpath = "//a [@class='btn btn-default button button-medium']")
    private WebElement proceedToCheckOut;

    public ChekOutWindow(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public CartPage clikToProceedButton() {
        proceedToCheckOut.click();
        return new CartPage(driver);
    }
}
