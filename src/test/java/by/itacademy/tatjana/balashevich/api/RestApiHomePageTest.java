package by.itacademy.tatjana.balashevich.api;

import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.jupiter.api.Test;
import org.testng.Assert;

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

    @Test
    public void isTopSellingProductsTwentyTest() {
        Response response = given().header("accept", "application/json").
                            when().get("https://api.y-r.by/api/v1/products?filter[is_top_seller]=1&limit=20");
        JsonPath jsonPath = response.jsonPath();
        int jsonSize = jsonPath.getInt("data.size()");
        Assert.assertEquals(jsonSize, 20);
    }
}
