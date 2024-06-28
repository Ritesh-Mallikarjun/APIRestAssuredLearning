package CRUD_Operations.GET_Request.Non_BDD;

import io.qameta.allure.Description;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.Test;

public class Lab118_us_Class_Obj {

    RequestSpecification rs=RestAssured.given();
    Response response;
    ValidatableResponse vr;
    String baseURL="https://restful-booker.herokuapp.com";
    String basePath="/booking/";
    String bookingId="3424";


    @Description("verify the get method using classes and objects")
    @Test
    public void getRequestNonBDD(){
        rs.baseUri(baseURL);
        rs.basePath(basePath+bookingId);

        response=rs.when().log().all().get();
        String resdata=response.asString();
        System.out.println(resdata);

        vr=response.then().log().all();
        vr.statusCode(200);
    }
}
