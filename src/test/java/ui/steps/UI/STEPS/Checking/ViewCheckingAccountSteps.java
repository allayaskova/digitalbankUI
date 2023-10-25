package ui.steps.UI.STEPS.Checking;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import ui.Models.CheckingAccountModel;
import ui.Pages.Login.LoginPage;
import ui.Utilities.Driver;

import java.time.Duration;
import java.util.List;

public class ViewCheckingAccountSteps {
    WebDriver driver = Driver.getDriver();
    private LoginPage loginPage = new LoginPage(driver);

    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(2));

    @Given("user is on login with credentials {string} and password {string}")
    public void user_is_on_login_with_credentials_and_password(String username, String password) {
       loginPage.loginInfo(username, password);
       loginPage.clickToSignIn();
    }
    @Given("user has a checking account with the following details:")
    public void user_has_a_checking_account_with_the_following_details(List<CheckingAccountModel> checking) {
        WebElement checkingAccountButton = driver.findElement(By.xpath("//div/ul/li[2]"));
        checkingAccountButton.click();
        WebElement viewCheckingBtn = driver.findElement(By.id("view-checking-menu-item"));
        viewCheckingBtn.click();

    }
    @When("user checks the account balance")
    public void user_checks_the_account_balance() {
        WebElement balanceBtn = driver.findElement(By.xpath("//div[@class = 'h4 m-0' ]"));
        balanceBtn.isDisplayed();
    }
    @Then("user should see the following account details:")
    public void user_should_see_the_following_account_details(List<CheckingAccountModel> checking) {
//accountnumber
        //balance
    }
}
