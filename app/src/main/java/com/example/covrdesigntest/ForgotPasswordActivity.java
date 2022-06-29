package com.example.covrdesigntest;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

public class ForgotPasswordActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forgot_password);

        ImageView back = findViewById(R.id.back);
        back.setOnClickListener(view -> finish());

        LinearLayout usernameHolder = findViewById(R.id.username);
        LinearLayout usernameLabelHolder = usernameHolder.findViewById(R.id.labelHolder);
        EditText usernameField = usernameHolder.findViewById(R.id.textfield);

        carbon.widget.LinearLayout button = findViewById(R.id.button);
        TextView buttonText = button.findViewById(R.id.filled_text);

        usernameLabelHolder.setVisibility(View.GONE);

        usernameField.setHint("Email/Username");

        buttonText.setText("Reset Password");
        button.setOnClickListener(view -> startActivity(new Intent(this, ResetActivity.class)));
    }
}