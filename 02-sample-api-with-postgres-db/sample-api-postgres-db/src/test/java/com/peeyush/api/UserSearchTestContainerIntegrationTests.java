package com.peeyush.api;

import com.github.javafaker.Faker;
import io.restassured.RestAssured;
import net.javacrumbs.jsonunit.core.Option;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;
import org.springframework.test.context.TestPropertySource;

import static io.restassured.RestAssured.given;
import static net.javacrumbs.jsonunit.assertj.JsonAssertions.assertThatJson;

@TestPropertySource(properties = "spring.datasource.url=jdbc:tc:postgresql:11.13-alpine:///sample-db")
@SpringBootTest(classes = SampleApiApplication.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class UserSearchTestContainerIntegrationTests {

    private static final String USER_BY_ID_PATH = "/api/v1/users/{id}";
    private static final String ID_PARAM = "id";

    private final ApiResponseMother apiResponseMother = new ApiResponseMother();
    private final Faker faker = new Faker();

    @LocalServerPort
    private int port;

    @BeforeEach
    public void setUp() {
        RestAssured.port = port;
    }

    @Test
    @Disabled
    public void getUsersById_NotFound() {
        //Arrange
        var userIdToSearch = faker.number().randomDigitNotZero();

        //Act & Assert
        var response =
                given()
                    .pathParam(ID_PARAM, userIdToSearch)
                .when()
                    .get(USER_BY_ID_PATH)
                .then()
                    .assertThat().statusCode(HttpStatus.NOT_FOUND.value())
                .extract().asString();

        assertThatJson(response)
                .when(Option.IGNORING_ARRAY_ORDER)
                .isEqualTo(apiResponseMother.userNotFound(userIdToSearch));

    }
}
