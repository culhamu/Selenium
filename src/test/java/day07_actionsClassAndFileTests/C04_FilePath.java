package day07_actionsClassAndFileTests;

import org.junit.Test;

import java.nio.file.Files;
import java.nio.file.Paths;

public class C04_FilePath {
    @Test
    public void test01(){
        //user.home
        //"C:\Users\mergu\OneDrive\Masaüstü\TheDelta.docx"

        //içinde bulunduğumuz projenin temel dosya yolu user.dir
        //C:\Users\mergu\seleniumTeam108\src\test\java\day07_actionsClassAndFileTests\text.txt

        String dosyaYolu="C:/Users/mergu/OneDrive/Masaüstü/TheDelta.docx";

        boolean sonuc= Files.exists(Paths.get(dosyaYolu));
        System.out.println(sonuc);

           /*
            Bilgisayarimizda bir dosyanin var oldugunu test etmek icin
            dosya yoluna ihtiyacimiz var
            Ancak herkesin bilgisayarindaki dosya yollari
            farkliliklar gosterir
            herkesin bilgisayarina gore farkli olan kismi
            java'dan bir komut ile elde edebiliriz
         */

        System.out.println(System.getProperty("user.home"));
        dosyaYolu=System.getProperty("user.home")+"/OneDrive/Masaüstü/TheDelta.docx";

        System.out.println(System.getProperty("user.dir"));
    }
}
