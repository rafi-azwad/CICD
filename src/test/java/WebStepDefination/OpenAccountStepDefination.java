package WebStepDefination;

import SearchPage.OpenAccountPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

import static WebStepDefination.AddCustomerStepDefination.driver;

public class OpenAccountStepDefination {
    OpenAccountPage op;
    @Given("click open account")
    public void clickOpenAccount() {
        op = new OpenAccountPage(driver);
        op.openAccount();
    }
    @And("select customer name and currency")
    public void selectCustomerNameAndCurrency() {

        op.customerNameAndCurrency();
    }


    @And("click process button")
    public void clickProcessButton() {

        op.processButton();

    }

    @Then("navigate the popup page")
    public void navigateThePopupPage() {

        op.popUp2();

    }
}
