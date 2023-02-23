package day03_xpath_cssSelector;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.locators.RelativeLocator;

import java.time.Duration;

public class C05_RelativeLocators {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        driver.get("https://www.diemol.com/selenium-4-demo/relative-locators-demo.html");

        WebElement berlin=driver.findElement(By.xpath("//*[@*='pid7_thumb']"));
        WebElement nyc=driver.findElement(By.xpath("//*[@*='pid3_thumb']"));
        WebElement boston=driver.findElement(By.xpath("//*[@*='pid6_thumb']"));
        WebElement sailor=driver.findElement(By.xpath("//*[@*='pid11_thumb']"));

        //selenium4 ile yeni gelen bir özellik
        //olur da bir elemnti locate edemezsek
        //iki şey ile o elementi locate edebiliriz
        //1 etrafından bir webElement(sağ,sol,alt,üst)
        //2 locate edemediğimiz webElement'e ait bir özellik

        WebElement berlin1=driver.findElement(RelativeLocator.with(By.tagName("img")).below(nyc));
        berlin1.click();
        Thread.sleep(3000);
        System.out.println(berlin1.getAttribute("id"));//berlin1 id=pid7_thumb
        WebElement berlin2= driver.findElement(RelativeLocator.with(By.tagName("img")).toRightOf(boston));
        System.out.println(berlin2.getAttribute("id"));//berlin2 id=pid7_thumb
        WebElement berlin3= driver.findElement(RelativeLocator.with(By.tagName("img")).above(sailor));
        System.out.println(berlin3.getAttribute("id"));//berlin3 id=pid7_thumb
        driver.close();
    }
}
