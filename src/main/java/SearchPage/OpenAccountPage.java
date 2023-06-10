package SearchPage;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class OpenAccountPage {

    WebDriver driver;
    public OpenAccountPage(WebDriver driver){
        this.driver = driver;
    }
    By openAcc = By.xpath("//button[@ng-class='btnClass2']");
    By cusName = By.xpath("//select[@ng-model='custId']");
    By currency = By.xpath("//select[@ng-model='currency']");
    public void openAccount(){
        driver.findElement(openAcc).click();

    }
    public void customerNameAndCurrency(){
        driver.findElement(cusName).click();
        driver.findElement(By.xpath("//select//option[text()='Rafi Azwad']")).click();

        driver.findElement(cusName).click();
        //Select select = new Select(loc_Start);
        //   select.selectByIndex(2);
        driver.findElement(currency).click();
        driver.findElement(By.xpath("//select//option[text()='Dollar']")).click();
        driver.findElement(currency).click();

    }

    public void processButton(){

        driver.findElement(By.xpath("//button[text()='Process']")).click();
    }
    public void popUp2(){
        Alert alert = driver.switchTo().alert();
        String msg = alert.getText();
        System.out.println("confimation msg: "+msg);
        alert.accept();
    }

}
