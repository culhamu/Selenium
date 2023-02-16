package day04_JUnitFramework;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C04_BeforeAfterClass {
    // 3 test method'u olusturun
    // 1.amazon anasayfaya gidip, amazona gittiginizi test edin
    // 2.Nutella aratip arama sonuclarinin nutella icerdigini test edin
    // 3.Ilk urune tiklayip, urun isminde Nutella gectigini test edin

    //eğer herbir test methodu için driver oluşturup kapatmamız gerekmiyrsa
    //class'in başında ve sonunda bir kez oluşturup kapatırız

    //BeforeClass ve AfterClass notasyonunu kullanan Method'lar Static olmalı

   static WebDriver driver;
    @BeforeClass
    public static void setup(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }

    @AfterClass
    public static void teardown(){
        driver.close();
    }
    @Test
    public void test01(){
        driver.get("https://www.amazon.com");
        String expectedIcerik="amazon";
        String actualaUrl=driver.getCurrentUrl();

        if (actualaUrl.contains(expectedIcerik)){
            System.out.println("Test PASSED");
        }else {
            System.out.println("Test FAILED"+
                               "Test amazon içer miyor");
        }
    }
    @Test
    public void test02(){

        WebElement serachBox= driver.findElement(By.id("twotabsearchtextbox"));
        serachBox.sendKeys("Nutella"+ Keys.ENTER);
        WebElement aramaSonucElementi= driver.findElement(By.xpath("//h1[@class='a-size-base s-desktop-toolbar a-text-normal']"));

        String expectedIcerik="Nutella";
        String actualIcerik=aramaSonucElementi.getText();

        if (actualIcerik.contains(expectedIcerik)){
            System.out.println("Test PASSED");
        }else {
            System.out.println("Test FAILED"+
                    "Test amazon içer miyor");
        }

    }
    @Test
    public void test03(){
        WebElement ilkUrun= driver.findElement(By.xpath("(//span[@class='a-size-base-plus a-color-base a-text-normal'])[1]"));
        ilkUrun.click();

        WebElement urunIsimElmnt= driver.findElement(By.xpath("//span[@id='productTitle']"));

        String expectedIcerik="Nutella";
        String actualUrunIsim= urunIsimElmnt.getText();

        if (actualUrunIsim.contains(expectedIcerik)){
            System.out.println("İlk urun testi PASSED");
        }else {
            System.out.println("Ilk urun testi FAILED");
        }

    }
}
