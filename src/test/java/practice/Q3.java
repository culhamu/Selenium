package practice;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.time.Duration;

public class Q3 {
    /*
    go to url : https://www.techlistic.com/p/selenium-practice-form.html
    fill the firstname
    fill the lastname
    check the gender
    check the experience
    fill the date
    choose your profession -> Automation Tester
    choose your tool -> Selenium Webdriver
    choose your continent -> Antartica
    choose your command  -> Browser Commands
    click submit button
 */
    WebDriver driver;
    @Before
    public void setup(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofMillis(10000));
        driver.manage().window().maximize();
    }
    @After
    public void teardown(){
       driver.close();
    }
    @Test
    public void test(){
        // go to url : https://www.techlistic.com/p/selenium-practice-form.html
        driver.get("https://www.techlistic.com/p/selenium-practice-form.html");

        //driver.findElement(By.id("ezmob-footer-close")).click();
        driver.findElement(By.id("cookieChoiceDismiss")).click();
        WebElement automation= driver.findElement(By.id("profession-1"));
        WebElement selenium= driver.findElement(By.id("tool-2"));
        WebElement button= driver.findElement(By.xpath("//button[@id='submit']"));
        Actions actions=new Actions(driver);
        WebElement login= driver.findElement(By.xpath("//input[@name='firstname']"));
        actions.sendKeys(login)
                .sendKeys("Haydar")
                .sendKeys(Keys.TAB)
                .sendKeys("Dağdeviren")
                .sendKeys(Keys.TAB)
                .sendKeys(Keys.RIGHT)
                .sendKeys(Keys.LEFT)
                .sendKeys(Keys.TAB)
                .sendKeys(Keys.RIGHT)
                .sendKeys(Keys.RIGHT)
                .sendKeys(Keys.RIGHT)
                .sendKeys(Keys.RIGHT)
                .sendKeys(Keys.RIGHT)
                .sendKeys(Keys.TAB)
                .sendKeys("30/11/2009")
                .sendKeys(Keys.TAB)
                .sendKeys(Keys.TAB)
                .click(automation)
                .sendKeys(Keys.TAB)
                .sendKeys(Keys.TAB)
                .sendKeys(Keys.TAB)
                .click(selenium)
                .sendKeys(Keys.TAB)
                .sendKeys(Keys.ENTER)
                .sendKeys("Antartica")
                .sendKeys(Keys.TAB)
                .sendKeys(Keys.TAB)
                .sendKeys(Keys.TAB)
                .click(button)
                .perform();


      // fill the firstname
      // fill the lastname
      // check the gender
      // check the experience
      // fill the date
      // choose your profession -> Automation Tester
      // choose your tool -> Selenium Webdriver
      // choose your continent -> Antartica
      // choose your command  -> Browser Commands
      // click submit button
    }
}
