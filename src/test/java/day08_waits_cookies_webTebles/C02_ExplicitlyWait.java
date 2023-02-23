package day08_waits_cookies_webTebles;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class C02_ExplicitlyWait {
    @Test
    public void test01(){
        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();

        //amazon anasayfaya gidin
        driver.get("https://www.amazon.com");

        //arama kutusu clickable olana kadar bekleyin


        //explicitly wait için
        WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(40));

        //mumkunse web elementi locate et
        WebElement searchBox= driver.findElement(By.id("twotabsearchtextbox"));

        //wait objesini kullanarak istenen görev için bekle
        wait.until(ExpectedConditions.elementToBeClickable(searchBox));

        searchBox.sendKeys("Nutella"+ Keys.ENTER);

        driver.close();

        //sonra Nutella araması yapın
    }
}
