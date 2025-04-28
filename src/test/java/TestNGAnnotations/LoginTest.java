package TestNGAnnotations;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;

import java.util.Objects;

public class LoginTest {
    String loginUrl;
    String userName;
    String passWord;
    String invalidPassword;
    WebDriver driver;

    @BeforeSuite
   /*   Setup                     	Why
    Test Data Setup         	If you need to connect to a database, create test data, etc.
    Database Connection	        Open a DB connection pool if needed for your tests.
    Global Configuration	    Load properties files (like environment URL, credentials).
    Reporting Setup	            Start test report generation (e.g., ExtentReports, Allure setup).
    API Authentication	        Get an access token once if multiple API tests need it.
    Server Setup	            Start mock servers or Docker containers (for APIs, services).
    Logging Initialization	    Start loggers or log frameworks if required for the suite.    */

    public void SetUpChrome(){
        loginUrl = "https://opensource-demo.orangehrmlive.com/web/index.php/auth/login";
        userName = "Admin";
        passWord = "admin123";
        invalidPassword = "123Admin";
        System.out.println("Invoked Test Data");
    }

    @BeforeClass
    public void setupClass() {
        System.out.println("Before Class");

    }

    @BeforeMethod
    public void initializeBrowser() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        System.out.println("Chrome Browser Initialised");
        driver.get(loginUrl);
        Thread.sleep(5000);
    }

    @Test
    public void CheckValidLogin() throws InterruptedException {
        driver.findElement(By.xpath ("//input[@Placeholder='Username']")).sendKeys(userName);
        driver.findElement(By.xpath ("//input[@Placeholder='Password']")).sendKeys(passWord);
        driver.findElement(By.cssSelector("button.orangehrm-login-button")).click();
        Thread.sleep(5000);
        if(!Objects.equals(driver.getCurrentUrl(), loginUrl)){
            System.out.println("Logged in successfully with Valid Credentials");
        }else{
            System.out.println("Login Failed");
        }
    }
    @Test
    public void CheckInvalidLogin() throws InterruptedException {
        driver.findElement(By.xpath ("//input[@Placeholder='Username']")).sendKeys(userName);
        driver.findElement(By.xpath ("//input[@Placeholder='Password']")).sendKeys(invalidPassword);
        driver.findElement(By.cssSelector("button.orangehrm-login-button")).click();
        Thread.sleep(5000);
        if(!Objects.equals(driver.getCurrentUrl(), loginUrl)){
            System.out.println("Logged in successfully with InValid Credentials");
        }else{
            System.out.println("Login Failed");
        }
    }

    @AfterMethod
    public void teardownDriver(){
        driver.quit();
        System.out.println("Driver closed !");

    }

    @AfterClass
    public void setupTearDownClass(){
        System.out.println("TearDown the Class");
    }

    @AfterSuite
    public void setupTearDownSuite(){
        System.out.println("Tear down the suite");
    }

}
