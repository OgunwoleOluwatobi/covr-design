package com.example.covrdesigntest;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

public class SetupSecurityQuestionActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setup_security_question);

        ImageView back = findViewById(R.id.back);
        back.setOnClickListener(view -> finish());

        LinearLayout questionHolder = findViewById(R.id.question);
        EditText questionField = questionHolder.findViewById(R.id.textfield);
        LinearLayout questionLabelHolder = questionHolder.findViewById(R.id.labelHolder);
        TextView questionLabel = questionLabelHolder.findViewById(R.id.label);

        LinearLayout answerHolder = findViewById(R.id.answer);
        EditText answerField = answerHolder.findViewById(R.id.textfield);
        LinearLayout answerLabelHolder = answerHolder.findViewById(R.id.labelHolder);
        TextView answerLabel = answerLabelHolder.findViewById(R.id.label);

        carbon.widget.LinearLayout button = findViewById(R.id.button);
        TextView buttonText = button.findViewById(R.id.filled_text);

        questionLabel.setText("Security Question");
        questionField.setHint("Select Question");

        answerLabel.setText("Security Answer");
        answerField.setHint("Enter Security Answer");

        buttonText.setText("Save and Proceed");
        button.setOnClickListener(view -> startActivity(new Intent(this, ChangePasswordActivity.class)));
    }
}