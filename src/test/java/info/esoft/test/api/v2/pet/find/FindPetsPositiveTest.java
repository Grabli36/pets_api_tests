package info.esoft.test.api.v2.pet.find;

import info.esoft.test.api.configuration.Settings;
import info.esoft.test.api.constants.ConstAllure;
import info.esoft.test.api.constants.HTTPStatusCode;
import info.esoft.test.api.constants.api_path.v2.ConstPet;
import info.esoft.test.api.helpers.pet.FindPetsResponseHelper;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;


@Epic(ConstAllure.Epic.FIND_PETS)
@Feature(ConstAllure.Feature.POSITIVE)
@Tag(ConstAllure.Tag.FIND_PETS_POSITIVE)
public class FindPetsPositiveTest extends Settings {

    @Test
    @Tag(ConstAllure.Tag.POSITIVE)
    @DisplayName(ConstAllure.Method.GET + ConstPet.API_PATH + ConstPet.ORGANISATIONS + ConstAllure.StatusCode.CODE_200)
    void findPetsTest(){

        FindPetsResponseHelper.getDictionaryResponse()
                .statusCode(HTTPStatusCode.R_200);
    }

}
