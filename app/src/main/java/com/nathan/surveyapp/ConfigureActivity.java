package com.nathan.surveyapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class ConfigureActivity extends AppCompatActivity {

    private static final int CONFIGURE_REQUEST_CODE = 3;

    public static final String EXTRA_QUESTION_QUESTION = "com.nathan.surveyapp.questionQuestion";
    public static final String EXTRA_QUESTION_ONE_TEXT = "com.nathan.surveyapp.questionOneText";
    public static final String EXTRA_QUESTION_TWO_TEXT = "com.nathan.surveyapp.questionTwoText";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_configure);

        Button addQuestion = findViewById(R.id.add_question_button);
        final EditText questionText = findViewById(R.id.new_question);
        final EditText yesText = findViewById(R.id.yes_answer);
        final EditText noText = findViewById(R.id.no_answer);
        addQuestion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String newQuestion = questionText.getText().toString() +"?";
                String mYesText = yesText.getText().toString();
                String mNoText = noText.getText().toString();

                if (newQuestion.isEmpty() || mYesText.isEmpty() || mNoText.isEmpty()) {
                    Toast.makeText(ConfigureActivity.this, "Please enter some text", Toast.LENGTH_LONG).show();
                    return;
                }

                Intent returnToMainIntent = new Intent(ConfigureActivity.this, MainActivity.class);
                returnToMainIntent.putExtra(EXTRA_QUESTION_QUESTION, newQuestion);
                returnToMainIntent.putExtra(EXTRA_QUESTION_ONE_TEXT, mYesText);
                returnToMainIntent.putExtra(EXTRA_QUESTION_TWO_TEXT, mNoText);

                questionText.getText().clear();
                yesText.getText().clear();
                noText.getText().clear();

                startActivityForResult(returnToMainIntent, CONFIGURE_REQUEST_CODE);
            }
        });
    }
}
