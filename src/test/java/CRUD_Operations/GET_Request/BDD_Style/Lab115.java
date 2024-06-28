package CRUD_Operations.GET_Request.BDD_Style;

import io.qameta.allure.Description;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.response.Validatable;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import org.testng.annotations.Test;

public class Lab115 {
    String baseURL="https://restful-booker.herokuapp.com";
    String basePath="/booking/";
    RequestSpecification rs= RestAssured.given();

    @Description("verify the get positive request")
    @Test
    public void getNonBDDPosRequest(){
        String booking_id="12";

        rs.baseUri(baseURL);
        rs.basePath(basePath+booking_id);

        Response response= rs.when().log().all().get();
        String responsedata= response.asString();
        System.out.println("this is the response:- "+responsedata);

        ValidatableResponse vresponse= response.then();
       vresponse.log().all().statusCode(200);
    }
}
