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

public class Test_Case_9_Search_Product {


    WebDriver driver;
    HomePage homePage;
    SignupPage signupPage;
    AccountCreatedPage accountCreatedPage;
    LoggedInPage loggedInPage;
    DeleteButtonPage deleteButtonPage;
    LogOutPage logOutPage;
    AllProductsPage allProductsPage;
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
        productsPage = new ProductsPage(driver);

    }

    @Test
    public void testSearchProduct() throws InterruptedException {
        String ProdName="Men Tshirt";

        Assert.assertTrue(homePage.isHomePageVisible(), "Home Page is not visible!");
        Thread.sleep(1000);
        homePage.productbutton();
        Thread.sleep(1000);
        homePage.isAllproductVisible();
        Thread.sleep(1000);
        productsPage.Enterproductnameandclicksearch(ProdName);
        Thread.sleep(1000);
        productsPage.verifyAllSearchedProductsVisible();

    }


    @AfterClass
    public void tearDown() {
        System.out.println("Test Case 9 successfully");
        driver.quit();
    }
}
