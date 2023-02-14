package day02_webelements_locators;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C03_driverMethods {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver","drivers/chromedriver.exe");
        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

       // 1.Yeni bir class olusturalim (Homework)
       // 2.ChromeDriver kullanarak, facebook sayfasina gidin ve sayfa basliginin (title) “facebook” oldugunu dogrulayin (verify), degilse dogru basligi yazdirin.
        driver.get("https://www.facebook.com");
        String expectedTitle="facebook";
        String actualTitle=driver.getTitle();
        if (actualTitle.equals(expectedTitle)){
            System.out.println("Facebook Title Test PASSED");
        }else {
            System.out.println("Facebook Title Test FAILED"+
                               "\n Gerçekleşen Title : "+actualTitle);
        }
       // 3.Sayfa URL’inin “facebook” kelimesi icerdigini dogrulayin, icermiyorsa “actual” URL’i yazdirin.
        String expectedUrl="facebook";
        String actualUrl=driver.getCurrentUrl();
        if (actualUrl.contains(expectedUrl)){
            System.out.println("Facebook Url Test PASSED");
        }else {
            System.out.println("Facebook Url Test FAILED"+
                               "\n Gerçekleşen Url : "+actualUrl);
        }
       // 4.https://www.walmart.com/ sayfasina gidin.
        driver.get("https://www.walmart.com/");
       // 5. Sayfa basliginin “Walmart.com” icerdigini dogrulayin.
        String expectedWalmartTitle="Walmart.com";
        String actualWalmartTitle=driver.getTitle();

        if (actualWalmartTitle.contains(expectedWalmartTitle)){
            System.out.println("Walmart Title Test PASSED");
        }else {
            System.out.println("Walmart Title Test FAILED"+
                    "\n Gerçekleşen Title : "+actualWalmartTitle);
        }

       // 6. Tekrar “facebook” sayfasina donun
        driver.navigate().back()
        ;
       // 7. Sayfayi yenileyin
        driver.navigate().refresh();

       // 8. Sayfayi tam sayfa (maximize) yapin
        driver.manage().window().maximize();

       // 9.Browser’i kapatin
        driver.quit();
    }
}
