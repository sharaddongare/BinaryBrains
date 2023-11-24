package stepdefinitions.api;

import com.api.apiUtility.GenericAPIFunctions;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.restassured.http.ContentType;
import io.restassured.response.ValidatableResponse;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.equalTo;

public class BasicApiSteps {

    private ValidatableResponse validatableResponse;

    GenericAPIFunctions genericAPIFunctions=new GenericAPIFunctions();
    private String endpoint = "http://dummy.restapiexample.com/api/v1/employee/1";

    @Given("I send a request to the URL to get user details")
    public void sendRequest(){
        validatableResponse = given().contentType(ContentType.JSON)
                .when().get(endpoint).then();
        System.out.println("Response :"+validatableResponse.extract().asPrettyString());
    }


//    public void getRequest(){
//        genericAPIFunctions.getRequest();
//        System.out.println("Response :"+validatableResponse.extract().asPrettyString());
//    }

    @Then("the response will return status {int} and id {int} and salary {int} and name {string} and age {int} and message {string}")
    public void verifyStatus(int statusCode, int id, int emp_Salary, String emp_name, int emp_age, String message ){
        validatableResponse.assertThat().statusCode(statusCode);
        validatableResponse.assertThat().body("data.id",equalTo(id));
        validatableResponse.assertThat().body("data.employee_salary",equalTo(emp_Salary));
        validatableResponse.assertThat().body("data.employee_name",equalTo(emp_name));
        validatableResponse.assertThat().body("data.employee_age",equalTo(emp_age));
        validatableResponse.assertThat().body("message",equalTo(message));
    }
}
