package CRUD_Operations.GET_Request.BDD_Style;

import io.qameta.allure.Description;
import io.restassured.RestAssured;
import org.testng.annotations.Test;

public class Lab108 {

    @Description("Verify the positive result")
    @Test
    public void getBDDStylePosRequest(){
        RestAssured.given().baseUri("https://restful-booker.herokuapp.com").basePath("booking/1838")
                .when().log().all().get()
                .then().log().all().statusCode(200);
    }

    @Description("Verify the negative result")
    @Test
    public void getBDDStyleNegRequest(){
        RestAssured.given().baseUri("https://restful-booker.herokuapp.com").basePath("booking/0")
                .when().log().all().get()
                .then().log().all().statusCode(404);
    }

}
