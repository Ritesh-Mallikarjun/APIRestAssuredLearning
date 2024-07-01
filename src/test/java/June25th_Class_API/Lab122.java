package June25th_Class_API;

import org.testng.annotations.Test;

public class Lab122 {

    @Test(priority = 1)
    public void getMethodZot(){
        System.out.println("zot");
    }

    @Test(priority = 0)
    public void getMethodSot(){
        System.out.println("sot");
    }
    @Test(priority = 3)
    public void getMethodGot(){
        System.out.println("got");

    }
    @Test(priority = 2)
    public void getMethodBot(){
        System.out.println("bot");
    }

    @Test(priority = -3)
    public void getMethodM3(){
        System.out.println("minus 3");
    }

    @Test(priority = -5)
    public void getMethodM5(){
        System.out.println("minus 5");
    }
    @Test(priority = -1)
    public void getMethodM1(){
        System.out.println("minus 1");
    }


}
