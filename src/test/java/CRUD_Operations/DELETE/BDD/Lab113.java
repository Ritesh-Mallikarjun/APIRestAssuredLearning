package CRUD_Operations.DELETE.BDD;

import io.qameta.allure.Description;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.testng.annotations.Test;

public class Lab113 {

    @Description("verify the delete pos request")
    @Test
    public void deleteRequest(){
        String bookingid="1838";
        String Token="c1b4141b43c87c2";

        RestAssured.given().baseUri("https://restful-booker.herokuapp.com").basePath("/booking/"+bookingid)
                .contentType(ContentType.JSON).cookie("token",Token).
                when().log().all().delete().
                then().log().all().statusCode(201);
    }
}
