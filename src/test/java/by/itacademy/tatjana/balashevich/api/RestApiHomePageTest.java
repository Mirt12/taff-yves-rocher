package by.itacademy.tatjana.balashevich.api;

import com.github.javafaker.Faker;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.equalTo;

public class RestApiHomePageTest {

    @Test
    public void isTopProductHasIdKeyTest() {
        RestPageObjectForHome po = new RestPageObjectForHome();
        given().headers(po.getHeadersForTopProduct())
                .when().get(po.endpoint + "/products?filter[is_top_seller]=1&limit=1")
                .then()
                .statusCode(200)
                .body(containsString("id"));
    }

    @Test
    public void isTopProductsHasTwentyItemsTest() {
        RestPageObjectForHome po = new RestPageObjectForHome();
        Response response = given().headers(po.getHeadersForTopProduct())
                .when().get(po.endpoint + "/products?filter[is_top_seller]=1&limit=20");
        JsonPath jsonPath = response.jsonPath();
        int jsonSize = jsonPath.getInt("data.size()");
        Assertions.assertEquals(jsonSize, 20);
    }

    @Test
    public void isProductInCartTest() {
      RestPageObjectForHome po = new RestPageObjectForHome();
        given().headers(po.getHeadersForBasket())
                .queryParams(po.getQueryParams())
                .when().post(po.endpoint + "/basket")
                .then()
                .statusCode(200)
                .body("basket[0].product.id", equalTo(3626));
  }
}
