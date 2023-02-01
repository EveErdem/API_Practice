package automationExercise;

import baseUrls.ExerciseBaseUrl;
import io.restassured.http.ContentType;
import io.restassured.path.xml.XmlPath;
import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class PostRequest405 extends ExerciseBaseUrl {
    @Test
    public void name() {
        /*
        API URL: https://automationexercise.com/api/productsList
Request Method: POST
Response Code: 405
Response Message: This request method is not supported.
         */
        XmlPath doc = new XmlPath(
                XmlPath.CompatibilityMode.HTML,
                "<!DOCTYPE html PUBLIC \"-//W3C//DTD XHTML 1.0 Strict//EN\" \"http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd\">"
                        + "<html xmlns=\"http://www.w3.org/1999/xhtml\">"
                        + "<head><title>Hello world</title></head>"
                        + "<body>some body"
                        + "<div class=\"content\">wrapped</div>"
                        + "<div class=\"content\">wrapped2</div>"
                        + "</body></html>");
        specExercise.pathParam("pp1","productsList");
        Response response=given()
                .spec(specExercise)
                .body(doc.toString())
                .contentType(ContentType.HTML)
                .when()
                .post("/{pp1}");
        response.prettyPrint();
        System.out.println(response.getStatusCode());

    }
}
