package by.itacademy.tatjana.balashevich.api;

import org.junit.jupiter.api.Test;

import java.util.HashMap;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

public class RestApiLoginTests {

    @Test
    public void validUserCanLoginTest() {
        RestPageObject po = new RestPageObject();
        given().headers(po.getRequestHeaders())
                .queryParams(po.getQueryParams("tbalashevich@bk.ru", "PostinG@2579!", "true"))
                .when().post(po.endPoint)
                .then()
                .assertThat()
                .statusCode(200)
                .body(containsString("token"));
    }

    @Test
    public void loginByNotCreatedUserTest() {
        RestPageObject po = new RestPageObject();
        given().headers(po.getRequestHeaders()).queryParams(po.getQueryParams("test@test.com", "DDD42!test", "true"))
                .when().post(po.endPoint)
                .then()
                .assertThat()
                .statusCode(401)
                .body(containsString("message"))
                .body(not(containsString("token")))
                .body("message", equalTo("Проверьте корректность введенных данных"));
    }

    @Test
    public void loginByEmptyEmailAndPwdTest() {
        RestPageObject po = new RestPageObject();
        given().headers(po.getRequestHeaders()).queryParams(po.getQueryParams("", "", "true"))
                .when().post(po.endPoint)
                .then()
                .assertThat()
                .statusCode(422)
                .body("errors.password[0]", equalTo("Поле пароль обязательно для заполнения."))
                .body("errors.email[0]", equalTo("Поле электронная почта обязательно для заполнения."));
    }

    @Test
    public void loginByEmptyPwdTest() {
        RestPageObject po = new RestPageObject();
        given().headers(po.getRequestHeaders()).queryParams(po.getQueryParams("tbalashevich@bk.ru", "", "true"))
                .when().post(po.endPoint)
                .then()
                .assertThat()
                .statusCode(422)
                .body("errors.password[0]", equalTo("Поле пароль обязательно для заполнения."));
    }
}
