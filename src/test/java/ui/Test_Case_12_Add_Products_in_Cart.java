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

public class Test_Case_12_Add_Products_in_Cart {

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

    }


    @Test
    public void testaddproductsincart() throws InterruptedException {
        Assert.assertTrue(homePage.isHomePageVisible(), "Home Page is not visible!");
        Thread.sleep(1000);
        homePage.productbutton();
        Thread.sleep(1000);
        productsPage.HoverAndAddFirstProductToCart();
        Thread.sleep(1000);
        productsPage.pressonContinueShopping();
        Thread.sleep(3000);
        productsPage.HoverAndAddSecondProductToCart();
        Thread.sleep(1000);
        productsPage.pressonViewCartButton();
        Thread.sleep(1000);
        Assert.assertTrue(cartPage.isProductDisplayed(1), "First product not in cart!");
        Thread.sleep(1000);
        Assert.assertTrue(cartPage.isProductDisplayed(2), "Second product not in cart!");
        Thread.sleep(1000);
        Assert.assertEquals(cartPage.getProductQuantity(1), "1", "First product quantity mismatch!");
        Thread.sleep(1000);
        Assert.assertEquals(cartPage.getProductPrice(1), "Rs. 500", "First product price mismatch!");
        Thread.sleep(1000);
        Assert.assertEquals(cartPage.getProductTotal(1), "Rs. 500", "First product total mismatch!");
        Thread.sleep(1000);
        Assert.assertEquals(cartPage.getProductQuantity(2), "1", "Second product quantity mismatch!");
        Assert.assertEquals(cartPage.getProductPrice(2), "Rs. 400", "Second product price mismatch!");
        Assert.assertEquals(cartPage.getProductTotal(2), "Rs. 400", "Second product total mismatch!");
    }



    @AfterClass
    public void tearDown() {
        driver.quit();
    }

}
