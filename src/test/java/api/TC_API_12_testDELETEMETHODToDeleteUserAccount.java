package api;

import api.endpoints.CreateAccountAPI;
import api.endpoints.DeleteAccountAPI;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC_API_12_testDELETEMETHODToDeleteUserAccount {
    @Test
    public void testDeleteUser() {
        DeleteAccountAPI deleteAccountAPI = new DeleteAccountAPI();
        CreateAccountAPI createAccountAPI = new CreateAccountAPI();

        // إنشاء بريد إلكتروني فريد لتجنب تكرار الحساب
        String email = "Bola" + System.currentTimeMillis() + "@test.com";

        Response CreateAccountresponse = createAccountAPI.createUser(
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

        System.out.println("Status Code: " + CreateAccountresponse.getStatusCode());
        System.out.println("Response Body: " + CreateAccountresponse.asString());

        // بيانات الحساب المراد حذفه
        String password = "123456";

        Response DeletAccountresponse = deleteAccountAPI.deleteUser(email, password);

        System.out.println("Status Code: " + DeletAccountresponse.getStatusCode());
        System.out.println("Response Body: " + DeletAccountresponse.asString());

        // التحقق من نجاح الحذف
        Assert.assertEquals(DeletAccountresponse.getStatusCode(), 200);
        Assert.assertTrue(DeletAccountresponse.jsonPath().getString("message").contains("Account deleted!"));
        System.out.println("TC_API 12 successfully");

    }
}
