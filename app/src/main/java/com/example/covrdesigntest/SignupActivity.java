package com.example.covrdesigntest;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

public class SignupActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        LinearLayout usernameHolder = findViewById(R.id.username);
        LinearLayout usernameLabelHolder = usernameHolder.findViewById(R.id.labelHolder);
        EditText usernameField = usernameHolder.findViewById(R.id.textfield);

        LinearLayout passwordHolder = findViewById(R.id.password);
        LinearLayout passwordLabelHolder = passwordHolder.findViewById(R.id.labelHolder);
        EditText passwordField = passwordHolder.findViewById(R.id.textfield);

        carbon.widget.LinearLayout button = findViewById(R.id.button);
        TextView buttonText = button.findViewById(R.id.filled_text);

        usernameLabelHolder.setVisibility(View.GONE);
        passwordLabelHolder.setVisibility(View.GONE);

        usernameField.setHint("Username");
        passwordField.setHint("Temporary Password");

        buttonText.setText("Sign Up");
        button.setOnClickListener(view -> startActivity(new Intent(this, SetupSecurityQuestionActivity.class)));
    }
}