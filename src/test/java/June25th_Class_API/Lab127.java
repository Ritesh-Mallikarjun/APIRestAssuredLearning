package June25th_Class_API;

import org.testng.annotations.Test;

public class Lab127 {
    //Depend on method
    String name;
    String companyName;

    @Test
    public void method1(){
        name="rahul";
        System.out.println("this is method1");
    }

    @Test
    public void method2(){
        companyName="Infosys";
        System.out.println("this is method2");
    }

    @Test(dependsOnMethods = {"method1","method2"})
    public void printDetails(){
        System.out.println("my name is "+name);
        System.out.println("my company name is "+companyName);
    }

    @Test(dependsOnMethods = {"method1","method2"})
    public void mshowDetails(){
        System.out.println("my name is "+name);
        System.out.println("my company name is "+companyName);
    }
}
