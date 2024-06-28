package CRUD_Operations.DELETE.Non_BDD;

import io.qameta.allure.Description;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.Test;

public class Lab120 {
    String baseURL = "https://restful-booker.herokuapp.com";
    String basePath = "/booking/";
    String bookid = "3424";
    RequestSpecification rs = RestAssured.given();
    Response response;
    ValidatableResponse vr;
    String token_id = "3407b1cafbf2019";

    @Description("verify the non bdd style delete request- positive")
    @Test
    public void deleteRequestNonBDDStyle() {
        rs.baseUri(baseURL);
        rs.basePath(basePath + bookid);
        rs.contentType(ContentType.JSON);
        rs.cookie("token", token_id);

        response = rs.when().log().all().delete();

        vr = response.then().log().all();
        vr.statusCode(201);
    }
}
