package com.example.quiz;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class NetworkUtils {
    private static final String BASE_API = "https://opentdb.com/";
    private static questionsAPI apiInterface;
    public static questionsAPI getApiInterface() {
        if (apiInterface == null) {
            Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl(BASE_API)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
            apiInterface = retrofit.create(questionsAPI.class);
        }
        return apiInterface;
    }
}
