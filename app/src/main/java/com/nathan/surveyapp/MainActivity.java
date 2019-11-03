package com.nathan.surveyapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    public static final String EXTRA_QUESTION_ONE_TEXT = "com.nathan.surveyapp.questionOneText";
    public static final String EXTRA_QUESTION_TWO_TEXT = "com.nathan.surveyapp.questionTwoText";
    public static final String EXTRA_QUESTION_ONE = "com.nathan.surveyapp.questionOne";
    public static final String EXTRA_QUESTION_TWO = "com.nathan.surveyapp.questionTwo";

    private static final String TABS_INDEX = "questionOne";
    private static final String SPACES_INDEX = "questionTwo";

    private static final int RESULTS_REQUEST_CODE = 0;
    private static final int CONFIGURE_REQUEST_CODE = 1;

    Button mTabsButton;
    Button mSpacesButton;
    TextView mQuestion;
    TextView mTabsCount;
    TextView mSpacesCount;
    Button mResultsButton;
    Button mConfigureButton;

    String question = "";
    String questionOneText = "";
    String questionTwoText = "";
    int mTabsValue = 0;
    int mSpacesValue = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mTabsButton = findViewById(R.id.tabsButton);
        mSpacesButton = findViewById(R.id.spacesButton);
        mQuestion = findViewById(R.id.questionText);
        mTabsCount = findViewById(R.id.questionTwoCount);
        mSpacesCount = findViewById(R.id.questionOneCount);
        mResultsButton = findViewById(R.id.resultsButton);
        mConfigureButton = findViewById(R.id.configureButton);

        if (savedInstanceState != null) {
            mTabsValue = savedInstanceState.getInt(TABS_INDEX, 0);
            mSpacesValue = savedInstanceState.getInt(SPACES_INDEX, 0);
        }

        if (this.getIntent().getExtras() != null) {

            Log.d("MAIN_ACTIVITY", "there is an intent: " + this.getIntent().getExtras());

            question = getIntent().getStringExtra(ConfigureActivity.EXTRA_QUESTION_QUESTION);
            questionOneText = getIntent().getStringExtra(ConfigureActivity.EXTRA_QUESTION_ONE_TEXT);
            questionTwoText = getIntent().getStringExtra(ConfigureActivity.EXTRA_QUESTION_TWO_TEXT);

            mQuestion.setText(question);
            mTabsButton.setText(questionOneText);
            mSpacesButton.setText(questionTwoText);
        }

        mTabsCount.setText(Integer.toString(mTabsValue));
        mSpacesCount.setText(Integer.toString(mSpacesValue));

        mTabsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mTabsValue += 1;
                mTabsCount.setText(Integer.toString(mTabsValue));
            }
        });
        mSpacesButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mSpacesValue += 1;
                mSpacesCount.setText(Integer.toString(mSpacesValue));
            }
        });

        mResultsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent showResultsIntent = new Intent(MainActivity.this, ResultsActivity.class);

                showResultsIntent.putExtra(EXTRA_QUESTION_ONE_TEXT, questionOneText);
                showResultsIntent.putExtra(EXTRA_QUESTION_TWO_TEXT, questionTwoText);
                showResultsIntent.putExtra(EXTRA_QUESTION_ONE, mTabsValue);
                showResultsIntent.putExtra(EXTRA_QUESTION_TWO, mSpacesValue);
                startActivityForResult(showResultsIntent, RESULTS_REQUEST_CODE);
            }
        });

        mConfigureButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent showConfigureIntent = new Intent(MainActivity.this, ConfigureActivity.class);
                startActivityForResult(showConfigureIntent, CONFIGURE_REQUEST_CODE);
            }
        });
    }

    //Retains data after being rotated
    @Override
    public void onSaveInstanceState(Bundle savedInstanceState){
        super.onSaveInstanceState(savedInstanceState);
        savedInstanceState.putInt(TABS_INDEX, mTabsValue);
        savedInstanceState.putInt(SPACES_INDEX, mSpacesValue);
    }
}
