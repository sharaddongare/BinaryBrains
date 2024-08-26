package com.api.apiUtility;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class AddContacts {
    public static void main(String[] args) {
        RestAssured.baseURI = "https://api.example.com"; // Replace with actual base URI
        String token = "your_token"; // Replace with actual token

        Set<String> existingUsers = new HashSet<>();
        Response getUsersResponse = RestAssured
                .given()
                .header("Authorization", "Bearer " + token)
                .get("/contacts");

// Assuming getUsersResponse is your response object
        List<String> usernames = getUsersResponse.jsonPath().getList("contacts.username");
        usernames.forEach(existingUsers::add);

        for (int i = 1; i <= 5; i++) {
            String newUsername = "user" + i;
            if (!existingUsers.contains(newUsername)) {
                RestAssured
                        .given()
                        .header("Authorization", "Bearer " + token)
                        .contentType("application/json")
                        .body("{ \"username\": \"" + newUsername + "\", \"email\": \"user" + i + "@example.com\" }")
                        .post("/contacts");
            }
        }
    }
}
