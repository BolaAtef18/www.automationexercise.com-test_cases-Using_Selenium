package api;

import api.endpoints.CreateAccountAPI;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC_API_11_testPOSTToCreateRegisterUserAccount {

    @Test
    public void testCreateUser() {
        CreateAccountAPI createAccountAPI = new CreateAccountAPI();

        // إنشاء بريد إلكتروني فريد لتجنب تكرار الحساب
        String email = "Bola" + System.currentTimeMillis() + "@test.com";

        Response response = createAccountAPI.createUser(
                "Bola Atef",
                email,
                "123456",
                "Mr",
                "10",
                "May",
                "1990",
                "Bola",
                "Atef",
                "ABC Corp",
                "123 Street",
                "Apartment 4B",
                "Canada",
                "12345",
                "Ontario",
                "Toronto",
                "+11234567890"
        );

        System.out.println("Status Code: " + response.getStatusCode());
        System.out.println("Response Body: " + response.asString());

        // تحقق من نجاح العملية
        Assert.assertEquals(response.jsonPath().getInt("responseCode"),201);

        Assert.assertTrue(response.asString().contains("User created!"));
        System.out.println("TC_API 11 successfully");

    }
}
