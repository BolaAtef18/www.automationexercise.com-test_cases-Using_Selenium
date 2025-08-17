package pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage {

    WebDriver driver;
    By logo = By.xpath("//*[@id=\"header\"]/div/div/div/div[1]/div/a/img");
    By signupLoginLink = By.xpath("//*[@id=\"header\"]/div/div/div/div[2]/div/ul/li[4]/a");
    By contactus = By.xpath("//*[@id=\"header\"]/div/div/div/div[2]/div/ul/li[8]/a");
    By testcasebutton = By.xpath("//*[@id=\"header\"]/div/div/div/div[2]/div/ul/li[5]/a");
    By testcase = By.xpath("//*[@id=\"form\"]/div/div[1]/div/h2/b");

        public HomePage(WebDriver driver) {
            this.driver = driver;
        }
        public boolean isHomePageVisible() {
           return driver.findElement(logo).isDisplayed();
        }
        public void clickSignupLogin() {
            driver.findElement(signupLoginLink).click();
        }
        public void contactusbutton(){
            driver.findElement(contactus).click();
        }
        public void testCasebutton(){driver.findElement(testcasebutton).click();}
        public boolean isTestCasesVisible() {
        return driver.findElement(testcase).isDisplayed();
    }

}

