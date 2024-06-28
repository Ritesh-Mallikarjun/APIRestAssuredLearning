package com.thetestingacademy.RA01;

import io.restassured.RestAssured;

public class Lab099_without_testng_library {

    public void getRequest() {
        RestAssured.given().baseUri("https://restful-booker.herokuapp.com").basePath("/booking/5")
                .when().log().all().get()
                .then().log().all().statusCode(200);
    }

    public void getRequest1() {
        RestAssured.given().baseUri("https://restful-booker.herokuapp.com").basePath("/booking/abcde")
                .when().log().all().get()
                .then().log().all().statusCode(404);
    }
    public void getRequest2() {
        RestAssured.given().baseUri("https://restful-booker.herokuapp.com").basePath("/booking/@^^&^*&*&")
                .when().log().all().get()
                .then().log().all().statusCode(404);
    }

    public static void main(String[] args) {
        Lab099_without_testng_library l1 = new Lab099_without_testng_library();
        l1.getRequest(); //Positive
        l1.getRequest1(); //Negative
        l1.getRequest2(); //Negative
    }
}
