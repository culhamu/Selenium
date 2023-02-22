package day07_actionsClassAndFileTests;

import org.junit.Assert;
import org.junit.Test;

import java.nio.file.Files;
import java.nio.file.Paths;

public class C05_DinamikDosyaYolu {
    @Test
    public void test01(){
        //Masaüstümüzdeki TheDelta isimli bir dosya bulunduğunu test edin

        String dosyaYolu=System.getProperty("user.home")+"/OneDrive/Masaüstü/TheDelta.docx";

        Assert.assertTrue(Files.exists(Paths.get(dosyaYolu)));
    }
}
