package SearchPage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class DeleteCustomerPage {
    WebDriver driver;
    public DeleteCustomerPage(WebDriver driver){
        this.driver = driver;
    }
    By customer = By.xpath("//button[@ng-click='showCust()']");
    By sCustomer = By.xpath("//input[@ng-model='searchCustomer']");
    By deleteCus = By.xpath("//button[text()='Delete']");
    public void customer(){
        driver.findElement(customer).click();
    }
    public void sCustomer(){
        driver.findElement(sCustomer).sendKeys("Rafi");
    }
    public void delterCustomer(){
        driver.findElement(deleteCus).click();
    }
    public void homePage(){
        driver.findElement(By.xpath("//button[text()='Home']")).click();
    }
}
