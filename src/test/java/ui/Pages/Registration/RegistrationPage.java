package ui.Pages.Registration;

import com.github.javafaker.Faker;
import io.cucumber.java.zh_cn.假如;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import org.openqa.selenium.support.ui.Select;

import ui.Utilities.MockData;

import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class RegistrationPage {
    Faker faker = new Faker();
    MockData mockData = new MockData();
    public WebDriver driver;
//    public List<RegistrationPageData> registrationInfo;

    public RegistrationPage(WebDriver driver) {
        this.driver = this.driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "title")
    public WebElement titleDropDown;

    @FindBy(id = "firstName")
    public WebElement firstNameElement;
    @FindBy(id = "lastName")
    public WebElement lastNameElement;
    @FindBy(xpath = "//label[@for = 'male']//input")
    public WebElement genderMElement;
    @FindBy(xpath = "//label[@for = 'female']//input")
    public WebElement genderFElement;
    @FindBy(id = "dob")
    public WebElement DOBElement;
    @FindBy(id = "ssn")
    public WebElement SSNElement;
    @FindBy(id = "emailAddress")
    public WebElement emailElement;
    @FindBy(id = "password")
    public WebElement passwordElement;
    @FindBy(id = "confirmPassword")
    public WebElement passwordConfirmElement;
    @FindBy(xpath = "//button[@type = 'submit']")
    public WebElement nextBtn;
    @FindBy(xpath = "//button[@class = 'btn btn-primary btn-flat m-b-30 m-t-30']")
    public WebElement registerBtn;
    @FindBy(id = "address")
    public WebElement addressTextBox;

    @FindBy(id = "locality")
    public WebElement localityTextBox;

    @FindBy(xpath = "//input[@name= 'region']")
    public WebElement regionTextBox;

    @FindBy(xpath = "//input[@name= 'postalCode']")
    public WebElement postalCodeTextBox;

    @FindBy(xpath = "//input[@name= 'country']")
    public WebElement countryTextBox;

    @FindBy(id = "homePhone")
    public WebElement homePhoneTextBox;

    @FindBy(id = "mobilePhone")
    public WebElement mobilePhoneTextBox;

    @FindBy(id = "workPhone")
    public WebElement workPhoneTextBox;

    @FindBy(id = "agree-terms")
    public WebElement agreeToTermsCheckBox;

    @FindBy(xpath = "//button[text()='Register']")
    public WebElement registerButton;
@FindBy(xpath = "//div[@class = 'sufee-alert alert with-close alert-success alert-dismissible fade show']")//does not work
public WebElement messageLabel;
    public void createNewAccount(List<Map<String, String>> registrationPageData) {


        Select titleSelect = new Select(titleDropDown);
        Map<String, String> firstRaw = registrationPageData.get(0);
        if (firstRaw.get("title") != null) {
            titleSelect.selectByVisibleText(firstRaw.get("title"));
        }
        if (firstRaw.get("firstName") != null) {
            firstNameElement.sendKeys(firstRaw.get("firstName"));
        }
        if (firstRaw.get("lastName") != null) {
            lastNameElement.sendKeys(firstRaw.get("lastName"));
        }
        if (firstRaw.get("gender") != null) {
            if (firstRaw.get("gender").equalsIgnoreCase("M")) {
                genderMElement.click();
            } else if (firstRaw.get("gender").equalsIgnoreCase("F")) {
                genderFElement.click();
            } else {
                System.out.println("Wrong gender");
            }
        }
        if (firstRaw.get("DOB") != null) {
            DOBElement.sendKeys(firstRaw.get("DOB"));
        }
        //mock
        if (firstRaw.get("SSN") != null) {
            SSNElement.sendKeys(firstRaw.get("SSN"));
            }

        if (firstRaw.get("email") != null) {
               emailElement.sendKeys(firstRaw.get("email"));
        }
        if (firstRaw.get("password") != null) {
            passwordElement.sendKeys(firstRaw.get("password"));
            passwordConfirmElement.sendKeys(firstRaw.get("confirmPassword"));
        }
        nextBtn.click();
        if (addressTextBox.isDisplayed()) {
            //2nd page
            if (firstRaw.get("address") != null) {
                addressTextBox.sendKeys(firstRaw.get("address"));
            }
            if (firstRaw.get("locality") != null) {
                localityTextBox.sendKeys(firstRaw.get("locality"));
            }
            if (firstRaw.get("region") != null) {
                regionTextBox.sendKeys(firstRaw.get("region"));
            }
            if (firstRaw.get("postalCode") != null) {
                postalCodeTextBox.sendKeys(firstRaw.get("postalCode"));
            }
            if (firstRaw.get("country") != null) {
                countryTextBox.sendKeys(firstRaw.get("country"));
            }
            if (firstRaw.get("homePhone") != null) {
                homePhoneTextBox.sendKeys(firstRaw.get("homePhone"));
            }
            if (firstRaw.get("mobilePhone") != null) {
                mobilePhoneTextBox.sendKeys(firstRaw.get("mobilePhone"));
            }
            if (firstRaw.get("workPhone") != null) {
                workPhoneTextBox.sendKeys(firstRaw.get("workPhone"));
            }

            if (firstRaw.get("agreeToTermsCheckBox") != null) {
                if (firstRaw.get("agreeToTermsCheckBox").equalsIgnoreCase("true")) {
                    agreeToTermsCheckBox.click();
                }
            }
            registerBtn.click();

        }
    }
    public String getMessage(){
        String fullMessageWithX = messageLabel.getText();
        String modifiedMessage = fullMessageWithX.substring(0, fullMessageWithX.length() - 2);
        return modifiedMessage;
    }
    public String getRequiredFieldErrorMsg(String fieldError){
        switch (fieldError){
            case "title":
                return titleDropDown.getAttribute("validationMessage");//!memorize - will give us error message
            case "firstName":
                return firstNameElement.getAttribute("validationMessage");
            case "lastName":
                return lastNameElement.getAttribute("validationMessage");
            case "gender":
                return genderMElement.getAttribute("validationMessage");
            case "DOB":
                return DOBElement.getAttribute("validationMessage");
            case "SSN":
                return SSNElement.getAttribute("validationMessage");
            case "email":
                return emailElement.getAttribute("validationMessage");
            case "password":
                return passwordElement.getAttribute("validationMessage");
            case "confirmPassword":
                return passwordConfirmElement.getAttribute("validationMessage");
            case "address":
                return addressTextBox.getAttribute("validationMessage");
            case "locality":
                return localityTextBox.getAttribute("validationMessage");
            case "region":
                return regionTextBox.getAttribute("validationMessage");
            case "postalCode":
                return postalCodeTextBox.getAttribute("validationMessage");
            case "country":
                return countryTextBox.getAttribute("validationMessage");
            case "homePhone":
                return homePhoneTextBox.getAttribute("validationMessage");
            case "mobilePhone":
                return mobilePhoneTextBox.getAttribute("validationMessage");
            case "workPhone":
                return workPhoneTextBox.getAttribute("validationMessage");
            case "agreeToTermsCheckBox":
                return agreeToTermsCheckBox.getAttribute("validationMessage");
            default:
                return null;
        }

    }
}
