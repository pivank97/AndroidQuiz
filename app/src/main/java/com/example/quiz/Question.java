package com.example.quiz;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public class Question {

    @SerializedName("question")
    @Expose
    private String question;

    @SerializedName("correct_answer")
    @Expose
    private String correct_answer;

    @SerializedName("incorrect_answers")
    @Expose
    private String[] incorrect_answers;

    private List<String> all_answers;

    public String getQuestion(){
        return question;
    }

    public String getCorrect_answer(){
        return correct_answer;
    }

    public String[] getIncorrect_answers(){
        return incorrect_answers;
    }

    public List<String> getAll_answers() { return all_answers; }

    public Question(String question, String correct_answer, String[] incorrect_answers) {
        this.question = question;
        this.correct_answer = correct_answer;
        this.incorrect_answers = incorrect_answers;
    }

    public void shuffle(){
        all_answers = new ArrayList<>();
        all_answers.add(getCorrect_answer());
        for(int i = 0; i<3; i++){
            all_answers.add((getIncorrect_answers()[i]));
        }
        Collections.shuffle(all_answers);
    }

}
