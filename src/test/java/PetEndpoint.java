import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import net.thucydides.core.annotations.Step;

public class PetEndpoint {

    private RequestSpecification given() {
        RestAssured.enableLoggingOfRequestAndResponseIfValidationFails();
        return RestAssured.given()
                .baseUri(Config.PET_STORE_BASE_URI)
                .contentType("application/json")
                .log().uri();
    }

    @Step
    public Response getPetById(int petId) {
        return given()
                .basePath(Config.GET_PET_BY_ID)
                .pathParam("id", petId)
                .get()
                .then().extract().response();
    }

    @Step
    public Response getPetByStatus(String status) {
        return given()
                .basePath(Config.GET_PET_BY_STATUS)
                .param("status", status)
                .get()
                .then().extract().response();
    }

    @Step
    public Response createPet(PetEntity petEntity) {
        return given()
                .basePath(Config.CREATE_PET)
                .body(petEntity)
                .post()
                .then().extract().response();
    }
}
