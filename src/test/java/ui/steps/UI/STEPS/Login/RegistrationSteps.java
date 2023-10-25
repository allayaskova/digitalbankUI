package ui.steps.UI.STEPS.Login;

import io.cucumber.java.bs.A;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import ui.Pages.Registration.RegistrationPage;
import ui.Utilities.ConfigReader;
import ui.Utilities.dbUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static ui.Utilities.Driver.getDriver;

public class RegistrationSteps {
    RegistrationPage registrationPage = new RegistrationPage(getDriver());
    List<Map<String, Object>> nextValList = new ArrayList<>();//saved on class level so we can reuse
    @Given("the following user with email {string} is not in DB")

    public void theFollowingUserWithEmailIsNotInDB(String email) {
        String queryUserProfile = String.format("DELETE FROM user_profile where email_address = '%s'", email);
        String queryUsers = String.format("DELETE FROM users where username = '%s'", email);

        String queryToGetNextValInHibernateSeqTable = String.format("select * from hibernate_sequence");
        nextValList = dbUtils.runSQLSelectQuery(queryToGetNextValInHibernateSeqTable);

        dbUtils.runSQLUpdateQuery(queryUserProfile);
        dbUtils.runSQLUpdateQuery(queryUsers);


    }
    @Given("the user navigates to signup page")
    public void the_user_navigates_to_signup_page() {
        getDriver().get(ConfigReader.getPropertiesValue("digitalbank.registrationpageurl"));
        assertEquals("Digital Bank", getDriver().getTitle(), "Title mismatch");
    }

    @When("the user creates account with following fields")
    public void the_user_creates_account_with_following_fields(List<Map<String, String>> registrationPageDataExpected) {
        registrationPage.createNewAccount(registrationPageDataExpected);
    }

    @Then("the user should be displayed with the message {string}")
    public void the_user_should_be_displayed_with_the_message(String expectedMessage) {
        assertEquals(expectedMessage, registrationPage.getMessage(), "success message mismatch");
    }

    @Then("the user should see the {string} required field error message {string}")
    public void theUserShouldSeeTheRequiredFieldErrorMessage(String fieldError, String errorMessage) {
        String actualErrorMessage = registrationPage.getRequiredFieldErrorMsg(fieldError);
        assertEquals(errorMessage, actualErrorMessage, "mismatch");
    }

    @Then("the user info should be saved in the db")
    public void theUserInfoShouldBeSaveInTheDb(List<Map<String, String>> expectedUserInfoInDbList) {
        Map<String, String> expectedUserInfoMap = expectedUserInfoInDbList.get(0);//from our table one row
        String queryUserTable = String.format("select * from users where username='%s'", expectedUserInfoMap.get("email"));
        String queryUserProfileTable = String.format("select * from user_profile where email_address='%s'", expectedUserInfoMap.get("email"));


        List<Map<String, Object>> actualUserInfoList = dbUtils.runSQLSelectQuery(queryUserTable);//run this query
        List<Map<String, Object>> actualUserProfileList = dbUtils.runSQLSelectQuery(queryUserProfileTable);

        assertEquals(1, actualUserInfoList.size(), "unexpected number of users");//user already exists
        assertEquals(1, actualUserProfileList.size(), "unexpected number of users");

        Map<String, Object> actualUserInfoMap = actualUserInfoList.get(0);//from db
        Map<String, Object> actualUserProfileInfoMap = actualUserProfileList.get(0);//from db

        assertEquals(expectedUserInfoMap.get("title"), actualUserProfileInfoMap.get("title"), "registration generated wrong title");
        assertEquals(expectedUserInfoMap.get("firstName"), actualUserProfileInfoMap.get("first_name"), "registration generated wrong first name");
        assertEquals(expectedUserInfoMap.get("lastName"), actualUserProfileInfoMap.get("last_name"), "registration generated wrong last name");
        assertEquals(expectedUserInfoMap.get("gender"), actualUserProfileInfoMap.get("gender"), "registration generated wrong gender");
        //assertEquals(expectedUserInfoMap.get("DOB"), actualUserInfoMap.get("dob"), "registration generated wrong dob");
        assertEquals(expectedUserInfoMap.get("SSN"), actualUserProfileInfoMap.get("ssn"), "registration generated wrong ssn");
        assertEquals(expectedUserInfoMap.get("email"), actualUserProfileInfoMap.get("email_address"), "registration generated wrong email");
        //password skipped by Askar????
        assertEquals(expectedUserInfoMap.get("address"), actualUserProfileInfoMap.get("address"), "registration generated wrong address");
        assertEquals(expectedUserInfoMap.get("locality"), actualUserProfileInfoMap.get("locality"), "registration generated wrong locality");
        assertEquals(expectedUserInfoMap.get("region"), actualUserProfileInfoMap.get("region"), "registration generated wrong region");
        assertEquals(expectedUserInfoMap.get("postalCode"), actualUserProfileInfoMap.get("postal_code"), "registration generated wrong postal code");
        assertEquals(expectedUserInfoMap.get("country"), actualUserProfileInfoMap.get("country"), "registration generated wrong country");
        assertEquals(expectedUserInfoMap.get("homePhone"), actualUserProfileInfoMap.get("home_phone"), "registration generated wrong home phone");
        assertEquals(expectedUserInfoMap.get("mobilePhone"), actualUserProfileInfoMap.get("mobile_phone"), "registration generated wrong mobile phone");
        assertEquals(expectedUserInfoMap.get("workPhone"), actualUserProfileInfoMap.get("work_phone"), "registration generated wrong work phone");
        assertEquals(nextValList.get(0).get("next_val"), actualUserInfoMap.get("id"), "ID mismatch");//id is taken from hibernet_sequence table
        //no id validation ask Askar?
        long expectedUserProfileId = Integer.parseInt(String.valueOf(nextValList.get(0).get("next_val")));
        assertEquals(++expectedUserProfileId, actualUserProfileInfoMap.get("id"), "ID mismatch");
    }


}
