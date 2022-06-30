package com.example.covrdesigntest;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

public class CashTransfer extends AppCompatActivity implements PinPadDialog.pinPadListener {

    Dialog dialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cash_transfer);

        ImageView back = findViewById(R.id.back);
        back.setOnClickListener(view -> finish());

        dialog = new Dialog(this, R.style.DialogTheme);
        dialog.setContentView(R.layout.transaction_summary);
        dialog.getWindow().setLayout(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);

        ImageView closeDialog = dialog.findViewById(R.id.cancel);
        closeDialog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialog.dismiss();
            }
        });

        carbon.widget.LinearLayout dialogButton = dialog.findViewById(R.id.button);
        TextView dialogButtonText = dialogButton.findViewById(R.id.filled_text);
        dialogButton.setBackgroundColor(getResources().getColor(R.color.white));
        dialogButtonText.setText("Confirm");
        dialogButtonText.setTextColor(getResources().getColor(R.color.primary));
        dialogButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialog.dismiss();
                PinPadDialog pinPadDialog = new PinPadDialog();
                pinPadDialog.show(getSupportFragmentManager(), "pinPad");
            }
        });

        carbon.widget.LinearLayout button = findViewById(R.id.button);
        TextView buttonText = button.findViewById(R.id.filled_text);

        buttonText.setText("Transfer");
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialog.show();
            }
        });
    }

    @Override
    public void onComplete(String pin) {

    }
}