package ui;

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

public class Test_Case_4_Logout_User {

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
        options.addArguments("--headless");          // يخلي المتصفح يرن من غير GUI
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
    public void TestLogoutUser() throws InterruptedException {
        Assert.assertTrue(homePage.isHomePageVisible(), "Home Page is not visible!");
        Thread.sleep(1000);
        homePage.clickSignupLogin();
        Thread.sleep(1000);
        signupPage.isLogintoyouraccountVisible();
        Thread.sleep(1000);
        signupPage.filloginForm("login@logout.com","123456");
        Thread.sleep(1000);
        loggedInPage.isLogged_in_as_usernameVisible();
        Thread.sleep(1000);
        loggedInPage.logout_button();
        Thread.sleep(1000);
        signupPage.isLogintoyouraccountVisible();
        Thread.sleep(1000);

    }


    @AfterClass
    public void tearDown() {
        driver.quit();
    }
}
