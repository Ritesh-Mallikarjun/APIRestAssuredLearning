package CRUD_Operations.FULL_CRUD;

import io.qameta.allure.Description;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.File;

public class Lab121 {

    RequestSpecification rs = RestAssured.given();
    Response response;
    ValidatableResponse vr;
    String baseURL = "https://restful-booker.herokuapp.com";
    String basePath = "/booking/";
    String basePathToken = "/auth";
    Integer booking_Id;
    String generated_Token;

    @Description("verify if the token is generated or not")
    @BeforeTest
    public void getToken() {
        File file = new File("src/test/java/CRUD_Operations/FULL_CRUD/TOKENFILE");
        rs.baseUri(baseURL);
        rs.basePath(basePathToken);
        rs.contentType(ContentType.JSON);
        rs.body(file);

        response = rs.when().log().all().post();
        String responsedata = response.asString();
        System.out.println(responsedata);

        vr = response.then().log().all();
        vr.statusCode(200);

        generated_Token = response.then().log().all().extract().path("token");
        System.out.println(generated_Token);
        Assert.assertNotNull(generated_Token);
    }

    @Description("verify if the booking id is generated or not")
    @BeforeTest
    public void getBookingID_PostMethod() {
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

        rs.baseUri(baseURL);
        rs.basePath(basePath);
        rs.contentType(ContentType.JSON);
        rs.log().all().body(payload);

        response = rs.when().log().all().post();

        vr = response.then().log().all();
        vr.statusCode(200);

        booking_Id = response.then().extract().path("bookingid");
        System.out.println(booking_Id);
        Assert.assertNotNull(booking_Id);

//        String firstname_post = response.then().log().all().extract().path("booking.firstname");
//        Assert.assertEquals(firstname_post, "Jim");
//        String lastname_post = response.then().log().all().extract().path("booking.lastname");
//        Assert.assertEquals(lastname_post, "Brown");
//        Integer totalprice_post = response.then().log().all().extract().path("booking.totalprice");
//        Assert.assertEquals(totalprice_post, "111");
//        String depositpaid_post = response.then().log().all().extract().path("booking.depositpaid");
//        Assert.assertEquals(depositpaid_post, "true");
//        String datecheckin_post = response.then().log().all().extract().path("booking.bookingdates.checkin");
//        Assert.assertEquals(datecheckin_post, "2018-01-01");
//        String datecheckout_post = response.then().log().all().extract().path("booking.bookingdates.checkout");
//        Assert.assertEquals(datecheckout_post, "2019-01-01");
//        String addneeds_post = response.then().log().all().extract().path("booking.additionalneeds");
//        Assert.assertEquals(addneeds_post, "Breakfast");
    }

    @Description("verify if the put request is successful or not")
    @Test(priority =0)
    public void getBookingID_PutMethod() {
        String payload = "{\n" +
                "    \"firstname\" : \"Andy\",\n" +
                "    \"lastname\" : \"Mindy\",\n" +
                "    \"totalprice\" : 111,\n" +
                "    \"depositpaid\" : true,\n" +
                "    \"bookingdates\" : {\n" +
                "        \"checkin\" : \"2018-01-01\",\n" +
                "        \"checkout\" : \"2019-01-01\"\n" +
                "    },\n" +
                "    \"additionalneeds\" : \"Breakfast+Dinner\"\n" +
                "}";

        rs.baseUri(baseURL);
        rs.basePath(basePath + booking_Id);
        rs.contentType(ContentType.JSON);
        rs.cookie("token", generated_Token);
        rs.log().all().body(payload);

        response = rs.when().log().all().put();

        vr = response.then().log().all();
        vr.statusCode(200);

        String firstname_put = response.then().log().all().extract().path("firstname");
        Assert.assertEquals(firstname_put, "Andy");
        String lastname_put = response.then().log().all().extract().path("lastname");
        Assert.assertEquals(lastname_put, "Mindy");
        String addneeds_put = response.then().log().all().extract().path("additionalneeds");
        Assert.assertEquals(addneeds_put, "Breakfast+Dinner");

    }

    @Description("verify if the patch results is successful or not")
    @Test(priority =1)
    public void patchRequestMethod() {
        String patchbody = "{    \"totalprice\" : 101010,\n}";

        rs.baseUri(baseURL);
        rs.basePath(basePath + booking_Id);
        rs.contentType(ContentType.JSON);
        rs.cookie("token", generated_Token);
        rs.log().all().body(patchbody);

        response = rs.when().log().all().patch();

        vr = response.then().log().all();
        vr.statusCode(200);

        Integer totalPrice = response.then().log().all().extract().path("totalprice");
        Assert.assertEquals(totalPrice, 300);
        Assert.assertNotNull(totalPrice);
    }

    @Description("verify if the get results is working fine or not")
    @Test(priority =2)
    public void getMethodRequest() {
        rs.baseUri(baseURL);
        rs.basePath(basePath + booking_Id);

        response = rs.when().log().all().get();

        vr = response.then().log().all();
        vr.statusCode(200);
    }

    @Description("verify if the delete results is working fine or not")
    @Test(priority =3)
    public void deleteMethodRequest() {
        rs.baseUri(baseURL);
        rs.basePath(basePath + booking_Id);
        rs.cookie("token", generated_Token);

        response = rs.when().log().all().delete();

        vr = response.then().log().all();
        vr.statusCode(201);
    }

    @Description("verify if the get results is working fine or not")
    @Test(priority =4)
    public void getMethodRequest1() {
        rs.baseUri(baseURL);
        rs.basePath(basePath + booking_Id);

        response = rs.when().log().all().get();

        vr = response.then().log().all();
        vr.statusCode(200);

    }

}
