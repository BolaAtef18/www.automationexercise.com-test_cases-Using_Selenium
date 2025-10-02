package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class PaymentPage {

    WebDriver driver;

    By nameoncard = By.xpath("//*[@id=\"payment-form\"]/div[1]/div/input");
    By cardnumber = By.xpath("//*[@id=\"payment-form\"]/div[2]/div/input");
    By cvc = By.xpath("//*[@id=\"payment-form\"]/div[3]/div[1]/input");
    By expirationmonth = By.xpath("//*[@id=\"payment-form\"]/div[3]/div[2]/input");
    By expirationyear = By.xpath("//*[@id=\"payment-form\"]/div[3]/div[3]/input");
    By payandconfirmorderbutton = By.xpath("//*[@id=\"submit\"]");
    By successmessage = By.xpath("//*[contains(text(),'Order Placed!')]");
    By downloadinvoicebutton = By.xpath("//*[@id=\"form\"]/div/div/div/a");
    By continuebutton = By.xpath("//*[@id=\"form\"]/div/div/div/div/a");

    public PaymentPage(WebDriver driver){
        this.driver= driver;
    }

    public void enterdataofcardandpayorder (){
        driver.findElement(nameoncard).sendKeys("test");
        driver.findElement(cardnumber).sendKeys("1234567890123456");
        driver.findElement(cvc).sendKeys("123");
        driver.findElement(expirationmonth).sendKeys("01");
        driver.findElement(expirationyear).sendKeys("2026");
        driver.findElement(payandconfirmorderbutton).click();
    }

    public boolean issuccessmessagevisible() {
        return driver.findElement(successmessage).isDisplayed();
    }

    public void pressondownloadinvoicebutton(){
        driver.findElement(downloadinvoicebutton).click();
    }

    public void pressoncontinuebutton(){
        driver.findElement(continuebutton);
    }
}
