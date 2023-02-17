package practice;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class Q2 {
    /* ...Exercise2...
 1 - Driver olusturalim
 2 - Java class'imiza chromedriver.exe'yi tanitalim
 3 - Driver'in tum ekrani kaplamasini saglayalim
 4 - Driver'a sayfanın yuklenmesini 10.000 milisaniye (10 saniye) boyunca beklesini
     söyleyelim. Eger oncesinde sayfa yuklenirse, beklemeyi bıraksin.
 5 - "https://www.otto.de" adresine gidelim
 6 - Bu web adresinin sayfa basligini (title) ve adres (url)ini alalim
 7 - Title ve url'nin "OTTO" kelimesinin icerip icermedigini kontrol edelim
 8 - Ardindan "https://wisequarter.com/" adresine gidelim
 9 - Bu adresin basligini alalim ve "Quarter" kelimesini icerip icermedigini
     kontrol edelim
 10- Bir onceki web sayfamiza geri donelim
 11- Sayfayi yenileyelim
 12- Daha sonra web sayfamiza tekrar donelim ve oldugumuz sayfayi kapatalim
 13- En son adim olarak butun sayfalarimizi kapatmis olalim
     */
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver","drivers/chromedriver.exe");
        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofMillis(10000));

        driver.get("https://www.otto.de");
        String actualPageTitle= driver.getTitle();
        String actualPageUrl= driver.getCurrentUrl();
        String expectedTitle="OTTO";
        String expectedUrl="OTTO";

        if (actualPageTitle.contains(expectedTitle)){
            System.out.println("Title test PASSED");
        }else {
            System.out.println("Title test FAILED"+
                               "\n Actual Title : "+actualPageTitle);
        }
        if (actualPageUrl.contains(expectedUrl)){
            System.out.println("Title test PASSED");
        }else {
            System.out.println("Title test FAILED"+
                    "\n Actual Title : "+actualPageUrl);
        }

        driver.get("https://wisequarter.com");
        String expectedWiseTitle="Quarter";
        String actualWiseTitle=driver.getTitle();

        if (actualWiseTitle.contains(expectedWiseTitle)){
            System.out.println("WiseQuarter test PASSED");
        }else {
            System.out.println("WiseQuarter title FAILED"+
                               "\n Actual title : "+actualWiseTitle);
        }

        driver.navigate().back();
        driver.navigate().refresh();
        driver.navigate().forward();
        driver.close();
        driver.quit();


    }


}
