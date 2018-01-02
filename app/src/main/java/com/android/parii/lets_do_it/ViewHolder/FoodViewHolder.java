package com.android.parii.lets_do_it.ViewHolder;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.android.parii.lets_do_it.Interface.ItemClickListener;
import com.android.parii.lets_do_it.R;


public class FoodViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

    public TextView food_name;
    public ImageView food_image;
    private ItemClickListener itemClickListener;

    public void setItemClickListener(ItemClickListener itemClickListener){
        this.itemClickListener = itemClickListener;

    }
    public void onClick(View view)
    {
        itemClickListener.onClick(view,getAdapterPosition(),false);
    }

    public FoodViewHolder(View itemView)
    {
        super(itemView);

        food_name = (TextView) itemView.findViewById(R.id.food_name);
        food_image = (ImageView) itemView.findViewById(R.id.food_image);

        itemView.setOnClickListener(this);

    }
}
