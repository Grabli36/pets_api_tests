package info.esoft.test.api.configuration;

import info.esoft.test.api.helpers.utils.PropertyHelper;
import io.qameta.allure.restassured.AllureRestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.log.LogDetail;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.apache.commons.configuration2.ex.ConfigurationException;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;

import java.util.HashMap;

import static info.esoft.test.api.logger.Logger.LOG4J_LOGGER;

public class Settings {
    // API location
    private static String URL         = "https://petstore.swagger.io",
                          BASE_PATH   = "/v2/pet/";

    public static boolean isSectionUpdatingCommitted = false;

    // Хранилища для параметров запроса
    protected static HashMap<String, Object> headers,
            body,
            queryParameters,
            pathParameters;

    // Хранилище ответов
    protected Response response;

    // Прикрепляет к отчёту параметры запроса и ответа
    private static final AllureRestAssured ALLURE_REQUEST_RESPONSE_TEMPLATE = new AllureRestAssured()
            .setRequestTemplate("custom-http-request.ftl")
            .setResponseTemplate("custom-http-response.ftl");

    private static final RequestSpecBuilder requestSpec = new RequestSpecBuilder()
            .addFilter(ALLURE_REQUEST_RESPONSE_TEMPLATE)
            .setAccept(ContentType.JSON)
            .log(LogDetail.ALL)
            .setContentType(ContentType.JSON);

    protected static RequestSpecification requestSpecification;

    @BeforeAll
    public static void setup() throws ConfigurationException {
        if(!isSectionUpdatingCommitted) {
            PropertyHelper.incrementSectionNumberAtConfigFile();
            isSectionUpdatingCommitted = true;
        }
        requestSpec.setBaseUri(URL);
        requestSpec.setBasePath(BASE_PATH);
        requestSpecification = requestSpec.build();
    }

    @AfterAll
    public static void afterAll() {
        requestSpecification = null;
    }

    @BeforeEach
    public void beforeEach() {
        response = null;

        headers         = new HashMap<>();
        body            = new HashMap<>();
        queryParameters = new HashMap<>();
        pathParameters  = new HashMap<>();
        LOG4J_LOGGER.info("************** NEW TEST STARTED  **************");
    }
}
