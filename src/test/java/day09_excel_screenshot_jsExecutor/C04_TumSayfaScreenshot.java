package day09_excel_screenshot_jsExecutor;

import org.apache.commons.io.FileUtils;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.*;
import utilities.TestBase;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

public class C04_TumSayfaScreenshot extends TestBase {
    @Test
    public void test01() throws IOException {

        driver.get("https://www.amazon.com");

        WebElement searchBox= driver.findElement(By.id("twotabsearchtextbox"));

        searchBox.sendKeys("Nutella"+ Keys.ENTER);

        WebElement actualResultText= driver.findElement(By.xpath("//h1[@class='a-size-base s-desktop-toolbar a-text-normal']"));
        String expectedText="Nutella";
        Assert.assertTrue(actualResultText.getText().contains(expectedText));

        //tüm sayfanın fotoğrafını çekelim

        //Tüms sayfa screenshot için;
        //1- TakeScreenshot pbjesi oluşturalım

        TakesScreenshot ts= (TakesScreenshot) driver;

        //2-Screenshot'ı kaydedeceğimiz bir dosya oluşturalım
        File tumSayfaSS=new File("target/screenshot.jpeg");

        //3-Geçici bir dosya oluşturup ts objesi ile çekilen fotoğrafı dosyaya kaydediyoruz
        File geciciResim=ts.getScreenshotAs(OutputType.FILE);

        //4-Geçici dosyayı tumSayfaSS dosyasına kopyalayalım
        FileUtils.copyFile(geciciResim,tumSayfaSS);
        bekle(3);
    }
}
