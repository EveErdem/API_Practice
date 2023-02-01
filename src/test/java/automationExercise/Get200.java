package automationExercise;

import baseUrls.ExerciseBaseUrl;
import io.restassured.response.Response;
import org.hamcrest.Matchers;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class Get200 extends ExerciseBaseUrl {
    @Test
    public void name() {
        /*
        API URL: https://automationexercise.com/api/productsList
Request Method: GET
Response Code: 200
Response JSON: All products list
         */
        /*
               // response.prettyPrint();
         int size=response.jsonPath().getList("bookingid").size();
        System.out.println(size);
        response.
                then().
                assertThat().
                statusCode(200).
                body("bookingid", Matchers.hasSize(size));
         */
        specExercise.pathParams("pp1","api","pp2","productsList");
        Response response=given()
                .spec(specExercise)
                .when()
                .get("/{pp1}/{pp2}");
        response.prettyPrint();
       // int size=response.jsonPath().getJsonObject("products.id").size()
        System.out.println(size);
        response.then()
                .assertThat()
                .statusCode(200);
                //.body(response.jsonPath().get("products.id"), Matchers.hasSize(43));
    }
}
