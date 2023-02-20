package day05_assertion_dropdownMenu;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;

public class C04_DropdownMenu {
    //● Bir class oluşturun: C3_DropDownAmazon
    //● https://www.amazon.com/ adresine gidin.
    //- Test 1

    //	-Test 2


    static WebDriver driver;
    @BeforeClass
    public static void setup(){

        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.get("https://www.amazon.com/");
    }
    @Test
    public void test01(){
        // Arama kutusunun yanindaki kategori menusundeki kategori sayisinin 45 oldugunu test edin
        WebElement ddm= driver.findElement(By.xpath("//select[@id='searchDropdownBox']"));
        Select select=new Select(ddm);
        int actualOptionSyisi=select.getOptions().size();
        int expectedOptionSayisi=45;
        Assert.assertEquals(expectedOptionSayisi,actualOptionSyisi);


    }
    @Test
    public void test02(){
        // 1. Kategori menusunden Books secenegini secin

        WebElement ddm= driver.findElement(By.xpath("//select[@id='searchDropdownBox']"));
        Select select=new Select(ddm);
        select.selectByVisibleText("Books");
        // 2. Arama kutusuna Java yazin ve aratin
        WebElement searchBox=driver.findElement(By.id("twotabserchtextbox"));
        searchBox.sendKeys("Java");
        // 3. Bulunan sonuc sayisini yazdirin
        WebElement sonucYaziElementi=driver.findElement(By.xpath("//h1[@class='a-size-base s-desktop-toolbar a-text-normal']"));
        System.out.println(sonucYaziElementi.getText());
        // 4. Sonucun Java kelimesini icerdigini test edin
        String expectedSonucYazisi="Java";
        String actualSonucYazisi=sonucYaziElementi.getText();

        Assert.assertTrue(actualSonucYazisi.contains(expectedSonucYazisi));
    }
    @AfterClass
    public static void teardown(){

        driver.close();
    }
}
