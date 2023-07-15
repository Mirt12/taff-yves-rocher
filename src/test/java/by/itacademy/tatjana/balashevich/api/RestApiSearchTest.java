package by.itacademy.tatjana.balashevich.api;

import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;


public class RestApiSearchTest {
    @Test
    public void hasSearchProductTitleKey() {
        String url = "https://api.y-r.by/api/v1/products?search=����";
        given().header("accept", "application/json").
                when().get(url).
                then().
                assertThat().statusCode(200).
                assertThat().body(containsString("title"));
    }

    @Test
    public void hasSearchProductCremeValue() {
        String url = "https://api.y-r.by/api/v1/products?search=����";
        given().header("accept", "application/json").
                when().get(url).
                then().
                assertThat().statusCode(200).
                assertThat().body("data[0].category", containsString("����"));
    }

    @Test
    public void isInvalidSearchHasEmptyArray() {
        //to save response
        Response response = given().header("accept", "application/json").
                when().get("https://api.y-r.by/api/v1/products?search=�������");
        //to save json body
        JsonPath jsonPath = response.jsonPath();
        int jsonSize = jsonPath.getInt("data.size()");
        Assertions.assertEquals(jsonSize, 0);
    }
}
