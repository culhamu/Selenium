package day08_waits_cookies_webTebles;


import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

import java.util.List;

import static dev.failsafe.internal.util.Assert.*;

public class C05_WebTables extends TestBase {

    @Test
    public void test01(){

        //1.“https://www.amazon.com” adresine gidin
        driver.get("https://www.amazon.com");

        //2.Sayfanin en altina inin
        Actions actions=new Actions(driver);
        actions.sendKeys(Keys.END).perform();

        //3.Web table tum body’sini yazdirin
        WebElement tumBody= driver.findElement(By.xpath("//tbody"));
        System.out.println(tumBody.getText());

        //4.Web table’daki satir sayisinin 10 oldugunu test edin
        List<WebElement> satilarListesi=driver.findElements(By.xpath("//tbody/tr"));
        Assert.assertEquals(10,satilarListesi.size());

        //5.Tum satirlari yazdirin
        int satirNo=1;
        for (WebElement each:satilarListesi) {
            System.out.println(satirNo+"-->"+each.getText());
            satirNo++;
        }

        //6. Web table’daki sutun sayisinin 13 olduğunu test edin

        List<WebElement> ucuncuSatirDataList=driver.findElements(By.xpath("//tbody/tr[3]/td"));
        Assert.assertEquals(13,ucuncuSatirDataList.size());

        //7. 5.sutunu yazdirin

        List<WebElement> besinciSutunElementleri=driver.findElements(By.xpath("//tbody/tr/td[5]"));
        satirNo=1;
        for (WebElement each:besinciSutunElementleri) {

            System.out.println(satirNo+"-->"+each.getText());
            satirNo++;
        }

        //8.Satir ve sutun sayisini parametre olarak alip, hucredeki bilgiyi döndüren bir method olusturun

        System.out.println(getData(3,5));

        //9.  7. satirin 9. datasının Shoes içerdiğini test edelim
        String actualData=getData(7,9);
        String expectedIcerik="Shoes";
        Assert.assertTrue(actualData.contains(expectedIcerik));


    }
    public  String getData(int satirNo,int sutunNo){

        //3. satır 5. sütundaki bilgiyi yazdırın
        String dataXPath="//tbody/tr["+satirNo+"]/td["+sutunNo+"]";

        String istenenData=driver.findElement(By.xpath(dataXPath)).getText();
        return istenenData;
    }
}
