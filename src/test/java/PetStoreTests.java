import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.Test;

public class PetStoreTests {

    final PetEndpoint PET_ENDPOINT = new PetEndpoint();

    @Test
    public void getPetById200() {
        PET_ENDPOINT
                .getPetById(1)
                .then().statusCode(200);
    }

    @Test
    public void getPetById404() {
        RestAssured
                .given()
                .baseUri("https://petstore.swagger.io/v2/pet/0")
                .log().uri()
                .get()
                .then().statusCode(404);
    }

}
