package June25th_Class_API.Listeners;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(Listenerrs_Class.class)
public class Lab134 {

    @Test
    public void method1(){
        System.out.println("this is method1");
        method2(20);
    }
    public void method2(Integer a){
        String b=Integer.toHexString(a);
        System.out.println(a);
        System.out.println(b);
    }

    @AfterSuite
    public void aftersuite(){
        System.out.println("Sending the mail , please wait");
    }
}

