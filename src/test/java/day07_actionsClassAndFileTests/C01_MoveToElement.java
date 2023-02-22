package day07_actionsClassAndFileTests;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

public class C01_MoveToElement extends TestBase {
    @Test
    public void test01(){
        //1- https://www.amazon.com/ adresine gidin
        driver.get("https://www.amazon.com/");
        //2- Sag ust bolumde bulunan “Account & Lists” menusunun acilmasi icin mouse’u bu menunun ustune getirin
        WebElement mouseClick= driver.findElement(By.xpath("//span[text()='Account & Lists']"));
        Actions actions=new Actions(driver);
        actions.moveToElement(mouseClick).perform();

        //3- “Create a list” butonuna basin
        driver.findElement(By.xpath("//span[text()='Create a List']")).click();

        //4- Acilan sayfada “Your Lists” yazisi oldugunu test edin
        String actualText=driver.findElement(By.xpath("//div[@role='heading']")).getText();
        String expectedText="Your Lists";
        Assert.assertEquals(expectedText,actualText);

    }
}
