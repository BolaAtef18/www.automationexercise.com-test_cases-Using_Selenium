package api;

import api.endpoints.VerifyLoginAPI;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class TC_API_8_testPOSTToVerifyLoginWithoutEmailParameter {

    @Test
    public void testVerifyLogin_WithoutEmail() {
    VerifyLoginAPI api = new VerifyLoginAPI();

    // Password فقط بدون email
    String password = "123456";

    Response response = api.postVerifyLoginWithoutEmail(password);

    // Print response body
        System.out.println(response.getBody().asString());

    // Parse JSON manually
    JsonPath json = response.jsonPath();

    int responseCode = json.getInt("responseCode");
    String message = json.getString("message");

    // Assert
    assertEquals(response.getStatusCode(), 200); // HTTP status code غالبًا 200
    assertEquals(responseCode, 400);             // Response code داخل الـ JSON
    assertEquals(message, "Bad request, email or password parameter is missing in POST request.");

    System.out.println("TC_API 8 successfully");

    }
}
