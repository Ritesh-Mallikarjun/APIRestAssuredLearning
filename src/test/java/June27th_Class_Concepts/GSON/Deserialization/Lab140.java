package June27th_Class_Concepts.GSON.Deserialization;

import June27th_Class_Concepts.GSON.Serialization.BookingResponse;
import com.google.gson.Gson;
import org.testng.annotations.Test;

public class Lab140 {

    String javaStringResponse = "{\"bookingid\":3769,\"booking\":{\"firstname\":\"Rohnan\",\"lastname\":\"Milan\",\"totalprice\":1000,\"depositpaid\":true,\"bookingdates\":{\"checkin\":\"2018-01-01\",\"checkout\":\"2019-01-01\"},\"additionalneeds\":\"breakfast + Dinner\"}}";

    @Test
    public void deserialization() {
            Gson gson = new Gson();
        BookingResponse booking= gson.fromJson(javaStringResponse, BookingResponse.class);
        System.out.println("the bookind id is: "+booking.getBookingid());
        System.out.println("the first name is: "+booking.getBooking().getFirstname());
        System.out.println("the last name is: "+booking.getBooking().getLastname());
        System.out.println("the totalprice is: "+booking.getBooking().getTotalprice());
        System.out.println("the depositpaid is: "+booking.getBooking().getDepositpaid());
        System.out.println("the booking checkin is: "+booking.getBooking().getBookingdates().getCheckin());
        System.out.println("the booking checkout is: "+booking.getBooking().getBookingdates().getCheckout());
        System.out.println("the additional needs is: "+booking.getBooking().getAdditionalneeds());

    }

}
