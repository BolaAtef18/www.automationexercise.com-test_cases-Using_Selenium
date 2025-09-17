package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

public class ProductsPage {
    WebDriver driver;
    Actions actions;


    By firstProduct = By.xpath("/html/body/section[2]/div/div/div[2]/div/div[2]/div/div[1]/div[1]");
    By addtocartbutton1stproduct = By.xpath("/html/body/section[2]/div/div/div[2]/div/div[2]/div/div[1]/div[2]/div/a");
    By continueshoppingbutton = By.xpath("//*[@id=\"cartModal\"]/div/div/div[3]/button");
    By secondProduct = By.xpath("/html/body/section[2]/div/div/div[2]/div/div[3]/div/div[1]/div[1]");
    By addtocartbutton2ndproduct = By.xpath("/html/body/section[2]/div/div/div[2]/div/div[3]/div/div[1]/div[1]/a");
    By viewcartbutton = By.xpath("//*[@id=\"cartModal\"]/div/div/div[2]/p[2]/a/u");



    public ProductsPage (WebDriver driver) {
        this.driver = driver;
        this.actions = new Actions(driver);
    }
    public void HoverAndAddFirstProductToCart() {
        actions.moveToElement(driver.findElement(firstProduct)).perform();
        driver.findElement(addtocartbutton1stproduct).click();
    }
    public void pressonContinueShopping(){
        driver.findElement(continueshoppingbutton).click();
    }
    public void HoverAndAddSecondProductToCart() {
        actions.moveToElement(driver.findElement(secondProduct)).perform();
        driver.findElement(addtocartbutton2ndproduct).click();
    }
    public void pressonViewCartButton(){
        driver.findElement(viewcartbutton).click();
    }

}
