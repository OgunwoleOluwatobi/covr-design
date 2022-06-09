package com.example.covrdesigntest;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.util.TypedValue;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.TextView;

import com.example.covrdesigntest.adapters.OnboardingAdapter;

import java.util.ArrayList;

import carbon.widget.LinearLayout;

public class OnboardingActivity extends AppCompatActivity {

    private ViewPager viewPager;
    LinearLayout dot1;
    LinearLayout dot2;
    LinearLayout dot3;
    TextView shortText;
    TextView mainText;
    TextView borderButtonText;
    TextView filledButtonText;
    LinearLayout signup;
    LinearLayout login;
    LinearLayout next;
    android.widget.LinearLayout buttonHolder;

    Animation animation;
    Animation onboardingIndicatorAnimation;

    private OnboardingAdapter onboardingAdapter;

    private final String[] shortTexts = {
            "All In One",
            "Swift",
            "For Everyone"
    };
    private final String[] mainTexts = {
            "Your one stop application for financial services",
            "Complete your transactions in Minutes",
            "Welcome to the world of branchless banking"
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_onboarding);

        viewPager = findViewById(R.id.page_view);
        dot1 = findViewById(R.id.dot1);
        dot2 = findViewById(R.id.dot2);
        dot3 = findViewById(R.id.dot3);
        shortText = findViewById(R.id.short_text);
        mainText = findViewById(R.id.main_text);
        borderButtonText = findViewById(R.id.border_text);
        filledButtonText = findViewById(R.id.filled_text);
        next = findViewById(R.id.next);
        buttonHolder = findViewById(R.id.button_holder);
        signup = findViewById(R.id.signup);
        login = findViewById(R.id.login);

        animation = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.fade_in);
        onboardingIndicatorAnimation = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.onboarding_indicator_anim);


        onboardingAdapter = new OnboardingAdapter(this);

        viewPager.setAdapter(onboardingAdapter);
        viewPager.addOnPageChangeListener(pageChangeListener);

        next.setOnClickListener(view -> viewPager.setCurrentItem(viewPager.getCurrentItem()+1, true));
        signup.setOnClickListener(view -> startActivity(new Intent(this, MainActivity.class)));
        login.setOnClickListener(view -> startActivity(new Intent(this, MainActivity.class)));

    }

    ViewPager.SimpleOnPageChangeListener pageChangeListener = new ViewPager.SimpleOnPageChangeListener() {

        @Override
        public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
            super.onPageScrolled(position, positionOffset, positionOffsetPixels);
        }

        @Override
        public void onPageSelected(int position) {
            shortText.setText(shortTexts[position]);
            mainText.setText(mainTexts[position]);

            if(position == 0) {
                /*-------Status Color Code To Change--------*/
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                    Window window = OnboardingActivity.this.getWindow();
                    window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
                    window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
                    window.setStatusBarColor(OnboardingActivity.this.getResources().getColor(R.color.primary));
                }

                dot1.setBackgroundColor(ContextCompat.getColor(OnboardingActivity.this, R.color.primary));
                dot2.setBackgroundColor(ContextCompat.getColor(OnboardingActivity.this, R.color.onboardingIndicatorInactive));
                dot3.setBackgroundColor(ContextCompat.getColor(OnboardingActivity.this, R.color.onboardingIndicatorInactive));

                dot1.setElevation(TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 10, getResources().getDisplayMetrics()));
                dot2.setElevation(0);
                dot3.setElevation(0);

                dot1.startAnimation(onboardingIndicatorAnimation);

                dot1.getLayoutParams().width = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 76, getResources().getDisplayMetrics());
                dot1.requestLayout();
                dot2.getLayoutParams().width = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 9, getResources().getDisplayMetrics());
                dot2.requestLayout();
                dot3.getLayoutParams().width = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 9, getResources().getDisplayMetrics());
                dot3.requestLayout();

                next.setVisibility(View.VISIBLE);
                buttonHolder.setVisibility(View.GONE);
            }
            if(position == 1) {
                /*-------Status Color Code To Change--------*/
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                    Window window = OnboardingActivity.this.getWindow();
                    window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
                    window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
                    window.setStatusBarColor(OnboardingActivity.this.getResources().getColor(R.color.onboarding2));
                }

                dot2.setBackgroundColor(ContextCompat.getColor(OnboardingActivity.this, R.color.primary));
                dot1.setBackgroundColor(ContextCompat.getColor(OnboardingActivity.this, R.color.onboardingIndicatorInactive));
                dot3.setBackgroundColor(ContextCompat.getColor(OnboardingActivity.this, R.color.onboardingIndicatorInactive));

                dot2.setElevation(TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 10, getResources().getDisplayMetrics()));
                dot1.setElevation(0);
                dot3.setElevation(0);

                dot2.startAnimation(onboardingIndicatorAnimation);

                dot2.getLayoutParams().width = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 76, getResources().getDisplayMetrics());
                dot2.requestLayout();
                dot1.getLayoutParams().width = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 9, getResources().getDisplayMetrics());
                dot1.requestLayout();
                dot3.getLayoutParams().width = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 9, getResources().getDisplayMetrics());
                dot3.requestLayout();

                next.setVisibility(View.VISIBLE);
                buttonHolder.setVisibility(View.GONE);
            }

            if(position == 2) {
                /*-------Status Color Code To Change--------*/
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                    Window window = OnboardingActivity.this.getWindow();
                    window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
                    window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
                    window.setStatusBarColor(OnboardingActivity.this.getResources().getColor(R.color.onboarding3));
                }

                dot3.setBackgroundColor(ContextCompat.getColor(OnboardingActivity.this, R.color.primary));
                dot1.setBackgroundColor(ContextCompat.getColor(OnboardingActivity.this, R.color.onboardingIndicatorInactive));
                dot2.setBackgroundColor(ContextCompat.getColor(OnboardingActivity.this, R.color.onboardingIndicatorInactive));

                dot3.setElevation(TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 10, getResources().getDisplayMetrics()));
                dot1.setElevation(0);
                dot2.setElevation(0);

                dot3.startAnimation(onboardingIndicatorAnimation);

                dot3.getLayoutParams().width = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 76, getResources().getDisplayMetrics());
                dot3.requestLayout();
                dot1.getLayoutParams().width = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 9, getResources().getDisplayMetrics());
                dot1.requestLayout();
                dot2.getLayoutParams().width = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 9, getResources().getDisplayMetrics());
                dot2.requestLayout();
                next.setVisibility(View.GONE);
                buttonHolder.setVisibility(View.VISIBLE);
                borderButtonText.setText("Sign up");
                filledButtonText.setText("Login");
            }
        }

        @Override
        public void onPageScrollStateChanged(int state) {
            super.onPageScrollStateChanged(state);
        }
    };

}