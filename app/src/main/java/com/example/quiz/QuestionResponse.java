package com.example.quiz;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class QuestionResponse {

    @SerializedName("results")
    @Expose
    private Question[] questions;

    public Question[] getQuestions() {
        return questions;
    }
}
