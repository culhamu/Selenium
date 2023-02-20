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
       WebElement maleButton= driver.findElement(By.xpath("(//input[@type='radio'])[2]"));
       WebElement femaleButton= driver.findElement(By.xpath("(//input[@type='radio'])[1]"));
       WebElement customButton= driver.findElement(By.xpath("(//input[@type='radio'])[3]"));
       maleButton.click();

        //seçtiğiniz radio butonun seçili olup olmadığını test edin

        Assert.assertTrue(maleButton.isSelected());
        Assert.assertFalse(femaleButton.isSelected());
        Assert.assertFalse(customButton.isSelected());

    }
    @After
    public void teardown(){

        driver.close();
    }
}
