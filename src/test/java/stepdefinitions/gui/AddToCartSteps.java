package stepdefinitions.gui;


import com.gui.guiUtility.DriverFactory;
import com.gui.pages.AddToCartPage;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;

public class AddToCartSteps
{

    private AddToCartPage addToCartPage = new AddToCartPage();
    private static final Logger LOG = LogManager.getLogger(AddToCartSteps.class);

    /**
     *This method is used to perform add to cart and click on cart icon
     */
    @When("user should perform add_to_cart and click on cart icon")
    public void user_should_perform_add_to_cart_and_click_on_cart_icon()
    {
        addToCartPage.addToCartButton();
        LOG.info("Add to cart called!");
    }

    /**
     * This method is used to proceed with checkout operation
     */
    @Then("user proceed with checkout operation")
    public void user_proceed_with_checkout_operation() {
        addToCartPage.cartIcon();
        LOG.info("Cart Checkout done!");
    }

}
