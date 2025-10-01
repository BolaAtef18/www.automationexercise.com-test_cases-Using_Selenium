package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProductDetailsPage {
    WebDriver driver;

    By produtDetails = By.xpath("/html/body/section/div/div/div[2]/div[2]/div[2]/div");
    By quantity = By.xpath("//*[@id=\"quantity\"]");
    By addtocartbutton =By.xpath("/html/body/section/div/div/div[2]/div[2]/div[2]/div/span/button");
    By writeyourreview = By.xpath("/html/body/section/div/div/div[2]/div[3]/div[1]/ul/li/a");
    By name = By.xpath("//*[@id=\"name\"]");
    By email = By.xpath("//*[@id=\"email\"]");
    By review = By.xpath("//*[@id=\"review\"]");
    By submitButton = By.xpath("//*[@id=\"button-review\"]");
    By successemessage = By.xpath("//*[@id=\"review-section\"]/div/div/span");


    public ProductDetailsPage(WebDriver driver) {
        this.driver = driver;
    }

    public boolean thisproductdetails (){
        return driver.findElement(produtDetails).isDisplayed();
    }

    public void increaseQuantity(int qty){
        driver.findElement(quantity).clear();
        driver.findElement(quantity).sendKeys(String.valueOf(qty));
    }

    public void pressonaddtocartbutton(){
        driver.findElement(addtocartbutton).click();
    }
    public boolean isWriteyourreviewvisiable(){
        return driver.findElement(writeyourreview).isDisplayed();
    }
    public void enternameemailreview(){
        driver.findElement(name).sendKeys("bola atef");
        driver.findElement(email).sendKeys("bola@testing.com");
        driver.findElement(review).sendKeys("good review");
        driver.findElement(submitButton).click();
    }
    public boolean issuccessemessagevisiable(){
        return driver.findElement(successemessage).isDisplayed();
    }


}
