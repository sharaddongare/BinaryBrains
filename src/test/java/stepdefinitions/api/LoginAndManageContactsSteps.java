package stepdefinitions.api;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class LoginAndManageContactsSteps {

    private String token;
    private Set<String> existingUsers = new HashSet<>();

    @Given("I login to the application via API")
    public void loginToApplication() {
        // Base URI
        RestAssured.baseURI = "https://thinking-tester-contact-list.herokuapp.com";

        // Perform GET request with email and password
        Response response = RestAssured
                .given()
                .auth()
                .preemptive()
                .basic("roshanraokamble@gmail.com", "May@@2722")
                .when()
                .get("/users/login");

        // Print response
        System.out.println("Response Status Code: " + response.getStatusCode());
        System.out.println("Response Body: " + response.getBody().asString());
        System.out.println("Done");
    }

    @When("I add 5 new contacts to the database")
    public void addNewContacts() {

        RestAssured.baseURI = "https://thinking-tester-contact-list.herokuapp.com";

        // Bearer token
        String token = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJfaWQiOiI2NmNjNTBiMTQzMGM1MDAwMTM3YzVmZTYiLCJpYXQiOjE3MjQ2Njc0MjB9.d86sVxmGwuN5bNYLD_RnWarRo2Gen2JMU080KStG6ww";

        // JSON body for the request
        String requestBody = "{\n" +
                "    \"firstName\": \"Rushi\",\n" +
                "    \"lastName\": \"Dafal\",\n" +
                "    \"birthdate\": \"1970-01-01\",\n" +
                "    \"email\": \"jdoe@fake.com\",\n" +
                "    \"phone\": \"8005555555\",\n" +
                "    \"street1\": \"1 Main St.\",\n" +
                "    \"street2\": \"Apartment A\",\n" +
                "    \"city\": \"Anytown\",\n" +
                "    \"stateProvince\": \"KS\",\n" +
                "    \"postalCode\": \"12345\",\n" +
                "    \"country\": \"USA\"\n" +
                "}";

        // Perform POST request with Bearer token
        Response response = RestAssured
                .given()
                .header("Authorization", "Bearer " + token)
                .contentType(ContentType.JSON)
                .body(requestBody)
                .when()
                .post("/contacts");

        // Print response
        System.out.println("Response Status Code: " + response.getStatusCode());
        System.out.println("Response Body: " + response.getBody().asString());
        System.out.println("Done");
    }

    @Then("I verify the new contacts are added to the database")
    public void verifyContactsAdded() {
        String token = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJfaWQiOiI2NmNjNTBiMTQzMGM1MDAwMTM3YzVmZTYiLCJpYXQiOjE3MjQ2Njc0MjB9.d86sVxmGwuN5bNYLD_RnWarRo2Gen2JMU080KStG6ww"; // Replace with your actual token

        Response response = RestAssured.given()
                .header("Authorization", "Bearer " + token)
                .when()
                .get("https://thinking-tester-contact-list.herokuapp.com/contacts");

        System.out.println("Response Status Code: " + response.getStatusCode());
        System.out.println("Response Body: " + response.getBody().asString());
        System.out.println("Verify Done!");
    }

    @Then("I remove the first 5 entries from the database")
    public void removeFirstFiveEntries() {
        RestAssured.baseURI = "https://thinking-tester-contact-list.herokuapp.com";

        // Bearer token
        String token = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJfaWQiOiI2NmNjNTBiMTQzMGM1MDAwMTM3YzVmZTYiLCJpYXQiOjE3MjQ2Njc0MjB9.d86sVxmGwuN5bNYLD_RnWarRo2Gen2JMU080KStG6ww";

        // Contact ID to delete
        String contactId = "66cc5677bbb7c100130aebd4"; // Replace with the actual contact ID

        // Perform DELETE request with Bearer token
        Response response = RestAssured
                .given()
                .header("Authorization", "Bearer " + token)
                .when()
                .delete("/contacts/" + contactId);

        // Print response
        System.out.println("Response Status Code: " + response.getStatusCode());
        System.out.println("Response Body: " + response.getBody().asString());

        System.out.println("Remove Done");
    }

    @When("I add {int} new contacts to the database Test")
    public void i_add_new_contacts_to_the_database_test(Integer int1) {

        System.out.println("Done -4");
    }
    @When("I remove the first {int} entries from the database Test")
    public void i_remove_the_first_entries_from_the_database_test(Integer int1) {

        System.out.println("Done -5");

    }
}
