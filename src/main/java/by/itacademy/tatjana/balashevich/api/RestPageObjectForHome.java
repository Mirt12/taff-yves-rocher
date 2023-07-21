package by.itacademy.tatjana.balashevich.api;

import com.github.javafaker.Faker;

import java.util.HashMap;

public class RestPageObjectForHome {

    String endpointProducts = "https://api.y-r.by/api/v1/products";
    String endpointBasket = "https://api.y-r.by/api/v1/basket";

    public HashMap<String, String> getHeadersForTopProduct() {
        HashMap<String, String> headers = new HashMap<>();
        headers.put("accept", "application/json");
        return headers;
    }

    public HashMap<String, String> getHeadersForBasket() {
        Faker faker = new Faker();
        String letters = faker.internet().password();
        HashMap<String, String> headers = new HashMap<>();
        headers.put("accept", "application/json");
        headers.put("x-session", "d3a2ad058ce3077b6a7ccb01e2fc04dc16d3926" + letters);
        return headers;
    }

    public HashMap<String, Number> getQueryParamsFor1TopProduct() {
        HashMap<String, Number> queryParams = new HashMap<>();
        queryParams.put("filter[is_top_seller]", 1);
        queryParams.put("limit", 1);
        return queryParams;
    }

    public HashMap<String, Number> getQueryParamsFor20TopProducts() {
        HashMap<String, Number> queryParams = new HashMap<>();
        queryParams.put("filter[is_top_seller]", 1);
        queryParams.put("limit", 20);
        return queryParams;
    }

    public HashMap<String, Number> getQueryParamsForBasket() {
        HashMap<String, Number> queryParams = new HashMap<>();
        queryParams.put("product_id", 3626);
        queryParams.put("amount", 1);
        return queryParams;
    }
}
