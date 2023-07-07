package by.itacademy.tatjana.balashevich.api;

import com.github.javafaker.Faker;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.jupiter.api.Test;
import org.testng.Assert;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.equalTo;

public class RestApiHomePageTest {

    @Test
    public void isTopProductHasIdKey() {
        String url = "https://api.y-r.by/api/v1/products?filter[is_top_seller]=1&limit=1";
        given().header("accept", "application/json").
                when().get(url).
                then().log().body().
                assertThat().
                statusCode(200).
                body(containsString("id"));
    }

    @Test
    public void isTopProductsHasTwentyItems() {
        Response response = given().header("accept", "application/json").
                when().get("https://api.y-r.by/api/v1/products?filter[is_top_seller]=1&limit=20");
        JsonPath jsonPath = response.jsonPath();
        int jsonSize = jsonPath.getInt("data.size()");
        Assert.assertEquals(jsonSize, 20);
    }

    @Test
    public void isProductInCart() {
        Faker faker = new Faker();
        String letters = faker.internet().password();
        String requestBody = "{\"product_id\":3626,\"amount\":1}";
        given().header("content-type", "application/json")
                .header("x-session", "d3a2ad058ce3077b6a7ccb01e2fc04dc16d3926" + faker)
                .body(requestBody).log().body().
                when().post("https://api.y-r.by/api/v1/basket").
                then().
                assertThat().
                statusCode(200).
                body("basket[0].product.id", equalTo(3626));
    }
}
