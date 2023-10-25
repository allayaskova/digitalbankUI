package ui.steps.UI.STEPS.Login;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import ui.Pages.Login.LoginPage;
import ui.Utilities.Driver;

import java.time.Duration;

public class RememberMeBtnSteps {
    WebDriver driver = Driver.getDriver();
    private LoginPage loginPage = new LoginPage(driver);

    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(2));
    @Given("the user is on main page with url {string}")
    public void the_user_on_main_page(String url) {
        driver.get(url);
    }
    @When("the user fills out his credentials {string} and {string}")
    public void the_user_fills_out_his_credentials_and(String username, String password) {
        loginPage.getUsernameTextBox().sendKeys(username);
        loginPage.getPasswordTextBox().sendKeys(password);
    }
    @When("the user clicks on {string} button")
    public void the_user_clicks_on_button(String string) {
    loginPage.rememberMeCheckBox.click();


    }
@Then("the user click Sign In button and credentials should be saved")
public void the_user_click_sign_in_button_and_credentials_should_be_saved() {
    loginPage.signInButton.click();
}
}
