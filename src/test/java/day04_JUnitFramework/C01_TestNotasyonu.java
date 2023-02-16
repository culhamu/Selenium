package day04_JUnitFramework;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C01_TestNotasyonu {
    /*
    Framework :ortak çalışma çerçevesidir
               hangi dosyaları nerede oluşturacagımızı belirler
               ve böylece toplu çalışmayı kolaylaştırır
               Her Framework dosya düzeni oluşturmanın yanında
               işerimizi kolaylaştıran yeni özellikler sunmuştur

               JUnit Framework en temel test framework'üdür.
               Bize kazandırdığı en önemli özellik test annotation(notasyon)'ıdır.
               Test notasyonu sayesinde herbir method bağımsız olarak çalıştırılabilen method olur.

               @test notasyonu sayesinde istersek herbir test methodunu bağımsız çalıştırabildiğimiz gibi
               istersek class leveldan çalıştırıp hepsini başlatabiliriz

               JUnit framework de hangi sıra ile çalışacağını öngöremetiz ve kontrol edemeyiz.



     */
    @Test
    public void test01(){
        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        driver.get("https://www.wisequarter.com");
        driver.close();

    }

    @Test
    public void test02(){
        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        driver.get("https://www.youtube.com");
        driver.close();

    }
}
