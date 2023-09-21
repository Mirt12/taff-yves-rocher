package by.itacademy.tatjana.balashevich.api;

import groovy.json.JsonOutput;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

public class RestApiLoginTests {

    @Test
    public void validUserCanLoginTest() {
        RestPageObjectForLogin po = new RestPageObjectForLogin();
        given().headers(po.getRequestHeaders())
                .queryParams(po.getQueryParams("tbalashevich@bk.ru", "PostinG@2579!", "true"))
                .when().post(po.endpointToken)
                .then()
                .assertThat()
                .statusCode(200)
                .body(containsString("token"));
    }

    @Test
    public void loginByNotCreatedUserTest() {
        RestPageObjectForLogin po = new RestPageObjectForLogin();
        given().headers(po.getRequestHeaders())
                .queryParams(po.getQueryParams("test@test.com", "DDD42!test", "true"))
                .when().post(po.endpointToken)
                .then()
                .assertThat()
                .statusCode(401)
                .body(containsString("message"))
                .body(not(containsString("token")))
                .body("message", equalTo("Проверьте корректность введенных данных"));
    }

    @Test
    public void loginByEmptyEmailAndPwdTest() {
        RestPageObjectForLogin po = new RestPageObjectForLogin();
        given().headers(po.getRequestHeaders())
                .queryParams(po.getQueryParams("", "", "true"))
                .when().post(po.endpointToken)
                .then()
                .assertThat()
                .statusCode(422)
                .body("errors.password[0]", equalTo("Поле пароль обязательно для заполнения."))
                .body("errors.email[0]", equalTo("Поле электронная почта обязательно для заполнения."));
    }

    @Test
    public void loginByEmptyPwdTest() {
        RestPageObjectForLogin po = new RestPageObjectForLogin();
        given().headers(po.getRequestHeaders())
                .queryParams(po.getQueryParams("tbalashevich@bk.ru", "", "true"))
                .when().post(po.endpointToken)
                .then()
                .assertThat()
                .statusCode(422)
                .body("errors.password[0]", equalTo("Поле пароль обязательно для заполнения."));
    }
}
