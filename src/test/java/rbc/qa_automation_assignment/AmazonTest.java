package rbc.qa_automation_assignment;

import listenerspackage.CustomListeners;
import org.testng.annotations.Listeners;
import pageClassRepo.AmazonPageClassRepo;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;
import java.util.concurrent.TimeUnit;


@Listeners(CustomListeners.class)
public class AmazonTest {
    WebDriver driver;
    String baseUrl = "http://amazon.ca";
    String quantityValue = "2";
    AmazonPageClassRepo pageClassRepo;

    @BeforeClass
    public void beforeClassTest(){
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\pavelvorontsov\\Selenium\\drivers\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get(baseUrl);
        pageClassRepo = new AmazonPageClassRepo(driver);
    }

    @Test
    public void test(){
        pageClassRepo.clickKinderPaperwhiteLink();
        pageClassRepo.selectQuantity(quantityValue);
        pageClassRepo.clickAddToCartButton();
        pageClassRepo.clickPopUpWindowCloseButton();
        pageClassRepo.clickProceedToCheckoutButton();
        pageClassRepo.verifyEmailMobileLabelPresent();
    }

    @AfterClass
    public void afterClassTest(){
        driver.quit();
    }
}