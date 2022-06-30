package com.example.covrdesigntest.adapters;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.util.DisplayMetrics;
import android.util.Log;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import com.example.covrdesigntest.AccountOpeningActivity;
import com.example.covrdesigntest.AllTransactionsActivity;
import com.example.covrdesigntest.BillsPaymentActivity;
import com.example.covrdesigntest.EarningsActivity;
import com.example.covrdesigntest.FundsTransferActivity;
import com.example.covrdesigntest.MainActivity;
import com.example.covrdesigntest.R;
import com.example.covrdesigntest.models.DashItem;

import java.util.List;

public class DashItemsAdapter extends RecyclerView.Adapter<DashItemsAdapter.DashItemsViewHolder> {
    private List<DashItem> dashItems;
    private int smallHeight;
    Activity activity;

    public DashItemsAdapter(List<DashItem> dashItems, int smallHeight, Activity activity) {
        this.dashItems = dashItems;
        this.smallHeight = smallHeight;
        this.activity = activity;
    }

    @NonNull
    @Override
    public DashItemsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new DashItemsViewHolder(
                LayoutInflater.from(parent.getContext()).inflate(
                        R.layout.dash_item_view,
                        parent,
                        false
                )
        );
    }

    @Override
    public void onBindViewHolder(@NonNull DashItemsViewHolder holder, int position) {
        holder.setDashImage(dashItems.get(position));
        holder.setDashBackground(dashItems.get(position));
        holder.setDashText(dashItems.get(position));
        if(position == 1 || position == 3 || position == 4 || position == 5) {
            holder.rearrange();
        }
        holder.background.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int position = holder.getAdapterPosition();

                switch (position) {
                    case 0:
                        activity.startActivity(new Intent(activity, AccountOpeningActivity.class));
                        break;
                    case 1:
                        activity.startActivity(new Intent(activity, AllTransactionsActivity.class));
                        break;
                    case 2:
                        activity.startActivity(new Intent(activity, BillsPaymentActivity.class));
                        break;
                    case 3:
                        activity.startActivity(new Intent(activity, FundsTransferActivity.class));
                        break;
                    case 4:
                        activity.startActivity(new Intent(activity, MainActivity.class).setFlags(Intent.FLAG_ACTIVITY_NEW_TASK));
                        break;
                    case 5:
                        activity.startActivity(new Intent(activity, MainActivity.class).setFlags(Intent.FLAG_ACTIVITY_NEW_TASK));
                        break;
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return dashItems.size();
    }

    class DashItemsViewHolder extends RecyclerView.ViewHolder {
        ImageView dashImage;
        LinearLayout background;
        TextView dashText;
        ConstraintLayout constraintLayout;

        public DashItemsViewHolder(@NonNull View itemView) {
            super(itemView);
            dashImage = itemView.findViewById(R.id.dashImage);
            background = itemView.findViewById(R.id.background);
            dashText = itemView.findViewById(R.id.dashText);
            constraintLayout = itemView.findViewById(R.id.constraint);
        }

        void setDashImage(DashItem dashItem) {
            dashImage.setImageResource(dashItem.getIcon());
            dashImage.getLayoutParams().height = dashItem.getHeight();
            dashImage.getLayoutParams().width = dashItem.getWidth();
            dashImage.requestLayout();
        }

        void setDashBackground(DashItem dashItem) {
            background.setBackgroundResource(dashItem.getBg());
        }

        void setDashText(DashItem dashItem) {
            dashText.setText(dashItem.getText());
        }

        void rearrange() {
            background.getLayoutParams().height = smallHeight;
            background.requestLayout();
            ConstraintLayout.LayoutParams dashImageLayoutParams = (ConstraintLayout.LayoutParams) dashImage.getLayoutParams();
            dashImageLayoutParams.endToEnd = constraintLayout.getId();
            dashImageLayoutParams.startToStart = ConstraintLayout.LayoutParams.UNSET;
            dashImage.requestLayout();

            ConstraintLayout.LayoutParams dashTextLayoutParams = (ConstraintLayout.LayoutParams) dashText.getLayoutParams();
            dashTextLayoutParams.topToBottom = ConstraintLayout.LayoutParams.UNSET;
            dashTextLayoutParams.bottomToBottom = constraintLayout.getId();
            dashText.requestLayout();
        }
    }
}
