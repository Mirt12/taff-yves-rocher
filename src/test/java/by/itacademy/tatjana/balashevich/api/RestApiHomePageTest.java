package by.itacademy.tatjana.balashevich.api;

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
                .queryParams(po.getQueryParamsFor1TopProduct())
                .when().get(po.endpointProducts)
                .then()
                .statusCode(200)
                .body(containsString("id"));
    }

    @Test
    public void isTopProductsHasTwentyItemsTest() {
        RestPageObjectForHome po = new RestPageObjectForHome();
        Response response = given()
                 .headers(po.getHeadersForTopProduct())
                .queryParams(po.getQueryParamsFor20TopProducts())
                .when().get(po.endpointProducts);
        JsonPath jsonPath = response.jsonPath();
        int jsonSize = jsonPath.getInt("data.size()");
        Assertions.assertEquals(jsonSize, 20);
    }

    @Test
    public void isProductInCartTest() {
        RestPageObjectForHome po = new RestPageObjectForHome();
        given().headers(po.getHeadersForBasket())
                .queryParams(po.getQueryParamsForBasket())
                .when().post(po.endpointBasket)
                .then().log().body()
                .statusCode(200)
                .body("basket[0].product.id", equalTo(3626));
    }
}
