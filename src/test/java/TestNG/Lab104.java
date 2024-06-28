package TestNG;

import org.testng.annotations.*;

public class Lab104 {
    @BeforeSuite
    public void demo1() {
        System.out.println("before suite");
        System.out.println("-----open database");
        System.out.println("-----read csv or excel");
        System.out.println("-----read text, or environment or property file");
    }

    @BeforeTest
    public void demo2() {
        System.out.println("before test");
    }

    @BeforeClass
    public void demo3() {
        System.out.println("before class");
    }

    @BeforeMethod
    public void demo4() {
        System.out.println("before method");
    }

    @Test
    public void demo5() {
        System.out.println("running test");
    }

    @AfterMethod
    public void demo6() {
        System.out.println("after method");
    }

    @AfterClass
    public void demo7() {
        System.out.println("after class");
    }

    @AfterTest
    public void demo8() {
        System.out.println("after test");
    }

    @AfterSuite
    public void demo9() {
        System.out.println("after suite");
        System.out.println("close opened files");
    }
}
