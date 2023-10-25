package ui.Pages.Checking;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ViewCheckingAccount {
    @FindBy(id="view-checking-menu-item")
    WebElement viewChecking;
@FindBy(id="page-title")
    WebElement pageTitle;
@FindBy(xpath = "//li[@class='active']")
    WebElement welcomeMessage;
@FindBy(xpath="//form[@action='/bank/account/checking-view']//div[@class='card-body']")
    WebElement card;
@FindBy(xpath = "//div[normalize-space()='1 checking account']")
    WebElement titleOfCheckingAccount;
@FindBy(xpath = "//span[@class='switch-label']")
    WebElement onBtn;
@FindBy( xpath  ="//small[normalize-space()='Account: Standard Checking']")
    WebElement accountTypeField;
@FindBy(xpath = "//small[normalize-space()='Ownership: Individual']")
    WebElement ownershipTypeField;
@FindBy(xpath= "//small[normalize-space()='Account Number: 486130052']")
    WebElement accountNameField;
@FindBy(xpath = "//small[normalize-space()='Interest Rate: 0.0%']")
    WebElement interestRateField;


}
