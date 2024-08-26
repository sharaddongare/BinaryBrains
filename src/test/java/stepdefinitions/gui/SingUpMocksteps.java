package stepdefinitions.gui;


import com.gui.pages.EmailPage;
import com.gui.pages.LoginTwitterPage;
import com.gui.pages.MockSignUp;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;

public class SingUpMocksteps {

    public String title;

    MockSignUp Ms=new MockSignUp();

    private EmailPage emailPage=new EmailPage();
    private static final Logger LOG = LogManager.getLogger(SingUpMocksteps.class);


    /**
     * This method is used perform click on sign in button
     */
    /*@Then("User clicks on Sign in button")
    public void userClicksOnSignInButton() {
        loginTwitterPage.twitterSignInButtonClick();

    }

    *//**
     * This method is used to enter the user name and password
     *//*
    @Then("user enters valid Username and Password")
    public void userEntersValidUsernameAndPassword() {
        loginTwitterPage.enterUser(ConfigReader.init_prop().getProperty("username"));
        loginTwitterPage.enterPass(EncryptDecrypt.decryption(ConfigReader.init_prop().getProperty("password")));
        loginTwitterPage.twitterLoginButton();
    }

    *//**
     * This method is used to enter the emailId
     *//*
    @Then("User enters valid Email ID")
    public void userEntersValidEmailID() {
        loginTwitterPage.enterEmail("dongaresharad@gmail.com");
    }


    *//**
     * This method is used perform click on login button
     *//*
    @And("click on login button")
    public void clickOnSigninButton() {
        loginTwitterPage.twitterLoginButton();
    }

    *//**
     * This method is used to get the title of the page
     *//*
    @When("user gets the title of the page")
    public void user_gets_the_title_of_the_page() {
        title = loginTwitterPage.getLoginPageTitle();
        System.out.println("Page title is: " + title);
    }

    *//**
     * @param expectedTitleName - passed as argument to validate the page title
     *//*
    @Then("page title should be {string}")
    public void page_title_should_be(String expectedTitleName) {
        title = loginTwitterPage.getLoginPageTitle();
        Assert.assertTrue(title.contains(expectedTitleName));
    }

    *//**
     * This method is used to enter the valid EmailId
     *
     *
     *//*
    @Then("User enters {string}")
    public void userEntersValid_Email_ID(String email) {
    }*/
/*
    @When("user hits URL {string}")
    public void userHitsURLHttpEmailAtagtrCom(String URL) {
        emailPage.hitURL(URL);


    }*/


/*    @Then("user enters emaild {string} and Password {string}")
    public void userEntersEmaildTeamAutoAtagtrComAndPasswordAuttahon(String username, String Pass) throws InterruptedException {
        Thread.sleep(3000);
        emailPage.enterUserNameandPass(username,Pass);
    }*/

/*    @Then("user click on sign in button")
    public void userClickOnSignInButton() {
    emailPage.clickonSignButton();
    }

    @Then("User clicks on Inbox")
    public void userClicksOnInbox() {

    emailPage.clickoninbox();
    }

    @Then("Check for mail entries")
    public void checkForMailEntries() throws IOException, InterruptedException {

    emailPage.checkmail();
    }*/

    @Then("User Cliks on singIn Button")
    public void userCliksOnSingInButton() {

        Ms.singin();
    }


    @Then("User enter singin data")
    public void userEnterSinginData() {
        Ms.singUpdata();

    }

    @Then("User enter singin data {string}{string}{string}{string}")
    public void userEnterSinginDataSharadDongareSharadDongareVodaSharad(String firstname,String lastname, String email, String password) throws InterruptedException {

        Ms.singUpdata(firstname,lastname,email,password);
    }

    @Then("User enters firstName {string} and Lastname {string}")
    public void userEntersFirstNameSharadAndLastnameDongare(String FirstName, String LastName) {

    Ms.addUsersDetails(FirstName,LastName);
    }
}
