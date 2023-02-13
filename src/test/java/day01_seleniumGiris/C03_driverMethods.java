package day01_seleniumGiris;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C03_driverMethods {
    public static void main(String[] args) {
        System.setProperty("Webdriver.chrome.driver","drivers/chromedriver.exe");
        WebDriver driver=new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.manage().window().maximize();
        //amazon sayfasına gidin
        //gittiğiniz sayfada ki title ve url yazdırın
        //amazon sayfasına gittiğinizi test edein
        driver.navigate().to("https://www.amazon.com");
        System.out.println("Amazon sayfasının Url'si : "+driver.getCurrentUrl());
        System.out.println("Amazon sayfasının Title'si : "+driver.getTitle());
        driver.close();
    }
}
