package June27th_Class_Concepts.JSONSchemaValidation;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.module.jsv.JsonSchemaValidator;
import org.testng.annotations.Test;

import java.io.File;

public class Lab142 {

    @Test
    public void jsonSchemaValidateGet() {
        RestAssured.given().baseUri("https://restful-booker.herokuapp.com/booking/15").
                when().log().all().get().then()
                .assertThat().body(JsonSchemaValidator.matchesJsonSchema(new File("src/test/java/June27th_Class_Concepts/JSONSchemaValidation/SchemaGet.json")));
    }

    @Test
    public void jsonSchemaValidatePost() {
        String payload = "{\n" +
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
        RestAssured.given().baseUri("https://restful-booker.herokuapp.com").basePath("/booking").
                contentType(ContentType.JSON).body(payload).
                when().log().all().post().then().log().all().assertThat().
                body(JsonSchemaValidator.matchesJsonSchema(new File("src/test/java/June27th_Class_Concepts/JSONSchemaValidation/SchemaPost.json")));
    }

}
