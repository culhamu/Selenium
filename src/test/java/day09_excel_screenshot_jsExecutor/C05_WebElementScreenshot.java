package day09_excel_screenshot_jsExecutor;

import org.apache.commons.io.FileUtils;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

import java.io.File;
import java.io.IOException;

public class C05_WebElementScreenshot extends TestBase {
    @Test
    public void test01() throws IOException {

        driver.get("https://www.amazon.com");

        WebElement searchBox= driver.findElement(By.id("twotabsearchtextbox"));

        searchBox.sendKeys("Nutella"+ Keys.ENTER);

        WebElement actualResultText= driver.findElement(By.xpath("//h1[@class='a-size-base s-desktop-toolbar a-text-normal']"));
        String expectedText="Nutella";
        Assert.assertTrue(actualResultText.getText().contains(expectedText));

        //Sonuç yazısının  fotoğrafını çekelim
        //Fotoğraf çekilecek elementi locate edlim

        File elementScreenshot=new File("target/elementScreenshot.png");

        File geciciDosya=actualResultText.getScreenshotAs(OutputType.FILE);

        FileUtils.copyFile(geciciDosya,elementScreenshot);
    }
}
