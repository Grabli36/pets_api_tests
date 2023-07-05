package info.esoft.test.api.v2.pet.add;

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

@Epic(ConstAllure.Epic.ADD_PETS)
@Feature(ConstAllure.Feature.POSITIVE)
@Tag(ConstAllure.Tag.ADD_PETS_POSITIVE)
public class AddPetsPositiveTest extends Settings {

    @Test
    @Tag(ConstAllure.Tag.POSITIVE)
    @DisplayName("Тестовый тесто, добавить питомца в магазин")
    void findPetsTest(){

        FindPetsResponseHelper.getDictionaryResponse()
                .statusCode(HTTPStatusCode.R_200);
    }

}
