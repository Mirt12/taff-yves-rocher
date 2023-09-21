package by.itacademy.tatjana.balashevich.api;

import java.util.HashMap;

public class RestPageObjectForSearch {

    String endpoint = "https://api.y-r.by/api/v1/products";

    public HashMap<String, String> getHeaders() {
        HashMap<String, String> headers = new HashMap<>();
        headers.put("accept", "application/json");
        headers.put("Content-Type", "application/octet-stream; charset=UTF-8");
        return headers;
    }

    public HashMap<String, String> getQueryParams() {
        HashMap<String, String> queryParams = new HashMap<>();
        queryParams.put("search", "bb-krem-6-v-1");
        return queryParams;
    }

    public HashMap<String, String> getQueryParamsForInvalidSearch() {
        HashMap<String, String> queryParams = new HashMap<>();
        queryParams.put("search", "antares");
        return queryParams;
    }
}