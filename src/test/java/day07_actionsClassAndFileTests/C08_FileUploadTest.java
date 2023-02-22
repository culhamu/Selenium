package day07_actionsClassAndFileTests;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

public class C08_FileUploadTest extends TestBase {
    @Test
    public void test01(){
        //1.https://the-internet.herokuapp.com/upload adresine gidelim
        driver.get("https://the-internet.herokuapp.com/upload");
        //2.chooseFile butonuna basalim
        //3.Yuklemek istediginiz dosyayi secelim.

        /*
        ChooseFile butonuna basarsak bilgisayarımızdan dosya seçme işlemi yapmamız gerekir
        ama selenium dosya seçme işlemi yapamaz
        bunun yerine selenium bir yöntem geliştirmiştir
        chooseFile ile seçmemiz gereken dosyanın yolunu oluşturup
        oluşturulan dosya yolunu sendkeys ile chooseFie gödermemiz yeterlidir
         */

        String dinamikDosyaYolu=System.getProperty("user.home")+"/OneDrive/Downloads/logo.png";
        WebElement chooseFileButton=driver.findElement(By.id("file-upload"));

        chooseFileButton.sendKeys(dinamikDosyaYolu);
        //4.Upload butonuna basalim.
        driver.findElement(By.id("file-submit")).click();
        //5.“File Uploaded!” textinin goruntulendigini test edelim.
        WebElement fileUploadedYaziElementi=driver.findElement(By.tagName("h3"));
        Assert.assertTrue(fileUploadedYaziElementi.isDisplayed());
    }
}
