package info.esoft.test.api.helpers.pet;

import info.esoft.test.api.configuration.Settings;
import info.esoft.test.api.constants.ConstAllure;
import info.esoft.test.api.constants.api_path.v2.ConstPet;
import io.qameta.allure.Step;
import io.restassured.filter.log.LogDetail;
import io.restassured.response.ValidatableResponse;

import static io.restassured.RestAssured.given;

public class FindPetsResponseHelper extends Settings {
    @Step(ConstAllure.Method.GET + ConstPet.API_PATH)
    public static ValidatableResponse getDictionaryResponse() {
        return
                given()
                        .spec(requestSpecification)
                .when()
                        .get("/1")
                .then()
                        .log().ifValidationFails(LogDetail.ALL);
    }
}
