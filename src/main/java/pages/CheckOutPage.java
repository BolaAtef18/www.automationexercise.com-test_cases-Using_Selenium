package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CheckOutPage {
    WebDriver driver;

    By addressdetails = By.xpath("//*[@id=\"cart_items\"]/div/div[2]/h2");
    By reviewyourorder = By.xpath("//*[@id=\"cart_items\"]/div/div[4]/h2");
    By comment = By.xpath("//*[@id=\"ordermsg\"]/textarea");
    By placeorderbutton =By.xpath("//*[@id=\"cart_items\"]/div/div[7]/a");
    By successmessage = By.xpath("//*[@id=\"success_message\"]/div");

    public CheckOutPage(WebDriver driver) {
        this.driver = driver;
    }

    public boolean isaddressdetailsvisiable(){return driver.findElement(addressdetails).isDisplayed();}
    public boolean isreviewyourordervisiable() {return driver.findElement(reviewyourorder).isDisplayed();}
    public void addcomment(){driver.findElement(comment).sendKeys("COMMENT");}
    public void pressonplaceorderbutton(){driver.findElement(placeorderbutton).click();}

}
