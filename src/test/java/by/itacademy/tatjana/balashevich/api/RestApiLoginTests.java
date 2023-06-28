package by.itacademy.tatjana.balashevich.api;

import org.junit.jupiter.api.Test;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.not;


public class RestApiLoginTests {
    @Test
    public void validUserCanLoginTest() {
        String url = "https://api.y-r.by/api/v1/token";
        String body = "{\n" +
                "    \"email\": \"tbalashevich@bk.ru\",\n" +
                "    \"password\": \"PostinG@2579!\",\n" +
                "    \"remember\": true\n" +
                "}";
        given().body(body)
                .header("Content-Type", "application/json")
                .header("accept", "application/json").
                when().post(url).
                then().log().body().
                assertThat().statusCode(200).
                assertThat().body(containsString("token")).
                assertThat().body(not(containsString("message")));
    }

    @Test
    public void invalidUserSeesErrorWhenLoginTest() {
        String url = "https://api.y-r.by/api/v1/token";
        String body = "{\n" +
                "    \"email\": \"tbalashevichTEST@bk.ru\",\n" +
                "    \"password\": \"PostinG@2579TEST!\",\n" +
                "    \"remember\": true\n" +
                "}";
        given().body(body)
                .header("Content-Type", "application/json")
                .header("accept", "application/json").
                when().post(url).
                then().log().body().
                assertThat().statusCode(401).
                assertThat().body(containsString("message")).
                assertThat().body(not(containsString("token")));
    }
}
