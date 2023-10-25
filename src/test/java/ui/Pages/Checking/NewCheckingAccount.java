package ui.Pages.Checking;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class NewCheckingAccount {
@FindBy(id = "checking-menu")
    WebElement checkingButton;
@FindBy( id="new-checking-menu-item")
    WebElement newChecking;
    @FindBy( id="page-title")
    WebElement pageTitle;
@FindBy(xpath = "//li[@class='active']")
    WebElement welcomeTitle;
@FindBy(xpath = "//strong[@class='card-title text-white']")
    WebElement neeCheckingAccountHeader;
@FindBy(xpath = "//strong[normalize-space()='Select Checking Account Type']")
    WebElement selectCheckingAccountTitle;
@FindBy(xpath = "//label[@for='Standard Checking']")
    WebElement standardCheckingLabel;
@FindBy(id="Standard Checking")
    WebElement standardCheckingBtn;
@FindBy(xpath ="//label[@for='Interest Checking']")
    WebElement interestCheckingLabel;
@FindBy(id="Interest Checking")
    WebElement interestCheckingBtn;
@FindBy(xpath="//strong[normalize-space()='Select Account Ownership']")
    WebElement selectAccountOwnershipHeader;
@FindBy(xpath = "//label[@for='Individual']")
    WebElement individualLabel;
@FindBy(id="Individual")
    WebElement individualBtn;
@FindBy(xpath = "//label[@for='Joint']")
    WebElement jointLabel;
@FindBy(id="Joint")
    WebElement jointBtn;
@FindBy(xpath = "//strong[normalize-space()='Account Name']")
    WebElement accountNameLabel;
@FindBy(id="name")
    WebElement accountNameField;
@FindBy(xpath = "//small[contains(text(),'ex. Short descriptive name to easily identify acco')]")
    WebElement messageUnderAccountNameField;
@FindBy(xpath = "//strong[normalize-space()='Initial Deposit Amount']")
    WebElement initialDepositAmountLabel;
@FindBy(id="openingBalance")
    WebElement openingBalanceField;
@FindBy(id="newCheckingSubmit")
    WebElement submitBtn;
@FindBy(id="newCheckingReset")
    WebElement resetBtn;
}
