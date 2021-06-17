package com.example.quiz;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class EndActivity extends AppCompatActivity {

    private TextView tvQuizFinished;
    private TextView tvQuizResults;
    private Button btnExitToMainMenu;
    private Button btnPlayAgain;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_end);

        tvQuizFinished = findViewById(R.id.tvQuizFinished);
        tvQuizResults = findViewById(R.id.tvQuizResults);
        btnExitToMainMenu = findViewById(R.id.btnExitToMainMenu);
        btnPlayAgain = findViewById(R.id.btnPlayAgain);

        int correctAnswerCount = getIntent().getIntExtra("correctAnswers", 0);

        tvQuizResults.setText("Your score is: " + correctAnswerCount + "/10");

        btnExitToMainMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(intent);
                finish();
            }
        });

        btnPlayAgain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), QuestionsActivity.class);
                startActivity(intent);
                finish();
            }
        });
    }
}