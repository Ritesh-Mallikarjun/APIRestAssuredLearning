package CRUD_Operations.POST.NonBDD;

import io.qameta.allure.Description;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.Test;

public class Lab116 {

    String baseURL="https://restful-booker.herokuapp.com";
    String basePath="/booking/";
    RequestSpecification rs= RestAssured.given();
    Response response;
    ValidatableResponse vr;

    @Description("verify the non bdd style post request- positive")
    @Test
    public void postRequestNonBDDStyle(){
        String payload="{\n" +
                "    \"firstname\" : \"Jim\",\n" +
                "    \"lastname\" : \"Brown\",\n" +
                "    \"totalprice\" : 111,\n" +
                "    \"depositpaid\" : true,\n" +
                "    \"bookingdates\" : {\n" +
                "        \"checkin\" : \"2018-01-01\",\n" +
                "        \"checkout\" : \"2019-01-01\"\n" +
                "    },\n" +
                "    \"additionalneeds\" : \"Breakfast\"\n" +
                "}";

        rs.baseUri(baseURL);
        rs.basePath(basePath);
        rs.contentType(ContentType.JSON);
        rs.log().all().body(payload);

        response= rs.when().log().all().post();

        vr= response.then().log().all();
        vr.statusCode(200);
    }

    @Description("verify the non bdd style post request- negative")
    @Test
    public void postRequestNonBDDStyleNeg1(){
        String payload="{\n" +
                "    \"firstname\" : \"Jim\",\n" +
                "    \"lastname\" : \"Brown\",\n" +
                "    \"totalprice\" : abcdfefefef,\n" +
                "    \"depositpaid\" : true,\n" +
                "    \"bookingdates\" : {\n" +
                "        \"checkin\" : \"2018-01-01\",\n" +
                "        \"checkout\" : \"2019-01-01\"\n" +
                "    },\n" +
                "    \"additionalneeds\" : \"Breakfast\"\n" +
                "}";

        rs.baseUri(baseURL);
        rs.basePath(basePath);
        rs.contentType(ContentType.JSON);
        rs.log().all().body(payload);

        response= rs.when().log().all().post();

        vr= response.then().log().all();
        vr.statusCode(200);
    }
}
