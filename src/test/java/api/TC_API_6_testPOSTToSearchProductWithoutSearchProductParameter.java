package api;

import api.endpoints.SearchAPI;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC_API_6_testPOSTToSearchProductWithoutSearchProductParameter {

    SearchAPI searchAPI = new SearchAPI();

    @Test
    public void testSearchProduct_WithoutProductParameter() {
        //String productName = "top"; // ممكن تغير القيمة لأي منتج
        Response response = searchAPI.SearchProductWithoutParam();

        JsonPath json = response.jsonPath();
        int actualResponseCode = json.getInt("responseCode");
        String actualMessage = json.getString("message");


        // التحقق من Status Code
        Assert.assertEquals(actualResponseCode, 400);

        // التحقق من JSON Response يحتوي على المنتجات
        Assert.assertEquals(actualMessage, "Bad request, search_product parameter is missing in POST request.");

        System.out.println("actual Response Code: "  + actualResponseCode);  // هيكون 200 لو تمام
        System.out.println("actual Message: " + actualMessage);

    }
}
