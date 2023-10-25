package ui.steps.UI.STEPS;

import io.cucumber.java.*;
import ui.Utilities.Driver;
import ui.Utilities.dbUtils;

import java.lang.annotation.Repeatable;
import java.util.concurrent.TimeUnit;

import static ui.Utilities.Driver.getDriver;

public class Hooks {
    @BeforeAll()
    public static void establishConnectionToDB() throws ClassNotFoundException {
        dbUtils.establishConnection();}
@Before("not @Registration")
public void the_user_is_on_dbank_homepage(){
    getDriver().get("https://dbank-qa.wedevx.co/bank/login");
}

    @After("not @NegativeRegistrationCase")
    public void tearDown(Scenario scenario){
        Driver.takeScreenShot(scenario);
        Driver.closeDriver();
    }
@AfterAll()
    public static void closeConnectionToDB(){
        dbUtils.closeConnection();
}

}
