package CRUD_Operations.PATCH.BDD_Style;

import io.qameta.allure.Description;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.testng.annotations.Test;

public class Lab112 {
    @Description("verify if the patch request is pass or fail")
    @Test
    public void patchRequest() {
        String bookingid = "1838";
        String payload = "{\"depositpaid\" : true,\n" +
                "    \"additionalneeds\" : \"Breakfast plus dinner\"}";
        String Token = "c1b4141b43c87c2";

        RestAssured.given().baseUri("https://restful-booker.herokuapp.com").basePath("/booking/" + bookingid)
                .contentType(ContentType.JSON).cookie("token", Token).body(payload).
                when().log().all().patch().
                then().log().all().statusCode(200);
    }
}
