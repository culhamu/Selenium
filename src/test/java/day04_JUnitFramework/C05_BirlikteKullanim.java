package day04_JUnitFramework;

import org.junit.*;

public class C05_BirlikteKullanim {
    @BeforeClass
    public static void beforeClass(){
        System.out.println("Before class çalıştı");

    }
    @AfterClass
    public static void afterClass(){
        System.out.println("After class çalıştı");
    }
    @Before
    public void before(){
        System.out.println("Before method Çalıştı");
    }
    @After
    public void after(){
        System.out.println("After method çalıştı");
    }
    @Test
    public void test01(){
        System.out.println("test 01 çalıştı");
    }

    @Test
    public void test02(){
        System.out.println("test 02 çalıştı");
    }

    @Test
    public void test03(){
        System.out.println("test 03 çalıştı");
    }
}
