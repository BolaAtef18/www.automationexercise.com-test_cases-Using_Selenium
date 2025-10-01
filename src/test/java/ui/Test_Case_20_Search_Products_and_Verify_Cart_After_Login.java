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

public class Test_Case_20_Search_Products_and_Verify_Cart_After_Login {
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
        checkOutPage = new CheckOutPage(driver);
        paymentPage = new PaymentPage(driver);
    }

    @Test
    public void testVerifyCartAfterLogin() throws InterruptedException {
        String ProdName="Men Tshirt";


        Assert.assertTrue(homePage.isHomePageVisible(), "Home Page is not visible!");
        Thread.sleep(2000);
        homePage.productbutton();
        Thread.sleep(1000);
        productsPage.isbrandsvisible();
        Thread.sleep(1000);
        productsPage.Enterproductnameandclicksearch(ProdName);
        Thread.sleep(1000);
        productsPage.verifyAllSearchedProductsVisible();
        Thread.sleep(3000);
        List<Map.Entry<Integer, String>> productDataList = productsPage.getAllProductIndexesAndIds();

        for (Map.Entry<Integer, String> entry : productDataList) {
            int index = entry.getKey();
            String id = entry.getValue();
            productsPage.HoverAndAddProductToCart(Integer.parseInt(id),index);
            Thread.sleep(1000);
            productsPage.pressonViewCartButton();
            Thread.sleep(1000);
            Assert.assertTrue(cartPage.isProductDisplayed(Integer.parseInt(id)), "The Product Not Display");
            Thread.sleep(1000);
            homePage.clickSignupLogin();
            Thread.sleep(1000);
            signupPage.filloginForm("login@logout.com", "123456");
            Thread.sleep(1000);
            loggedInPage.pressoncartbutton();
            Thread.sleep(1000);
            Assert.assertTrue(cartPage.isProductDisplayed(Integer.parseInt(id)), "The Product Not Display");
        }
    }



    @AfterClass
    public void tearDown() {
        driver.quit();
    }
}
