package com.example.quiz;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface questionsAPI {
    @GET("api.php?amount=10&difficulty=easy&type=multiple")
    Call<QuestionResponse> getQuestions();
}
