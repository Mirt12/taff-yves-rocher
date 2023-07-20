package by.itacademy.tatjana.balashevich.api;

import java.util.HashMap;

public class RestPageObjectForSearch {

    String endpoint = "https://api.y-r.by/api/v1/products?search";

    public HashMap<String, String> getHeaders() {
        HashMap<String, String> headers = new HashMap<>();
        headers.put("accept", "application/json");
        return headers;
    }
}