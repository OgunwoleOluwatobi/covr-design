package com.example.covrdesigntest.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;

import com.example.covrdesigntest.R;

public class OnboardingAdapter extends PagerAdapter {
    Context context;
    LayoutInflater layoutInflater;

    public OnboardingAdapter(Context context) {
        this.context = context;
    }

    private final int[] bgs = {
            R.drawable.onboarding_bg1,
            R.drawable.onboarding_bg2,
            R.drawable.onboarding_bg3
    };

    @Override
    public int getCount() {
        return bgs.length;
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view == object;
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = layoutInflater.inflate(R.layout.onboarding_item, null);

        ConstraintLayout background = view.findViewById(R.id.item_bg);

        background.setBackgroundResource(bgs[position]);

        ViewPager viewPager = (ViewPager) container;
        viewPager.addView(view, 0);

        return view;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        ViewPager viewPager = (ViewPager) container;
        View view = (View) object;
        viewPager.removeView(view);
    }
}
