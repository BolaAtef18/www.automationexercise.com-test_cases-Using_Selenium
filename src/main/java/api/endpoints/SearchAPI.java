package api.endpoints;

import io.restassured.response.Response;
import io.restassured.RestAssured;

import java.util.HashMap;
import java.util.Map;

public class SearchAPI {
    private static final String BASE_URL = "https://automationexercise.com/api";

    public Response searchProduct(String productName) {
        Map<String, String> params = new HashMap<>();
        params.put("search_product", productName);

        return RestAssured
                .given()
                .formParams(params)   // POST form parameters
                .when()
                .post(BASE_URL + "/searchProduct")
                .then()
                .extract()
                .response();
    }

    // Method for POST searchProduct without parameter
    public Response SearchProductWithoutParam() {
        return RestAssured
                .given()
                .post(BASE_URL + "/searchProduct");
    }
}
