package ui;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.*;
import pages.*;

import java.time.Duration;
import java.util.UUID;

public class Test_Case_1_Register_User {

        WebDriver driver;
        HomePage homePage;
        SignupPage signupPage;
        AccountCreatedPage accountCreatedPage;
        LoggedInPage loggedInPage;
        DeleteButtonPage deleteButtonPage;

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
        }

        @Test
        public void testRegisterUser() {
            Assert.assertTrue(homePage.isHomePageVisible(), "Home Page is not visible!");
            homePage.clickSignupLogin();

            String uniqueEmail = "test_" + UUID.randomUUID().toString().substring(0, 5) + "@example.com";
            signupPage.fillSignupForm("TestUser", uniqueEmail);

            signupPage.fillAccountInfo();
            signupPage.clickCreateAccount();

            Assert.assertTrue(accountCreatedPage.isAccountCreatedVisible(), "Account Created message not visible!");
            accountCreatedPage.contiuneButton();

            Assert.assertTrue(loggedInPage.isLogged_in_as_usernameVisible(), " Logged in as username is not visible!");

            loggedInPage.delete_button();
            Assert.assertTrue(deleteButtonPage.isAccount_DeletedVisible(), " Account Deleted is not visible!");

            deleteButtonPage.contine_button();


        }

        @AfterClass
        public void tearDown() {
            driver.quit();
        }
    }

