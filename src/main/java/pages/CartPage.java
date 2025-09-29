package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import java.util.List;

public class CartPage {

    WebDriver driver;
    By subscription = By.xpath("//*[@id=\"footer\"]/div[1]/div/div/div[2]/div/h2");
    By subscriptionEmail = By.xpath("//*[@id=\"susbscribe_email\"]");
    By arrowButton = By.xpath("//*[@id=\"subscribe\"]/i");
    By successemessage = By.xpath("//*[@id=\"success-subscribe\"]/div");
    By processdtocheckoutbutton = By.xpath("//*[@id=\"do_action\"]/div[1]/div/div/a");
    By Register_Loginbutton = By.xpath("//*[@id=\"checkoutModal\"]/div/div/div[2]/p[2]/a/u");
    By Xbutton = By.xpath("//*[@id=\"product-1\"]/td[6]/a/i");


    public CartPage (WebDriver driver) {this.driver = driver;}

    public void scrolldowntosubscription(){
        WebElement footer = driver.findElement(subscription);
        Actions actions = new Actions(driver);
        actions.scrollToElement(footer).perform();
    }
    public boolean verifySubscriptionisVisible(){return driver.findElement(subscription).isDisplayed();}

    public void Enteremailclickarrowbutton(){
        driver.findElement(subscriptionEmail).sendKeys("testing@test.com");
        driver.findElement(arrowButton).click();
    }
    public boolean verifysuccessmessageisvisible(){return driver.findElement(successemessage).isDisplayed();}

    public boolean isProductDisplayed(int index) {
        return driver.findElement(By.xpath("//tr[@id='product-"+ index +"']")).isDisplayed();
    }
    public String getProductPrice(int index){
        return driver.findElement(By.xpath("//*[@id=\"product-"+index+"]/td[3]/p")).getText();
    }
    public String getProductQuantity(int index) {
        return driver.findElement(By.xpath("//*[@id=\"product-"+index+"]/td[4]/button")).getText();
    }

    public String getProductTotal(int index) {
        return driver.findElement(By.xpath("//*[@id=\"product-"+index+"]/td[5]/p")).getText();
    }
    public void pressonprocessdtocheckoutbutton (){driver.findElement(processdtocheckoutbutton).click();}

    public void pressonRegister_Loginbutton(){driver.findElement(Register_Loginbutton).click();}

    public void pressonXbutton(){driver.findElement(Xbutton).click();}

    public boolean isproductstillincart(int index) {
        List<WebElement> productsAfterRemove = driver.findElements( By.xpath("//*[@id='product-" + index + "']"));

        return productsAfterRemove.size()==0;

    }


}
