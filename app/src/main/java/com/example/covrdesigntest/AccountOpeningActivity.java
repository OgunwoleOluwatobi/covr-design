package com.example.covrdesigntest;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;

public class AccountOpeningActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_account_opening);

        ImageView back = findViewById(R.id.back);
        back.setOnClickListener(view -> finish());
    }
}