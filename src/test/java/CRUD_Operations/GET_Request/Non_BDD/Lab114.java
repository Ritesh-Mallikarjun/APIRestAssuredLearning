package CRUD_Operations.GET_Request.Non_BDD;

import io.qameta.allure.Description;
import io.restassured.RestAssured;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.Test;

public class Lab114 {

    String baseURL="https://restful-booker.herokuapp.com";
    String basePath="/booking/";
    RequestSpecification rs= RestAssured.given();

    @Description("verify the get positive request")
    @Test
    public void getNonBDDPosRequest(){
        String booking_id="110";

        rs.baseUri(baseURL);
        rs.basePath(basePath+booking_id);
        rs.when().log().all().get();
        rs.then().log().all().statusCode(200);
    }

    @Description("verify the get negative request")
    @Test
    public void getNonBDDNegRequest(){
        String Nega_BookID="0";
        rs.baseUri(baseURL);
        rs.basePath(basePath+Nega_BookID);
        rs.when().log().all().get().then().log().all().statusCode(200);
    }
}
