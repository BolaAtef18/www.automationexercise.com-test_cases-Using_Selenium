package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class SignupPage {

    public String STAD(){
          String addrees = "123 Test Street";
          return addrees;
    }

        WebDriver driver;

        By nameField = By.name("name");
        By emailField = By.xpath("//*[@id=\"form\"]/div/div/div[3]/div/form/input[3]");
        By signupButton = By.xpath("//*[@id=\"form\"]/div/div/div[3]/div/form/button");

        By titleMr = By.id("id_gender1");
        By password = By.id("password");
        By day = By.id("days");
        By month = By.id("months");
        By year = By.id("years");
        By newsletter = By.id("newsletter");
        By optin = By.id("optin");

        By firstName = By.id("first_name");
        By lastName = By.id("last_name");
        By company = By.id("company");
        By address = By.id("address1");
        By country = By.id("country");
        By state = By.id("state");
        By city = By.id("city");
        By zipcode = By.id("zipcode");
        By mobile = By.id("mobile_number");

        By createAccountButton = By.xpath("//*[@id=\"form\"]/div/div/div/div/form/button");
        By Logintoyouraccount = By.xpath("//*[@id=\"form\"]/div/div/div[1]/div/h2");
        By LoginEmail = By.xpath("//*[@id='form']/div/div/div[1]/div/form/input[2]");
        By LoginPW = By.xpath("//*[@id='form']/div/div/div[1]/div/form/input[3]");
        By LoginButton = By.xpath("//*[@id='form']/div/div/div[1]/div/form/button");
        By NewUserSignup = By.xpath("//*[@id=\"form\"]/div/div/div[3]/div/h2");
        By EmailAddressalreadyexist = By.xpath("//*[@id=\"form\"]/div/div/div[3]/div/form/p");




    public SignupPage(WebDriver driver) {
            this.driver = driver;
        }

    public boolean isLogintoyouraccountVisible() throws InterruptedException {
        WebElement logintoyouraccount = driver.findElement(Logintoyouraccount);
        Thread.sleep(1000);
        return logintoyouraccount.isDisplayed();
    }

    public boolean isNewUserSignupVisible() {
        return driver.findElement(NewUserSignup).isDisplayed();
    }
    public boolean isEmailAddressalreadyexistVisible() throws InterruptedException {
         WebElement emailAddress = driver.findElement(EmailAddressalreadyexist);
         Thread.sleep(1000);
        return emailAddress.isDisplayed();

    }

    public void fillSignupForm(String name, String email) {
        driver.findElement(nameField).sendKeys(name);
        driver.findElement(emailField).sendKeys(email);
        driver.findElement(signupButton).click();
    }

    public void filloginForm(String email, String password) {
        driver.findElement(LoginEmail).sendKeys(email);
        driver.findElement(LoginPW).sendKeys(password);
        driver.findElement(LoginButton).click();
    }


    public void fillAccountInfo() {
        driver.findElement(titleMr).click();
        driver.findElement(password).sendKeys("Test@1234");
        driver.findElement(day).sendKeys("1");
        driver.findElement(month).sendKeys("January");
        driver.findElement(year).sendKeys("2000");
        driver.findElement(newsletter).click();
        driver.findElement(optin).click();
        driver.findElement(firstName).sendKeys("Test");
        driver.findElement(lastName).sendKeys("User");
        driver.findElement(company).sendKeys("BA Company");
        driver.findElement(address).sendKeys(STAD());
        driver.findElement(country).sendKeys("India");
        driver.findElement(state).sendKeys("Test State");
        driver.findElement(city).sendKeys("Test City");
        driver.findElement(zipcode).sendKeys("12345");
        driver.findElement(mobile).sendKeys("0123456789");

    }

    public void clickCreateAccount() {
        driver.findElement(createAccountButton).click();

    }

}
