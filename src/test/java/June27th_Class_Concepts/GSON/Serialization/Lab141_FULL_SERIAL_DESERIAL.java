package June27th_Class_Concepts.GSON.Serialization;

import com.google.gson.Gson;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.Test;

public class Lab141_FULL_SERIAL_DESERIAL {
    RequestSpecification rs = RestAssured.given();
    Response response;
    ValidatableResponse vrs;

    String baseurl = "https://restful-booker.herokuapp.com";
    String basePath = "/booking/";

    @Test(priority = 0)
    public void postMethodSerialzation() {
        Booking booking = new Booking();
        booking.setFirstname("Nelson");
        booking.setLastname("Mandela");
        booking.setTotalprice(586);
        booking.setDepositpaid(true);

        BookingDates bookDates = new BookingDates();
        bookDates.setCheckin("2014-02-01");
        bookDates.setCheckout("2015-02-01");

        booking.setBookingdates(bookDates);
        booking.setAdditionalneeds("breakfast + Dinner");


        //SERIALIZATION CONCEPT
        Gson gson = new Gson();
        String jsonStringToServer = gson.toJson(booking);

        rs.baseUri(baseurl);
        rs.basePath(basePath);
        rs.contentType(ContentType.JSON);
        rs.body(jsonStringToServer);

        response = rs.when().log().all().post();
        String responseString= response.asString();
        System.out.println(responseString);

        vrs = response.then().log().all();
        vrs.statusCode(200);
    }

    @Test(priority = 1)
    public void deSerialization(){
        String responseDeSerial = response.asString();

        Gson gson = new Gson();
        BookingResponse booking= gson.fromJson(responseDeSerial, BookingResponse.class);
        System.out.println("the booking id is: "+booking.getBookingid());
        System.out.println("the first name is: "+booking.getBooking().getFirstname());
        System.out.println("the last name is: "+booking.getBooking().getLastname());
        System.out.println("the totalprice is: "+booking.getBooking().getTotalprice());
        System.out.println("the depositpaid is: "+booking.getBooking().getDepositpaid());
        System.out.println("the booking checkin is: "+booking.getBooking().getBookingdates().getCheckin());
        System.out.println("the booking checkout is: "+booking.getBooking().getBookingdates().getCheckout());
        System.out.println("the additional needs is: "+booking.getBooking().getAdditionalneeds());
    }


}
