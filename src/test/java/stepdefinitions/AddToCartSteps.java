package stepdefinitions;

import com.pages.gui.AddToCartPage;
import com.qa.factory.DriverFactory;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;

public class AddToCartSteps
{
    public WebDriver driver;
    private AddToCartPage addToCartPage = new AddToCartPage(DriverFactory.getDriver());
    private static final Logger LOG = LogManager.getLogger(AddToCartSteps.class);

    @When("user should perform add_to_cart and click on cart icon")
    public void user_should_perform_add_to_cart_and_click_on_cart_icon()
    {
        addToCartPage.addToCartButton();
        LOG.info("Add to cart called!");
    }

    @Then("user proceed with checkout operation")
    public void user_proceed_with_checkout_operation() {
        addToCartPage.cartIcon();
        LOG.info("Cart Checkout done!");
    }

}
