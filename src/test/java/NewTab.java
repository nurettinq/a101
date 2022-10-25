import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class NewTab {
    static WebDriver driver;
    @BeforeClass
    public static void setUp(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

    }
    @AfterClass
    public static void tearDown() {
        driver.quit();
    }
    @Test
    public void test(){
        driver.get("https://amazon.com");
        String ilkSayfaWindowHandleDegeri= driver.getWindowHandle();
        Assert.assertTrue(driver.getCurrentUrl().contains("amazon"));
        driver.switchTo().newWindow(WindowType.WINDOW);
        driver.get("http://www.bestbuy.com");
        String ikinciSayfaWindowHandleDegeri= driver.getWindowHandle();
        Assert.assertTrue(driver.getTitle().contains("Best Buy"));
        driver.switchTo().window(ilkSayfaWindowHandleDegeri);
        driver.findElement(By.id("twotabsearchtextbox")).sendKeys("Java", Keys.ENTER);
        Assert.assertTrue(driver.findElement(By.xpath("//*[@class='a-color-state a-text-bold']")).getText().contains("Java"));
        driver.switchTo().window(ikinciSayfaWindowHandleDegeri);
        Assert.assertTrue(driver.findElement(By.xpath("(//img[@class='logo'])[1]")).isDisplayed());

    }
}
