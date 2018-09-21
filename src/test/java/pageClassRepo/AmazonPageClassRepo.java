package pageClassRepo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

/*
For test sake all the WebElements and methods are located in this class - pageClassRepo,
though each WebPage would be preferable to have it's own class
- f.e. HomePageRepo, ItemPageRepo, OrderSubtotalPageRepo etc.
 */
public class AmazonPageClassRepo {
    WebDriver driver;

    public AmazonPageClassRepo(WebDriver driver){
        this.driver = driver;
    }


    public WebElement element = null;

    //HomePage WebElements and methods

    public  WebElement departmentTab(){
        element = driver.findElement(By.id("nav-shop"));
        return  element;
    }

    public  WebElement kindleText(){
        element = driver.findElement(By.xpath("//span[@data-nav-panelkey = 'KindlePanel']/span[text() = 'Kindle']"));
        return  element;
    }

    public WebElement kindlePaperwhiteLink(){
        element = driver.findElement(By.xpath("//span[contains(@class,'nav-text') and contains(text(), 'Kindle Paperwhite')]"));
        return  element;
    }

    public void clickKinderPaperwhiteLink(){
        Actions action = new Actions(driver);
        action.moveToElement(departmentTab()).perform();
        action.moveToElement(kindleText()).perform();
        kindlePaperwhiteLink().click();
    }

    //ItemPage WebElements and methods

    public WebElement quantityBox(){
        element = driver.findElement(By.id("quantity"));
        return  element;
    }

    public WebElement addToCartButton(){
        element = driver.findElement(By.id("add-to-cart-button"));
        return  element;
    }

    public WebElement popUpWindowCloseButton(){
        element = driver.findElement(By.xpath("//i[@class = 'a-icon a-icon-close']"));
        return  element;
    }

    public void selectQuantity(String value) {
        Select select = new Select(quantityBox());
        select.selectByValue(value);
    }

    public void clickAddToCartButton() {
        addToCartButton().click();
    }

    public void clickPopUpWindowCloseButton() {
        popUpWindowCloseButton().click();
    }

    //Order subtotal page WebElements and methods

    public WebElement proceedToCheckoutButton(){
        element = driver.findElement(By.xpath("//a[@class = 'hucSprite s_checkout hlb-checkout-button']"));
        return  element;
    }

    public void clickProceedToCheckoutButton() {
        proceedToCheckoutButton().click();
    }

    //Signing page WebElements and methods

    public boolean isElementPresent(WebElement element) {
        if (element != null)
            return true;
        else
            return false;
    }

    public WebElement emailMobileLabel(){
        element = driver.findElement(By.xpath("//label[contains(text(), 'E-mail address or mobile phone number')]"));
        return element;
    }

    public boolean verifyEmailMobileLabelPresent() {
        return isElementPresent(emailMobileLabel());
    }
 }