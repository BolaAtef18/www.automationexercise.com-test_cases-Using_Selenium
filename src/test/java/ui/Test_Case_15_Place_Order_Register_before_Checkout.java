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

public class Test_Case_15_Place_Order_Register_before_Checkout {
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
    CheckOutPage checkOutPage;
    PaymentPage paymentPage;


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
        allProductsPage = new AllProductsPage(driver);
        cartPage = new CartPage(driver);
        productsPage = new ProductsPage(driver);
        checkOutPage = new CheckOutPage(driver);
        paymentPage = new PaymentPage(driver);
    }


    @Test
    public void testPlaceOrderRegisterBeforeCheckout () throws InterruptedException {
        int index= 6;

        Assert.assertTrue(homePage.isHomePageVisible(), "Home Page is not visible!");
        Thread.sleep(2000);
        homePage.clickSignupLogin();
        Thread.sleep(1000);
        signupPage.fillSignupForm("testuser123","bola@testuser.com");
        Thread.sleep(1000);
        signupPage.fillAccountInfo();
        Thread.sleep(1000);
        signupPage.clickCreateAccount();
        Thread.sleep(1000);
        Assert.assertTrue(accountCreatedPage.isAccountCreatedVisible(),"Account Created message not visible!");
        Thread.sleep(1000);
        accountCreatedPage.contiuneButton();
        Thread.sleep(1000);
        Assert.assertTrue(loggedInPage.isLogged_in_as_usernameVisible(),"Logged in as username is not visible!");
        Thread.sleep(5000);

        homePage.HoverAndAddProductToCart(index);
        Thread.sleep(3000);
        homePage.pressonviewcart();
        Thread.sleep(1000);
        Assert.assertTrue(cartPage.isProductDisplayed(index),"product not in cart!");
        Thread.sleep(1000);
        cartPage.pressonprocessdtocheckoutbutton();
        Thread.sleep(1000);

        Assert.assertTrue(checkOutPage.isaddressdetailsvisiable(),"Address Details not visible");
        Thread.sleep(1000);
        Assert.assertTrue(checkOutPage.isreviewyourordervisiable(),"Review your order not visible");
        Thread.sleep(1000);
        checkOutPage.addcomment();
        Thread.sleep(1000);
        checkOutPage.pressonplaceorderbutton();
        Thread.sleep(3000);
        paymentPage.enterdataofcardandpayorder();
        // Thread.sleep(1000);
        Assert.assertTrue(paymentPage.issuccessmessagevisible(),"success message not visible");
        Thread.sleep(1000);
        loggedInPage.delete_button();
        Thread.sleep(1000);
        deleteButtonPage.isAccount_DeletedVisible();
        Thread.sleep(1000);
        deleteButtonPage.contine_button();
        Thread.sleep(1000);

    }



    @AfterClass
    public void tearDown() {
        driver.quit();
    }
}
