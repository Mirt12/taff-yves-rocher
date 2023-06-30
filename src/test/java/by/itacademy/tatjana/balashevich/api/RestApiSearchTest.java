package by.itacademy.tatjana.balashevich.api;

import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.not;

public class RestApiSearchTest {
    @Test
    public void validProductSearchTest() {
        String url = "https://api.y-r.by/api/v1/products?search=крем";
        given().header("accept", "application/json").
                when().get(url).
                then().log().body().
                assertThat().statusCode(200).
                assertThat().body(containsString("id")).
                assertThat().body(containsString("title")).
                assertThat().body(containsString("cost")).
                assertThat().body(containsString("cost_for_human")).
                assertThat().body(containsString("discount_cost")).
                assertThat().body(containsString("discount_cost_for_human")).
                assertThat().body(containsString("current_cost")).
                assertThat().body(containsString("current_cost_for_human")).
                assertThat().body(containsString("discount")).
                assertThat().body(containsString("images")).
                assertThat().body(containsString("code")).
                assertThat().body(containsString("shape")).
                assertThat().body(containsString("weight")).
                assertThat().body(containsString("type")).
                assertThat().body(containsString("basket")).
                assertThat().body(containsString("rating")).
                assertThat().body(containsString("description")).
                assertThat().body(containsString("category")).
                assertThat().body(not(containsString("message")));
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
    }
}
