package automationExercise;

import baseUrls.ExerciseBaseUrl;
import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class GetBrandList200 extends ExerciseBaseUrl {
    @Test
    public void name() {
        /*
        API URL: https://automationexercise.com/api/brandsList
Request Method: GET
Response Code: 200
Response JSON: All brands list
         */
        specExercise.pathParam("pp1","brandsList");
        Response response=given()
                .spec(specExercise)
                .when()
                .get("/{pp1}");
        response.prettyPrint();
        response.then().assertThat()
                .statusCode(200);
    }
}
