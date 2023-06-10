package WebStepDefination;

import Core.BrowserHelper;
import SearchPage.AddCustomerPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;

public class AddCustomerStepDefination {
    public static WebDriver driver;
    AddCustomerPage lp;
    @Given("manager to the add customer page")
    public void managerToTheAddCustomerPage() {
        BrowserHelper bhp = new BrowserHelper();
        driver = bhp.chrome("https://www.globalsqa.com/angularJs-protractor/BankingProject/#/login");

    }
    @When("click bank manager login")
    public void clickBankManagerLogin() {
        lp = new AddCustomerPage(driver);
        lp.bankManagerLogin();
    }

    @And("select add customer button")
    public void selectAddCustomerButton() {
        lp.addCustomer();
    }

    @And("manger enters {string} and {string} and {string}")
    public void mangerEntersFirstNameAndLastNameAndPostCode(String fName, String lName, String pCode) {

        lp.addCustomerInfo(fName,lName,pCode);
    }

    @And("click add customer button")
    public void clickAddCustomerButton() {

        lp.clickButton();

    }

    @Then("manager will navigate to successful popup page")
    public void managerWillNavigateToSuccessfulPopupPage() {

        lp.popUp();

    }


}
