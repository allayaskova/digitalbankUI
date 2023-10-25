package ui.steps.UI.STEPS.Login;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import ui.Models.ProfileInfoModel;
import ui.Pages.Login.LoginPage;
import ui.Pages.ProfilePage.ProfilePage;
import ui.Utilities.ConfigReader;
import ui.Utilities.Driver;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static ui.Utilities.Driver.getDriver;

public class MyProfileSteps {
    WebDriver driver = Driver.getDriver();
    private ProfilePage profilePage = new ProfilePage(driver);
    private LoginPage loginPage = new LoginPage(driver);
    @Given("user login as {string} {string}")
    public void userLoginAs(String username, String password) {
        getDriver().get(ConfigReader.getPropertiesValue("digitalbank.loginurl"));
loginPage.loginInfo(username,password);
loginPage.signInButton.click();
    }


    @When("user clicks on my profile")
    public void user_clicks_on_my_profile() {
        profilePage.clickProfilePic();
    }

    @Then("the user should see his or her account with the corresponding data:")
    public void the_user_should_see_his_her_account_with_the_corresponding_data(List<ProfileInfoModel> profileInfoList) {
        ProfileInfoModel expectedProfileInfo = profileInfoList.get(0);
        assertEquals(expectedProfileInfo.getTitle(), profilePage.getTitle(), "error title");
        assertEquals(expectedProfileInfo.getFirstName(), profilePage.getTheFirstname(), "error firstname");
        assertEquals(expectedProfileInfo.getLastName(), profilePage.getTheLastname(), "error lastname");
        assertEquals(expectedProfileInfo.getHomePhone(), profilePage.getTheHomePhone(), "error home phone");
        assertEquals(expectedProfileInfo.getMobilPhone(), profilePage.getTheMobilePhone(), "error mobile phone");
        assertEquals(expectedProfileInfo.getWorkPhone(), profilePage.getTheWorkPhone(), "error work phone");
        assertEquals(expectedProfileInfo.getAddress(), profilePage.getTheAddress(), "error address");
        assertEquals(expectedProfileInfo.getPostalCode(), profilePage.getThePostalCode(), "error postal code");
        assertEquals(expectedProfileInfo.getRegion(), profilePage.getTheRegion(), "error region");
        assertEquals(expectedProfileInfo.getLocality(), profilePage.getTheLocality(), "error locality");
        assertEquals(expectedProfileInfo.getCountry(), profilePage.getTheCountry(), "error country");
        profilePage.submit();
    }
}




