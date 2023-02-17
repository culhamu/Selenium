package practice;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class Q5 {
     /*
    Navigate to website https://testpages.herokuapp.com/styled/index.html
    Under the ORIGINAL CONTENTS
    click on Alerts
    print the URL
    navigate back
    print the URL
    Click on Basic Ajax
    print the URL
    enter value 20 and ENTER
    and then verify Submitted Values is displayed open page
    close driver
     */
    WebDriver driver;
    @Before
    public void setup(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.manage().window().maximize();
    }
    @After
    public void teardown(){
        driver.close();
    }
    @Test
    public void test(){
        driver.navigate().to("https://testpages.herokuapp.com/styled/index.html");

        driver.findElement(By.xpath("//a[@id='alerts']")).click();
        String url= driver.getCurrentUrl();
        System.out.println("url = " + url);
        driver.navigate().back();
        String url2= driver.getCurrentUrl();
        System.out.println("url2 = " + url2);
        driver.findElement(By.id("basicajax")).click();
        String url3= driver.getCurrentUrl();
        System.out.println("url3 = " + url3);
        WebElement basicAjax=driver.findElement(By.id("lteq30"));
        basicAjax.click();
        basicAjax.sendKeys("20");
        basicAjax.click();
        String pageTitle= driver.getTitle();
        Assert.assertTrue("sayfa 20 var mı: ",pageTitle.contains("20"));

    }
}
