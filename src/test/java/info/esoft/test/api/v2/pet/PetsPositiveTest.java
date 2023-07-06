package info.esoft.test.api.v2.pet;

import info.esoft.test.api.configuration.Settings;
import info.esoft.test.api.constants.ConstAllure;

import info.esoft.test.api.constants.HTTPStatusCode;
import info.esoft.test.api.constants.api_path.v2.ConstPet;
import info.esoft.test.api.helpers.pet.dto.PetRoot;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static info.esoft.test.api.helpers.pet.PetsResponseHelper.*;
import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;


@Epic(ConstAllure.Epic.PETS)
@Feature(ConstAllure.Feature.POSITIVE)
@Tag(ConstAllure.Tag.PETS_POSITIVE)
public class PetsPositiveTest extends Settings {

    @ParameterizedTest(name = "[{index}] idPet={0}, idCategory={1}, nameCategory={2}, namePet={3}, photoUrl={4}, idTag={5}, nameTag={6}, status={7}")
    @Tag(ConstAllure.Tag.POSITIVE)
    @DisplayName(ConstAllure.Method.POST + " | Add a new pet to the store")
    @CsvSource({
            "1, 1, 'string', 'doggie', 'https://example.com/photo1.jpg', 1, 'string', 'available'",
            "2, 2, 'string2', 'cat', 'https://example.com/photo2.jpg', 2, 'string2', 'available'",
            "3, 3, 'string3', 'bird', 'https://example.com/photo3.jpg', 3, 'string3', 'available'"
    })
    void addPetsTest(Integer idPet, Integer idCategory, String nameCategory, String namePet, String photoUrl, Integer idTag, String nameTag, String status){
        PetRoot body = createSectionsBody(idPet,idCategory,nameCategory,namePet,photoUrl,idTag,nameTag,status);

        postPetResponse(body)
                        .statusCode(HTTPStatusCode.R_200)
                        .body(matchesJsonSchemaInClasspath(ConstPet.Schema.PET_VALID));
    }

    @Test
    @Tag(ConstAllure.Tag.POSITIVE)
    @DisplayName(ConstAllure.Method.GET + " | Find pet by ID")
    void findPetTest(){
        PetRoot body  = createSectionsBody();
        Long idPetResponse = getIdPetResponse(body);

        getPetResponse(idPetResponse)
                .statusCode(HTTPStatusCode.R_200)
                .body(matchesJsonSchemaInClasspath(ConstPet.Schema.PET_VALID));
    }
}
