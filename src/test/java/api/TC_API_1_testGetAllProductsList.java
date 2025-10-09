package api;

import api.endpoints.ProductsAPI;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC_API_1_testGetAllProductsList {

    @Test
    public void testGetAllProducts() {
        Response response = ProductsAPI.getAllProducts();

        // Verify Status Code
        Assert.assertEquals(response.getStatusCode(), 200, "Status code is not 200");

        // Verify Response contains "products"
        Assert.assertTrue(response.getBody().asString().contains("products"), "Response doesn't contain products");
        System.out.println("TC_API 1 successfully");

    }
}
