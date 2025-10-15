package api;

import api.endpoints.UserDetailAPI;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC_API_14_testGETuseraccountdetailbyemail {
    @Test
    public void testGetUserDetailByEmail() {

        String email = "Bolaupdate1@test.com";

        UserDetailAPI userDetailAPI = new UserDetailAPI();

        Response response = userDetailAPI.getUserDetailByEmail(email);

        // طباعة الريسبونس للتاكيد
        System.out.println("Status Code: " + response.statusCode());
        System.out.println("Response Body: " + response.asPrettyString());
        Assert.assertTrue(response.jsonPath().getString("user").contains(email));

        // التحقق من الكود و الرسالة
        Assert.assertEquals(response.statusCode(), 200, "Status code mismatch");
        Assert.assertTrue(response.asString().contains("user"), "User details not found!");
        System.out.println("TC_API 14 successfully");

    }
}
