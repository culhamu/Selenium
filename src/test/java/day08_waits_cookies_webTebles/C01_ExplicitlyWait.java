package day08_waits_cookies_webTebles;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class C01_ExplicitlyWait  {
    @Test
    public void test01(){
        /*
        Implcitly wait test yaparken işlemlerimizin çogunu halleder
        Nadirende olsa bazi işlemler için implicitlywait için tanımlanan
        süreden fazla zamana ihtiyaç olabilir

        Explicitlywait bir webElement üzerinde gerçekleşecek tek bir görev için tanımlanır

        Bunu için hem WebElement tanımlanmalı hem de görev

         */
        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
       // driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.manage().window().maximize();

        //3. https://the-internet.herokuapp.com/dynamic_controls adresine gidin.
        driver.get("https://the-internet.herokuapp.com/dynamic_controls");
        //4. Remove butonuna basin.
        driver.findElement(By.xpath("//*[text()='Remove']")).click();
        //5. “It’s gone!” mesajinin goruntulendigini dogrulayin.
        //  explicitlywait kullanacaksak
        //a- bir wait objesi olusturacaz

        WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(40));

        //b- EGER kullanacağımız WebElement locate edilebilirse locate yapalım

      //  WebElement itsGoneElementi= driver.findElement(By.xpath("//*[text()=\"It's gone!\"]"));

        //c- EGER locate etmemiz için zamana ihtiyaç varsa
        //o zaman locate ve görev tanımlama tek satırda olur

        WebElement itsGoneElementi=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[text()=\"It's gone!\"]")));
                Assert.assertTrue(itsGoneElementi.isDisplayed());
        driver.close();


    }

}
