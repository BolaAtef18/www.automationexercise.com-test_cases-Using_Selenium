package api.endpoints;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class UserDetailAPI {
    private String baseUrl = "https://automationexercise.com/api";

    // ميثود لجلب بيانات المستخدم عن طريق الإيميل
    public Response getUserDetailByEmail(String email) {
        Response response = RestAssured.given()
                .header("Content-Type", "application/x-www-form-urlencoded")
                .queryParam("email", email)
                .when()
                .get(baseUrl + "/getUserDetailByEmail");

        return response;
    }
}
