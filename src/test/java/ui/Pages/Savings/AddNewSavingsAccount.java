package ui.Pages.Savings;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AddNewSavingsAccount {
    @FindBy(id="new-savings-menu-item")
    WebElement newSavingsAccountBtn;
@FindBy(id="savings-menu")
    WebElement savingsBtn;
@FindBy(id="Savings")
    WebElement savingsRadioBtn;
@FindBy( id="Money Market")
    WebElement moneyMarketRadioBtn;
@FindBy(id="Individual")
    WebElement individualRadioBtn;
}
