package day05_assertion_dropdownMenu;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;
import utilities.TestBaseClass;

public class C07_JavaScriptAlert extends TestBaseClass {
    // 3 test method'u olusturup her method'da bir JsAlert'e basin
    // Ilgili method'lari kullanin
    // https://the-internet.herokuapp.com/javascript_alerts  adresine gidin

    @Test
    public void test01(){
        // https://the-internet.herokuapp.com/javascript_alerts  adresine gidin
        driver.get("https://the-internet.herokuapp.com/javascript_alerts");
        // 1.alert'e tiklayalim
        driver.findElement(By.xpath("//*[text()='Click for JS Alert']")).click();
        // Alert'deki yazinin "I am a JS Alert" oldugunu test edelim
        String expectedAlertYazisi="I am a JS Alert";
        String actualAlertYazisi=driver.switchTo().alert().getText();
        Assert.assertEquals(expectedAlertYazisi,actualAlertYazisi);
        // OK tusuna basip alert'i kapatalim
        driver.switchTo().alert().accept();
    }
    @Test
    public void test02(){
        driver.get("https://the-internet.herokuapp.com/javascript_alerts");
        // 2.alert'e tiklayalim
        driver.findElement(By.xpath("//*[text()='Click for JS Confirm']")).click();
        driver.switchTo().alert().dismiss();
        // cancel'a basip, cikan sonuc yazisinin "You clicked: Cancel" oldugunu test edin
        String expectedSonucYazisi="You clicked: Cancel";
        String actualSonucYazisi=driver.findElement(By.xpath("//*[text()=‘You clicked: Cancel’]")).getText();
        Assert.assertEquals(expectedSonucYazisi,actualSonucYazisi);

    }
    @Test
    public void test03(){
        driver.get("https://the-internet.herokuapp.com/javascript_alerts");
        // 3.alert'e tiklayalim
        driver.findElement(By.xpath("//*[text()='Click for JS Prompt']")).click();
        // Cikan prompt ekranina "Abdullah" yazdiralim ve OK tusuna basarak alert'i kapatalim
        driver.switchTo().alert().sendKeys("Abdullah");
        driver.switchTo().alert().accept();
        // Cikan sonuc yazisinin Abdullah icerdigini test edelim
        String actualsonucYazisi= driver.findElement(By.xpath("//*[@id='result']")).getText();
        String expectedIcerik="Abdullah";
        Assert.assertEquals(expectedIcerik,actualsonucYazisi);


    }










}
