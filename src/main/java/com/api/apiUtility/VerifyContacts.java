package com.api.apiUtility;


import io.restassured.RestAssured;
import io.restassured.response.Response;

public class VerifyContacts {
    public static void main(String[] args) {
        RestAssured.baseURI = "https://api.example.com"; // Replace with actual base URI
        String token = "your_token"; // Replace with actual token

        Response response = RestAssured
                .given()
                .header("Authorization", "Bearer " + token)
                .get("/contacts");

        response.jsonPath().getList("contacts").forEach(System.out::println);
    }
}
