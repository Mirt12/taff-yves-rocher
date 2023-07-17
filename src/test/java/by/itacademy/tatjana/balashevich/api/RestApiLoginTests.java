package by.itacademy.tatjana.balashevich.api;

import org.junit.jupiter.api.Test;

import java.util.HashMap;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

public class RestApiLoginTests {

    @Test
    public void validUserCanLoginTest() {
        RestPageObject po = new RestPageObject();
        given().headers(po.getRequestHeaders()).queryParams(po.getQueryParams())
                .when().post(po.endPoint)
                .then()
                .assertThat()
                .statusCode(200)
                .body(containsString("token"));
    }

    @Test
    public void loginByNotCreatedUserTest() {
        RestPageObject po = new RestPageObject();
        given().headers(po.getRequestHeaders()).queryParams(po.getQueryParamsForNotCreatedUser())
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
        given().headers(po.getRequestHeaders()).queryParams(po.getQueryParamsForEmptyLoginFields())
                .when().post(po.endPoint)
                .then()
                .assertThat()
                .statusCode(422)
                .body("errors.password[0]", equalTo("Поле пароль обязательно для заполнения."))
                .body("errors.email[0]", equalTo("Поле электронная почта обязательно для заполнения."));
    }

    @Test
    public void loginByEmptyPwdTest() {
        HashMap<String, String> queryParams = new HashMap<>();
        queryParams.put("email", "tbalashevich@bk.ru");
        queryParams.put("password", "");
        queryParams.put("remember", "true");
        HashMap<String, String> requestHeaders = new HashMap<>();
        requestHeaders.put("content-type", "application/json");
        requestHeaders.put("accept", "application/json");
        given().headers(requestHeaders).queryParams(queryParams).
                when().post("https://api.y-r.by/api/v1/token").
                then().assertThat().
                statusCode(422).
                body("errors.password[0]", equalTo("Поле пароль обязательно для заполнения."));
    }
}
