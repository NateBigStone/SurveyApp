package com.nathan.surveyapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

public class ResultsActivity extends AppCompatActivity {

    Button mReset;
    Button mContinue;

    TextView mQuestionOneCount;
    TextView mQuestionTwoCount;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_results);

        int questionOne = getIntent().getIntExtra(MainActivity.EXTRA_QUESTION_ONE, 0);

        mQuestionOneCount.findViewById(R.id.questionOneCountTest);
        //mQuestionOneCount.setText(Integer.toString(questionOne));

        mReset = findViewById(R.id.resetButton);
        mContinue = findViewById(R.id.continueButton);
    }
}
