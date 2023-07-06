package info.esoft.test.api.helpers.pet;

import info.esoft.test.api.configuration.Settings;
import info.esoft.test.api.constants.api_path.v2.ConstPet;
import info.esoft.test.api.helpers.pet.dto.Category;
import info.esoft.test.api.helpers.pet.dto.PetRoot;
import info.esoft.test.api.helpers.pet.dto.Tag;
import io.qameta.allure.Step;
import io.restassured.filter.log.LogDetail;
import io.restassured.response.ValidatableResponse;

import static io.restassured.RestAssured.given;


public class PetsResponseHelper extends Settings {

    @Step("Add pet")
    public static ValidatableResponse postPetResponse(PetRoot body) {
        return
            given()
                .spec(requestSpecification)
                .body(body)
            .when()
                .post(ConstPet.API_PATH)
            .then()
                .log().ifValidationFails(LogDetail.ALL);
    }

    @Step("Get id Pet")
    public static Long getIdPetResponse(PetRoot body) {
        return
                given()
                    .spec(requestSpecification)
                    .body(body)
                .when()
                    .post(ConstPet.API_PATH)
                .then()
                    .log().ifValidationFails(LogDetail.ALL)
                .extract().path("id");
    }

    @Step("Find pet")
    public static ValidatableResponse getPetResponse(Long idPet) {
        return
            given()
                    .spec(requestSpecification)
                    .pathParam("id",idPet)
            .when()
                    .get(ConstPet.API_PATH+ "/{id}")
            .then()
                    .log().ifValidationFails(LogDetail.ALL);
    }

    @Step("Create pet response body")
    public static PetRoot createSectionsBody(Integer idPet, Integer idCategory, String nameCategory, String namePet,
                                             String photoUrl, Integer idTag, String nameTag, String status) {
        return PetRoot.builder()
                .id(idPet)
                .category(Category.builder()
                        .id(idCategory)
                        .name(nameCategory)
                        .build())
                .name(namePet)
                .photoUrl(photoUrl)
                .tags(Tag.builder()
                        .id(idTag)
                        .name(nameTag)
                        .build())
                .status(status)
                .build();
    }

    @Step("Create pet response body")
    public static PetRoot createSectionsBody() {
        return PetRoot.builder()
                .id(0)
                .category(Category.builder()
                        .id(0)
                        .name("nameCategory")
                        .build())
                .name("namePet")
                .photoUrl("photoUrl")
                .tags(Tag.builder()
                        .id(0)
                        .name("nameTag")
                        .build())
                .status("status")
                .build();
    }
}
