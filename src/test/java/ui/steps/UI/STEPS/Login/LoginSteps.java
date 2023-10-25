package ui.steps.UI.STEPS.Login;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import ui.Pages.Login.LoginPage;
import ui.Utilities.ConfigReader;
import ui.Utilities.Driver;

import java.time.Duration;

import static org.asynchttpclient.util.Assertions.assertNotEmpty;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static ui.Utilities.Driver.getDriver;

public class LoginSteps {
   WebDriver driver = Driver.getDriver();
    private LoginPage loginPage = new LoginPage(driver);

    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(6));
    //positive
    @Given("launch application")
    public void launch_application() {
        getDriver().get(ConfigReader.getPropertiesValue("digitalbank.loginurl"));
    }

    @Given("the user entered valid {string} and {string}")
    public void the_user_entered_valid_and(String username, String password) {
loginPage.loginInfo(username, password);
        assertNotEmpty(username, "Username should not be empty");
        assertNotEmpty(password, "Password should not be empty");
    }
    @Given("the user entered invalid {string} and {string}")
    public void the_user_entered_invalid_and(String invalidusername, String invalidpassword) {
       loginPage.loginInfo(invalidusername,invalidpassword);
    }
    @When("the user click on {string} button")
    public void the_user_click_on_button(String signInButton) {
        loginPage.signInButton.click();
    }

    @Then("user should be successfully logged in")
    public void user_should_be_successfully_logged_in() {
String actualUrl = driver.getCurrentUrl();
String expectedUrl = "http://alla.mydevx.com/bank/home";
assertEquals(expectedUrl, actualUrl);
    }

    //negative
    @Then("receives an error message")
    public void receives_an_error_message() {
        String expectedErrorMessage = "Error Invalid credentials or access not granted due to user account status or an existing user session.\n×";
        String actualErrorMessage = loginPage.errorMessage();
        assertEquals(expectedErrorMessage, actualErrorMessage);
    }
}
