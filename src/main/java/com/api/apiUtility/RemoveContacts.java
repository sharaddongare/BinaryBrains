package com.api.apiUtility;

import io.restassured.RestAssured;
import io.restassured.response.Response;

import java.util.List;

public class RemoveContacts {
    public static void main(String[] args) {
        RestAssured.baseURI = "https://api.example.com"; // Replace with actual base URI
        String token = "your_token"; // Replace with actual token

        Response response = RestAssured
                .given()
                .header("Authorization", "Bearer " + token)
                .get("/contacts");

        List<Integer> contactIds = response.jsonPath().getList("contacts.id");

        for (int i = 0; i < 5 && i < contactIds.size(); i++) {
            RestAssured
                    .given()
                    .header("Authorization", "Bearer " + token)
                    .delete("/contacts/" + contactIds.get(i));
        }
    }
}
