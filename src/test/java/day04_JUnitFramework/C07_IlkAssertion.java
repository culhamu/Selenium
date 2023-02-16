package day04_JUnitFramework;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C07_IlkAssertion {

             // 1) Bir class oluşturun: BestBuyAssertions
             // 2) https://www.bestbuy.com/ Adresine gidin
             // farkli test method’lari olusturarak asagidaki testleri yapin
             // ○ Sayfa URL’inin https://www.bestbuy.com/ ’a esit oldugunu test edin
             // ○ titleTest => Sayfa başlığının “Rest” içermediğini(contains) test edin
             // ○   logoTest => BestBuy logosunun görüntülendigini test edin
             // ○ FrancaisLinkTest => Fransizca Linkin görüntülendiğini test edin
    static WebDriver driver;

    @BeforeClass
    public static void setup(){
        driver=new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.manage().window().maximize();
        driver.get("https://www.bestbuy.com/");
    }
    @AfterClass
    public static void teardown(){
        driver.close();

    }
    @Test
    public void test01(){
        String expectedUrl="https://www.bestbuy.com/";
        String actualUrl=driver.getCurrentUrl();

        Assert.assertEquals(expectedUrl,actualUrl);
    }
    @Test
    public void test02(){
        String expectedIcerik="Rest";
        String actualIcerik=driver.getTitle();

        Assert.assertFalse(actualIcerik.contains(expectedIcerik));
    }
    @Test
    public void test03(){
        WebElement logo= driver.findElement(By.xpath("(//img[@alt='Best Buy Logo'])[1]"));

        Assert.assertTrue(logo.isDisplayed());
    }

    @Test
    public void test04(){
        WebElement link= driver.findElement(By.xpath("//button[text()='Français']"));
        Assert.assertTrue(link.isDisplayed());
    }
}
