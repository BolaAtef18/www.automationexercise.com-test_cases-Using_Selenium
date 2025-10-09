package api;

import api.endpoints.BrandsAPI;
import io.restassured.path.json.JsonPath;
import org.testng.annotations.Test;
import io.restassured.response.Response;
import org.testng.Assert;

public class TC_API_4_testPUTToAllBrandsList {
    BrandsAPI brandsAPI = new BrandsAPI();

    @Test
    public void testPutBrandsList_NotSupported() {
        // Call API
        Response response = brandsAPI.putAllBrands();

        JsonPath json = response.jsonPath();
        int actualResponseCode = json.getInt("responseCode");
        String actualMessage = json.getString("message");

        // Assertions
        Assert.assertEquals(actualResponseCode, 405, "Status code should be 405");
        Assert.assertTrue(actualMessage.contains("This request method is not supported."),
                "Response body should contain error message");

        // Print response nicely
        System.out.println("Response Code: " + actualResponseCode);
        System.out.println("Response message:\n" + actualMessage);

        System.out.println("TC_API 4 successfully");

    }

}

