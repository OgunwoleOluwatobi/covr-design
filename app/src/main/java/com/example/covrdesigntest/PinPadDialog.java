package com.example.covrdesigntest;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.chaos.view.PinView;
import com.google.android.material.bottomsheet.BottomSheetDialogFragment;

import java.text.DecimalFormat;
import java.util.concurrent.Executor;

public class PinPadDialog extends BottomSheetDialogFragment implements View.OnClickListener {
    private static final String TAG = PinPadDialog.class.getSimpleName();
    private PinView mTextAmount;
    private StringBuilder mAmountBuilder;
    private StringBuilder mAmount;
    private Button btn_0, btn_1, btn_2, btn_3, btn_4, btn_5, btn_6, btn_7, btn_8, btn_9, btn_back, btn_clear;
    private pinPadListener mListener;
    private Executor executor;
    private Context pContext;

    public interface pinPadListener {
        void onComplete(String pin);
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        pContext = context;

        try {
            mListener = (pinPadListener) context;
        } catch (ClassCastException e) {
            throw new ClassCastException(context.toString() + "must implement pinPadListener");
        }
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.pin_pad, container, false);

        mTextAmount = (PinView) v.findViewById(R.id.edit_amount);
        mAmountBuilder = new StringBuilder();
        btn_0 = (Button) v.findViewById(R.id.btn_0);
        btn_1 = (Button) v.findViewById(R.id.btn_1);
        btn_2 = (Button) v.findViewById(R.id.btn_2);
        btn_3 = (Button) v.findViewById(R.id.btn_3);
        btn_4 = (Button) v.findViewById(R.id.btn_4);
        btn_5 = (Button) v.findViewById(R.id.btn_5);
        btn_6 = (Button) v.findViewById(R.id.btn_6);
        btn_7 = (Button) v.findViewById(R.id.btn_7);
        btn_8 = (Button) v.findViewById(R.id.btn_8);
        btn_9 = (Button) v.findViewById(R.id.btn_9);
        btn_back = (Button) v.findViewById(R.id.btn_back);
        btn_clear = (Button) v.findViewById(R.id.btn_clear);

        btn_0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setText("0");
            }
        });

        btn_1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setText("1");
            }
        });

        btn_2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setText("2");
            }
        });

        btn_3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setText("3");
            }
        });

        btn_4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setText("4");
            }
        });

        btn_5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setText("5");
            }
        });

        btn_6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setText("6");
            }
        });

        btn_7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setText("7");
            }
        });

        btn_8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setText("8");
            }
        });

        btn_9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setText("9");
            }
        });

        btn_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (mAmountBuilder.length() > 0) {
                    mAmountBuilder.delete(mAmountBuilder.length() - 1, mAmountBuilder.length());
                }
            }
        });

        return v;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_0:
                setText("0");
                break;
            case R.id.btn_1:
                setText("1");
                break;
            case R.id.btn_2:
                setText("2");
                break;
            case R.id.btn_3:
                setText("3");
                break;
            case R.id.btn_4:
                setText("4");
                break;
            case R.id.btn_5:
                setText("5");
                break;
            case R.id.btn_6:
                setText("6");
                break;
            case R.id.btn_7:
                setText("7");
                break;
            case R.id.btn_8:
                setText("8");
                break;
            case R.id.btn_9:
                setText("9");
                break;
            case R.id.btn_back:
                if (mAmountBuilder.length() > 1) {
                    mAmountBuilder.delete(mAmountBuilder.length() - 1, mAmountBuilder.length());
                }
                setText(null);
                break;
            case R.id.btn_clear:
                mAmountBuilder.delete(1, mAmountBuilder.length());
                setText(null);
                break;
            default:
                break;
        }
    }

    private String printInAmountFormat(String number)
    {
        double amount = Double.parseDouble(number.substring(1));
        DecimalFormat formatter = new DecimalFormat("#,###.00");
        String fin = "";
        Log.i(TAG, "OLUBAYO LENGTH: " + formatter.format(amount).length());
        if(formatter.format(amount).length() < 4)
            fin = " 0" + formatter.format(amount);
        else
            fin = " " + formatter.format(amount);
        return fin;
    }

    private void setText(String charNum) {
        String temp = mAmountBuilder.toString();
        Log.i(TAG, "temp = "+temp);

        if (temp.length() > 3) {
            return;
        }


        if (charNum != null) {
            mAmountBuilder.append(charNum);
        }

        temp = mAmountBuilder.toString();
        Log.i(TAG, "temp = "+temp);

        if (temp.equals("0")) {
            mAmountBuilder.delete(1, 2);
        }
        mAmount = new StringBuilder(temp);
//        Log.i(TAG, "mAmount before = "+mAmount);
//        for (int i = 0 ; i < 4 - mAmountBuilder.length(); i++) {
//            mAmount.insert(1, "0");
//        }
        Log.i(TAG, "mAmount = "+mAmount);
//        mAmount.insert(mAmount.length()-2, ".");
        mTextAmount.setText(mAmount.toString());

        if(temp.length() == 4) {
            dismiss();
            mListener.onComplete(mAmount.toString());
        }
        //mTextAmount.setText(mAmount);

//        temp = temp.substring(1);
//        Log.i(TAG, "temp.isEmpty() = "+temp.isEmpty());
    }
}
