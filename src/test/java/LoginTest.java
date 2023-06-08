import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginTest {

    WebDriver wd;

    @BeforeMethod
    public void init(){
        wd = new ChromeDriver();
        wd.navigate().to("https://telranedu.web.app/home");
    }

    @Test
    public void loginPositiveTest(){
        // open login form
        wd.findElement(By.xpath("//*[text()='LOGIN']")).click();
        // fill login form
        WebElement emailInput = wd.findElement(By.xpath("//input[1]"));
        emailInput.click();
        emailInput.clear();
        emailInput.sendKeys("abc@def.com");

        WebElement passInput = wd.findElement(By.xpath("//input[2]"));
        passInput.click();
        passInput.clear();
        passInput.sendKeys("$Abcdef12345");
        // click on Login button
        wd.findElement(By.xpath("//button[1]")).click();

        // Assert
        Assert.assertTrue(wd.findElements(By.xpath("//*[text()='Sign Out']")).size() > 0);


    }

    @AfterMethod
    public void tearDown(){

    }
}
