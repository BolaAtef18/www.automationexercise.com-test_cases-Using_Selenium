package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class DeleteButtonPage {
    WebDriver driver;

    By Account_Deleted = By.xpath("//*[@id=\"form\"]/div/div/div/h2/b");
    By Contine_Button = By.xpath("//*[@id=\"form\"]/div/div/div/div/a");


    public DeleteButtonPage(WebDriver driver) {
        this.driver = driver;
    }


    public boolean isAccount_DeletedVisible() {
        return driver.findElement(Account_Deleted).isDisplayed();
    }

    public void contine_button(){
        driver.findElement(Contine_Button).click();
    }
}

