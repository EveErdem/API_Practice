package baseUrls;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.junit.Before;

import static io.restassured.RestAssured.given;

public class ExerciseBaseUrl {
    protected RequestSpecification specExercise;
    @Before
    public void setUp(){
        specExercise= new RequestSpecBuilder().setBaseUri("https://automationexercise.com").build();

    }
}
