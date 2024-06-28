package CRUD_Operations.POST.BDD;

import io.qameta.allure.Description;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.testng.annotations.Test;

public class Lab109 {

    @Description("Verify the positive post request")
    @Test
    public void postRequest() {
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

        RestAssured.given().baseUri("https://restful-booker.herokuapp.com").basePath("/booking")
                .contentType(ContentType.JSON).body(payload)
                .when().log().all().post()
                .then().log().all().statusCode(200);
    }

    @Description("Verify the negative post request")
    @Test
    public void postNegRequest() {
        String payload="{\n" +
                "    \"firstname\" : \"@#@#@#@#!@!@!$#$$%a&**********************************\",\n" +
                "    \"lastname\" : \"Browwn445455555454545554545478665656655brown\",\n" +
                "    \"totalprice\" : 111,\n" +
                "    \"depositpaid\" : true,\n" +
                "    \"bookingdates\" : {\n" +
                "        \"checkin\" : \"2018-01-01\",\n" +
                "        \"checkout\" : \"2019-01-01\"\n" +
                "    },\n" +
                "    \"additionalneeds\" : \"Breakfast\"\n" +
                "}";

        RestAssured.given().baseUri("https://restful-booker.herokuapp.com").basePath("/booking")
                .contentType(ContentType.JSON).body(payload)
                .when().log().all().post()
                .then().log().all().statusCode(400);
    }
}
