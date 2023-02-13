package day01_seleniumGiris;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C04_driverMethods {
    public static void main(String[] args) {
        System.setProperty("Webdriver.Chrome.Driver","drivers/chromedriver.exe");
        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.get("https://www.wisequarter.com");
        System.out.println(driver.getWindowHandle());//CDwindow-54D4D376B75F6D521B99B51BCFAA6D72
        //***getWindowHandle selenium tarafından üretilen unique handle değerini döndürür

        System.out.println(driver.getWindowHandles());
        //getWindowHandles() test sırasında birden fazla sayfa açılmışsa onların handle değerlerini döndürür

        System.out.println(driver.getPageSource());
        //sayfa kodlarını içerir bunları test etmede faydalanılır


        //close() ve quit() ikiside sayfa kapatmak için kullanılır
        //close() sadece 1 sayfayı kapatırken quit() açılan bütün sayfaları kapatır.
        driver.close();
    }
}
