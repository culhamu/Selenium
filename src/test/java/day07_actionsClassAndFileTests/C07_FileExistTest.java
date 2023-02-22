package day07_actionsClassAndFileTests;

import org.junit.Assert;
import org.junit.Test;
import utilities.TestBase;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class C07_FileExistTest extends TestBase {
    @Test
    public void test01(){
        //Çlıştığımız package içinde bit text.txt olduğunu test edelim

        String dinamikDosyaYolu=System.getProperty("user.dir")+"/src/test/java/day07_actionsClassAndFileTests/text.txt";
        Assert.assertTrue(Files.exists(Paths.get(dinamikDosyaYolu)));
    }
}
