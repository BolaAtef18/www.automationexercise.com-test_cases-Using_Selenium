package pages;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class HomePage {

    WebDriver driver;
    Actions actions;

    By logo = By.xpath("//*[@id=\"header\"]/div/div/div/div[1]/div/a/img");
    By signupLoginLink = By.xpath("//*[@id=\"header\"]/div/div/div/div[2]/div/ul/li[4]/a");
    By contactus = By.xpath("//*[@id=\"header\"]/div/div/div/div[2]/div/ul/li[8]/a");
    By testcasebutton = By.xpath("//*[@id=\"header\"]/div/div/div/div[2]/div/ul/li[5]/a");
    By testcase = By.xpath("//*[@id=\"form\"]/div/div[1]/div/h2/b");
    By productButton = By.xpath("//*[@id=\"header\"]/div/div/div/div[2]/div/ul/li[2]/a");
    By Allproduct = By.xpath("/html/body/section[2]/div/div/div[2]/div/h2");
    By subscription = By.xpath("//*[@id=\"footer\"]/div[1]/div/div/div[2]/div/h2");
    By subscriptionEmail = By.xpath("//*[@id=\"susbscribe_email\"]");
    By submitsubscripButton = By.xpath("//*[@id=\"subscribe\"]/i");
    By successemessage = By.xpath("//*[@id=\"success-subscribe\"]/div");
    By cartButton = By.xpath("//*[@id=\"header\"]/div/div/div/div[2]/div/ul/li[3]/a");
    By viewProduct = By.xpath("/html/body/section[2]/div/div/div[2]/div[1]/div[2]/div/div[2]/ul/li/a");
    By viewcartbutton = By.xpath("//*[@id=\"cartModal\"]/div/div/div[2]/p[2]/a/u");
    By categories = By.xpath("/html/body/section[2]/div/div/div[1]/div/h2");
    By women = By.xpath("//*[@id=\"accordian\"]/div[1]/div[1]/h4/a");
    By dress = By.xpath("//*[@id=\"Women\"]/div/ul/li[1]/a");
    By recommendeditems = By.xpath("/html/body/section[2]/div/div/div[2]/div[2]");
    By addtocartof1strecommendeditem = By.xpath("//*[@id=\"recommended-item-carousel\"]/div/div[2]/div[2]/div/div/div/a");
    By scrolluparrwo = By.xpath("//*[@id=\"scrollUp\"]/i");
    By fullfledged = By.xpath("//*[@id=\"slider-carousel\"]/div/div[1]/div[1]/h2");

    public HomePage(WebDriver driver) {
        this.driver = driver;
        this.actions = new Actions(driver);
    }
    public boolean isHomePageVisible() {return driver.findElement(logo).isDisplayed();}
    public void clickSignupLogin() {driver.findElement(signupLoginLink).click();}
    public void contactusbutton(){driver.findElement(contactus).click();}
    public void testCasebutton(){driver.findElement(testcasebutton).click();}
    public boolean isTestCasesVisible() {
        return driver.findElement(testcase).isDisplayed();
    }
    public void productbutton (){driver.findElement(productButton).click();}
    public boolean isAllproductVisible(){return driver.findElement(Allproduct).isDisplayed();}
    public void scrolldowntosubscription(){
        WebElement footer = driver.findElement(subscription);
        Actions actions = new Actions(driver);
        actions.scrollToElement(footer).perform();
    }
    public boolean verifySubscriptionisVisible(){return driver.findElement(subscription).isDisplayed();}
    public void Enteremailclickarrowbutton(){
        driver.findElement(subscriptionEmail).sendKeys("testing@test.com");
        driver.findElement(submitsubscripButton).click();
    }
    public boolean verifysuccessmessageisvisible(){return driver.findElement(successemessage).isDisplayed();}

    public void pressoncartbutton(){driver.findElement(cartButton).click();}
    public void pressonViewProductbutton(int index){driver.findElement(By.xpath("//a[@href='/product_details/"+index+"']")).click();}
    //public void addproducttocart (int index){driver.findElement(By.xpath("//a[@data-product-id="+index+"]")).click();}
    public void pressonviewcart(){driver.findElement(viewcartbutton).click();}

    public void HoverAndAddProductToCart(int index) throws InterruptedException {

        List<WebElement> products = driver.findElements(By.xpath("//div[@class='product-overlay']"));
        WebElement product = products.get(index-1);
        actions.moveToElement(product).perform();
        Thread.sleep(1000);

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        WebElement addToCartBtn = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='overlay-content']//a[@data-product-id="+index+"]")));
        addToCartBtn.click();
    }
    public boolean iscategoryvisible(){
        return driver.findElement(categories).isDisplayed();
    }

    public void womencat(){
        driver.findElement(women).click();
    }

    public void pressondress(){
        driver.findElement(dress).click();
    }

    public void scrolldowntorecommendeditems(){
        WebElement footer = driver.findElement(recommendeditems);
        Actions actions = new Actions(driver);
        actions.scrollToElement(footer).perform();
    }

    public boolean isRecommendeditems(){
        return driver.findElement(recommendeditems).isDisplayed();
    }

    public void pressonaddtocartbtnof1stiteminrecommended(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        WebElement addToCartBtnofthe1stitem = wait.until(ExpectedConditions.elementToBeClickable(addtocartof1strecommendeditem));
        addToCartBtnofthe1stitem.click();
    }
    public int idof1st(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        WebElement addToCartBtnofthe1stitem12 = wait.until(ExpectedConditions.elementToBeClickable(addtocartof1strecommendeditem));
        String idof1strecitem =  addToCartBtnofthe1stitem12.getAttribute("data-product-id");
        return Integer.parseInt(idof1strecitem);
    }
    public void pressonscrolluparrow(){
        driver.findElement(scrolluparrwo).click();
    }
    public String isfullfledgedvisible(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        WebElement fullfledgedelement = wait.until(ExpectedConditions.elementToBeClickable(fullfledged));

        String textfullfledged = fullfledgedelement.getText();
        return textfullfledged;
    }

    public void scrollupwithoutarrow(){
        WebElement header = driver.findElement(fullfledged);
        Actions actions = new Actions(driver);
        actions.scrollToElement(header).perform();
    }
}

