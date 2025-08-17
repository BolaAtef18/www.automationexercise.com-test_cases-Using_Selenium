package pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LogOutPage {
    WebDriver driver;

    By LogOut_Button =By.xpath("//*[@id='header']/div/div/div/div[2]/div/ul/li[4]/a");

    public LogOutPage(WebDriver driver) {
        this.driver = driver;
    }

    public void logout_button(){
        driver.findElement(LogOut_Button).click();
    }

}
