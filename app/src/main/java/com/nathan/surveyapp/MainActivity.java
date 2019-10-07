package com.nathan.surveyapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    public static final String EXTRA_QUESTION_ONE = "com.nathan.surveyapp.questionOne";

    private static final String TABS_INDEX = "tabs";
    private static final String SPACES_INDEX = "spaces";

    private static final int RESULTS_REQUEST_CODE = 0;

    Button mTabsButton;
    Button mSpacesButton;
    TextView mTabsCount;
    TextView mSpacesCount;
    Button mResultsButton;
    Button mResetButton;

    int mTabsValue = 0;
    int mSpacesValue = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mTabsButton = findViewById(R.id.tabsButton);
        mSpacesButton = findViewById(R.id.spacesButton);
        mTabsCount = findViewById(R.id.questionTwoCount);
        mSpacesCount = findViewById(R.id.questionOneCount);
        mResultsButton = findViewById(R.id.resultsButton);
        mResetButton = findViewById(R.id.resetButton);

        if (savedInstanceState != null) {
            mTabsValue = savedInstanceState.getInt(TABS_INDEX, 0);
            mSpacesValue = savedInstanceState.getInt(SPACES_INDEX, 0);

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
                showResultsIntent.putExtra(EXTRA_QUESTION_ONE, mTabsValue);
                startActivityForResult(showResultsIntent, RESULTS_REQUEST_CODE);
            }
        });

        mResetButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mTabsValue = 0;
                mSpacesValue = 0;
                mTabsCount.setText(Integer.toString(mTabsValue));
                mSpacesCount.setText(Integer.toString(mSpacesValue));
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
