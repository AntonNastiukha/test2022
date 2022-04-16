package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePageLogIn extends BasePage {

    WebDriver driver;

    @FindBy(xpath = "//span[contains(text(),'Fynjy Anton')]")
    private WebElement logedInMessage;


    public HomePageLogIn(WebDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    public String getLogedInmessageText(){
       return logedInMessage.getText();
    }
}
