package June27th_Class_Concepts;

import com.github.javafaker.Faker;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.Test;

import java.util.LinkedHashMap;
import java.util.Map;

public class Lab135 {

    RequestSpecification rs = RestAssured.given();
    Response response;
    ValidatableResponse vrs;

    String baseurl = "https://restful-booker.herokuapp.com";
    String basePath = "/booking/";


//    String payload="{\"firstname\" : \"Antony\",\n"+
//            "    \"lastname\" : \"Manja\",\n"+
//            "    \"totalprice\" : 124,\n"+
//            "    \"depositpaid\" : true,\n"+
//            "    \"bookingdates\" : {\n"+
//            "        \"checkin\" : \"2018-01-01\",\n"+
//            "        \"checkout\" : \"2019-01-01\"\n"+
//            "    },\n"+
//            "    \"additionalneeds\" : \"Breakfast+Dinner\"}";

    @Test
    public void postMethod() {

        Faker faker = new Faker();
        Map<String, Object> mapUsingJson = new LinkedHashMap<>();
        mapUsingJson.put("firstname", faker.name().firstName());
        mapUsingJson.put("lastname", faker.name().lastName());
        mapUsingJson.put("totalprice", faker.random().nextInt(1000));
        mapUsingJson.put("depositpaid", faker.random().nextBoolean());

        Map<String,Object> bookingdatesjson = new LinkedHashMap<>();
        bookingdatesjson.put("checkin", "2018-01-01");
        bookingdatesjson.put("checkout", "2019-01-01");

        mapUsingJson.put("bookingdates", bookingdatesjson);
        mapUsingJson.put("additionalneeds", "breakfast plus dinner break");

        System.out.println(mapUsingJson);

        rs.baseUri(baseurl);
        rs.basePath(basePath);
        rs.contentType(ContentType.JSON);
        rs.body(mapUsingJson);

        response = rs.when().log().all().post();
        String responseString = response.asString();
        System.out.println(responseString);

        vrs = response.then().log().all();
        vrs.statusCode(200);

        Integer booking_id = response.then().log().all().extract().path("bookingid");
        System.out.println(booking_id);


    }
}
