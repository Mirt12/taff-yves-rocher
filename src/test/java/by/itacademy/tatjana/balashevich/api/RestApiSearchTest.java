package by.itacademy.tatjana.balashevich.api;

import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;


public class RestApiSearchTest {

    @Test
    public void hasSearchProductTitleKeyTest() {
        RestPageObjectForSearch po = new RestPageObjectForSearch();
        given().headers(po.getHeaders())
                .when().get(po.endpoint + "=крем")
                .then()
                .statusCode(200)
                .assertThat().body(containsString("title"));
    }

    @Test
    public void hasSearchProductCremeValueTest() {
        RestPageObjectForSearch po = new RestPageObjectForSearch();
        given().headers(po.getHeaders())
                .when().get(po.endpoint + "=крем")
                .then()
                .statusCode(200)
                .assertThat().body("data[0].title", containsString("Крем"));
    }

    @Test
    public void isInvalidSearchHasEmptyArrayTest() {
        RestPageObjectForSearch po = new RestPageObjectForSearch();
        Response response = given().headers(po.getHeaders()).
                when().get(po.endpoint + "=антарес");
        JsonPath jsonPath = response.jsonPath();
        int jsonSize = jsonPath.getInt("data.size()");
        Assertions.assertEquals(jsonSize, 0);
    }
}