package day04_JUnitFramework;

import org.junit.Assert;
import org.junit.Test;

public class C06_Assertion {
    String str1="Ali";
    String str2="ali";
    @Test
    public void test01(){
        //str1'in str2'ye eşit olduğunu test edin
        Assert.assertEquals("Karsılastırılan değerler farklı",str1,str2);

       // if (str1.equals(str2)) {
       //     System.out.println("esitlik Testi PASSED");
       // }else {
       //     System.out.println("esitlik testi FAILED");
       // }


    }
    @Test
    public void test02(){
    //str1'in "A" harfini içerdiğini test edin
        Assert.assertTrue(str1.contains("A"));

       // if (str1.contains("A")) {
       //     System.out.println("olumlu Test PASSED");
       // }else {
       //     System.out.println("olumlu test FAILED");
       // }
    }
    @Test
    public void test03(){
        //str2'in "c" harfini içermediğini test edin
        Assert.assertFalse(str2.contains("c"));

       // if (!str1.contains("c")) {
       //     System.out.println("negatif Test PASSED");
       // }else {
       //     System.out.println("negatif test FAILED");
       // }

    }
}
