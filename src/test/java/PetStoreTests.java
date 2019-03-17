import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.Test;

public class PetStoreTests {

    final static PetEndpoint PET_ENDPOINT = new PetEndpoint();

    @Test
    public void getPetById200() {
        PET_ENDPOINT
                .getPetById(1)
                .then().statusCode(200);
    }

    @Test
    public void getPetById404() {
        PET_ENDPOINT
                .getPetById(0)
                .then().statusCode(404);
    }

    @Test
    public void getPetByStatus200() {
        PET_ENDPOINT
                .getPetByStatus("available")
                .then().statusCode(200);
    }

    @Test
    public void createPet() {
        PetEntity petEntity = new PetEntity(5, "zombie", "available");
        PET_ENDPOINT
                .createPet(petEntity)
                .then().statusCode(200);

    }

}
