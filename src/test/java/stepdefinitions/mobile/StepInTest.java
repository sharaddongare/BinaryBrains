package stepdefinitions.mobile;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.mobile.CapSetUp;
import com.mobile.Products;
import com.mobile.WelcomeScreen;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;

public class StepInTest {

    CapSetUp capset = new CapSetUp();
    public Logger logger = LogManager.getLogger("Capabilities setup");

    @Given("Setup Virtual MobileDriver")
    public void setupTheMobileDriver_Virtual() throws MalformedURLException, InterruptedException {
        capset.setMobDriver_VirtualDevice();
    }

    @Then("Open Products")
    public void openProductsScreen() throws InterruptedException {
        WelcomeScreen welcomeScreen = new WelcomeScreen();
        welcomeScreen.openProducts();
        logger.info("Open Products Screen Successfully");
    }

    @Then("Get Product Details for {int}")
    public void getProductDetails(int numberOfProd) throws InterruptedException {
        Products products = new Products();
        String apiUrl = "http://ec2-54-254-162-245.ap-southeast-1.compute.amazonaws.com:9000/items/";

        for(int index=1;index<=numberOfProd;index++) {
            String prodName = products.getProductName(index);
            String prodDesc = products.getProductDescription(index);
            String prodPrice = products.getProductPrice(index);
            String numericPrice = prodPrice.replaceAll("[^0-9]", "");

            logger.info("Product Name: " + prodName);
            logger.info("Product Description: " + prodDesc);
            logger.info("Product Price: " + numericPrice);


            HashMap<String, String> productData = new HashMap<>();
            productData.put("name", prodName);
            productData.put("description", prodDesc);
            productData.put("price", numericPrice);
            productData.put("item_type", "Vodafone-2");


            Gson gson = new Gson();
            String jsonData = gson.toJson(productData);


            pushDataToAPI(apiUrl, jsonData);
        }
    }

    public void pushDataToAPI(String apiUrl, String jsonData) {
        String itemId = null;
        try {
            URL url = new URL(apiUrl);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("POST");
            conn.setRequestProperty("Content-Type", "application/json");
            conn.setRequestProperty("Accept", "application/json");
            conn.setDoOutput(true);

            try (OutputStream os = conn.getOutputStream()) {
                byte[] input = jsonData.getBytes("utf-8");
                os.write(input, 0, input.length);
            }

            int responseCode = conn.getResponseCode();
            System.out.println("Response Code: " + responseCode);



            if (responseCode == HttpURLConnection.HTTP_OK) {
                BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream()));
                String inputLine;
                StringBuilder response = new StringBuilder();

                while ((inputLine = in.readLine()) != null) {
                    response.append(inputLine);
                }
                in.close();


                String responseBody = response.toString();
                System.out.println("Response Body: " + responseBody);

                itemId = extractItemIdFromResponse(responseBody);
                System.out.println("Item Id: " + itemId);
            }


            conn.disconnect();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private String extractItemIdFromResponse(String responseBody) {
        // Parse the JSON response to extract the "id"
        JsonObject jsonObject = JsonParser.parseString(responseBody).getAsJsonObject();
        return jsonObject.get("id").getAsString();
    }

    @Then("Close the App")
    public void closeTheApp() {
        capset.quitMobDriver();
    }
}
