package ui.Pages.Login;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class LoginPage {

    private WebDriver driver;
    public LoginPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//img[@src='/bank/images/logo.png']")
    WebElement digitalBanksSignInHomeButton;

    @FindBy(xpath = "//form/div[1]/label")
    WebElement userNameTitle;

    @FindBy(xpath = "//form/div[2]/label")
    WebElement passwordTitle;

    @FindBy(xpath = "//input[@name = 'username']")
    WebElement usernameTextBox;

    @FindBy(xpath = "//input[@name = 'password']")
    WebElement passwordTextBox;

    @FindBy(xpath = "//input[@name = 'remember-me']")
    public WebElement rememberMeCheckBox;

    @FindBy(xpath = "//button[@type = 'submit']")
    public
    WebElement signInButton;

    @FindBy(xpath = "//div[@class='sufee-alert alert with-close alert-danger alert-dismissible fade show']")
    WebElement errorMessage;
    @FindBy(xpath = "//a[@href='/bank/signup']")
    WebElement signUpHereLink;

    public WebElement getUsernameTextBox() {
        return usernameTextBox;
    }

    public WebElement getPasswordTextBox() {
        return passwordTextBox;
    }
//create action methods

    public void loginInfo(String username, String password){
        usernameTextBox.sendKeys(username);
        passwordTextBox.sendKeys(password);
    }

    public void clickToSignIn(){
        signUpHereLink.click();
    }
    public String errorMessage() {
        return errorMessage.getText();
    }
}
