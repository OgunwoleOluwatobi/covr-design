package com.example.covrdesigntest;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.content.Intent;
import android.os.Bundle;
import android.text.Html;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.Spanned;
import android.text.style.ForegroundColorSpan;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

public class ChangePasswordActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_change_password);

        ImageView back = findViewById(R.id.back);
        back.setOnClickListener(view -> finish());

        LinearLayout tempPasswordHolder = findViewById(R.id.tempPassword);
        EditText tempPasswordField = tempPasswordHolder.findViewById(R.id.textfield);
        LinearLayout tempPasswordLabelHolder = tempPasswordHolder.findViewById(R.id.labelHolder);
        TextView tempPasswordLabel = tempPasswordLabelHolder.findViewById(R.id.label);

        LinearLayout newPasswordHolder = findViewById(R.id.newPassword);
        EditText newPasswordField = newPasswordHolder.findViewById(R.id.textfield);
        LinearLayout newPasswordLabelHolder = newPasswordHolder.findViewById(R.id.labelHolder);
        TextView newPasswordLabel = newPasswordLabelHolder.findViewById(R.id.label);

        LinearLayout confirmPasswordHolder = findViewById(R.id.confirmPassword);
        EditText confirmPasswordField = confirmPasswordHolder.findViewById(R.id.textfield);
        LinearLayout confirmPasswordLabelHolder = confirmPasswordHolder.findViewById(R.id.labelHolder);
        TextView confirmPasswordLabel = confirmPasswordLabelHolder.findViewById(R.id.label);

        carbon.widget.LinearLayout button = findViewById(R.id.button);
        TextView buttonText = button.findViewById(R.id.filled_text);

        TextView info = findViewById(R.id.info);
        SpannableString s1 = new SpannableString("Password should be a minimum of ");
        SpannableString s2 = new SpannableString("8 characters");
        SpannableString s3 = new SpannableString(" with ");
        SpannableString s4 = new SpannableString("at least one capital letter");
        SpannableString s5 = new SpannableString(" and ");
        SpannableString s6 = new SpannableString("one special character");

        int flag = Spanned.SPAN_EXCLUSIVE_EXCLUSIVE;
        s1.setSpan(new ForegroundColorSpan(ContextCompat.getColor(this, R.color.text93)), 0, s1.length(), flag);
        s2.setSpan(new ForegroundColorSpan(ContextCompat.getColor(this, R.color.text1E)), 0, s2.length(), flag);
        s3.setSpan(new ForegroundColorSpan(ContextCompat.getColor(this, R.color.text93)), 0, s3.length(), flag);
        s4.setSpan(new ForegroundColorSpan(ContextCompat.getColor(this, R.color.text1E)), 0, s4.length(), flag);
        s5.setSpan(new ForegroundColorSpan(ContextCompat.getColor(this, R.color.text93)), 0, s5.length(), flag);
        s6.setSpan(new ForegroundColorSpan(ContextCompat.getColor(this, R.color.text1E)), 0, s6.length(), flag);

        SpannableStringBuilder builder = new SpannableStringBuilder();
        builder.append(s1);
        builder.append(s2);
        builder.append(s3);
        builder.append(s4);
        builder.append(s5);
        builder.append(s6);

        info.setText(builder);

        tempPasswordLabel.setText("Temporary Password");
        tempPasswordField.setHint("Enter Password");

        newPasswordLabel.setText("Newly Preferred Password");
        newPasswordField.setHint("Enter New Password");

        confirmPasswordLabel.setText("Confirm New Password");
        confirmPasswordField.setHint("Confirm New Password");

        buttonText.setText("Confirm");
        button.setOnClickListener(view -> startActivity(new Intent(this, WelcomeActivity.class)));
    }
}