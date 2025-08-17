package tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.*;

import java.time.Duration;

public class Test_Case_3_Login_User_with_incorrect_email_and_password {
    WebDriver driver;
    HomePage homePage;
    SignupPage signupPage;
    AccountCreatedPage accountCreatedPage;
    LoggedInPage loggedInPage;
    DeleteButtonPage deleteButtonPage;
    LogOutPage logOutPage;

    @BeforeClass
    public void setup() {
        WebDriverManager.chromedriver().setup();

        ChromeOptions options = new ChromeOptions();
        options.addArguments("--user-data-dir=/tmp/chrome-profile-" + System.currentTimeMillis());
        driver = new ChromeDriver(options);

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.get("https://www.automationexercise.com");

        homePage = new HomePage(driver);
        signupPage = new SignupPage(driver);
        accountCreatedPage = new AccountCreatedPage(driver);
        loggedInPage = new LoggedInPage(driver);
        deleteButtonPage = new DeleteButtonPage(driver);
        logOutPage = new LogOutPage(driver);

    }

    @Test
    public void testLoginUserwithINCorrectEmailandPassword()  {
        Assert.assertTrue(homePage.isHomePageVisible(), "Home Page is not visible!");
        homePage.clickSignupLogin();
        Assert.assertTrue(signupPage.isLogintoyouraccountVisible(),"Login to your account is not visible");
        signupPage.filloginForm("123@gmail.com","123");
        Assert.assertTrue(driver.findElement(By.xpath("//*[@id=\"form\"]/div/div/div[1]/div/form/p")).isDisplayed(), "Your email or password is incorrect! is visible");


    }


    @AfterClass
    public void tearDown() {
        driver.quit();
    }
}
