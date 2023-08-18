package com.pages.api;


import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class GenericAPIFunctions {

    private static final String USER_ID = "9b5f49ab-eea9-45f4-9d66-bcf56a531b85";
    private static final String USERNAME = "TOOLSQA-Test";
    private static final String PASSWORD = "Test@@123";
    private static final String BASE_URL = "https://bookstore.toolsqa.com";

    private static String token;
    private static Response response;
    private static String jsonString;
    private static String bookId;

    private static final Logger logger = LogManager.getLogger(GenericAPIFunctions.class);

    public String generateAuthorizationToken() {
        RestAssured.baseURI = BASE_URL;
        RequestSpecification request = RestAssured.given();

        request.header("Content-Type", "application/json");
        response = request.body("{ \"userName\":\"" + USERNAME + "\", \"password\":\"" + PASSWORD + "\"}")
                .post("/Account/v1/GenerateToken");

        String jsonString = response.asString();
        return JsonPath.from(jsonString).get("token");
    }

    public static String generateOAuth2Token(String username, String password, String clientId, String secrete) {
        return "Bearer " + RestAssured.given().auth().basic(username, password)
                .formParam("client_id", clientId)
                .formParam("client_secret", secrete)
                .formParam("grant_type", "client_credentials")
                .when().post(BASE_URL + "/oauth2/v2.0/token")
                .then()
                .extract().path("access_token");
    }
}
