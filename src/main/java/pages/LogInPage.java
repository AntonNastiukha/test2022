package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LogInPage {
    private WebDriver driver;

    @FindBy(xpath = "//input [@id ='email']")
    private WebElement emailAddresField;

    @FindBy(xpath = "//input [@id ='passwd']")
    private WebElement passwordField;

    @FindBy(xpath = "//button [@name = 'SubmitLogin']")
    private WebElement logInButton;


    public LogInPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public HomePageLogIn LogInToSystem(String email, String password) {
        emailAddresField.clear();
        emailAddresField.sendKeys(email);
        passwordField.clear();
        passwordField.sendKeys(password);
        logInButton.click();
        return new HomePageLogIn(driver);
    }
}
