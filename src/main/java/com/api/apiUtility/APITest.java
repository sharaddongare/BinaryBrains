package com.api.apiUtility;
import io.restassured.RestAssured;
import io.restassured.response.Response;

public class APITest {
    public static void main(String[] args) {
        RestAssured.baseURI = "https://api.example.com"; // Replace with actual base URI

        Response response = RestAssured
                .given()
                .contentType("application/json")
                .body("{ \"username\": \"your_username\", \"password\": \"your_password\" }")
                .post("/login");

        String token = response.jsonPath().getString("token");
        System.out.println("Token: " + token);
    }
}
