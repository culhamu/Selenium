package day07_actionsClassAndFileTests;

import org.junit.Test;

import java.nio.file.Files;
import java.nio.file.Paths;

public class C04_FilePath {
    @Test
    public void test01(){
        //"C:\Users\mergu\OneDrive\Masaüstü\TheDelta.docx"

        String dosyaYolu="C:/Users/mergu/OneDrive/Masaüstü/TheDelta.docx";

        boolean sonuc= Files.exists(Paths.get(dosyaYolu));
        System.out.println(sonuc);

        System.out.println(System.getProperty("user.home"));
        dosyaYolu=System.getProperty("user.home")+"/OneDrive/Masaüstü/TheDelta.docx";
    }
}
