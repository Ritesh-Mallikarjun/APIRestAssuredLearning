package CRUD_Operations.PUT.NonBDD;

import io.qameta.allure.Description;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.Test;

public class Lab117 {

    String baseURL="https://restful-booker.herokuapp.com";
    String basePath="/booking/";
    String bookid="3424";
    RequestSpecification rs= RestAssured.given();
    Response response;
    ValidatableResponse vr;
    String token_id="2cceb206e32f6dd";

    @Description("verify the non bdd style post request- positive")
    @Test
    public void putRequestNonBDDStyle(){
        String payload="{\n" +
                "    \"firstname\" : \"Jimmy\",\n" +
                "    \"lastname\" : \"Brownie\",\n" +
                "    \"totalprice\" : 124,\n" +
                "    \"depositpaid\" : true,\n" +
                "    \"bookingdates\" : {\n" +
                "        \"checkin\" : \"2018-01-01\",\n" +
                "        \"checkout\" : \"2019-01-01\"\n" +
                "    },\n" +
                "    \"additionalneeds\" : \"Breakfast\"\n" +
                "}";

        rs.baseUri(baseURL);
        rs.basePath(basePath+bookid);
        rs.contentType(ContentType.JSON);
        rs.cookie("token",token_id);
        rs.log().all().body(payload);

        response= rs.when().log().all().put();

        vr= response.then().log().all();
        vr.statusCode(200);
    }
}
