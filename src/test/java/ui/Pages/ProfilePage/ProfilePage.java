package ui.Pages.ProfilePage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import ui.Pages.BasePage;

public class ProfilePage extends BasePage {
    public ProfilePage(WebDriver driver) {

        super(driver);
    }
//
    @FindBy(xpath = "//div[@class = 'user-area dropdown show']")
    WebElement profilePicture;
    @FindBy(xpath = "//a[normalize-space()='My Profile']")
    WebElement myProfileBtn;
    @FindBy(xpath = "//li[@class='active']")
    WebElement welcomeMessage;
    @FindBy(id="title")
    WebElement title;
    @FindBy(id="firstName")
    WebElement firstName;
    @FindBy(id="lastName")
    WebElement lastName;
    @FindBy(id="homePhone")
    WebElement homePhone;
    @FindBy(id="mobilePhone")
    WebElement mobilePhone;
@FindBy(id="workPhone")
WebElement workPhone;
@FindBy(id="address")
WebElement address;
@FindBy(id= "locality")
WebElement locality;
@FindBy(id="region")
WebElement region;
@FindBy(id="postalCode")
WebElement postalCode;
@FindBy(id="country")
WebElement country;
@FindBy(xpath = "//button[normalize-space()='Submit")
WebElement submit;

    public void clickProfilePic(){
//        profilePicture.click();
        Select select = new Select(profilePicture);
        select.selectByVisibleText("My Profile");
    }

    public String getTitle(){
        return title.getAttribute("value");
    }

    public String getTheFirstname(){

        return firstName.getAttribute("value");
    }

    public String getTheLastname(){

        return lastName.getAttribute("value");
    }
    public String getTheHomePhone(){
        return homePhone.getAttribute("value");
    }
    public String getTheMobilePhone(){
        return mobilePhone.getAttribute("value");
    }
    public String getTheWorkPhone(){
        return workPhone.getAttribute("value");
    }
    public String getTheAddress(){
        return address.getAttribute("value");
    }
    public String getTheLocality(){
        return locality.getAttribute("value");
    }
    public String getTheRegion(){
        return region.getAttribute("value");
    }
    public String getThePostalCode(){
        return postalCode.getAttribute("value");
    }
    public String getTheCountry(){
        return  country.getAttribute("value");
    }
    public void submit(){
        submit.click();
    }

}
