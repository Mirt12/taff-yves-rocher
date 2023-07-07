package by.itacademy.tatjana.balashevich.api;

import org.junit.jupiter.api.Test;

import java.util.HashMap;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

public class RestApiLoginTests {

    @Test
    public void validUserCanLogin() {
        HashMap<String, String> queryParams = new HashMap<>();
        queryParams.put("email", "tbalashevich@bk.ru");
        queryParams.put("password", "PostinG@2579!");
        queryParams.put("remember", "true");
        HashMap<String, String> requestHeaders = new HashMap<>();
        requestHeaders.put("content-type", "application/json");
        requestHeaders.put("accept", "application/json");
        given().headers(requestHeaders).queryParams(queryParams).
                when().post("https://api.y-r.by/api/v1/token").
                then().
                assertThat().
                statusCode(200).
                body(containsString("token"));
    }

    @Test
    public void loginByNotCreatedUser() {
        String url = "https://api.y-r.by/api/v1/token";
        String body = "{\n" +
                "    \"email\": \"TEST@bk.ru\",\n" +
                "    \"password\": \"Ghtf4f@TEST!\",\n" +
                "    \"remember\": true\n" +
                "}";
        given().body(body)
                .header("content-Type", "application/json")
                .header("accept", "application/json").
                when().post(url).
                then().log().body().
                assertThat().
                statusCode(401).
                body(containsString("message")).
                body(not(containsString("token"))).
                body("message", equalTo("Проверьте корректность введенных данных"));
    }

    @Test
    public void loginByEmptyEmailAndPwd() {
        HashMap<String, String> queryParams = new HashMap<>();
        queryParams.put("email", "");
        queryParams.put("password", "");
        queryParams.put("remember", "true");
        HashMap<String, String> requestHeaders = new HashMap<>();
        requestHeaders.put("content-type", "application/json");
        requestHeaders.put("accept", "application/json");
        given().headers(requestHeaders).queryParams(queryParams).
                when().post("https://api.y-r.by/api/v1/token").
                then().
                assertThat().
                statusCode(422).
                body("errors.password[0]", equalTo("Поле пароль обязательно для заполнения.")).
                body("errors.email[0]", equalTo("Поле электронная почта обязательно для заполнения."));
    }

    @Test
    public void loginByEmptyPwd() {
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
