package pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AccountCreatedPage {
        WebDriver driver;

        By accountCreatedText = By.xpath("//*[@id=\"form\"]/div/div/div/h2/b");
        By contiune = By.xpath("//*[@id=\"form\"]/div/div/div/div/a");

        public AccountCreatedPage(WebDriver driver) {
            this.driver = driver;
        }

        public boolean isAccountCreatedVisible() {
            return driver.findElement(accountCreatedText).isDisplayed();
        }

        public void contiuneButton(){
            driver.findElement(contiune).click();
        }
    }

