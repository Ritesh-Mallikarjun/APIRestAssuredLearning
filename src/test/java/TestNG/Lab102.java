package TestNG;

import io.qameta.allure.Description;
import io.restassured.RestAssured;
import org.testng.annotations.Test;

public class Lab102 {

    @Description("verify test getmethod 1")
    @Test
    public void getMethod1(){
        RestAssured.given().baseUri("https://restful-booker.herokuapp.com").basePath("/booking/5").
                when().get().then().statusCode(200);
    }

    @Description("verify test getmethod 2")
    @Test
    public void getMethod2(){
        RestAssured.given().baseUri("https://restful-booker.herokuapp.com").basePath("/booking/8").
                when().get().then().statusCode(200);
    }
}
