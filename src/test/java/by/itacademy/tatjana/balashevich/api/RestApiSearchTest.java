package by.itacademy.tatjana.balashevich.api;

import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.containsString;

public class RestApiSearchTest {
    @Test
    public void validProductSearchTest() {
        String url = "https://api.y-r.by/api/v1/products?search=крем";
        given().header("accept", "application/json").
                when().get(url).
                then().log().body().
                assertThat().statusCode(200).
                assertThat().body(containsString("title"));
        //to check word 'creme' is in the 'title' key of json
        //to check that "data": [] is not empty
    }

    @Test
    public void invalidProductSearchTest() {
        String url = "https://api.y-r.by/api/v1/products?search=антарес";
        given().header("accept", "application/json").
                when().get(url).
                then().log().body().
                assertThat().statusCode(200).
                assertThat().body(containsString("data")).
                assertThat().body(containsString("links")).
                assertThat().body(containsString("meta")).
                assertThat().body(containsString("filter_bar")).
                assertThat().body(containsString("banners_layout")).
                assertThat().body(containsString("filter_options"));
        //to check that "data": [] is empty in json
    }
}
