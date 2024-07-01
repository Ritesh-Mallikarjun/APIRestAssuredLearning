package June25th_Class_API;

import org.testng.annotations.Test;

public class Lab123 {
    //Same priority , then it will execute based on alphabets
    @Test(priority = 0)
    public void getMethodSamePA(){
        System.out.println("PA");
    }
    @Test(priority = 0)
    public void getMethodSamePK(){
        System.out.println("PK");

    }
    @Test(priority = 0)
    public void getMethodSamePI(){
        System.out.println("PI");

    }
    @Test(priority = 0)
    public void getMethodSamePT(){
        System.out.println("PT");

    }
    @Test(priority = 0)
    public void getMethodSamePE(){
        System.out.println("PE");

    }
}


// Default priority is always zero and when executing , it will preserve the order and also execute based on the alphabets
// Setting up the priority, it will execute the testcases based on the set priority
// Negative priority , based on negative priority , first it will execute first the negative priority and also
// negative priority based on highest negative , first -9, then -4, then -1 , so highest negative priority
// when all the priorities are same, then it will be executing based on the alphabets.
