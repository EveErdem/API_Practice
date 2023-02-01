package automationExercise;

import baseUrls.ExerciseBaseUrl;
import io.restassured.http.ContentType;
import io.restassured.path.xml.XmlPath;
import io.restassured.response.Response;
import org.hamcrest.Matchers;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;

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
        specExercise.pathParam("pp1","productsList");
        Response response=given()
                .spec(specExercise)
                .contentType(ContentType.JSON)
                .when()
                .get("/{pp1}");
        response.prettyPrint();
        XmlPath doc=response.xmlPath(XmlPath.CompatibilityMode.HTML);
       int size=response.jsonPath().getList("products.id").size();
        System.out.println(size);
       // System.out.println(response.htmlPath().getList("html.body").get(0));
        //int size= response.htmlPath().getList("products",)
       // int size=response.jsonPath().getList("id").size();
       // System.out.println(doc.getString("html.body.responseCode"));
       // System.out.println(size);
        response.then()
                .assertThat()
                .statusCode(200);
               // .body(("products.id"), Matchers.hasSize(size));
    }
}
