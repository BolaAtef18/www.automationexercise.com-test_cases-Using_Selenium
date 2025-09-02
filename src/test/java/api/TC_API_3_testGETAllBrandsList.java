package api;

import api.endpoints.BrandsAPI;
import org.testng.annotations.Test;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.testng.Assert;

public class TC_API_3_testGETAllBrandsList {

    BrandsAPI brandsAPI = new BrandsAPI();

    @Test
    public void testGetAllBrands(){

    Response response = brandsAPI.getAllBrands();

    // 2. تحقق من Status Code
        Assert.assertEquals(response.getStatusCode(), 200, "Status code should be 200");

    // 3. تحقق إن response body مش فاضي
    String responseBody = response.getBody().asString();
        Assert.assertFalse(responseBody.isEmpty(), "Response body should not be empty");

    // 4. تحقق من وجود Brand معين
        Assert.assertTrue(responseBody.contains("H&M"), "Response should contain Nike");

    // 5. Parse JSON باستخدام JsonPath
    JsonPath json = response.jsonPath();
    int firstBrandId = json.getInt("brands[0].id");
    String firstBrandName = json.getString("brands[0].brand");

        Assert.assertTrue(firstBrandId > 0, "Brand ID should be positive");
        Assert.assertNotNull(firstBrandName, "Brand name should not be null");

        int size = json.getList("brands").size();

        for (int i = 0; i < size; i++) {
            int id = json.getInt("brands[" + i + "].id");
            String name = json.getString("brands[" + i + "].brand");
            System.out.println(id + ", " + name);
        }
    }
}
