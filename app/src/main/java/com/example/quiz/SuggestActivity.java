package com.example.quiz;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class SuggestActivity extends AppCompatActivity {

    private EditText etWriteAQuestion;
    private Button btnSend;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_suggest);

        etWriteAQuestion = findViewById(R.id.etWriteAQuestion);
        btnSend = findViewById(R.id.btnSend);

        btnSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sendEmail();
            }
        });
    }
    void sendEmail(){
        String question = etWriteAQuestion.getText().toString();
        if (question.length() < 10){
            Context context = getApplicationContext();
            Toast.makeText(context, "Your question is too small.", Toast.LENGTH_SHORT).show();
            return;
        }
        String[] emailTo = {"ivankovicpetar2@gmail.com"};
        String subject = "Question";
        Intent intent = new Intent(Intent.ACTION_SENDTO, Uri.parse("mailto:"));
        intent.putExtra(Intent.EXTRA_EMAIL, emailTo);
        intent.putExtra(Intent.EXTRA_SUBJECT, subject);
        intent.putExtra(Intent.EXTRA_TEXT, question);
        startActivity(Intent.createChooser(intent, "Choose an e-mail client"));
    }
}