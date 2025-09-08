package api.endpoints;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class VerifyLoginAPI {
    private static final String BASE_URL = "https://automationexercise.com/api";

    // Method to verify login with valid credentials
    public Response postVerifyLogin(String email, String password) {
        return RestAssured
                .given()
                .formParam("email", email)
                .formParam("password", password)
                .post(BASE_URL + "/verifyLogin");
    }
    public Response postVerifyLoginWithoutEmail(String password) {
        return RestAssured
                .given()
                .formParam("password", password)
                .post(BASE_URL + "/verifyLogin");
    }

    public Response deleteVerifyLogin() {
        return RestAssured
                .given()
                .delete(BASE_URL + "/verifyLogin");
    }
}
