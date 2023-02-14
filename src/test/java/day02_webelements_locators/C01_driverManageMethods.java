package day02_webelements_locators;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class C01_driverManageMethods {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("Webdriver.chrome.driver","drivers/chromedriver.exe");
        WebDriver driver=new ChromeDriver();

        System.out.println(driver.manage().window().getSize());
        //ilk size (1050, 700)
        System.out.println(driver.manage().window().getPosition());
        //ilk position (10, 10)

        //ölçü ve boyutlarını değiştirelim
        driver.manage().window().setSize(new Dimension(800,800));
        driver.manage().window().setPosition(new Point(40,100));

        System.out.println("size : "+driver.manage().window().getSize());
        System.out.println("position : "+driver.manage().window().getPosition());
        Thread.sleep(2000);
        driver.close();
    }
}
