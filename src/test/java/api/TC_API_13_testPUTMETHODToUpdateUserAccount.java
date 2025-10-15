package api;

import api.endpoints.CreateAccountAPI;
import api.endpoints.UpdateAccountAPI;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC_API_13_testPUTMETHODToUpdateUserAccount {
    @Test
    public void testUpdateAccount() {
        CreateAccountAPI createAccountAPI = new CreateAccountAPI();

        UpdateAccountAPI updateAPI = new UpdateAccountAPI();
        String password = "123456";


        String email = "Bolaupdate1@test.com";

        Response updateResponse = updateAPI.updateUser("Bola Updated123",email,password);

        System.out.println("Status Code: " + updateResponse.getStatusCode());
        System.out.println("Response Body: " + updateResponse.asString());

        // Step 3: Validate response
        Assert.assertEquals(updateResponse.getStatusCode(), 200);
        Assert.assertTrue(updateResponse.asString().contains("User updated!"));
        System.out.println("TC_API 13 successfully");

    }
}
