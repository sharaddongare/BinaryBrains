package com.api.apiUtility;


import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.http.Method;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import io.restassured.specification.RequestSpecification;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.json.JSONException;
import org.json.JSONObject;
import org.junit.Assert;

import java.util.Map;

import static io.restassured.RestAssured.*;

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


    private static String requestBody = "{\n" +
            "  \"title\": \"foo\",\n" +
            "  \"body\": \"bar\",\n" +
            "  \"userId\": \"1\" \n}";

    /**
     * @return  - generate Authorization Token in string
     */
    public String generateAuthorizationToken() {
        RestAssured.baseURI = BASE_URL;
        RequestSpecification request = given();
        request.header("Content-Type", "application/json");
        response = request.body("{ \"userName\":\"" + USERNAME + "\", \"password\":\"" + PASSWORD + "\"}")
                .post("/Account/v1/GenerateToken");

        String jsonString = response.asString();
        return JsonPath.from(jsonString).get("token");
    }

    /**
     * @param username - passed as an argument to generateOAuth2Token
     * @param password - passed as an argument to generateOAuth2Token
     * @param clientId - passed as an argument to generateOAuth2Token
     * @param secrete  - passed as an argument to generateOAuth2Token
     * @return
     */
    public static String generateOAuth2Token(String username, String password, String clientId, String secrete) {
        return "Bearer " + given().auth().basic(username, password)
                .formParam("client_id", clientId)
                .formParam("client_secret", secrete)
                .formParam("grant_type", "client_credentials")
                .when().post(BASE_URL + "/oauth2/v2.0/token")
                .then()
                .extract().path("access_token");
    }

    /**
     * @throws JSONException
     */
   /* public void postRestAssured() throws JSONException {
        RestAssured.baseURI ="https://demoqa.com/Account/v1";
        RequestSpecification request = given();
        JSONObject requestParams = new JSONObject();
        requestParams.put("userName", "test_rest");
        requestParams.put("password", "Testrest@123");
        request.body(requestParams.toString());
        Response response = request.put("/User");
        ResponseBody body = response.getBody();
    }*/

    public void  getRest()
    {
        RestAssured.baseURI = "https://demoqa.com/BookStore/v1/Books";
        // Get the RequestSpecification of the request to be sent to the server.
        RequestSpecification httpRequest = given();
        // specify the method type (GET) and the parameters if any.
        //In this case the request does not take any parameters
        Response response = httpRequest.request(Method.GET, "");
        // Print the status and message body of the response received from the server
        System.out.println("Status received => " + response.getStatusLine());
        System.out.println("Response=>" + response.prettyPrint());
    }


    /**
     * This method is used to perform getRequest() operation
     *
     */
    public String getRequest() {
        String response = given()
                .contentType(ContentType.JSON)
                .when()
                .get("/posts")
                .then()
                .extract().response().toString();

        return response;
//        Assert.assertEquals(200,response.statusCode());
//        Assert.assertEquals("qui est esse", response.jsonPath().getString("title[1]"));
    }

    /**
     *  This method is used to perform getRequestWithQueryParam() operation
     *
     */
    public void getRequestWithQueryParam() {
        Response response = given()
                .contentType(ContentType.JSON)
                .param("postId", "2")
                .when()
                .get("/comments")
                .then()
                .extract().response();
        Assert.assertEquals(200, response.statusCode());
        Assert.assertEquals("Meghan_Littel@rene.us", response.jsonPath().getString("email[3]"));
    }


    /**
     * This method is used to perform postRequest() operation
     *
     */
    public void postRequest() {
        Response response = given()
                .header("Content-type", "application/json")
                .and()
                .body(requestBody)
                .when()
                .post("/posts")
                .then()
                .extract().response();

        Assert.assertEquals(201, response.statusCode());
        Assert.assertEquals("foo", response.jsonPath().getString("title"));
        Assert.assertEquals("bar", response.jsonPath().getString("body"));
        Assert.assertEquals("1", response.jsonPath().getString("userId"));
        Assert.assertEquals("101", response.jsonPath().getString("id"));
    }

    /**
     *  This method is used to perform putRequest() operation
     *
     */
    public void putRequest() {
        Response response = given()
                .header("Content-type", "application/json")
                .and()
                .body(requestBody)
                .when()
                .put("/posts/1")
                .then()
                .extract().response();

        Assert.assertEquals(200, response.statusCode());
        Assert.assertEquals("foo", response.jsonPath().getString("title"));
        Assert.assertEquals("baz", response.jsonPath().getString("body"));
        Assert.assertEquals("1", response.jsonPath().getString("userId"));
        Assert.assertEquals("1", response.jsonPath().getString("id"));
    }


    /**
     *  This method is used to perform patchRequest() operation
     *
     */
    public void patchRequest() {
        Response response = given()
                .header("Content-type", "application/json")
                .and()
                .body(requestBody)
                .when()
                .patch("/posts/1")
                .then()
                .extract().response();

        Assert.assertEquals(200, response.statusCode());
        Assert.assertEquals("bax", response.jsonPath().getString("title"));
        Assert.assertEquals("1", response.jsonPath().getString("userId"));
        Assert.assertEquals("1", response.jsonPath().getString("id"));
    }


    public void deleteRequest() {
        Response response = given()
                .header("Content-type", "application/json")
                .when()
                .delete("/posts/1")
                .then()
                .extract().response();

        Assert.assertEquals(200, response.statusCode());
    }


}
