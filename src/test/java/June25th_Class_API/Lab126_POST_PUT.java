package June25th_Class_API;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.hamcrest.Matchers;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.File;

public class Lab126_POST_PUT {
    RequestSpecification rs = RestAssured.given();
    Response response;
    ValidatableResponse vr;

    String baseURL = "https://restful-booker.herokuapp.com";
    String basePATH = "/booking/";
    String Auth = "/auth";
    Integer bookingId;
    String token;


    @BeforeTest
    public void getToken() {
        //Post method to get the token

        //Json body is stored in the file
        File file = new File("src/test/java/CRUD_Operations/FULL_CRUD/TOKENFILE");

        rs.baseUri(baseURL);
        rs.basePath(Auth);
        rs.contentType(ContentType.JSON);
        rs.body(file);
        response = rs.when().log().all().post();
        vr = response.then();
        vr.statusCode(200);

        token = response.then().log().all().extract().path("token");
        System.out.println(token);
        Assert.assertNotNull(token);
    }

    @BeforeTest
    public void getBookingIDPostMethod() {
        //post method to create the booking
        String payload = "{\"firstname\" : \"Jim\",\n" +
                "    \"lastname\" : \"Brown\",\n" +
                "    \"totalprice\" : 111,\n" +
                "    \"depositpaid\" : true,\n" +
                "    \"bookingdates\" : {\n" +
                "        \"checkin\" : \"2018-01-01\",\n" +
                "        \"checkout\" : \"2019-01-01\"\n" +
                "    },\n" +
                "    \"additionalneeds\" : \"Breakfast\"}";

        rs.baseUri(baseURL);
        rs.basePath(basePATH);
        rs.contentType(ContentType.JSON);
        rs.body(payload);

        response = rs.when().log().all().post();
        vr = response.then();
        vr.statusCode(200);

        bookingId = response.then().log().all().extract().path("bookingid");
        System.out.println("the booking id is: " + bookingId);
        Assert.assertNotNull(bookingId);
    }

    @Test
    public void putRequest() {
        String payload = "{\"firstname\" : \"Antony\",\n" +
                "    \"lastname\" : \"Manja\",\n" +
                "    \"totalprice\" : 124,\n" +
                "    \"depositpaid\" : true,\n" +
                "    \"bookingdates\" : {\n" +
                "        \"checkin\" : \"2018-01-01\",\n" +
                "        \"checkout\" : \"2019-01-01\"\n" +
                "    },\n" +
                "    \"additionalneeds\" : \"Breakfast+Dinner\"}";

        rs.baseUri(baseURL);
        rs.basePath(basePATH + bookingId);
        rs.contentType(ContentType.JSON);
        rs.cookie("token", token);
        rs.body(payload);

        response = rs.when().log().all().put();
        vr = response.then();
        vr.statusCode(200);

        //to get the full response from response
        String fullJsonresponse = response.asString();
        System.out.println(fullJsonresponse);

        //1) RA mathchers using vr.body(value,Matchers.equalTo("firstname")) -validatable response
        vr.body("firstname", Matchers.equalTo("Antony"));
        vr.body("lastname", Matchers.equalTo("Manja"));

        //2) TestNG asserts using extract and path and assert
        String firstNameSt = response.then().log().all().extract().path("firstname");
        Assert.assertEquals(firstNameSt, "Antony");

        //3) Using jsonpath validation and providing fulljsonstring as an input
        JsonPath jsonpath = new JsonPath(fullJsonresponse);

        String firstNameJsonpathExt = jsonpath.getString("firstname");
        String lastNameJsonExt = jsonpath.getString("lastname");
        Integer totalPriceExt = jsonpath.getInt("totalprice");
        Boolean depositpaisJsonExt = jsonpath.getBoolean("depositpaid");
        String checkinbookingdates = jsonpath.getString("bookingdates.checkin");
        String checkoutbookingdates = jsonpath.getString("bookingdates.checkout");
        String additionalNeeds = jsonpath.getString("additionalneeds");


        Assert.assertEquals(firstNameJsonpathExt, "Antony");
        Assert.assertEquals(lastNameJsonExt, "Manja");
        Assert.assertEquals(totalPriceExt, 124);
        Assert.assertEquals(depositpaisJsonExt, true);
        Assert.assertEquals(checkinbookingdates, "2018-01-01");
        Assert.assertEquals(checkoutbookingdates, "2019-01-01");
        Assert.assertEquals(additionalNeeds, "Breakfast+Dinner");

    }
}
