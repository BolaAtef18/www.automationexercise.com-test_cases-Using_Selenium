package api.endpoints;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class ProductsAPI {
    private static final String BASE_URL = "https://automationexercise.com/api";

    // Method to Get All Products
    public static Response getAllProducts() {
        return RestAssured
                .given()
                .when()
                .get(BASE_URL + "/productsList");
    }

    // POST: Attempt to send to productsList (Expected 405)
    public static Response postAllProducts() {
        return RestAssured
                .given()
                .header("Content-Type", "application/json")
                .body("{}") // body فارغ عشان نرسل POST
                .when()
                .post(BASE_URL + "/productsList");
    }
}
