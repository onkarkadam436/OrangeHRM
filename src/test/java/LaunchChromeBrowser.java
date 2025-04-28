
import org.openqa.selenium.*;
//import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.testng.Assert;

import java.util.Objects;

public class LaunchChromeBrowser {
    public static void main(String[]args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();  //auto-manages driver binaries
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
        Thread.sleep(5000);
        System.out.println(driver.getCurrentUrl());
        System.out.println(driver.getWindowHandles());
        System.out.println(driver.getTitle());
        Assert.assertEquals(driver.getTitle(),"OrangeHRM");

        if(Objects.equals(driver.getTitle(), "OrangeHRM")){
            driver.findElement(By.xpath ("//input[@Placeholder='Username']")).sendKeys("Admin");
            driver.findElement(By.xpath ("//input[@Placeholder='Password']")).sendKeys("admin123");
            driver.findElement(By.cssSelector("button.orangehrm-login-button")).click();
            System.out.println(driver.getCurrentUrl());

            if(Objects.equals(driver.getCurrentUrl(), "https://opensource-demo.orangehrmlive.com/web/index.php/dashboard/index")){
                System.out.println("Logged In Successfully");
            }

            driver.navigate().refresh();
            driver.navigate().back();
            System.out.println("last page url : "+ driver.getCurrentUrl());
            driver.navigate().forward();
            System.out.println("next page url : "+ driver.getCurrentUrl());

        }






    }
}
