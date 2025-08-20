package api;

import api.endpoints.ProductsAPI;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

public class testPOSTAllProductsList {

    @Test
    public void testPOSTNotAllowed(){
        Response response = ProductsAPI.postAllProducts();

        JsonPath json = response.jsonPath();
        int responseCodeInBody = json.getInt("responseCode");
        String message = json.getString("message");

//        System.out.println("POST Response code: " + response.getStatusCode());
//        System.out.println("POST Response body: " + response.getBody().asString());
//        Assert.assertEquals(response.getStatusCode(), 200, "Status code mismatch");
//        Assert.assertEquals(response.getBody());

        Assert.assertEquals(responseCodeInBody,405,"Response code inside body is not 405");
        Assert.assertEquals(message, "This request method is not supported.");
    }
}
