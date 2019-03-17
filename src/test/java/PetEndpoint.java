import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class PetEndpoint {

    private RequestSpecification given() {
        return RestAssured.given()
                .baseUri(Config.PET_STORE_BASE_URI)
                .log().uri();
    }

    public Response getPetById(int petId) {
        return given()
                .basePath(Config.GET_PET_BY_ID)
                .pathParam("id", petId)
                .get()
                .then().extract().response();
    }

    public Response getPetByStatus(String status) {
        return given()
                .basePath(Config.GET_PET_BY_STATUS)
                .param("status", status)
                .get()
                .then().extract().response();
    }
}
