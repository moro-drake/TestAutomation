import io.restassured.RestAssured;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class SampleRestTest {


    @BeforeClass
    public static void setup() {
        RestAssured.baseURI = "https://google.com";
        RestAssured.useRelaxedHTTPSValidation();
    }

    @Test
    public void doRestStuff() {
        given()
                .get()
                .then()
                .statusCode(200);
    }
}
