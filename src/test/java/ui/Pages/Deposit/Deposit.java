package ui.Pages.Deposit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import ui.Models.DepositToCheckingModel;

import java.util.List;

public class Deposit {
    private WebDriver driver;

    public Deposit(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "deposit-menu-item")
    WebElement depositButton;

    public WebElement getDepositButton() {
        return depositButton;
    }

    @FindBy(id = "selectedAccount")
    WebElement selectedAccountDrop;
    @FindBy(id = "amount")
    WebElement depositAmount;
    @FindBy(xpath = "//button[@type = 'submit']")
    WebElement submitDepositButton;

    //method
    public void doDeposit(List<DepositToCheckingModel> deposit) {
        Select select = new Select(selectedAccountDrop);//webelement
        select.deselectByVisibleText("John Doe First Account (Standard Checking)");
        depositAmount.sendKeys("1000.00 ");
        submitDepositButton.click();
    }

    public double calculateNewBalanceAmount(List<DepositToCheckingModel> entry) {
        double totalBalance = 0.0;

        for (DepositToCheckingModel element : entry) {
            double depositAmount = element.getDepositAmount();
            double balance = element.getBalance();

            if (depositAmount <= 0) {
                System.out.println("Invalid deposit amount. Amount must be greater than 0.");
            } else {
                totalBalance += balance + depositAmount;
            }
        }

        return totalBalance;
    }


    public void depositBtnClick(){
        depositButton.click();
    }

}



