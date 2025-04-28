import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

import java.util.Objects;


public class LocatorStructure {
    public static void main(String[]args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();  //auto-manages driver binaries
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        String LoginUrl = "https://opensource-demo.orangehrmlive.com/web/index.php/auth/login";
        driver.get(LoginUrl);

        Thread.sleep(10000);
        driver.findElement(By.xpath ("//input[@Placeholder='Username']")).sendKeys("Admin");
        driver.findElement(By.xpath ("//input[@Placeholder='Password']")).sendKeys("admin123");
        driver.findElement(By.cssSelector("button.orangehrm-login-button")).click();

        if(!Objects.equals(driver.getCurrentUrl(), LoginUrl)){
            System.out.println("Logged in");
        }else{
            System.out.println("Login Failed");
        }
    }
}
