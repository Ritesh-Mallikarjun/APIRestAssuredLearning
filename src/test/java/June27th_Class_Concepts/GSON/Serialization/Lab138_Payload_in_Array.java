package June27th_Class_Concepts.GSON.Serialization;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.Test;

import java.util.ArrayList;

public class Lab138_Payload_in_Array {

    RequestSpecification rs = RestAssured.given();
    Response response;
    ValidatableResponse vrs;

    String baseurl = "https://restful-booker.herokuapp.com";
    String basePath = "/booking/";

    @Test
    public void postMethod() {

        Booking booking1 = new Booking();
        booking1.setFirstname("Rohnan");
        booking1.setLastname("Milan");
        booking1.setTotalprice(1000);
        booking1.setDepositpaid(true);

        BookingDates bookDates1 = new BookingDates();
        bookDates1.setCheckin("2018-01-01");
        bookDates1.setCheckout("2019-01-01");

        booking1.setBookingdates(bookDates1);
        booking1.setAdditionalneeds("breakfast + Dinner");

        Booking booking2 = new Booking();
        booking2.setFirstname("gulshan");
        booking2.setLastname("grover");
        booking2.setTotalprice(-253);
        booking2.setDepositpaid(true);

        BookingDates bookDates2= new BookingDates();
        bookDates2.setCheckin("2015-01-01");
        bookDates2.setCheckout("2020-01-01");

        booking2.setBookingdates(bookDates2);
        booking2.setAdditionalneeds("breakfast + Dinner");

        ArrayList arrayList= new ArrayList();
        arrayList.add(booking1);
        arrayList.add(booking2);
        System.out.println(arrayList);

//        rs.baseUri(baseurl);
//        rs.basePath(basePath);
//        rs.contentType(ContentType.JSON);
//        rs.body(arrayList);
//
//        response = rs.when().log().all().post();
//        String responseString = response.asString();
//        System.out.println(responseString);
//
//        vrs = response.then().log().all();
//        vrs.statusCode(200);
//
//        Integer booking_id = response.then().log().all().extract().path("bookingid");
//        System.out.println("The booking2 id is: "+booking_id);
//        Assert.assertNotNull(booking_id);

    }

}
