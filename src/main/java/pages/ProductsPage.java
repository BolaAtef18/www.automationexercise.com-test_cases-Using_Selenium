package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.*;

public class ProductsPage {
    WebDriver driver;
    Actions actions;


    By firstProduct = By.xpath("/html/body/section[2]/div/div/div[2]/div/div[2]/div/div[1]/div[1]");
    By addtocartbutton1stproduct = By.xpath("/html/body/section[2]/div/div/div[2]/div[1]/div[2]/div/div[1]/div[2]/div/a");
    By continueshoppingbutton = By.xpath("//*[@id=\"cartModal\"]/div/div/div[3]/button");
    By secondProduct = By.xpath("/html/body/section[2]/div/div/div[2]/div/div[3]/div/div[1]/div[1]");
    By addtocartbutton2ndproduct = By.xpath("/html/body/section[2]/div/div/div[2]/div/div[3]/div/div[1]/div[1]/a");
    By viewcartbutton = By.xpath("//*[@id=\"cartModal\"]/div/div/div[2]/p[2]/a/u");
    By categories = By.xpath("/html/body/section/div/div[2]/div[1]/div/h2");
    By women_dressproducts = By.xpath("/html/body/section/div/div[2]/div[2]/div/h2");
    By mencat = By.xpath("//*[@id=\"accordian\"]/div[2]/div[1]/h4/a");
    By Tshirt = By.xpath("//*[@id=\"Men\"]/div/ul/li[1]/a");
    By men_tshirtproducts = By.xpath("/html/body/section/div/div[2]/div[2]/div/h2");
    By brands =By.xpath("/html/body/section[2]/div/div/div[1]/div/div[2]/h2");
    By Polo = By.xpath("/html/body/section[2]/div/div/div[1]/div/div[2]/div/ul/li[1]/a");
    By Poloproducts = By.xpath("/html/body/section/div/div[2]/div[2]/div/h2");
    By H_M =By.xpath("/html/body/section/div/div[2]/div[1]/div/div[2]/div/ul/li[2]/a");
    By H_Mproducts = By.xpath("/html/body/section/div/div[2]/div[2]/div/h2");
    By searchfiled = By.xpath("//*[@id=\"search_product\"]");
    By searchbutton = By.xpath("//*[@id=\"submit_search\"]");
    By searchedproduct = By.xpath("/html/body/section[2]/div/div/div[2]/div/div[2]/div/div[1]/div[2]");
    By productLocator = By.xpath("//div[@class=\"product-overlay\"]//div//a");
    By viewcartbuttonofbluetop = By.xpath("/html/body/section[2]/div/div/div[2]/div/div[2]/div/div[2]/ul/li/a");


    public ProductsPage (WebDriver driver) {
        this.driver = driver;
        this.actions = new Actions(driver);
    }

    // method تجيب كل أسماء المنتجات
    public List<String> getProductNames() {
        List<WebElement> products = driver.findElements(productLocator);
        List<String> names = new ArrayList<>();
        for (WebElement product : products) {
            String name = product.findElement(By.xpath(".//div/div/div[1]/div[1]/p")).getText();
            names.add(name);

        }
        return names;
    }

    public List<Map.Entry<Integer, String>> getAllProductIndexesAndIds() {
        List<WebElement> products = driver.findElements(productLocator);
        List<Map.Entry<Integer, String>> result = new ArrayList<>();

        for (int i = 0; i < products.size(); i++) {
            String productId = products.get(i).getAttribute("data-product-id");
            result.add(new AbstractMap.SimpleEntry<>(i, productId));
        }
        return result;
    }


    public void HoverAndAddFirstProductToCart() {
        actions.moveToElement(driver.findElement(firstProduct)).perform();
        driver.findElement(addtocartbutton1stproduct).click();
    }
    public void pressonContinueShopping(){
        driver.findElement(continueshoppingbutton).click();
    }
    public void HoverAndAddSecondProductToCart() {
        actions.moveToElement(driver.findElement(secondProduct)).perform();
        driver.findElement(addtocartbutton2ndproduct).click();
    }
    public void pressonViewCartButton(){
        driver.findElement(viewcartbutton).click();
    }
    public boolean iscategoryvisible(){
        return driver.findElement(categories).isDisplayed();
    }

    public String iswomendressproductvisible(){

        String Women_DressProduct = driver.findElement(women_dressproducts).getText();
        return Women_DressProduct;
    }

    public void pressonmencat(){
        driver.findElement(mencat).click();
    }
    public void pressontshirt(){
        driver.findElement(Tshirt).click();
    }
    public String ismentshortsvisible(){

        String Men_TshirtProducts = driver.findElement(men_tshirtproducts).getText();
        return Men_TshirtProducts;
    }
    public boolean isbrandsvisible(){
        return driver.findElement(brands).isDisplayed();
    }
    public void polobrand(){
        driver.findElement(Polo).click();
    }
    public String ispoloproductsvisible(){

        String PoloProducts = driver.findElement(Poloproducts).getText();
        return PoloProducts;
    }
    public void H_Mbrand(){
        driver.findElement(H_M).click();
    }
    public String isH_Mproductsvisible(){

        String H_MProducts = driver.findElement(H_Mproducts).getText();
        return H_MProducts;
    }
    public void Enterproductnameandclicksearch(String PROD) {
        driver.findElement(searchfiled).sendKeys(PROD);
        driver.findElement(searchbutton).click();
        assert driver.findElement(searchedproduct).isDisplayed(): "SEARCHED PRODUCTS' is not visible!";
    }
    public void verifyAllSearchedProductsVisible(){
        List<WebElement> products =driver.findElements(searchedproduct);

        for (WebElement product:products){
            assert product.isDisplayed(): "Product is not visible: " + product.getText();
        }
    }
    public void HoverAndAddProductToCart(int id,int index) throws InterruptedException {

        List<WebElement> products = driver.findElements(By.xpath("//div[@class='product-overlay']"));

        WebElement product = products.get(index);
        //System.out.println(products.size());
        actions.moveToElement(product).perform();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        WebElement addToCartBtn = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='overlay-content']//a[@data-product-id="+id+"]")));
        addToCartBtn.click();
    }
    public void pressonviewcartbuttonofbluetop(){
        driver.findElement(viewcartbuttonofbluetop).click();
    }
}
