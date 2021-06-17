package com.example.quiz;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class QuestionsActivity extends AppCompatActivity {

    private TextView tvQuestion;
    private TextView tvQuestionCount;
    private Button btnFirstAnswer;
    private Button btnSecondAnswer;
    private Button btnThirdAnswer;
    private Button btnFourthAnswer;
    private Call<QuestionResponse> apiCall;

    private List<Question> questionList;
    private int questionNumber = 0;
    private int correctAnswerCount = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_questions);

        tvQuestion = findViewById(R.id.tvQuestion);
        tvQuestionCount = findViewById(R.id.tvQuestionCount);
        btnFirstAnswer = findViewById(R.id.btnFirstAnswer);
        btnSecondAnswer = findViewById(R.id.btnSecondAnswer);
        btnThirdAnswer = findViewById(R.id.btnThirdAnswer);
        btnFourthAnswer = findViewById(R.id.btnFourthAnswer);

        apiCall = NetworkUtils.getApiInterface().getQuestions();

        questionList = new ArrayList<>();

        apiCall.enqueue(new Callback<QuestionResponse>() {
            @Override
            public void onResponse(Call<QuestionResponse> call, Response<QuestionResponse> response) {
                if(!response.isSuccessful()) {
                    Context context = getApplicationContext();
                    Toast.makeText(context, "HTTP error!", Toast.LENGTH_SHORT).show();
                    return;
                }
                QuestionResponse questionResponse = response.body();
                questionList = new ArrayList<>(Arrays.asList(questionResponse.getQuestions()));

                loadQuestion(questionNumber);
                tvQuestionCount.setText("Question: " + (questionNumber+1) + "/10");
                btnFirstAnswer.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if (btnFirstAnswer.getText().equals(questionList.get(questionNumber).getCorrect_answer())) {
                            correctAnswerCount++;
                            Context context = getApplicationContext();
                            Toast.makeText(context, "Correct!", Toast.LENGTH_SHORT).show();
                        } else {
                            String correctAnswer = checkAndFixString(questionList.get(questionNumber).getCorrect_answer());
                            Context context = getApplicationContext();
                            Toast.makeText(context, "Wrong! Correct answer is: " + correctAnswer + ".", Toast.LENGTH_SHORT).show();
                        }
                        new Handler().postDelayed(new Runnable() {
                            @Override
                            public void run() {
                                if(questionNumber < questionList.size()-1){
                                    questionNumber++;
                                    loadQuestion(questionNumber);
                                    tvQuestionCount.setText("Question: " + (questionNumber+1) + "/10");
                                }
                                else{
                                    Intent intent = new Intent(getApplicationContext(), EndActivity.class);
                                    intent.putExtra("correctAnswers", correctAnswerCount);
                                    startActivity(intent);
                                    finish();
                                }
                            }
                        }, 1500);
                    }
                });
                btnSecondAnswer.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if (btnSecondAnswer.getText().equals(questionList.get(questionNumber).getCorrect_answer())) {
                            correctAnswerCount++;
                            Context context = getApplicationContext();
                            Toast.makeText(context, "Correct!", Toast.LENGTH_SHORT).show();
                        } else {
                            String correctAnswer = checkAndFixString(questionList.get(questionNumber).getCorrect_answer());
                            Context context = getApplicationContext();
                            Toast.makeText(context, "Wrong! Correct answer is: " + correctAnswer + ".", Toast.LENGTH_SHORT).show();
                        }
                        new Handler().postDelayed(new Runnable() {
                            @Override
                            public void run() {
                                if(questionNumber < questionList.size()-1){
                                    questionNumber++;
                                    loadQuestion(questionNumber);
                                    tvQuestionCount.setText("Question: " + (questionNumber+1) + "/10");
                                }
                                else{
                                    Intent intent = new Intent(getApplicationContext(), EndActivity.class);
                                    intent.putExtra("correctAnswers", correctAnswerCount);
                                    startActivity(intent);
                                    finish();
                                }
                            }
                        }, 1500);
                    }
                });
                btnThirdAnswer.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if (btnThirdAnswer.getText().equals(questionList.get(questionNumber).getCorrect_answer())) {
                            correctAnswerCount++;
                            Context context = getApplicationContext();
                            Toast.makeText(context, "Correct!", Toast.LENGTH_SHORT).show();
                        } else {
                            String correctAnswer = checkAndFixString(questionList.get(questionNumber).getCorrect_answer());
                            Context context = getApplicationContext();
                            Toast.makeText(context, "Wrong! Correct answer is: " + correctAnswer + ".", Toast.LENGTH_SHORT).show();
                        }
                        new Handler().postDelayed(new Runnable() {
                            @Override
                            public void run() {
                                if(questionNumber < questionList.size()-1){
                                    questionNumber++;
                                    loadQuestion(questionNumber);
                                    tvQuestionCount.setText("Question: " + (questionNumber+1) + "/10");
                                }
                                else{
                                    Intent intent = new Intent(getApplicationContext(), EndActivity.class);
                                    intent.putExtra("correctAnswers", correctAnswerCount);
                                    startActivity(intent);
                                    finish();
                                }
                            }
                        }, 1500);
                    }
                });
                btnFourthAnswer.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if (btnFourthAnswer.getText().equals(questionList.get(questionNumber).getCorrect_answer())) {
                            correctAnswerCount++;
                            Context context = getApplicationContext();
                            Toast.makeText(context, "Correct!", Toast.LENGTH_SHORT).show();
                        } else {
                            String correctAnswer = checkAndFixString(questionList.get(questionNumber).getCorrect_answer());
                            Context context = getApplicationContext();
                            Toast.makeText(context, "Wrong! Correct answer is: " + correctAnswer + ".", Toast.LENGTH_SHORT).show();
                        }
                        new Handler().postDelayed(new Runnable() {
                            @Override
                            public void run() {
                                if(questionNumber < questionList.size()-1){
                                    questionNumber++;
                                    loadQuestion(questionNumber);
                                    tvQuestionCount.setText("Question: " + (questionNumber+1) + "/10");
                                }
                                else{
                                    Intent intent = new Intent(getApplicationContext(), EndActivity.class);
                                    intent.putExtra("correctAnswers", correctAnswerCount);
                                    startActivity(intent);
                                    finish();
                                }
                            }
                        }, 1500);
                    }
                });
            }

            @Override
            public void onFailure(Call<QuestionResponse> call, Throwable t) {
                Context context = getApplicationContext();
                Toast.makeText(context, "Something went wrong!", Toast.LENGTH_SHORT).show();
            }
        });
    }

    public void loadQuestion(int i){
        questionList.get(i).shuffle();
        String question = checkAndFixString(questionList.get(i).getQuestion());
        String answerOptionA = checkAndFixString(questionList.get(i).getAll_answers().get(0));
        String answerOptionB = checkAndFixString(questionList.get(i).getAll_answers().get(1));
        String answerOptionC = checkAndFixString(questionList.get(i).getAll_answers().get(2));
        String answerOptionD = checkAndFixString(questionList.get(i).getAll_answers().get(3));
        tvQuestion.setText(question);
        btnFirstAnswer.setText(answerOptionA);
        btnSecondAnswer.setText(answerOptionB);
        btnThirdAnswer.setText(answerOptionC);
        btnFourthAnswer.setText(answerOptionD);
    }

    public String checkAndFixString(String string){
        if(string.contains("&quot")){
            string = string.replace("&quot;", "\"");
        }
        if(string.contains("&#039;")){
            string = string.replace("&#039;", "\'");
        }
        if(string.contains("&amp;")){
            string = string.replace("&amp;", "&");
        }
        if(string.contains("&eacute;")){
            string = string.replace("&eacute;", "é");
        }
        if(string.contains("&hellip;")){
            string = string.replace("&hellip;", "...");
        }
        if(string.contains("&ldquo;")){
            string = string.replace("&ldquo;", "\"");
        }
        if(string.contains("&rdquo;")){
            string = string.replace("&rdquo;", "\"");
        }
        if(string.contains("&rsquo;")){
            string = string.replace("&rsquo;", "\'");
        }
        if(string.contains("&Uuml;")){
            string = string.replace("&Uuml;", "Ü");
        }
        return string;
    }
}

