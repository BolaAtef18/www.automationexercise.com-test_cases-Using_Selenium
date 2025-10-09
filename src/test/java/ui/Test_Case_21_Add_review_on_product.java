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
import java.util.List;
import java.util.Map;

public class Test_Case_21_Add_review_on_product {
    WebDriver driver;
    HomePage homePage;
    SignupPage signupPage;
    AccountCreatedPage accountCreatedPage;
    LoggedInPage loggedInPage;
    DeleteButtonPage deleteButtonPage;
    LogOutPage logOutPage;
    AllProductsPage allProductsPage;
    CartPage cartPage;
    ProductsPage productsPage;
    ProductDetailsPage productDetailsPage;
    CheckOutPage checkOutPage;
    PaymentPage paymentPage;

    @BeforeClass
    public void setup() {
        WebDriverManager.chromedriver().setup();

        ChromeOptions options = new ChromeOptions();
//        options.addArguments("--user-data-dir=/tmp/chrome-profile-" + System.currentTimeMillis());
        options.addArguments("--incognito");

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
        allProductsPage = new AllProductsPage(driver);
        cartPage = new CartPage(driver);
        productsPage = new ProductsPage(driver);
        productDetailsPage = new ProductDetailsPage(driver);
        checkOutPage = new CheckOutPage(driver);
        paymentPage = new PaymentPage(driver);
    }

    @Test
    public void testVerifyCartAfterLogin() throws InterruptedException {

        Assert.assertTrue(homePage.isHomePageVisible(), "Home Page is not visible!");
        Thread.sleep(2000);
        homePage.productbutton();
        Thread.sleep(1000);
        productsPage.isbrandsvisible();
        Thread.sleep(1000);
        productsPage.pressonviewcartbuttonofbluetop();
        Thread.sleep(1000);
        productDetailsPage.isWriteyourreviewvisiable();
        Thread.sleep(1000);
        productDetailsPage.enternameemailreview();
        Thread.sleep(1000);
        Assert.assertTrue(productDetailsPage.issuccessemessagevisiable(),"The Successe Message Not Appear");

    }


    @AfterClass
    public void tearDown() {
        System.out.println("Test Case 21 successfully");
        driver.quit();
    }
}
