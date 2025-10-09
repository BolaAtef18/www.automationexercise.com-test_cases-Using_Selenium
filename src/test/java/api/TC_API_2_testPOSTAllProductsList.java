package api;

import api.endpoints.ProductsAPI;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC_API_2_testPOSTAllProductsList {

    @Test
    public void testPOSTNotAllowed(){
        Response response = ProductsAPI.postAllProducts();

        JsonPath json = response.jsonPath();
        int responseCodeInBody = json.getInt("responseCode");
        String message = json.getString("message");

        Assert.assertEquals(responseCodeInBody,405,"Response code inside body is not 405");
        Assert.assertEquals(message, "This request method is not supported.");
        System.out.println(responseCodeInBody);
        System.out.println("TC_API 2 successfully");

    }
}
