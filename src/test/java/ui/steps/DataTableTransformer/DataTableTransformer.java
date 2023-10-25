package ui.steps.DataTableTransformer;

import ui.Models.*;
import io.cucumber.java.DataTableType;

import java.util.Map;

public class DataTableTransformer {

    @DataTableType
    public CheckingAccountCard checkingAccountCardEntry(Map<String, String> entry) {

        String accountName = entry.get("accountName");
        String accountType = entry.get("accountType");
        String ownership = entry.get("ownership");
        long accountNumber = Long.parseLong(entry.get("accountNumber"));
        String interestRate = entry.get("interestRate");
        double balance = Double.parseDouble(entry.get("balance"));


        return new CheckingAccountCard(accountName, accountType, ownership, accountNumber, interestRate, balance);
    }



    @DataTableType
    public CheckingTransactionMenu checkingTransactionMenuEntry(Map<String, String> entry) {
        String date = entry.get("date");
        String category = entry.get("category");
        String description = entry.get("description");
        double amount = Double.parseDouble(entry.get("amount"));
        double balance = Double.parseDouble(entry.get("balance"));

        return new CheckingTransactionMenu(date, category, description, amount, balance);
    }
    @DataTableType
    public DepositToCheckingModel depositTransformer(Map<String, String> entry){
         String accountForDeposit = entry.get("accountForDeposit");
        double balance = Double.parseDouble(entry.get("balance"));
        double depositAmount = Double.parseDouble(entry.get("depositAmount"));
        double newBalance = Double.parseDouble(entry.get("newBalance"));
        return new DepositToCheckingModel(accountForDeposit, balance,depositAmount,newBalance);

    }
    @DataTableType
    public CheckingAccountModel checkingAccount(Map<String, String> entry){
        int accountNumber = Integer.parseInt(entry.get("accountNumber"));
        double balance = Double.parseDouble(entry.get("balance"));
        return new CheckingAccountModel(accountNumber,balance);
    }

    @DataTableType
    public NewCheckingData newCheckingData(Map<String, String> entry) {
        String accountName = entry.get("accountName");
        String accountType = entry.get("accountType");
        String ownership = entry.get("ownership");
        double deposit = Double.parseDouble(entry.get("deposit"));

        return new NewCheckingData(accountName,accountType, ownership, deposit);
    }
    @DataTableType
    public ProfileInfoModel profileInfoEntry(Map<String, String> entry) {
        String title = entry.get("title");
        String firstName = entry.get("firstName");
        String lastName = entry.get("lastName");
        String homePhone = entry.get("homePhone");
        String mobilPhone = entry.get("mobilPhone");
        String workPhone = entry.get("workPhone");
        String address = entry.get("address");
        String postalCode = entry.get("postalCode");
        String region = entry.get("region");
        String locality = entry.get("locality");
        String country = entry.get("country");
        return new ProfileInfoModel(title,firstName,lastName,homePhone,mobilPhone,workPhone,address,postalCode,region,locality,country);
    }

}
