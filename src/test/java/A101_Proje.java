import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.time.Duration;

public class A101_Proje {
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
       // driver.quit();
    }
    @Test
    public  void test(){
        driver.get("https://a101.com.tr");
        driver.findElement(By.xpath("//*[@id='CybotCookiebotDialogBodyLevelButtonLevelOptinAllowAll']")).click();
        Actions a=new Actions(driver);
        a.moveToElement(driver.findElement(By.xpath("(//*[@title='GİYİM & AKSESUAR'])[1]"))).perform();
     driver.findElement(By.xpath("//*[@title='Dizaltı Çorap']")).click();
        Assert.assertTrue(driver.findElement(By.xpath("(//*[@class='name'])[1]")).getText().contains("Siyah"));
        driver.findElement(By.xpath("(//*[@class='name'])[1]")).click();
        driver.findElement(By.xpath("//*[@class='add-to-basket button green block with-icon js-add-basket']")).click();
    driver.findElement(By.xpath("//*[@class='go-to-shop']")).click();
    driver.findElement(By.xpath("//*[@class='button green checkout-button block js-checkout-button']")).click();



    }
}
