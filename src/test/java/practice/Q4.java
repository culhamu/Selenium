package practice;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class Q4 {
    /*
Navigate to  https://testpages.herokuapp.com/styled/index.html
Click on  Calculater under Micro Apps
Type any number in the first input
Type any number in the second input
Click on Calculate
Get the result
Print the result
     */
    WebDriver driver;
    @Before
    public void setup(){
        System.setProperty("webdriver.chrome.driver","drivers/chromedriver.exe");
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }
    @After
    public void teardown(){
        driver.close();
    }
    @Test
    public void test(){
        driver.navigate().to("https://testpages.herokuapp.com/styled/index.html");

        driver.findElement(By.id("calculatetest")).click();
       WebElement number1= driver.findElement(By.id("number1"));
       number1.click();
       number1.sendKeys("25");
        WebElement number2= driver.findElement(By.id("number2"));
        number2.click();
        number2.sendKeys("35");
        driver.findElement(By.id("calculate")).click();
        WebElement answer= driver.findElement(By.id("answer"));
        String answerStr= answer.getText();
        System.out.println(answerStr);
    }
}
