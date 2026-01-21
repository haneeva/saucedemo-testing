package base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;

import java.time.Duration;

import resources.TestData;

import io.qameta.allure.testng.AllureTestNg;

@Listeners({AllureTestNg.class})
public class BaseTest {

    protected WebDriver driver;

    protected WebDriverWait wait;

    @BeforeMethod
    public  void setUp(){
        WebDriverManager.chromedriver().setup(); // Setup Chromedriver using WebDriveManager
        driver = new ChromeDriver();
        if (driver == null){
            System.err.println("Driver is not initialized!");
        } else {
            System.out.println("Driver initialized successfully.");
        }
        driver.manage().window().maximize();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.get(TestData.BASE_URL);

    }

    @AfterMethod
    public void tearDown(){
        if (driver != null){
            driver.quit();
        }
    }

}
