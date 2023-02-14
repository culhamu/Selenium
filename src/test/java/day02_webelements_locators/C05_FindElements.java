package day02_webelements_locators;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;

public class C05_FindElements {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("Webdriver.chrome.driver","drivers/chromedriver.exe");
        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

        //amazon anasayfasına gidin
        driver.get("https://www.amazon.com");

        //arama kutusuna java yazıp aratın
        WebElement searchBox= driver.findElement(By.id("twotabsearchtextbox"));
        searchBox.sendKeys("java"+ Keys.ENTER);

        //arama sonuçlarında çıkan resimlerdeki yazıları yazdırın

        List<WebElement> searchResultList=driver.findElements(By.className("sg-col-inner"));
        System.out.println(searchResultList.size());

        //bu 86 elementi yazdıralım
        int elementNo=1;
        for (WebElement each:searchResultList) {
            System.out.println(elementNo+"-->"+each.getText());
            elementNo++;
        }
        Thread.sleep(2000);
        driver.close();
    }
}
