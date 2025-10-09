package api;

import api.endpoints.VerifyLoginAPI;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class TC_API_9_testDELETEToVerifyLogin {

    @Test
    public void testVerifyLogin_WithDeleteMethod() {
        VerifyLoginAPI api = new VerifyLoginAPI();

        Response response = api.deleteVerifyLogin();

        // Print response body
        System.out.println(response.getBody().asString());

        // Parse JSON manually
        JsonPath json = response.jsonPath();

        int responseCode = json.getInt("responseCode");
        String message = json.getString("message");

        // Assert
        assertEquals(response.getStatusCode(), 200); // HTTP status code غالبًا 200
        assertEquals(responseCode, 405);             // Response code داخل JSON
        assertEquals(message, "This request method is not supported."); // الرسالة
        System.out.println("TC_API 9 successfully");

    }
}
