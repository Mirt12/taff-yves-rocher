package by.itacademy.tatjana.balashevich.api;

import java.util.HashMap;

public class RestPageObjectForLogin {
    String endPoint = "https://api.y-r.by/api/v1/token";

    public HashMap<String, String> getRequestHeaders() {
        HashMap<String, String> headers = new HashMap<>();
        headers.put("content-type", "application/json");
        headers.put("accept", "application/json");
        return headers;
    }

    public HashMap<String, String> getQueryParams(String email, String password, String isRemember) {
        HashMap<String, String> queryParams = new HashMap<>();
        queryParams.put("email", email);
        queryParams.put("password", password);
        queryParams.put("remember", isRemember);
        return queryParams;
    }
}
