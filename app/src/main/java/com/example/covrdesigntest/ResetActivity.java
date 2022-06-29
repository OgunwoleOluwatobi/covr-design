package com.example.covrdesigntest;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

public class ResetActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reset);

        ImageView back = findViewById(R.id.back);
        back.setOnClickListener(view -> finish());

        LinearLayout oldPasswordHolder = findViewById(R.id.oldPassword);
        EditText oldPasswordField = oldPasswordHolder.findViewById(R.id.textfield);
        LinearLayout oldPasswordLabelHolder = oldPasswordHolder.findViewById(R.id.labelHolder);
        TextView oldPasswordLabel = oldPasswordLabelHolder.findViewById(R.id.label);

        LinearLayout newPasswordHolder = findViewById(R.id.newPassword);
        EditText newPasswordField = newPasswordHolder.findViewById(R.id.textfield);
        LinearLayout newPasswordLabelHolder = newPasswordHolder.findViewById(R.id.labelHolder);
        TextView newPasswordLabel = newPasswordLabelHolder.findViewById(R.id.label);

        LinearLayout confirmPasswordHolder = findViewById(R.id.confirmPassword);
        EditText confirmPasswordField = confirmPasswordHolder.findViewById(R.id.textfield);
        LinearLayout confirmPasswordLabelHolder = confirmPasswordHolder.findViewById(R.id.labelHolder);
        TextView confirmPasswordLabel = confirmPasswordLabelHolder.findViewById(R.id.label);

        LinearLayout secAnswerHolder = findViewById(R.id.secAnswer);
        EditText secAnswerField = secAnswerHolder.findViewById(R.id.textfield);
        LinearLayout secAnswerLabelHolder = secAnswerHolder.findViewById(R.id.labelHolder);
        TextView secAnswerLabel = secAnswerLabelHolder.findViewById(R.id.label);

        carbon.widget.LinearLayout button = findViewById(R.id.button);
        TextView buttonText = button.findViewById(R.id.filled_text);

        oldPasswordLabel.setText("Password");
        oldPasswordField.setHint("Enter Password");

        newPasswordLabel.setText("Newly Preferred Password");
        newPasswordField.setHint("Enter New Password");

        confirmPasswordLabel.setText("Confirm New Password");
        confirmPasswordField.setHint("Confirm New Password");

        secAnswerLabel.setText("Security Answer");
        secAnswerField.setHint("Enter Security Answer");

        buttonText.setText("Confirm");
        button.setOnClickListener(view -> startActivity(new Intent(this, LoginActivity.class)));
    }
}