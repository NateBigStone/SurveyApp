package com.nathan.surveyapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

public class ResultsActivity extends AppCompatActivity {

    Button mReset;
    Button mContinue;

    TextView mQuestionOneCount;
    //TextView mQuestionTwoCount;

    //int question_one = getIntent().getIntExtra(MainActivity.EXTRA_QUESTION_ONE, 0);
    // TODO: figure out why this breaks stuff

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_results);

        //mQuestionOneCount.findViewById(R.id.questionOneCount);

        //mQuestionOneCount.setText(Integer.toString(question_one));

        mReset = findViewById(R.id.resetButton);
        mContinue = findViewById(R.id.continueButton);
    }
}
