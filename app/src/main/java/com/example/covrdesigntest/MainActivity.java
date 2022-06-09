package com.example.covrdesigntest;

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

import android.widget.ImageView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    ImageView menu;
    ImageView closeDrawer;
    DrawerLayout drawerLayout;
    RecyclerView drawerItems;
    static ArrayList<String> drawerTitle = new ArrayList<>();
    static ArrayList<Integer> drawerIcon = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

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

        //define recycler view type for dashboard options
        RecyclerView recyclerView = findViewById(R.id.dash_list);
        recyclerView.setLayoutManager(
                new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL)
        );

        menu.setOnClickListener(view -> drawerLayout.openDrawer(GravityCompat.START));

        closeDrawer.setOnClickListener(view -> closeDrawer(drawerLayout));

        //create array for dashboard items
        List<DashItem> dashItems = new ArrayList<>();
        dashItems.add(new DashItem(
                R.drawable.ic_dash_bg1,
                R.drawable.dash_icon1,
                "Account\nOpening",
                (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 92, getResources().getDisplayMetrics()),
                (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 69, getResources().getDisplayMetrics())
            )
        );
        dashItems.add(new DashItem(
                R.drawable.ic_dash_bg2,
                R.drawable.dash_icon2,
                "Cash\nwithdrawal",
                (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 39, getResources().getDisplayMetrics()),
                (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 39, getResources().getDisplayMetrics())
            )
        );
        dashItems.add(new DashItem(
                R.drawable.ic_dash_bg4,
                R.drawable.dash_icon4,
                "Bills\nPayment",
                (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 92, getResources().getDisplayMetrics()),
                (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 69, getResources().getDisplayMetrics())
            )
        );
        dashItems.add(new DashItem(
                R.drawable.ic_dash_bg3,
                R.drawable.dash_icon3,
                "Funds\nTransfer",
                (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 50, getResources().getDisplayMetrics()),
                (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 38, getResources().getDisplayMetrics())
            )
        );
        dashItems.add(new DashItem(
                R.drawable.ic_dash_bg5,
                R.drawable.dash_icon5,
                "Airtime\ntop up",
                (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 57, getResources().getDisplayMetrics()),
                (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 57, getResources().getDisplayMetrics())
            )
        );
        dashItems.add(new DashItem(
                R.drawable.ic_dash_bg6,
                R.drawable.dash_icon6,
                "Cash\ndeposit",
                (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 58, getResources().getDisplayMetrics()),
                (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 58, getResources().getDisplayMetrics())
            )
        );

        recyclerView.setAdapter(new DashItemsAdapter(dashItems, (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 116, getResources().getDisplayMetrics())));
    }

    @Override
    protected void onPause() {
        super.onPause();
        MainActivity.closeDrawer(drawerLayout);
    }

    private static void closeDrawer(DrawerLayout drawerLayout) {
        if(drawerLayout.isDrawerOpen(GravityCompat.START)) {
            drawerLayout.closeDrawer(GravityCompat.START);
        }
    }
}