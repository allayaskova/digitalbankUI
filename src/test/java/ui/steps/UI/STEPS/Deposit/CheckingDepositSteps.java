package ui.steps.UI.STEPS.Deposit;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import ui.Models.DepositToCheckingModel;
import ui.Pages.Deposit.Deposit;
import ui.Pages.Login.LoginPage;
import ui.Utilities.Driver;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static ui.Utilities.Driver.getDriver;

public class CheckingDepositSteps {
    Deposit depositToChecking  =  new Deposit(Driver.getDriver());
    LoginPage loginPage = new LoginPage(Driver.getDriver());
    @Given("launch application and login with login {string} and password {string}")
    public void launch_application_and_login_with_login_and_password(String username, String password) {
        getDriver().get("https://dbank-qa.wedevx.co/bank/login");
        loginPage.loginInfo(username, password);
        loginPage.signInButton.click();
    }
    @Given("the user has checking account with original balance")
    public void the_user_has_checking_account_with_original_balance(List<DepositToCheckingModel> entry) {
        DepositToCheckingModel expected = entry.get(0);
depositToChecking.getDepositButton().click();

    }
    @When("the user deposits the following amount:")
    public void the_user_deposits_the_following_amount(List<DepositToCheckingModel> entry) {
        DepositToCheckingModel expected = entry.get(0);
        depositToChecking.doDeposit((List<DepositToCheckingModel>) expected);
        depositToChecking.depositBtnClick();
    }
    @Then("the account balance should be updated as follows:")
    public void the_account_balance_should_be_updated_as_follows(List<DepositToCheckingModel> entry) {
        DepositToCheckingModel expected = entry.get(0);
depositToChecking.calculateNewBalanceAmount((List<DepositToCheckingModel>) expected);
    }
}
