package api.endpoints;

import io.restassured.RestAssured;
import io.restassured.response.Response;

import java.util.HashMap;
import java.util.Map;

public class CreateAccountAPI {
    private final String BASE_URI = "https://automationexercise.com";
    private final String ENDPOINT = "/api/createAccount";

    public Response createUser(String name, String email, String password, String title,
                               String birth_date, String birth_month, String birth_year,
                               String firstname, String lastname, String company,
                               String address1, String address2, String country,
                               String zipcode, String state, String city, String mobile_number) {

        RestAssured.baseURI = BASE_URI;

        Map<String, String> requestBody = new HashMap<>();
        requestBody.put("name", name);
        requestBody.put("email", email);
        requestBody.put("password", password);
        requestBody.put("title", title);
        requestBody.put("birth_date", birth_date);
        requestBody.put("birth_month", birth_month);
        requestBody.put("birth_year", birth_year);
        requestBody.put("firstname", firstname);
        requestBody.put("lastname", lastname);
        requestBody.put("company", company);
        requestBody.put("address1", address1);
        requestBody.put("address2", address2);
        requestBody.put("country", country);
        requestBody.put("zipcode", zipcode);
        requestBody.put("state", state);
        requestBody.put("city", city);
        requestBody.put("mobile_number", mobile_number);

        Response response = RestAssured
                .given()
                .header("Content-Type", "application/x-www-form-urlencoded")
                .formParams(requestBody)
                .post(ENDPOINT)
                .then()
                .extract().response();

        return response;
    }
}
