package by.itacademy.tatjana.balashevich.api;

import java.util.HashMap;

public class RestPageObject {
    String endPoint = "https://api.y-r.by/api/v1/token";

    public HashMap<String, String> getRequestHeaders() {
        HashMap<String, String> headers = new HashMap<>();
        headers.put("content-type", "application/json");
        headers.put("accept", "application/json");
        return headers;
    }

    public HashMap<String, String> getQueryParams() {
        HashMap<String, String> queryParams = new HashMap<>();
        queryParams.put("email", "tbalashevich@bk.ru");
        queryParams.put("password", "PostinG@2579!");
        queryParams.put("remember", "true");
        return queryParams;
    }

    public HashMap<String, String> getQueryParamsForNotCreatedUser() {
        HashMap<String, String> queryParams = new HashMap<>();
        queryParams.put("email", "test@test.com");
        queryParams.put("password", "DDD42!test");
        queryParams.put("remember", "true");
        return queryParams;
    }




}
