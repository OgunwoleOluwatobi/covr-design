package com.example.covrdesigntest.adapters;

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

import com.example.covrdesigntest.R;
import com.example.covrdesigntest.models.DashItem;

import java.util.List;

public class DashItemsAdapter extends RecyclerView.Adapter<DashItemsAdapter.DashItemsViewHolder> {
    private List<DashItem> dashItems;
    private int smallHeight;

    public DashItemsAdapter(List<DashItem> dashItems, int smallHeight) {
        this.dashItems = dashItems;
        this.smallHeight = smallHeight;
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
