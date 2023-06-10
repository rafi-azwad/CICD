package WebStepDefination;

import SearchPage.DeleteCustomerPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static WebStepDefination.AddCustomerStepDefination.driver;

public class DeleteAccountStepDefination {
    DeleteCustomerPage cp;
    @Given("user in customer page")
    public void userInCustomerPage() {
        cp = new DeleteCustomerPage(driver);
        cp.customer();

    }

    @When("search customer name")
    public void searchCustomerName() throws InterruptedException {

        cp.sCustomer();
        Thread.sleep(2000);
    }

    @And("click delete button")
    public void clickDeleteButton() throws InterruptedException {

        cp.delterCustomer();
        Thread.sleep(2000);

    }

    @Then("successfully go to home page")
    public void successfullyGoToHomePage() {

        cp.homePage();
    }
}
