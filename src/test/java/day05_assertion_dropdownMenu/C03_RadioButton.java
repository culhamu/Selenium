package day05_assertion_dropdownMenu;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C03_RadioButton {

    WebDriver driver;
    @Before
    public void setup(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.manage().window().maximize();


    }
    @Test
    public void test01(){
        // https://facebook.com
        driver.get("https://facebook.com");
        // c. Create an account buton’una basin
        driver.findElement(By.xpath("//a[text()='Yeni hesap oluştur']")).click();
        // d. Radio button elementlerini locate edin ve size uygun olani secin
        driver.findElement(By.xpath("//input[@id='u_8_b_eI']")).sendKeys("Ali");
        driver.findElement(By.xpath("//input[@id='u_8_d_YC']")).sendKeys("Veli");
        driver.findElement(By.xpath("//input[@id='u_8_g_V+']")).sendKeys("05446548978");
        driver.findElement(By.xpath("//input[@id='password_step_input']")).sendKeys("123456789a.wwrE");
        driver.findElement(By.xpath("//select[@id='day']")).sendKeys("15");
        driver.findElement(By.xpath("//select[@id='month']")).sendKeys("Haz");
        driver.findElement(By.xpath("//select[@id='year']")).sendKeys("2000");
       WebElement radioButton= driver.findElement(By.xpath("//input[@id='u_8_5_Qb']"));
       radioButton.click();

        //seçtiğiniz radio butonun seçili olup olmadığını test edin

        Assert.assertTrue(radioButton.isSelected());
        driver.findElement(By.xpath("//button[@id='u_8_s_HB']")).click();

    }
    @After
    public void teardown(){

    }
}
