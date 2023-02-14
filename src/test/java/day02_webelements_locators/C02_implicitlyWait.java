package day02_webelements_locators;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C02_implicitlyWait {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver","drivers/chromedriver.exe");
        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        /*
        driver'ı bir web uygulamasına gönderdiğimizde o sayfanın açılması
        biraz zaman alabilir
        bu yüzden implicitlyWait özelliğini kullanarak oluşabilecek hataların önüne geçmek için
        belirli bir süre bekletmemiz gerekir.
         */
    }
}
