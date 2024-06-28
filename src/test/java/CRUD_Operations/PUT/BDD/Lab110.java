package CRUD_Operations.PUT.BDD;

import io.qameta.allure.Description;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.testng.annotations.Test;

public class Lab110 {

    @Description("verify the put request is pass or fail")
    @Test
    public void putBDDRequest() {
        String bookingid = "1838";

        String payload = "{\n" +
                "    \"firstname\" : \"mariy\",\n" +
                "    \"lastname\" : \"putti\",\n" +
                "    \"totalprice\" : 111,\n" +
                "    \"depositpaid\" : true,\n" +
                "    \"bookingdates\" : {\n" +
                "        \"checkin\" : \"2018-01-01\",\n" +
                "        \"checkout\" : \"2019-01-01\"\n" +
                "    },\n" +
                "    \"additionalneeds\" : \"Breakfast\"\n" +
                "}";
        String Token = "c1b4141b43c87c2";

        RestAssured.given().baseUri("https://restful-booker.herokuapp.com").basePath("/booking/" + bookingid).
                contentType(ContentType.JSON).body(payload).cookie("token", Token).
                when().log().all().put().
                then().log().all().statusCode(200);
    }
}
