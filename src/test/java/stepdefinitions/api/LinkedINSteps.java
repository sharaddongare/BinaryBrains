package stepdefinitions.api;


import com.google.gson.JsonObject;
import io.cucumber.java.en.*;
import io.restassured.RestAssured;
import io.restassured.response.Response;


import static io.restassured.RestAssured.given;

public class LinkedINSteps {

    private String accessToken;
    private Response response;
    String API_KEY = "0oULD2ByzI3tU7waYcSxiYqRj";
    String API_SECRET_KEY = "BViylHBOO6mGfFJyppiXjCWKWUKUPMqH6INrT3CrkKG0YiAutN";
    String ACCESS_TOKEN = "1827199527708979201-edjjauqaoPs3reTIPM3ywNaDhHYj8c";
    String ACCESS_TOKEN_SECRET = "MmTFBYxzLscB0blZNlcQNjH1OPJWPWLFmALnkRutguH5D";

// Credential For Twitter


    @Given("User should have valid LinkedIn access token")
    public void user_should_have_valid_linked_in_access_token() {
        System.out.println("Step 1- Create Access Token");
        // Replace with your actual access token
        accessToken = "AQXvOLLHBb8yFrjCO_eiEZ9zB18Pbf9aoN1jY_7ckfBYE_DmHfjNIopX9w5yTMarw8hWky6Lvj7iwpONa79kj1wbUHJcVWbB-LgXD4khoMldTU-cfervl37NRE-SCY7irlDRxf5vgWVZjr--pYL3qfyq9EO9rAS_0qxbsn35KeNKTx6b_oV8mkmDZJwO_jujBNSLSEZGvK6rz4pEVe0hBjQlRPmx4nbOklzO3eyyZTUrjGgfp7GOrmHBmjCXW0alUwpUAeRwNr1Xso9We31lOpgC_4Gk7wqbGfxndvyufrpcVrAeOmnAdSn_FBFy9sx9E1_ifetJFdx1DYqjSyGN6htOxUrVSg";
        System.out.println("accessToken");
    }

    @When("User post a message on LinkedIn")
    public void user_post_a_message_on_linked_in() {
        System.out.println("Step 2 - Actual post to LinkedIn");
        // Base URI
        RestAssured.baseURI = "https://api.linkedin.com/";

        // JSON body
        String requestBody = "{\n" +
                "    \"author\": \"urn:li:person:bOGetXf8ET\",\n" +
                "    \"lifecycleState\": \"PUBLISHED\",\n" +
                "    \"specificContent\": {\n" +
                "        \"com.linkedin.ugc.ShareContent\": {\n" +
                "            \"shareCommentary\": {\n" +
                "                \"text\": \"Hello World! #Automation\"\n" +
                "            },\n" +
                "            \"shareMediaCategory\": \"NONE\"\n" +
                "        }\n" +
                "    },\n" +
                "    \"visibility\": {\n" +
                "        \"com.linkedin.ugc.MemberNetworkVisibility\": \"PUBLIC\"\n" +
                "    }\n" +
                "}";

        // Send POST request
        Response response = given()
                .header("Authorization", "Bearer AQXvOLLHBb8yFrjCO_eiEZ9zB18Pbf9aoN1jY_7ckfBYE_DmHfjNIopX9w5yTMarw8hWky6Lvj7iwpONa79kj1wbUHJcVWbB-LgXD4khoMldTU-cfervl37NRE-SCY7irlDRxf5vgWVZjr--pYL3qfyq9EO9rAS_0qxbsn35KeNKTx6b_oV8mkmDZJwO_jujBNSLSEZGvK6rz4pEVe0hBjQlRPmx4nbOklzO3eyyZTUrjGgfp7GOrmHBmjCXW0alUwpUAeRwNr1Xso9We31lOpgC_4Gk7wqbGfxndvyufrpcVrAeOmnAdSn_FBFy9sx9E1_ifetJFdx1DYqjSyGN6htOxUrVSg")
                .header("Content-Type", "application/json")
                .header("X-Restli-Protocol-Version", "2.0.0")
                .and()
                .body(requestBody)
                .when()
                .post("v2/ugcPosts")
                .then()
                .extract().response();

        // Print response
        System.out.println("Response Status Code: " + response.getStatusCode());
        System.out.println("Response Body: " + response.getBody().asString());

    }

    @Then("User message should be posted successfully")
    public void user_message_should_be_posted_successfully() {
        System.out.println("Step 3");
        System.out.println("LinkedIn Post Done");
    }


    @Then("User should twitt on Twitter")
    public void user_should_twitt_on_twitter() {

        System.out.println("Twitt on Twitter");
        String BEARER_TOKEN = "AAAAAAAAAAAAAAAAAAAAAP4YvgEAAAAA0l3gL6WSTT0YBvaT%2FKE67KzfPFc%3DMZ6eAI035e9JfOfwbBZEFEgPAkvJFPVGB7B6n1gqtxwbT9dW4A";
        String TWEET_ENDPOINT = "https://api.twitter.com/2/tweets";

        JsonObject tweet = new JsonObject();
        tweet.addProperty("text", "Hello, Twitter!");

        Response response = RestAssured.given()
                .auth()
                .oauth2(BEARER_TOKEN)
                .header("Content-Type", "application/json")
                .body(tweet.toString())
                .post(TWEET_ENDPOINT);

        switch (response.getStatusCode()) {
            case 201:
                System.out.println("Tweet posted successfully!");
                break;
            case 403:
                System.out.println("Failed to post tweet: Forbidden. Check your token and permissions.");
                break;
            default:
                System.out.println("Failed to post tweet: " + response.getStatusLine());
                break;
        }
        System.out.println("Done");
    }

}


