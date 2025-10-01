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

public class Test_Case_19_View_Cart_Brand_Products {
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
    public void testViewCartBrandProduct() throws InterruptedException {

        Assert.assertTrue(homePage.isHomePageVisible(), "Home Page is not visible!");
        Thread.sleep(2000);
        homePage.productbutton();
        Thread.sleep(1000);
        productsPage.isbrandsvisible();
        Thread.sleep(1000);
        productsPage.polobrand();
        Thread.sleep(1000);
        Assert.assertEquals(productsPage.ispoloproductsvisible(),"BRAND - POLO PRODUCTS");
        Thread.sleep(1000);
        productsPage.H_Mbrand();
        Thread.sleep(1000);
        Assert.assertEquals(productsPage.isH_Mproductsvisible(),"BRAND - H&M PRODUCTS");
        Thread.sleep(1000);
    }



    @AfterClass
    public void tearDown() {
        driver.quit();
    }
}
