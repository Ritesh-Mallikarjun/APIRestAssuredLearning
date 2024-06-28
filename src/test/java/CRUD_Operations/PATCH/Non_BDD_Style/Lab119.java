package CRUD_Operations.PATCH.Non_BDD_Style;

import io.qameta.allure.Description;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.Test;

public class Lab119 {
    String baseURL = "https://restful-booker.herokuapp.com";
    String basePath = "/booking/";
    String bookid = "3424";
    RequestSpecification rs = RestAssured.given();
    Response response;
    ValidatableResponse vr;
    String token_id = "e2855b8ddf029fa";

    @Description("verify the non bdd style patch request- positive")
    @Test
    public void patchRequestNonBDDStyle() {
        String payload = "{\n" +
                "    \"firstname\" : \"James\",\n" +
                "    \"lastname\" : \"Brown\"\n" +
                "}";

        rs.baseUri(baseURL);
        rs.basePath(basePath + bookid);
        rs.contentType(ContentType.JSON);
        rs.cookie("token", token_id);
        rs.log().all().body(payload);

        response = rs.when().log().all().patch();

        vr = response.then().log().all();
        vr.statusCode(200);
    }
}
