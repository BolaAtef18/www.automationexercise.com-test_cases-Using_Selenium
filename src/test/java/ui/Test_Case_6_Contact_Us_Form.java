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

public class Test_Case_6_Contact_Us_Form {
    WebDriver driver;
    HomePage homePage;
    SignupPage signupPage;
    AccountCreatedPage accountCreatedPage;
    LoggedInPage loggedInPage;
    DeleteButtonPage deleteButtonPage;
    LogOutPage logOutPage;
    ContactUsPage contactUsPage;

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
        contactUsPage =new ContactUsPage(driver);

    }

    @Test
    public void testContactUsForm() throws InterruptedException {
        Assert.assertTrue(homePage.isHomePageVisible(), "Home Page is not visible!");
        Thread.sleep(1000);
        homePage.contactusbutton();
        Thread.sleep(1000);
        Assert.assertTrue(contactUsPage.isGetInTouchVisible(),"Get In Touch not visible");
        Thread.sleep(1000);
        contactUsPage.EnterData();
        Thread.sleep(1000);
        contactUsPage.issuccessmessageVisible();
        Thread.sleep(1000);
        contactUsPage.ClickOnHome();
        Thread.sleep(1000);
        contactUsPage.ishomepageVisible();
        Thread.sleep(1000);

    }



    @AfterClass
    public void tearDown() {
        driver.quit();
    }
}
