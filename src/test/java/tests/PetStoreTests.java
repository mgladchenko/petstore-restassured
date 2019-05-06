package tests;

import endpoints.PetEndpoint;
import io.restassured.response.ValidatableResponse;
import models.PetEntity;
import net.thucydides.core.annotations.Steps;
import org.junit.Test;
import org.junit.runner.RunWith;
import net.serenitybdd.junit.runners.SerenityRunner;


import static org.hamcrest.Matchers.is;

@RunWith(SerenityRunner.class)
public class PetStoreTests {

    @Steps
    protected PetEndpoint petEndpoint;

    @Test
    public void getPetById200() {
        petEndpoint
                .getPetById(1)
                .then().statusCode(200);
    }

    @Test
    public void getPetById404() {
        petEndpoint
                .getPetById(0)
                .then().statusCode(404);
    }

    @Test
    public void getPetByStatus200() {
        petEndpoint
                .getPetByStatus("available")
                .then().statusCode(200);
    }

    @Test
    public void createPet() {
        int petId = 5;
        PetEntity petEntity = new PetEntity(petId, "zombie", "available");

        ValidatableResponse response = petEndpoint
                .createPet(petEntity)
                .then().statusCode(200)
                .and().body("id", is(petId));
    }

}
