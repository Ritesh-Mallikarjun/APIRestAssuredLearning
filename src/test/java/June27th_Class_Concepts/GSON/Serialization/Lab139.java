package June27th_Class_Concepts.GSON.Serialization;

import com.google.gson.Gson;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Lab139 {

    RequestSpecification rs = RestAssured.given();
    Response response;
    ValidatableResponse vrs;

    String baseurl = "https://restful-booker.herokuapp.com";
    String basePath = "/booking/";

    @Test
    public void postMethod() {
        Booking booking = new Booking();
        booking.setFirstname("Rohnan");
        booking.setLastname("Milan");
        booking.setTotalprice(1000);
        booking.setDepositpaid(true);

        BookingDates bookDates = new BookingDates();
        bookDates.setCheckin("2018-01-01");
        bookDates.setCheckout("2019-01-01");

        booking.setBookingdates(bookDates);
        booking.setAdditionalneeds("breakfast + Dinner");

        System.out.println("-------Printing the object----------");
        System.out.println(booking);

        System.out.println("-------Printing the JSON STRING----------");
        //SERIALIZATION
        Gson gson = new Gson();
        String jsonStringfromObject = gson.toJson(booking);
        System.out.println(jsonStringfromObject);

        rs.baseUri(baseurl);
        rs.basePath(basePath);
        rs.contentType(ContentType.JSON);

//        rs.body(booking);  // Send the booking object directly

        rs.body(jsonStringfromObject); // Send the JSON string directly

        response = rs.when().log().all().post();
        String responseString = response.asString();
        System.out.println("this is the response string " + responseString);

        vrs = response.then().log().all();
        vrs.statusCode(200);

        Integer booking_id = response.then().log().all().extract().path("bookingid");
        System.out.println("The booking id is: " + booking_id);
        Assert.assertNotNull(booking_id);
    }

}
