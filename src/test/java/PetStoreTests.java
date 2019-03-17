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
        String body = "{\n" +
                "  \"id\": 0,\n" +
                "  \"category\": {\n" +
                "    \"id\": 0,\n" +
                "    \"name\": \"string\"\n" +
                "  },\n" +
                "  \"name\": \"doggie\",\n" +
                "  \"photoUrls\": [\n" +
                "    \"string\"\n" +
                "  ],\n" +
                "  \"tags\": [\n" +
                "    {\n" +
                "      \"id\": 0,\n" +
                "      \"name\": \"string\"\n" +
                "    }\n" +
                "  ],\n" +
                "  \"status\": \"available\"\n" +
                "}";
    }

}
