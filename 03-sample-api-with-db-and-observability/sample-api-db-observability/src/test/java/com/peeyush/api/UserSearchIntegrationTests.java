package com.peeyush.api;

import com.peeyush.api.dtos.UserSearchResponse;
import io.restassured.RestAssured;
import net.javacrumbs.jsonunit.core.Option;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;

import static io.restassured.RestAssured.*;
import static net.javacrumbs.jsonunit.assertj.JsonAssertions.assertThatJson;

@SpringBootTest(classes = SampleApiApplication.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class UserSearchIntegrationTests {

    private static final String USER_BY_ID_PATH = "/api/v1/users/{id}";
    private static final String ID_PARAM = "id";

    private final ApiResponseMother apiResponseMother = new ApiResponseMother();

    @LocalServerPort
    private int port;

    @BeforeEach
    public void setUp() {
        RestAssured.port = port;
    }

    @Test
    public void getUsersById_success() {

        //Act & Assert
        var response =
                given()
                    .pathParam(ID_PARAM, 6)
                .when()
                    .get(USER_BY_ID_PATH)
                .then()
                    .assertThat().statusCode(HttpStatus.OK.value())
                .extract().asString();

        assertThatJson(response)
                .when(Option.IGNORING_ARRAY_ORDER)
                .isEqualTo(apiResponseMother.sampleUserSearchResponse());

    }
}
