package com.example.test_wear;

import android.os.Bundle;
import android.widget.TextView;

import android.support.wearable.activity.WearableActivity;
import android.support.wearable.view.CircledImageView;
import android.support.wearable.view.WearableListView;

public class wear_start_skreen extends WearableActivity {

    private TextView mTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wear_start_skreen);

        mTextView = (TextView) findViewById(R.id.text);

        // Enables Always-on
        setAmbientEnabled();
    }
}
