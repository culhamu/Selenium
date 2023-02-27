package day09_excel_screenshot_jsExecutor;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

public class C08_JavascriptExecutorClick extends TestBase {

    @Test
    public void test01(){

        //wisequarter anasayfasıba gidelim
        driver.get("https://www.wisequarter.com");


        //refresh diyerek reklamı geçin
        driver.navigate().refresh();

        //Java Test automation tanıtımına kadar aşağı inin ve resmi click yapın
        WebElement otomasyonElementi= driver.findElement(By.xpath("(//img[@alt='Automation Engineer'])[1]"));
        JavascriptExecutor jse= (JavascriptExecutor) driver;

        jse.executeScript("arguments[0].scrollIntoView();",otomasyonElementi);
        jse.executeScript("arguments[0].click();",otomasyonElementi);


        //ekrana "JUnit bitti" yazdırın
        jse.executeScript("alert('JUnit bitti');");


    }
}
