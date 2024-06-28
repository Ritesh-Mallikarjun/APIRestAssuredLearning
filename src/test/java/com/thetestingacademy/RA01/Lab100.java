package com.thetestingacademy.RA01;

import io.restassured.RestAssured;
import org.testng.annotations.Test;

public class Lab100 {
    String token;

    public String postRequest(){
        String payload="\"firstname\" : \"Candy\",\n" +
                "    \"lastname\" : \"Mindy\",\n" +
                "    \"totalprice\" : 555,\n" +
                "    \"depositpaid\" : true,\n" +
                "    \"bookingdates\" : {\n" +
                "        \"checkin\" : \"2018-01-01\",\n" +
                "        \"checkout\" : \"2019-01-01\"\n" +
                "    },\n" +
                "    \"additionalneeds\" : \"Breakfast plus lunch\"";
        RestAssured.given().baseUri("https://restful-booker.herokuapp.com").basePath("/booking").
                body(payload).log().all().
                when().log().all().post()
                .then().statusCode(200);
        return payload;
    }

    public void putRequest(){
        String postPaylod="\"firstname\" : \"Candy\",\n" +
                "    \"lastname\" : \"White\",\n" +
                "    \"totalprice\" : 555,\n" +
                "    \"depositpaid\" : true,\n" +
                "    \"bookingdates\" : {\n" +
                "        \"checkin\" : \"2018-01-01\",\n" +
                "        \"checkout\" : \"2019-01-01\"\n" +
                "    },\n" +
                "    \"additionalneeds\" : \"Breakfast\"";

        RestAssured.given().baseUri("https://restful-booker.herokuapp.com").basePath("/booking/5").cookie(token).
                body(postPaylod).log().all().
                when().log().all().post()
                .then().statusCode(200);
    }

    public void deleteRequest(){
        RestAssured.given().baseUri("https://restful-booker.herokuapp.com").basePath("/booking/5").cookie(token).
                when().delete().then().statusCode(200);
    }

    public void getRequest(){
        RestAssured.given().baseUri("https://restful-booker.herokuapp.com").basePath("/booking/5").
                when().get().then().statusCode(200);
    }

    public static void main(String[] args) {
        //1st Post request by creating new id,
        //2nd using put request , update the existing id details with token and payload
        //3rd using delete request, after updating it , time to delete the updated request.
        //4th using get request, after delete, try to fetch the deleted details using get request method.
        Lab100 lhund = new Lab100();
        String payload=lhund.postRequest();
        lhund.putRequest();
        lhund.deleteRequest();
        lhund.getRequest();
    }


}
