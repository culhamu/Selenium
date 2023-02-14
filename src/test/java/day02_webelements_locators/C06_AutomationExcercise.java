package day02_webelements_locators;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;

public class C06_AutomationExcercise {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver","drivers/chromedriver.exe");
        WebDriver driver=new ChromeDriver();
       driver.manage().window().maximize();
       driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
      // 1- Bir test class’i olusturun ilgili ayarlari yapin
      // 2- https://www.automationexercise.com/ adresine gidin
        driver.get("https://www.automationexercise.com/");
      // 3- Sayfada 147 adet link bulundugunu test edin.
        List<WebElement> linkElementleriList=driver.findElements(By.tagName("a"));
        int expectedLinkSayisi=147;
        int actualLinkSayisi=linkElementleriList.size();

        if (actualLinkSayisi==expectedLinkSayisi){
            System.out.println("link test PASSED");
        }else {
            System.out.println("link test FAİLED"+
                               "actual Link sayısı : "+actualLinkSayisi);
        }

      // 4- Products linkine tiklayin
        driver.findElement(By.partialLinkText("Products")).click();
      // 5- special offer yazisinin gorundugunu test edin
        WebElement specialYazisi=driver.findElement(By.id("sale_image"));
        if (specialYazisi.isDisplayed()){
            System.out.println("Special offer testi PASSED");
        }else {
            System.out.println("Special offer testi FAILED");
        }
      // 6- Sayfayi kapatin
        Thread.sleep(2000);
        driver.close();
    }
}
