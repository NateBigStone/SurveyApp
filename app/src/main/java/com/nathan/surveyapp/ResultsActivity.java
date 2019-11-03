package com.nathan.surveyapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class ResultsActivity extends AppCompatActivity {

    private static final int MAIN_REQUEST_CODE = 1;

    Button mReset;
    Button mContinue;

    TextView mQuestionOneText;
    TextView mQuestionTwoText;

    TextView mQuestionOneCount;
    TextView mQuestionTwoCount;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_results);

        String questionOneText = getIntent().getStringExtra(MainActivity.EXTRA_QUESTION_ONE_TEXT);
        String questionTwoText = getIntent().getStringExtra(MainActivity.EXTRA_QUESTION_TWO_TEXT);
        int questionOne = getIntent().getIntExtra(MainActivity.EXTRA_QUESTION_ONE, 0);
        int questionTwo = getIntent().getIntExtra(MainActivity.EXTRA_QUESTION_TWO, 0);

        mQuestionOneText = findViewById(R.id.optionOne);
        mQuestionTwoText = findViewById(R.id.optionTwo);
        mQuestionOneCount = findViewById(R.id.questionOneCount);
        mQuestionTwoCount = findViewById(R.id.questionTwoCount);
        mQuestionOneText.setText(questionOneText + ": ");
        mQuestionTwoText.setText(questionTwoText + ": ");
        mQuestionOneCount.setText(Integer.toString(questionOne));
        mQuestionTwoCount.setText(Integer.toString(questionTwo));

        mReset = findViewById(R.id.resetButton);
        mContinue = findViewById(R.id.continueButton);

        mReset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent clearResultsIntent = new Intent(ResultsActivity.this, MainActivity.class);
                startActivityForResult(clearResultsIntent, MAIN_REQUEST_CODE);
            }
        });

        mContinue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               finish();
            }
        });
    }
}
