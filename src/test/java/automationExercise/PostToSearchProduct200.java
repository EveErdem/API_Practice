package automationExercise;

import baseUrls.ExerciseBaseUrl;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class PostToSearchProduct200 extends ExerciseBaseUrl {
    @Test
    public void name() {
        /*
        API URL: https://automationexercise.com/api/searchProduct
Request Method: POST
Request Parameter: search_product (For example: top, tshirt, jean)
Response Code: 200
Response JSON: Searched products list
         */
      specExercise.pathParam("pp1","searchProduct").queryParam("search_product","jean");
        Response response=given()
                .spec(specExercise)
                .contentType("application/json")
                //.accept("text/html; charset=utf-8")
                .when()
                .post("/{pp1}");
        response.prettyPrint();
        System.out.println(response.contentType());
        response.then()
                .assertThat().statusCode(200);
    }
}
