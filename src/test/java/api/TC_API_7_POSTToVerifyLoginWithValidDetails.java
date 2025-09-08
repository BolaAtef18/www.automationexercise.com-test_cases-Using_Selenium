package api;

import api.endpoints.VerifyLoginAPI;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class TC_API_7_POSTToVerifyLoginWithValidDetails {

    @Test
    public void testVerifyLogin_WithValidDetails() {
        VerifyLoginAPI api = new VerifyLoginAPI();

        // Replace with valid credentials
        String email = "login@logout.com";
        String password = "123456";

        Response response = api.postVerifyLogin(email, password);

        // Print response for debugging
        System.out.println(response.getBody().asString());

        // Parse JSON manually
        JsonPath json = response.jsonPath();

        int responseCode = json.getInt("responseCode");
        String message = json.getString("message");

        // Assert
        assertEquals(response.getStatusCode(), 200);      // HTTP status code
        assertEquals(responseCode, 200);                 // Response code inside JSON
        assertEquals(message, "User exists!");          // Message inside JSON
    }
}
