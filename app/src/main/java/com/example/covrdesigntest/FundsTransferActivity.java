package com.example.covrdesigntest;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import carbon.widget.LinearLayout;

public class FundsTransferActivity extends AppCompatActivity implements PinPadDialog.pinPadListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_funds_transfer);

        ImageView back = findViewById(R.id.back);
        back.setOnClickListener(view -> finish());

        LinearLayout cash = findViewById(R.id.cash);
        LinearLayout card = findViewById(R.id.card);

        cash.setOnClickListener(view -> startActivity(new Intent(this, CashTransfer.class)));
        card.setOnClickListener(view -> startActivity(new Intent(this, CardTransfer.class)));

//        new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                PinPadDialog pinPadDialog = new PinPadDialog();
//                pinPadDialog.show(getSupportFragmentManager(), "pinPad");
//            }
//        }
    }

    @Override
    public void onComplete(String pin) {

    }
}