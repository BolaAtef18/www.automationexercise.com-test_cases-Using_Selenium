package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

public class AnyProductPage {
    WebDriver driver;

    By produtDetails = By.xpath("/html/body/section/div/div/div[2]/div[2]/div[2]/div");
    By quantity = By.xpath("//*[@id=\"quantity\"]");
    By addtocartbutton =By.xpath("/html/body/section/div/div/div[2]/div[2]/div[2]/div/span/button");
    By viewcartbutton = By.xpath("//*[@id=\"cartModal\"]/div/div/div[2]/p[2]/a/u");


    public AnyProductPage (WebDriver driver) {
        this.driver = driver;
    }

    public boolean productdetails (){
        return driver.findElement(produtDetails).isDisplayed();
    }

    public void increaseQuantity(int qty){
        driver.findElement(quantity).clear();
        driver.findElement(quantity).sendKeys(String.valueOf(qty));
    }

    public void pressonaddtocartbutton(){
        driver.findElement(addtocartbutton).click();
    }
    public void pressonviewcartbutton(){
        driver.findElement(viewcartbutton).click();
    }
}
