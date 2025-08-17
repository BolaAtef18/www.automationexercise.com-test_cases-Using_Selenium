package pages;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.io.File;

public class ContactUsPage {

    WebDriver driver;

    public ContactUsPage(WebDriver driver) {
        this.driver = driver;
    }

    By GetInTouch = By.xpath("//*[@id=\"contact-page\"]/div[2]/div[1]/div/h2");

    By name = By.xpath("//*[@id=\"contact-us-form\"]/div[1]/input");
    By email = By.xpath("//*[@id=\"contact-us-form\"]/div[2]/input");
    By subject = By.xpath("//*[@id=\"contact-us-form\"]/div[3]/input");
    By message = By.xpath("//*[@id=\"message\"]");
    By uploadfile = By.xpath("//*[@id=\"contact-us-form\"]/div[5]/input");
    By submit = By.xpath("//*[@id=\"contact-us-form\"]/div[6]/input");
    By successmessage = By.xpath("//*[@id=\"contact-page\"]/div[2]/div[1]/div/div[2]");
    By homebutton = By.xpath("//*[@id=\"form-section\"]/a/span");
    By homepageverify = By.xpath("//*[@id=\"header\"]/div/div/div/div[1]/div/a/img");

    public boolean isGetInTouchVisible() {
        return driver.findElement(GetInTouch).isDisplayed();
    }

    public void EnterData() throws InterruptedException {
        driver.findElement(name).sendKeys("bola atef");
        Thread.sleep(1000);
        driver.findElement(email).sendKeys("bolaatef@test.com");
        Thread.sleep(1000);
        driver.findElement(subject).sendKeys("testing");
        Thread.sleep(1000);
        driver.findElement(message).sendKeys("testing");
        Thread.sleep(1000);
        File file = new File("src/test/resources/files/rubber.jpg");
        driver.findElement(uploadfile).sendKeys(file.getAbsolutePath());
        Thread.sleep(1000);
        driver.findElement(submit).click();
        Thread.sleep(1000);
        Alert alert = driver.switchTo().alert();
        alert.accept();
        Thread.sleep(1000);
    }

    public boolean issuccessmessageVisible() {
        return driver.findElement(successmessage).isDisplayed();
    }

    public  void ClickOnHome(){
        driver.findElement(homebutton).click();
    }

    public boolean ishomepageVisible() {
        return driver.findElement(homepageverify).isDisplayed();
    }
}
