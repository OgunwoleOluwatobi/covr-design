package com.example.covrdesigntest;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class SetPinActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_set_pin);

        ImageView back = findViewById(R.id.back);
        back.setOnClickListener(view -> finish());

        carbon.widget.LinearLayout button = findViewById(R.id.button);
        TextView buttonText = button.findViewById(R.id.filled_text);

        buttonText.setText("Confirm");
        buttonText.setTextColor(ContextCompat.getColor(this, R.color.primary));
        button.setBackgroundColor(ContextCompat.getColor(this, R.color.white));
        button.setOnClickListener(view -> startActivity(new Intent(this, MainActivity.class)));
    }
}