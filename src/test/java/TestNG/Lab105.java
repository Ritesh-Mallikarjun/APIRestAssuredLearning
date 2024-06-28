package TestNG;

import io.qameta.allure.Description;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class Lab105 {

    @Description("Verify the test assertions!!!!")
    @Test
    public void test1(){
//        //Assertions mainly to check, expected result with actual result
//        //200=200
//        //there are 2 types of assertions Soft and Hard Assertions
//
//        SoftAssert s = new SoftAssert();
//        s.assertEquals("ritesh","rijtesh","Actual and Expected are not equal");
//        s.assertEquals("praveen","Naveem","Actual and Expected are not equal");
//        System.out.println("End of the program");
//        s.assertAll();
//
////        SoftAssert s1= new SoftAssert();
////        s1.assertEquals("Tunty","Aunty","Not Equal");
////        System.out.println("End of the program");
////        s1.assertAll();
//
//        Assert.assertEquals("ritesh i am fine","Ritesh how are you ","Not Equal");
//        System.out.println("Hi how are you");

        Assert.assertEquals(true,false);
    }

    @Test
    public void test2(){
        Assert.assertEquals(false,false);
    }
}
