import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chromium.ChromiumDriver;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;

public class C01_RegisterUser {

        //1. Launch browser
    //2. Navigate to url 'http://automationexercise.com'
    //3. Verify that home page is visible successfully
    //4. Click on 'Signup / Login' button
    //5. Verify 'New User Signup!' is visible
    //6. Enter name and email address
    //7. Click 'Signup' button
    //8. Verify that 'ENTER ACCOUNT INFORMATION' is visible
    //9. Fill details: Title, Name, Email, Password, Date of birth
    //10. Select checkbox 'Sign up for our newsletter!'
    //11. Select checkbox 'Receive special offers from our partners!'
    //12. Fill details: First name, Last name, Company, Address, Address2, Country, State, City, Zipcode, Mobile Number
    //13. Click 'Create Account button'
    //14. Verify that 'ACCOUNT CREATED!' is visible
    //15. Click 'Continue' button
    //16. Verify that 'Logged in as username' is visible
    //17. Click 'Delete Account' button
    //18. Verify that 'ACCOUNT DELETED!' is visible and click 'Continue' button
    static WebDriver driver;
    @BeforeClass
    public static void setUp(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.navigate().to("http://automationexercise.com");
    }
    @AfterClass
    public static void tearDown() {
        //driver.quit();
    }
    @Test
    public void test(){
        Assert.assertTrue(driver.findElement(By.xpath("(//*[@class='col-sm-4'])[1]")).isDisplayed());
    }
    @Test
   @Ignore
    public void test2() {
        //Click on 'Signup / Login' button
        driver.findElement(By.xpath("//*[text()=' Signup / Login']")).click();
        String ActualText = driver.findElement(By.xpath("//h2[text()='New User Signup!']")).getText();
        String ExpectedText = "New User Signup!";
        Assert.assertEquals(ExpectedText, ActualText);
        //5. Verify 'New User Signup!' is visible


    } @Test
        public void test3(){
        //6. Enter name and email address
        //7. Click 'Signup' button
        //8. Verify that 'ENTER ACCOUNT INFORMATION' is visible
     //  driver.findElement(By.xpath("//*[text()=' Signup / Login']")).click();
        test2();
        driver.findElement(By.cssSelector("input[type='text']")).sendKeys("nurettin");
        driver.findElement(By.xpath("(//*[@type='email'])[2]")).sendKeys("nurettin@gmail.com");
        driver.findElement(By.xpath("(//*[@type='submit'])[2]")).click();
        String ActualText = driver.findElement(By.xpath("//*[text()='Enter Account Information']")).getText();
        String ExpectedText = "ENTER ACCOUNT INFORMATION";
        Assert.assertEquals(ExpectedText,ActualText);
        driver.findElement(By.xpath("//*[@id='id_gender1']")).click();
        driver.findElement(By.cssSelector("#password")).sendKeys("123");
        Select options=new Select(driver.findElement(By.xpath("(//*[@class='form-control'])[4]")));
        options.selectByValue("7");
        Select options2=new Select(driver.findElement(By.xpath("//*[@id='months']")));
        options2.selectByValue("1");
        Select options3=new Select(driver.findElement(By.xpath("//*[@id='years']")));
        options3.selectByValue("1994");
        //9. Fill details: Title, Name, Email, Password, Date of birth
        //10. Select checkbox 'Sign up for our newsletter!'
        //11. Select checkbox 'Receive special offers from our partners!'
        driver.findElement(By.cssSelector("#newsletter")).click();
        driver.findElement(By.cssSelector("#optin")).click();
       //Fill details: First name, Last name, Company, Address, Address2, Country, State, City, Zipcode, Mobile Number
        driver.findElement(By.cssSelector("#first_name")).sendKeys("nur");
        driver.findElement(By.cssSelector("#last_name")).sendKeys("nur");
        driver.findElement(By.cssSelector("#company")).sendKeys("nur");
        driver.findElement(By.cssSelector("#address1")).sendKeys("nur");

        driver.findElement(By.cssSelector("#first_name")).sendKeys("nur");
        driver.findElement(By.cssSelector("#first_name")).sendKeys("nur");
        driver.findElement(By.cssSelector("#first_name")).sendKeys("nur");
        //13. Click 'Create Account button'


}
}
