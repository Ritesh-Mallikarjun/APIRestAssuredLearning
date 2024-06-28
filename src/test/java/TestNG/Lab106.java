package TestNG;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Lab106 {
    String uname;
    String password;
    String booking_id;

    @BeforeTest
    public String getToken() {
        String token = "1234";
        return token;
    }

    @BeforeTest
    public String getTokenandPostRequest() {
        System.out.println("Post request");
        //Post method
        return booking_id="567";
    }

    @Test
    public void putRequest() {
        System.out.println(booking_id);
        String token=getToken();
        System.out.println(token);
        //put method
    }

    @Test
    public void deleteRequest() {
        System.out.println(booking_id);
        String token=getToken();
        System.out.println(token);
        //delete method
    }

    @Test
    public void getRequest() {
        System.out.println(booking_id);
    }
}
