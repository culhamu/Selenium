package day05_assertion_dropdownMenu;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

public class C05_TestBaseIlkTest extends TestBase {
    // amazona gidip nutella aratalım sonuçların nutella içerdiğini test edelim
    @Test
    public void amazonTest(){

        driver.get("https://www.amazon.com");
        driver.findElement(By.id("twotabsearchtextbox")).sendKeys("Nutella"+ Keys.ENTER);
        WebElement actualSonucYazisi= driver.findElement(By.xpath("//h1[@class='a-size-base s-desktop-toolbar a-text-normal']"));
        String expectedIcerik="Nutella";
        String actualIcerik= actualSonucYazisi.getText();
        Assert.assertTrue(actualIcerik.contains(expectedIcerik));
    }
}
