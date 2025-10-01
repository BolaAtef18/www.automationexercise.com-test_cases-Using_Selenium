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

public class Test_Case_13_Verify_Product_quantity_in_Cart {

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

        productDetailsPage = new ProductDetailsPage(driver);



    }


    @Test
    public void testverifyproductsincart() throws InterruptedException {
        int index=6;
        Assert.assertTrue(homePage.isHomePageVisible(), "Home Page is not visible!");
        Thread.sleep(1000);
        homePage.pressonViewProductbutton(index);
        Thread.sleep(1000);
        Assert.assertTrue(productDetailsPage.thisproductdetails());
        Thread.sleep(1000);
        productDetailsPage.increaseQuantity(4);
        Thread.sleep(1000);
        productDetailsPage.pressonaddtocartbutton();
        Thread.sleep(1000);
        productsPage.pressonViewCartButton();
        Thread.sleep(2000);
        Assert.assertTrue(cartPage.isProductDisplayed(index), "First product not in cart!");
        Thread.sleep(1000);
        Assert.assertEquals(cartPage.getProductQuantity(index),"4","product quantity mismatch!");


    }



    @AfterClass
    public void tearDown() {
        driver.quit();
    }

}
