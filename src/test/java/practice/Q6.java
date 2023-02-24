package practice;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;


public class Q6  {

   static WebDriver driver;
   static WebElement searchBox;

    @BeforeClass
    public static void setup(){

        //    BeforeClass ile driver'i olusturun ve class icinde static yapin
        WebDriverManager.chromedriver().setup();
        //    Maximize edin ve 10 sn bekletin
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }
    @Before
    public void before(){
        //    http://www.google.com adresine gidin
        driver.get("http://www.google.com");
        searchBox=driver.findElement(By.xpath("//input[@title='Ara']"));
    }

    @Test
    public void test01(){



        //    arama kutusuna "The Lord of the Rings" yazip, cikan sonuc sayisini yazdirin

        searchBox.sendKeys("The Lord of the Rings"+ Keys.ENTER);
        System.out.println(driver.findElement(By.id("result-stats")).getText());

    }
    @Test
    public void test02(){


        //    arama kutusuna "Brave Heart" yazip, cikan sonuc sayisini yazdirin
        searchBox.sendKeys("Brave Heart"+Keys.ENTER);
        System.out.println(driver.findElement(By.id("result-stats")).getText());


    }
    @Test
    public void test03(){

        //    arama kutusuna "Harry Potter" yazip, cikan sonuc sayisini yazdirin
        searchBox.sendKeys("Harry Potter"+Keys.ENTER);
        System.out.println(driver.findElement(By.id("result-stats")).getText());


    }
    @AfterClass
    public static void teardown(){

        //    AfterClass ile kapatin.
        driver.quit();

    }
}
