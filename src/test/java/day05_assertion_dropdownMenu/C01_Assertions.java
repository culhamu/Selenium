package day05_assertion_dropdownMenu;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C01_Assertions {
  //  1) Bir class oluşturun: YoutubeAssertions
  //  2) https://www.youtube.com adresine gidin
  //  3) Aşağıdaki adları kullanarak 4 test metodu oluşturun ve gerekli testleri yapin




    static WebDriver driver;
    @BeforeClass
    public static void setup(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.manage().window().maximize();
        driver.get("https://www.youtube.com");

    }
    @Test
    public void titleTest(){

        //  ○ titleTest   => Sayfa başlığının “YouTube” oldugunu test edin
        String expectedTitle="YouTube";
        String actualTitle=driver.getTitle();
        Assert.assertEquals(expectedTitle,actualTitle);

    }
    @Test
    public void imageTest(){
        //  ○ imageTest   => YouTube resminin görüntülendiğini (isDisplayed()) test edin
        WebElement webElement=driver.findElement(By.xpath("(//yt-icon[@id='logo-icon'])[1]"));
        Assert.assertTrue(webElement.isDisplayed());
    }
    @Test
    public void searchBoxTest(){
        //  ○ Search Box 'in erisilebilir oldugunu test edin (isEnabled())
        WebElement webElement= driver.findElement(By.xpath("//input[@id='search']"));
        Assert.assertTrue(webElement.isEnabled());
    }
    @Test
    public void wrongTitleTest(){

        //  ○ wrongTitleTest => Sayfa basliginin “youtube” olmadigini dogrulayin
        String unexpectedTitle="youtube";
        String actualTitle=driver.getTitle();
        Assert.assertNotEquals(unexpectedTitle,actualTitle);
    }
    @AfterClass
    public static void teardown(){
        driver.close();
    }








}
