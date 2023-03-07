package practice;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import utilities.TestBase;

import java.time.Duration;
import java.util.List;
import java.util.Set;

public class Q7 {
    WebDriver driver;




    @Before
    public void setup(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.manage().window().maximize();

    }
    @Test
    public void testKiwi(){
        // https://www.kiwi.com sayfasina gidin
        driver.get("https://www.kiwi.com/en/");

        // Cookies i reddedin
        driver.findElement(By.xpath("(//div[@class='ButtonPrimitiveContent__StyledButtonPrimitiveContent-sc-1nfggrh-0 iFkUjC'])[3]")).click();

        // Sag ust kisimdan dil ve para birimi secenegini Turkiye ve TL olarak secin
        driver.findElement(By.xpath("(//div[@class='ButtonPrimitiveContent__StyledButtonPrimitiveContent-sc-1nfggrh-0 jIgbVC'])[7]")).click();

        WebElement dilSecimi= driver.findElement(By.xpath("//select[@data-test='LanguageSelect']"));

        Select select=new Select(dilSecimi);

        select.selectByVisibleText("Türkçe");

        WebElement paraSecimi=driver.findElement(By.xpath("//select[@class='Select__StyledSelect-sc-2ijy2y-1 jZBCHP']"));

        select=new Select(paraSecimi);

        select.selectByVisibleText("Turkish lira - TRY");

        driver.findElement(By.xpath("//*[text()='Save & continue']")).click();

        // Sectiginiz dil ve para birimini dogrulayin
        String actualText=driver.findElement(By.xpath("//div[text()='TRY']")).getText();
        String expectedText="TRY";

        Assert.assertEquals(expectedText,actualText);

        // Ucus secenegi olarak tek yon secelim
        driver.findElement(By.xpath("(//div[text()='Gidiş Dönüş'])[1]")).click();
        driver.findElement(By.xpath("(//p[text()='Tek Yön'])[1]")).click();

        // Kalkis ve varis boxlarini temizleyerek kalkis ve varis ulkesini kendimiz belirleyelim
       driver.findElement(By.xpath("//*[@class='Icon__StyledIcon-sc-psgqgs-0 hlUuqk closeIcon']")).click();

       WebElement kalkisElementi=driver.findElement(By.xpath("(//input[@data-test='SearchField-input'])[1]"));
       kalkisElementi.sendKeys("İstanbul");
        TestBase testBase=new TestBase();
        testBase.bekle(2);

       driver.findElement(By.xpath("(//div[@class='PlacePickerstyled__PlacePickerItemName-sc-1ialbal-3 fasyeN'])[1]")).click();

        WebElement varisElementi=driver.findElement(By.xpath("(//input[@data-test='SearchField-input'])[2]"));
        varisElementi.sendKeys("Varşova");
        testBase.bekle(2);

        driver.findElement(By.xpath("(//div[@class='PlacePickerstyled__PlacePickerItemName-sc-1ialbal-3 fasyeN'])[1]")).click();

        // Gidis tarihi kismina erisim saglayarak gidecegimiz gunu secelim ve booking i iptal edelim
        driver.findElement(By.xpath("//div[@data-test='SearchDateInput']")).click();
        driver.findElement(By.xpath("//div[@data-value='2023-03-16']")).click();
        driver.findElement(By.xpath("//*[text()='Tarihleri ayarla']")).click();
        driver.findElement(By.xpath("//*[text()='Booking.com ile konaklama arayın']")).click();
        driver.findElement(By.xpath("(//div[@class='ButtonPrimitiveContentChildren__StyledButtonPrimitiveContentChildren-sc-mra4yy-0 HJizW'])[4]")).click();

        // Sadece aktarmasiz ucuslar olarak filtreleme yapalim ve en ucuz secenegine tiklayalim
        driver.findElement(By.xpath("(//span[@class='Radio__StyledLabelText-sc-1e6hy4x-4 bfniyv'])[2]")).click();
        WebElement ilkFiyat=driver.findElement(By.xpath("(//strong[@data-test='ResultCardPrice'])[1]"));
        ilkFiyat.click();
        driver.findElement(By.xpath("//button[@class='ButtonPrimitive__StyledButtonPrimitive-sc-j8pavp-0 fXaJsU']")).click();
        driver.findElement(By.xpath("(//div[@class='ButtonPrimitiveIconContainer__StyledButtonPrimitiveIconContainer-sc-1bqiptv-0 cUaWLp'])[4]")).click();

        // Filtreleme yaptigimiz en ucuz ucusun fiyatini getirerek 5000 tl den kucuk oldgunu dogurlayalim
        String ilkFiyatStr=ilkFiyat.getText().replaceAll("\\D","");
        Double ilkFiyatDbl=Double.valueOf(ilkFiyatStr);

        Assert.assertTrue(ilkFiyatDbl<5000);


    }
    @After
    public void teardown(){
       driver.close();
    }
}