package by.itacademy.tatjana.balashevich.api;

import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;

public class RestApiHomePageTest {
    @Test
    public void loadHomePageHtmlTest() {
        String url = "https://www.y-r.by";
        given().header("accept", "application/json").
                when().get(url).
                then().log().body().
                assertThat().statusCode(200);
    }

    @Test
    public void loadTopSellingProductsTest() {
        String url = "https://api.y-r.by/api/v1/products?filter[is_top_seller]=1&limit=20";
        given().header("accept", "application/json").
                when().get(url).
                then().log().body().
                assertThat().statusCode(200);
    }

}
