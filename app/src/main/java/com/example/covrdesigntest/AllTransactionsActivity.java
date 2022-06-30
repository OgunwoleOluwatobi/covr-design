package com.example.covrdesigntest;

import android.os.Build;
import android.os.Bundle;

import com.example.covrdesigntest.adapters.DashItemsAdapter;
import com.example.covrdesigntest.adapters.DrawerAdapter;
import com.example.covrdesigntest.models.DashItem;

import androidx.appcompat.app.AppCompatActivity;

import android.util.TypedValue;

import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;

import java.util.ArrayList;
import java.util.List;

public class AllTransactionsActivity extends AppCompatActivity {
    ImageView menu;
    ImageView closeDrawer;
    DrawerLayout drawerLayout;
    RecyclerView drawerItems;
    static ArrayList<String> drawerTitle = new ArrayList<>();
    static ArrayList<Integer> drawerIcon = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_all_transactions);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            Window window = AllTransactionsActivity.this.getWindow();
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
            window.setStatusBarColor(AllTransactionsActivity.this.getResources().getColor(R.color.green));
        }

        menu = findViewById(R.id.menu);
        closeDrawer = findViewById(R.id.close_drawer);
        drawerLayout = findViewById(R.id.drawer_layout);
        drawerItems = findViewById(R.id.drawer_items);
        drawerItems.setLayoutManager(new LinearLayoutManager(this));

        //Set List for drawer items and icons
        drawerTitle.clear();
        drawerTitle.add("Dashboard");
        drawerTitle.add("All Transactions");
        drawerTitle.add("Earnings");
        drawerTitle.add("Statements");
        drawerTitle.add("Account History");
        drawerTitle.add("Account Settings");

        drawerIcon.clear();
        drawerIcon.add(R.drawable.ic_dashboard);
        drawerIcon.add(R.drawable.ic___user);
        drawerIcon.add(R.drawable.ic_work);
        drawerIcon.add(R.drawable.ic_statement);
        drawerIcon.add(R.drawable.ic_calendar);
        drawerIcon.add(R.drawable.ic_lock);

        drawerItems.setAdapter(new DrawerAdapter(this, drawerTitle, drawerIcon));

        menu.setOnClickListener(view -> drawerLayout.openDrawer(GravityCompat.START));

        closeDrawer.setOnClickListener(view -> closeDrawer(drawerLayout));
    }

    @Override
    protected void onPause() {
        super.onPause();
        AllTransactionsActivity.closeDrawer(drawerLayout);
    }

    private static void closeDrawer(DrawerLayout drawerLayout) {
        if(drawerLayout.isDrawerOpen(GravityCompat.START)) {
            drawerLayout.closeDrawer(GravityCompat.START);
        }
    }
}