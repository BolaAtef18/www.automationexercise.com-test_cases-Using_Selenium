package api.endpoints;

import io.restassured.RestAssured;
import io.restassured.response.Response;

import java.util.HashMap;
import java.util.Map;

public class DeleteAccountAPI {
    private final String BASE_URI = "https://automationexercise.com";
    private final String ENDPOINT = "/api/deleteAccount";

    public Response deleteUser(String email, String password) {

        RestAssured.baseURI = BASE_URI;

        Map<String, String> requestBody = new HashMap<>();
        requestBody.put("email", email);
        requestBody.put("password", password);

        Response response = RestAssured
                .given()
                .header("Content-Type", "application/x-www-form-urlencoded")
                .formParams(requestBody)
                .delete(ENDPOINT)
                .then()
                .extract().response();

        return response;
    }
}
