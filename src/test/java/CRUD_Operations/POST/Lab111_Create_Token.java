package CRUD_Operations.POST;

import io.qameta.allure.Description;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.testng.annotations.Test;

public class Lab111_Create_Token {
    @Description("verify the token is generated or not")
    @Test
    public void createToken() {
        String payload = "{\n" +
                "    \"username\" : \"admin\",\n" +
                "    \"password\" : \"password123\"\n" +
                "}";
        RestAssured.given().baseUri("https://restful-booker.herokuapp.com").basePath("/auth").
                contentType(ContentType.JSON).body(payload).when().log().all().post().
                then().log().all().statusCode(200);
    }
}
