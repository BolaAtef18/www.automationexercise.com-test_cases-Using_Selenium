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

public class Test_Case_22_Add_to_cart_from_Recommended_items {
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
        int index =homePage.idof1st();
        System.out.println(index);

        Assert.assertTrue(homePage.isHomePageVisible(), "Home Page is not visible!");
        Thread.sleep(2000);
        homePage.scrolldowntorecommendeditems();
        Thread.sleep(1000);
        homePage.isRecommendeditems();
        Thread.sleep(1000);
        homePage.pressonaddtocartbtnof1stiteminrecommended();
        Thread.sleep(1000);
        homePage.pressonviewcart();
        Thread.sleep(1000);
        cartPage.isProductDisplayed(index);
    }


    @AfterClass
    public void tearDown() {
        driver.quit();
    }
}
