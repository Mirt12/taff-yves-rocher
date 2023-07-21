package by.itacademy.tatjana.balashevich.api;

import java.util.HashMap;

public class RestPageObjectForSearch {

    String endpoint = "https://api.y-r.by/api/v1/products";

    public HashMap<String, String> getHeaders() {
        HashMap<String, String> headers = new HashMap<>();
        headers.put("accept", "application/json");
        return headers;
    }

    public HashMap<String, String> getQueryParams() {
        HashMap<String, String> queryParams = new HashMap<>();
        queryParams.put("search", "крем");
        return queryParams;
    }

    public HashMap<String, String> getQueryParamsForInvalidSearch() {
        HashMap<String, String> queryParams = new HashMap<>();
        queryParams.put("search", "антарес");
        return queryParams;
    }
}