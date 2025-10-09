    package api.endpoints;

    import io.restassured.RestAssured;
    import io.restassured.response.Response;

    import java.util.HashMap;
    import java.util.Map;

    public class UpdateAccountAPI {
        private String baseUrl = "https://automationexercise.com/api";

        public Response updateUser(String name, String emailupdate,String passwordupdate) {

            Response response = RestAssured.given()
                    .header("Content-Type", "application/x-www-form-urlencoded")
                    .formParam("name", name)
                    .formParam("email", emailupdate)
                    .formParam("password", passwordupdate)
                    .formParam("title", "Mr")
                    .formParam("birth_date", "15")
                    .formParam("birth_month", "10")
                    .formParam("birth_year", "1993")
                    .formParam("firstname", "Bola")
                    .formParam("lastname", "Atef")
                    .formParam("company", "Updated Company")
                    .formParam("address1", "Updated Address 1")
                    .formParam("address2", "Updated Address 2")
                    .formParam("country", "Egypt")
                    .formParam("zipcode", "55555")
                    .formParam("state", "Cairo")
                    .formParam("city", "Nasr City")
                    .formParam("mobile_number", "01099999999")
                    .when()
                    .put(baseUrl + "/updateAccount");


            return response;
        }
    }
