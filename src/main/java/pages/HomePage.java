package pages;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

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
    By arrowButton = By.xpath("//*[@id=\"subscribe\"]/i");
    By successemessage = By.xpath("//*[@id=\"success-subscribe\"]/div");
    By cartButton = By.xpath("//*[@id=\"header\"]/div/div/div/div[2]/div/ul/li[3]/a");
    By viewProduct = By.xpath("/html/body/section[2]/div/div/div[2]/div[1]/div[2]/div/div[2]/ul/li/a");
    By viewcartbutton = By.xpath("//*[@id=\"cartModal\"]/div/div/div[2]/p[2]/a/u");

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
        driver.findElement(arrowButton).click();
    }
    public boolean verifysuccessmessageisvisible(){return driver.findElement(successemessage).isDisplayed();}

    public void pressoncartbutton(){driver.findElement(cartButton).click();}
    public void pressonViewProductbutton(int index){driver.findElement(By.xpath("//a[@href='/product_details/"+index+"']")).click();}
    public void addproducttocart (int index){driver.findElement(By.xpath("//a[@data-product-id="+index+"]"));}
    public void pressonviewcart(){driver.findElement(viewcartbutton).click();}

    public void HoverAndAddProductToCart(int index) throws InterruptedException {
        actions.moveToElement(driver.findElement(By.xpath("//a[@data-product-id="+ index +"]"))).perform();
        driver.findElement(By.xpath("/html/body/section[2]/div/div/div[2]/div/div[7]/div/div[1]/div[2]/div/a[@data-product-id="+index+"]")).click();
    }
}

