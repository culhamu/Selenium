package day09_excel_screenshot_jsExecutor;

import org.apache.poi.ss.usermodel.*;
import org.junit.Assert;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Map;
import java.util.TreeMap;

public class C02_ReadExcel {
    @Test
    public void test01() throws IOException {

        String dosyaYolu="src/test/java/day09_excel_screenshot_jsExecutor/ulkeler.xlsx";
        FileInputStream fis=new FileInputStream(dosyaYolu);
        Workbook workbook= WorkbookFactory.create(fis);
        Sheet sayfa1= workbook.getSheet("Sayfa1");

        //- 1.satirdaki 2.hucreye gidelim ve yazdiralim
        Row row=sayfa1.getRow(0);
        Cell cell= row.getCell(1);
        System.out.println(cell.toString());
        //2. Yöntem

        System.out.println(workbook.getSheet("Sayfa1").getRow(0).getCell(1));

        // - 1.satirdaki 2.hucreyi bir string degiskene atayalim ve yazdiralim
        String istenenData=workbook.getSheet("Sayfa1").getRow(0).getCell(1).toString();
        System.out.println(istenenData);

        // - 2.satir 4.cell’in afganistan’in baskenti oldugunu test edelim
        String expectedData="Kabil";
        String actualData=workbook.getSheet("Sayfa1").getRow(1).getCell(3).toString();
        Assert.assertEquals(expectedData,actualData);

        // - Satir sayisini bulalim
        System.out.println("Satır sayısı : "+(workbook.getSheet("Sayfa1").getLastRowNum()+1));
        //getLastRowNum bize index sayısını döndürür satır sayını istiyorsak 1 eklemeliyiz

        // - Sayfa2 deki satır sayısı ve Fiziki olarak kullanilan satir sayisini bulun
        System.out.println("Sayfa2 satır sayisi : "+(workbook.getSheet("Sayfa2").getLastRowNum()+1));

        System.out.println("Sayfa2 fiziki kulanılan satır sayısı : "+workbook.getSheet("Sayfa2").getPhysicalNumberOfRows());


        // - Ingilizce Ulke isimleri ve baskentleri bir map olarak kaydedelim

        Map<String,String> ulkelerMap=new TreeMap<>();
        int sonSatirIndexi=workbook.getSheet("Sayfa1").getLastRowNum();
        for (int i = 1; i <=sonSatirIndexi ; i++) {//Başlığı almamak için 1 den başlattım

            String key=workbook.getSheet("Sayfa1").getRow(i).getCell(0).toString();
            String value=workbook.getSheet("Sayfa1").getRow(i).getCell(1).toString();

            ulkelerMap.put(key,value);

        }

        System.out.println(ulkelerMap);

    }
}
