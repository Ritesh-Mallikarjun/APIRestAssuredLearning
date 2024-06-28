package com.thetestingacademy.RA01;

import io.restassured.RestAssured;

public class Lab098 {
    public static void main(String[] args) {
        //given - url, header, payload, auth
        //when - get method, or post method
        //then - we can verify the response

        RestAssured.given().baseUri("https://restful-booker.herokuapp.com")
                .basePath("/ping").when().get().then().statusCode(201);

        RestAssured.given().baseUri("https://www.google.com").basePath("/search?q=zomato").
                when().get().
                then().statusCode(200);
    }
}
