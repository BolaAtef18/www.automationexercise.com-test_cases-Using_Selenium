package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoggedInPage {
    WebDriver driver;

    By LoggedIn_Username = By.xpath("//*[@id=\"header\"]/div/div/div/div[2]/div/ul/li[10]/a");
    By Delete_Button =By.xpath("//*[@id=\"header\"]/div/div/div/div[2]/div/ul/li[5]/a");
    By Logout_Button =By.xpath("//*[@id=\"header\"]/div/div/div/div[2]/div/ul/li[4]/a");
    By cartButton = By.xpath("//*[@id=\"header\"]/div/div/div/div[2]/div/ul/li[3]/a");



    public LoggedInPage(WebDriver driver) {
        this.driver = driver;
    }


    public boolean isLogged_in_as_usernameVisible() {
        return driver.findElement(LoggedIn_Username).isDisplayed();
    }

    public void delete_button(){
        driver.findElement(Delete_Button).click();
    }

    public void logout_button(){
        driver.findElement(Logout_Button).click();
    }
    public void pressoncartbutton(){driver.findElement(cartButton).click();}

}
