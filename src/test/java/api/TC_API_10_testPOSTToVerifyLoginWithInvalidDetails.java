package api;

import api.endpoints.VerifyLoginAPI;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class TC_API_10_testPOSTToVerifyLoginWithInvalidDetails {

    @Test
    public void testVerifyLogin_WithInvalidDetails() {
        VerifyLoginAPI api = new VerifyLoginAPI();

        // Fake credentials
        String email = "wrong@example.com";
        String password = "wrongPassword";

        Response response = api.postVerifyLogin(email, password);

        // Print body for debugging
        System.out.println(response.getBody().asString());

        // Parse JSON
        JsonPath json = response.jsonPath();

        int responseCode = json.getInt("responseCode");
        String message = json.getString("message");

        // Assert
        assertEquals(response.getStatusCode(), 200); // السيرفر بيرجع 200
        assertEquals(responseCode, 404);             // لكن جوه JSON بيرجع 404
        assertEquals(message, "User not found!");

        System.out.println("TC_API 10 successfully");

    }
}
