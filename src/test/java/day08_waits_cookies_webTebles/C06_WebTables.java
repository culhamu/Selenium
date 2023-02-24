package day08_waits_cookies_webTebles;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

import java.util.List;

public class C06_WebTables extends TestBase {

    @Test
    public void test01(){

        //1. “https://demoqa.com/webtables” sayfasina gidin
        driver.get("https://demoqa.com/webtables");

        // 2. Headers da bulunan basliklari yazdirin
        List<WebElement> baslikElementi=driver.findElements(By.xpath("//div[@class='rt-tr']"));
        int siraNo=1;
        for (WebElement each:baslikElementi) {
            System.out.println(siraNo+"-->"+each.getText());
            siraNo++;
        }

        // 3. 3.sutunun basligini yazdirin
        WebElement ucuncuSutunBasligi= driver.findElement(By.xpath("(//div[@class='rt-resizable-header-content'])[3]"));
        System.out.println("Üçüncü sütun başlığı : "+ucuncuSutunBasligi.getText());

        // 4. Tablodaki tum datalari yazdirin
        List<WebElement> tumBodyElementleri=driver.findElements(By.xpath("//div[@class='rt-tr-group']//div[@class='rt-td']"));
        siraNo=1;
        for (WebElement each:tumBodyElementleri) {
            System.out.println(siraNo+"-->"+each.getText());
            siraNo++;
        }
        System.out.println(tumBodyElementleri.size());

        // 5. Tabloda kac tane bos olmayan cell (data) oldugunu yazdirin
        List<WebElement> tumDataElementi=driver.findElements(By.xpath("//div[@class='rt-tr-group']//div[@class='rt-td']"));
        siraNo=1;
        for (WebElement each:tumDataElementi) {
            if (!each.getText().equals(" ")){
                System.out.println(siraNo+"-->"+each.getText());
                siraNo++;
            }
        }

        // 6. Tablodaki satir sayisini yazdirin
        List<WebElement> satirSayisi=driver.findElements(By.xpath("//div[@class='rt-tr-group']"));
        System.out.println("Satır sayısı : "+satirSayisi.size());

        // 7. Tablodaki sutun sayisini yazdirin
        List<WebElement> sutunSayisi=driver.findElements(By.xpath("(//div[@class='rt-tr-group'])[1]//div[@class='rt-td']"));
        System.out.println("Sütun sayısı : "+sutunSayisi.size());

        // 8. Tablodaki 3.kolonu yazdirin
       for (int i = 1; i <10 ; i++) {

            System.out.println(getData(i,3));
        }

        // 9. Tabloda “First Name” i Kierra olan kisinin Salary’sini yazdirin
        WebElement kierraSalary= driver.findElement(By.xpath("((//div[@class='rt-tr -odd'])[2]//div[@class='rt-td'])[5]"));
        System.out.println("Kierra'nın maaşı : "+kierraSalary.getText());

        //10. Page sayfasinda bir method olusturun, Test sayfasindan satir ve sutun sayisini girdigimde bana datayi yazdirsin
        System.out.println(getData(3,5));


    }
    public String getData(int satirNo,int sutunNo){

        String dataPath="((//div[@class='rt-tr-group'])["+satirNo+"]//div[@class='rt-td'])["+sutunNo+"]";
        String istenenData=driver.findElement(By.xpath(dataPath)).getText();

        return istenenData;
    }
}
