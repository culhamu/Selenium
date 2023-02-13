package day01_seleniumGiris;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C06_driverManageMethods {
    public static void main(String[] args) {
        System.setProperty("Webdriver.chrome.driver","drivers/chromedriver.exe");
        WebDriver driver=new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        driver.get("https://www.amazon.com");

        driver.manage().window().maximize();

        System.out.println("maximize size : "+driver.manage().window().getSize());//maximize size : (1382, 736)
        System.out.println("maximize position : "+driver.manage().window().getPosition());//maximize position : (-8, -8)

        driver.manage().window().fullscreen();

        System.out.println("fullscreen size : "+driver.manage().window().getSize());//fullscreen size : (1366, 768)
        System.out.println("fullscreen position : "+driver.manage().window().getPosition());//fullscreen position : (0, 0)

        driver.close();
    }
}
