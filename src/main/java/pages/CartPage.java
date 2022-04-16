package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CartPage {
    @FindBy(xpath = "//td [@class ='cart_unit']//span [contains(text(),'$')]")
    private WebElement expectedElementInCart;

    public CartPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }


    public String getTextFromItem() {
        return expectedElementInCart.getText();
    }
}
