package ui;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.*;

import java.time.Duration;

public class Test_Case_2_Login_User_with_correct_email_and_password {

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
        options.addArguments("--headless");

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
    public void testLoginUserwithCorrectEmailandPassword() throws InterruptedException {
        Assert.assertTrue(homePage.isHomePageVisible(), "Home Page is not visible!");
        homePage.clickSignupLogin();
        Assert.assertTrue(signupPage.isLogintoyouraccountVisible(),"Login to your account is not visible");
        signupPage.fillSignupForm("bola atef", "bola123@Test.com");
        signupPage.fillAccountInfo();
        signupPage.clickCreateAccount();
        accountCreatedPage.isAccountCreatedVisible();
        accountCreatedPage.contiuneButton();
        Thread.sleep(2000);
        loggedInPage.isLogged_in_as_usernameVisible();
        logOutPage.logout_button();
        Thread.sleep(2000);
        signupPage.filloginForm("bola123@Test.com","Test@1234");
        loggedInPage.isLogged_in_as_usernameVisible();
        loggedInPage.delete_button();
        deleteButtonPage.isAccount_DeletedVisible();
        deleteButtonPage.contine_button();
    }

    @AfterClass
    public void tearDown() {
        driver.quit();
    }
}
