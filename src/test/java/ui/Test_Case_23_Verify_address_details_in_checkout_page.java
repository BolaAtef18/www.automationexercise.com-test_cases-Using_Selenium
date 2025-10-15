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

public class Test_Case_23_Verify_address_details_in_checkout_page {

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
    public void testVerifyaddressdetailsincheckoupage() throws InterruptedException {
        int index =1;

        Assert.assertTrue(homePage.isHomePageVisible(), "Home Page is not visible!");
        Thread.sleep(2000);
        homePage.clickSignupLogin();
        Thread.sleep(1000);
        signupPage.fillSignupForm("testerBola","bola3@testuser.com");
        Thread.sleep(1000);
        signupPage.fillAccountInfo();
        Thread.sleep(1000);
        signupPage.clickCreateAccount();
        Thread.sleep(1000);
        accountCreatedPage.contiuneButton();
        Thread.sleep(1000);
        Assert.assertTrue(loggedInPage.isLogged_in_as_usernameVisible(), " Logged in as username is not visible!");
        Thread.sleep(1000);
        homePage.HoverAndAddProductToCart(index);
        Thread.sleep(1000);
        homePage.pressonviewcart();
        Thread.sleep(1000);
        cartPage.isProductDisplayed(index);
        Thread.sleep(1000);
        cartPage.pressonprocessdtocheckoutbutton();
        Thread.sleep(1000);
        Assert.assertEquals(signupPage.STAD(), checkOutPage.deliveryaddressappearincheckout());
        System.out.println(signupPage.STAD());
        System.out.println(checkOutPage.deliveryaddressappearincheckout());
        Thread.sleep(1000);
        Assert.assertEquals(signupPage.STAD(), checkOutPage.billingaddressappearincheckout());
        System.out.println(signupPage.STAD());
        System.out.println(checkOutPage.billingaddressappearincheckout());
        Thread.sleep(1000);
        checkOutPage.delete_button();
        Thread.sleep(1000);
        Assert.assertTrue(deleteButtonPage.isAccount_DeletedVisible(), " Account Deleted is not visible!");
        Thread.sleep(1000);
        deleteButtonPage.contine_button();
        Thread.sleep(1000);

    }


    @AfterClass
    public void tearDown() {
        System.out.println("Test Case 23 successfully");
        driver.quit();
    }
}
