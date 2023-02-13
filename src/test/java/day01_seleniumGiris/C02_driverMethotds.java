package day01_seleniumGiris;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C02_driverMethotds {
    public static void main(String[] args) {


        System.setProperty("Webdriver.chrome.driver","drivers/chromedriver.exe");
        WebDriver driver=new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.manage().window().maximize();

        driver.get("https://www.wisequarter.com");

        driver.close();

    }
}
