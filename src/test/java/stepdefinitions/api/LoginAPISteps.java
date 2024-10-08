package stepdefinitions.api;

import java.util.List;
import java.util.Map;

import com.api.apiUtility.GenericAPIFunctions;
import org.junit.Assert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class LoginAPISteps {
    private static final String USER_ID = "9b5f49ab-eea9-45f4-9d66-bcf56a531b85";
    private static final String USERNAME = "TOOLSQA-Test";
    private static final String PASSWORD = "Test@@123";
    private static final String BASE_URL = "https://bookstore.toolsqa.com";

    private static String token;
    private static Response response;
    private static String jsonString;
    private static String bookId;

    private GenericAPIFunctions genericAPIFunctions = new GenericAPIFunctions();

    /**
     * This method is used for an Authorization of token
     */
    @Given("I am an authorized user")
    public void iAmAnAuthorizedUser() {
        token = genericAPIFunctions.generateAuthorizationToken();
        System.out.println("Token :"+token);
    }

    /**
     *This method is used to get the available list of book
     */
    @Given("A list of books are available")
    public void listOfBooksAreAvailable() {
        RestAssured.baseURI = BASE_URL;
        RequestSpecification request = RestAssured.given();
        response = request.get("/BookStore/v1/Books");
        jsonString = response.asString();
        System.out.println(response.prettyPrint());
        List<Map<String, String>> books = JsonPath.from(jsonString).get("books");
        Assert.assertTrue(books.size() > 0);
        bookId = books.get(0).get("isbn");
        System.out.println("*** Book Id is "+bookId);
    }

    /**
     *This method is use to add the book to the reading list
     */
    @When("I add a book to my reading list")
    public void addBookInList() {
        RestAssured.baseURI = BASE_URL;
        RequestSpecification request = RestAssured.given();
        request.header("Authorization", "Bearer " + token)
                .header("Content-Type", "application/json");

        response = request.body("{ \"userId\": \"" + USER_ID + "\", " +
                        "\"collectionOfIsbns\": [ { \"isbn\": \"" + bookId + "\" } ]}")
                .post("/BookStore/v1/Books");
    }

    /**
     * This method is Checking 201 response code
     */
    @Then("The book is added")
    public void bookIsAdded() {
        System.out.println("Response code is "+ response.getStatusCode());
        Assert.assertEquals(201, response.getStatusCode());
    }

    /**
     * This method is used to remove the book from my reading list
     */
    @When("I remove a book from my reading list")
    public void removeBookFromList() {
        RestAssured.baseURI = BASE_URL;
        RequestSpecification request = RestAssured.given();

        request.header("Authorization", "Bearer " + token)
                .header("Content-Type", "application/json");

        response = request.body("{ \"isbn\": \"" + bookId + "\", \"userId\": \"" + USER_ID + "\"}")
                .delete("/BookStore/v1/Book");
        System.out.println("Response for remove book "+response);
    }

    /**
     * This method is Checking 204 response code
     */
    @Then("The book is removed")
    public void bookIsRemoved() {
        Assert.assertEquals(204, response.getStatusCode());

        RestAssured.baseURI = BASE_URL;
        RequestSpecification request = RestAssured.given();

        request.header("Authorization", "Bearer " + token)
                .header("Content-Type", "application/json");

        response = request.get("/Account/v1/User/" + USER_ID);
        Assert.assertEquals(200, response.getStatusCode());

        jsonString = response.asString();
        List<Map<String, String>> booksOfUser = JsonPath.from(jsonString).get("books");
        Assert.assertEquals(0, booksOfUser.size());
    }


}