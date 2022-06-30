package com.example.covrdesigntest.adapters;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;

import com.example.covrdesigntest.AllTransactionsActivity;
import com.example.covrdesigntest.EarningsActivity;
import com.example.covrdesigntest.MainActivity;
import com.example.covrdesigntest.R;

import java.util.ArrayList;

public class DrawerAdapter extends RecyclerView.Adapter<DrawerAdapter.viewHolder> {
    ArrayList<String> titles;
    ArrayList<Integer> icons;
    Activity activity;

    public DrawerAdapter(Activity activity, ArrayList<String> titles, ArrayList<Integer> icons) {
        this.titles = titles;
        this.icons = icons;
        this.activity = activity;
    }

    @NonNull
    @Override
    public viewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new viewHolder(
                LayoutInflater.from(parent.getContext()).inflate(
                        R.layout.drawer_item,
                        parent,
                        false
                )
        );
    }

    @Override
    public void onBindViewHolder(@NonNull viewHolder holder, int position) {
        holder.imageView.setImageResource(icons.get(position));
        holder.textView.setText(titles.get(position));

        holder.drawerItem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int position = holder.getAdapterPosition();

                switch (position) {
                    case 0:
                        activity.startActivity(new Intent(activity, MainActivity.class).setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK));
                        activity.finish();
                        break;
                    case 1:
                        activity.startActivity(new Intent(activity, AllTransactionsActivity.class).setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK));
                        activity.finish();
                        break;
                    case 2:
                        activity.startActivity(new Intent(activity, EarningsActivity.class).setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK));
                        activity.finish();
                        break;
                    case 3:
                        activity.startActivity(new Intent(activity, MainActivity.class).setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK));
                        activity.finish();
                        break;
                    case 4:
                        activity.startActivity(new Intent(activity, MainActivity.class).setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK));
                        activity.finish();
                        break;
                    case 5:
                        activity.startActivity(new Intent(activity, MainActivity.class).setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK));
                        activity.finish();
                        break;
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return titles.size();
    }

    public static class viewHolder extends RecyclerView.ViewHolder {
        ImageView imageView;
        TextView textView;
        LinearLayout drawerItem;

        public viewHolder(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.drawer_item_icon);
            textView = itemView.findViewById(R.id.drawer_item_text);
            drawerItem = itemView.findViewById(R.id.drawer_item);
        }
    }
}
