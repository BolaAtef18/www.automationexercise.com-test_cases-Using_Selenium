package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class AllProductsPage {
    WebDriver driver;

    By productList = By.xpath("/html/body/section[2]/div/div/div[2]/div");
    By viewFirestProduct = By.xpath("/html/body/section[2]/div/div/div[2]/div/div[2]/div/div[2]/ul/li/a");
    By productName = By.xpath("/html/body/section/div/div/div[2]/div[2]/div[2]/div/h2");
    By category = By.xpath("/html/body/section/div/div/div[2]/div[2]/div[2]/div/p[1]");
    By price = By.xpath("/html/body/section/div/div/div[2]/div[2]/div[2]/div/span/span");
    By availability = By.xpath("/html/body/section/div/div/div[2]/div[2]/div[2]/div/p[2]");
    By condition = By.xpath("/html/body/section/div/div/div[2]/div[2]/div[2]/div/p[3]");
    By brand = By.xpath("/html/body/section/div/div/div[2]/div[2]/div[2]/div/p[4]");
    By searchfiled = By.xpath("//*[@id=\"search_product\"]");
    By searchbutton = By.xpath("//*[@id=\"submit_search\"]");
    By searchedproduct = By.xpath("/html/body/section[2]/div/div/div[2]/div/div[2]/div/div[1]/div[2]");



    public AllProductsPage(WebDriver driver) {this.driver = driver;}

    public boolean isProductListVisible(){return driver.findElement(productList).isDisplayed();}

    public void clickViewProductOfFirstProduct() {
        // اضغط على View Product لأول منتج
        WebElement firstProductViewBtn = driver.findElement(viewFirestProduct);
        firstProductViewBtn.click();

        // ممكن تضيف Assertion علشان تتأكد إن صفحة التفاصيل اتفتحت
        String expectedUrlPart = "https://www.automationexercise.com/product_details/1";
        assert driver.getCurrentUrl().contains(expectedUrlPart)
                : "Product details page not opened!";
    }

    public void verifyProductDetailsOfFirestProduct() {

        // Assertions للتأكد إن العناصر ظاهرة
        assert driver.findElement(productName).isDisplayed() : "Product Name not visible";
        assert driver.findElement(category).isDisplayed() : "Category not visible";
        assert driver.findElement(price).isDisplayed() : "Price not visible";
        assert driver.findElement(availability).isDisplayed() : "Availability not visible";
        assert driver.findElement(condition).isDisplayed() : "Condition not visible";
        assert driver.findElement(brand).isDisplayed() : "Brand not visible";
    }

    public void Enterproductnameandclicksearch() {
        driver.findElement(searchfiled).sendKeys("Men Tshirt");
        driver.findElement(searchbutton).click();
        assert driver.findElement(searchedproduct).isDisplayed(): "SEARCHED PRODUCTS' is not visible!";
    }

    public void verifyAllSearchedProductsVisible(){
        List<WebElement> products =driver.findElements(searchedproduct);

        for (WebElement product:products){
            assert product.isDisplayed(): "Product is not visible: " + product.getText();
        }
    }



}
