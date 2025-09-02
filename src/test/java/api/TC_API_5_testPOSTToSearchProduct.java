package api;

import api.endpoints.SearchAPI;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC_API_5_testPOSTToSearchProduct {

    SearchAPI searchAPI = new SearchAPI();

    @Test
    public void testSearchProduct_ValidProduct() {
        String productName = "top"; // ممكن تغير القيمة لأي منتج
        Response response = searchAPI.searchProduct(productName);

        // التحقق من Status Code
        Assert.assertEquals(response.statusCode(), 200, "Expected HTTP 200");

        // التحقق من JSON Response يحتوي على المنتجات
        Assert.assertTrue(response.jsonPath().getList("products").size() > 0,
                "Expected products list not to be empty");

        JsonPath json = response.jsonPath();

        int size = json.getList("products").size();

        for (int i = 0; i < size; i++) {
            //int id = json.getInt("products[" + i + "].id");
            String name = json.getString("products[" + i + "]");
//            System.out.println(id + ", " + name);
            System.out.println(name);
        }
    }
}
