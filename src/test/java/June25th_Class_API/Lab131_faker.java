package June25th_Class_API;

import com.github.javafaker.Faker;
import com.github.javafaker.PhoneNumber;
import org.testng.annotations.Test;

public class Lab131_faker {

    @Test
    public void testMethod1(){
        Faker faker = new Faker();
        String name= faker.name().firstName();
        String password= faker.internet().password();
        System.out.println(name);
        System.out.println(password);
    }

    @Test(dependsOnMethods = {"testMethod1"})
    public void testMethod2(){
        Faker faker= new Faker();
        System.out.println("this is method2 ");
        String lastName=faker.name().lastName();
        Boolean bvalue= faker.random().nextBoolean();
        Integer depositPaid= faker.number().numberBetween(1,1000);
        String phonenumber=faker.phoneNumber().phoneNumber();
        System.out.println(lastName);
        System.out.println(bvalue);
        System.out.println(depositPaid);
        System.out.println(phonenumber);
    }
}
