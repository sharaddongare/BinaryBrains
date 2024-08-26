package stepdefinitions.gui;

import com.gui.guiUtility.ConfigReader;
import com.gui.guiUtility.DriverFactory;
import com.gui.pages.UltimateQAPage;
import io.cucumber.java.en.Then;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import io.restassured.http.ContentType;

public class UltimateQASteps {

    private UltimateQAPage ultimatePage = new UltimateQAPage();

    private static final Logger LOG = LogManager.getLogger(BasicCommonSteps.class);
    private DriverFactory driverFactory = new DriverFactory();

    @Then("User should land on Home page")
    public void user_should_land_on_home_page() {
        System.out.println("Step 2");
    }

    @Then("User click on login Automation")
    public void user_click_on_login_automation() {
        // Write code here that turns the phrase above into concrete actions
        System.out.println("Step 3 - Click Ultimate login URL");
        ultimatePage.ultimateLoginURL();
    }

    @Then("User enter username and password and click login button")
    public void user_enter_and_and_click_login_button() {
        // Write code here that turns the phrase above into concrete actions
        System.out.println("Step 4");
        ultimatePage.enterUltimateUser(ConfigReader.init_prop().getProperty("ultimateUser"));
        ultimatePage.enterUltimatePass(ConfigReader.init_prop().getProperty("ultimatePass"));
        ultimatePage.ultimateLoginButton();
        System.out.println("Done");
    }

    @Then("User should use get method")
    public void user_should_use_get_method() {

        System.out.println("Push information to FB");
        String pageId = "368395739697931";
        String accessToken = "EAA1i9quZBm3oBO213xykyAb9hfmWKLu1bY9gly3hzi7ey0PJ4wbAPifuJVqrZBpZCYZCmkq8jiFm0yDHtZC5KXCGHk50R0ZCOCxQjTZAWfpVhKJ4Qa2keeiEZCvzRspAQWdcXiKuMWQiJknVs7O6CNG8wAuVZApk0dkKqmvVdaIBnEPLhckQH4SzGrbREE5xQeBJRTu42U3X0kb1fiVq4JwZDZD";
        String message = "Hey Rushi -1";

        Response response = RestAssured.given()
                .contentType(ContentType.JSON)
                .body("{\"message\":\"" + message + "\", \"access_token\":\"" + accessToken + "\"}")
                .post("https://graph.facebook.com/v20.0/" + pageId + "/feed");

        System.out.println("Response: " + response.asString());

    }

}
