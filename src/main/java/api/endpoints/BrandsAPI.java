package api.endpoints;
import io.restassured.RestAssured;
import io.restassured.response.Response;

public class BrandsAPI {
    private static final String BASE_URL = "https://automationexercise.com/api";

    // Method for GET /brandsList
    public Response getAllBrands() {
        return RestAssured
                .given()
                .baseUri(BASE_URL)
                .when()
                .get("/brandsList")
                .then()
                .extract().response();
    }
    public Response putAllBrands(){
        return RestAssured
                .given()
                .baseUri(BASE_URL)
                .when()
                .put("/brandsList")
                .then()
                .extract().response();
    }
}
