package TestNG;

import io.qameta.allure.Description;
import org.testng.annotations.Test;

public class Lab103 {

    @Description("verify test method 1")
    @Test
    public void TestM1() {
        System.out.println("this is testcase 1");
    }

    @Description("verify test method 2")
    @Test
    public void TestM2() {
        System.out.println("this is testcase 2");
    }

    @Description("verify test method 3")
    @Test
    public void TestM3() {
        System.out.println("this is testcase 3");
    }
}
