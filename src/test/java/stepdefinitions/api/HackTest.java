package stepdefinitions.api;

import io.cucumber.java.en.*;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;
import com.fasterxml.jackson.databind.ObjectMapper;


import static org.hamcrest.CoreMatchers.notNullValue;
import static org.hamcrest.MatcherAssert.assertThat;

public class HackTest {

    private Response response;
    private int itemId;

    @Given("I have news data")
    public void iHaveNewsData() {
        // Set up news data (title, content, date)
        System.out.println("Prepare Base URL and Payload");

        // Replace with actual API endpoint
        String apiUrl = "http://ec2-54-254-162-245.ap-southeast-1.compute.amazonaws.com:9000";

        // Prepare request body
        Map<String, String> data = new HashMap<>();
        data.put("title", "India Won the match");
        data.put("content", "India won the match on 15-Aug-2024,India clinched a thrilling victory in their cricket match, delighting fans nationwide. This win, coinciding with India’s Independence Day, added a special significance to the celebration");
        data.put("price", "15082024");
        data.put("item_type", "Vodafone");

        try {
            // Convert map to JSON string
            ObjectMapper objectMapper = new ObjectMapper();
            String jsonRequestBody = objectMapper.writeValueAsString(data);

            // Print the JSON request body
            System.out.println("JSON Request Body: " + jsonRequestBody);
        } catch (Exception e) {
            e.printStackTrace();
        }
        response = RestAssured.given()
                .contentType(ContentType.JSON)
                .body(data)
                .post(apiUrl);

        System.out.println("Step 1 - Done!");
    }

    @When("I post the news data to the API Server")
    public void iSendTheNewsDataToTheAPI() throws JSONException {
        RestAssured.baseURI = "http://ec2-54-254-162-245.ap-southeast-1.compute.amazonaws.com:9000";

        // Create request body
        String requestBody = "{\n" +
                "  \"name\": \"India won the match\",\n" +
                "  \"description\": \"India won the match on 15-Aug-2024\",\n" +
                "  \"price\": \"15082024\",\n" +
                "  \"item_type\": \"Vois\"\n" +
                "}";

        // Send POST request
        response = RestAssured.given()
                .header("accept", "application/json")
                .header("Content-Type", "application/json")
                .body(requestBody)
                .post("/items/");

        // Extract the response body as a String
        String responseBody = response.getBody().asString();

        // Print the response
        System.out.println("Response Body: " + responseBody);
        System.out.println("First Post Done - Sent news Data to Server");
    }


    @And("Asserted item ID should be present in the response")
    public void theCreatedItemIdShouldBePresentInTheResponse() throws JSONException {

        // Extract the 'id' from the response
        itemId = response.jsonPath().getInt("id");
        System.out.println("Extracted Item ID : " + itemId);
        assertThat(itemId, notNullValue());
        System.out.println("Assertion for ItemID is Done!");
    }

    @When("Validate the created item using its ItemID from Server")
    public void iValidateTheCreatedItem() {
        String validationUrl = "http://ec2-54-254-162-245.ap-southeast-1.compute.amazonaws.com:9000/items/" + itemId;
        response = RestAssured.given()
                .get(validationUrl);

        // Send GET request for validation
        Response getResponse = RestAssured.given()
                .get(validationUrl);

        // Extract the response body as a String
        String responseServer = getResponse.getBody().asString();
        System.out.println("Roshan Server Response " + responseServer);

        // Extract Server 'ItemId' from the response
        itemId = response.jsonPath().getInt("id");
        System.out.println("Extracted Item ID : " + itemId);

        //Assertion for the ItemId coming from server
        assertThat(itemId, notNullValue());

        // Validate the response status code (you can add more validations if needed)
        int statusCode = getResponse.getStatusCode();
        if (statusCode == 200) {
            System.out.println("Validation successful! Status code: " + statusCode);
        } else {
            System.out.println("Validation failed! Status code: " + statusCode);
        }
        System.out.println("Item Validated");
    }
}

