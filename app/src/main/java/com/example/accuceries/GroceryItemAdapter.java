package com.example.accuceries;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.core.view.LayoutInflaterFactory;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

public class GroceryItemAdapter extends RecyclerView.Adapter<GroceryItemAdapter.GroceryItemViewHolder> {

    private ArrayList<GroceryItem> groceryItems;
    private Context context;
    private OnItemClickListener listener;

    public interface OnItemClickListener{
        void onAddItemClick(int position);
        void onSubtractItemClick(int position);
    }

    public void setOnItemClickListener(OnItemClickListener tListener){
        listener = tListener;
    }
    public static class GroceryItemViewHolder extends RecyclerView.ViewHolder {
        public ImageView ivImage;
        public TextView tvItemName, tvItemQuantity, tvItemPrice, tvAdd, tvSubtract;

        public GroceryItemViewHolder(@NonNull View itemView, OnItemClickListener tListener) {
            super(itemView);
            ivImage = itemView.findViewById(R.id.ivImage);
            tvItemName = itemView.findViewById(R.id.tvItemName);
            tvItemQuantity = itemView.findViewById(R.id.tvItemQuantity);
            tvItemPrice = itemView.findViewById(R.id.tvItemPrice);
            tvAdd = itemView.findViewById(R.id.tvAdd);
            tvSubtract = itemView.findViewById(R.id.tvSubtract);

            tvAdd.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (tListener!=null){
                        int position = getAdapterPosition();
                        if (position!=RecyclerView.NO_POSITION){
                            tListener.onAddItemClick(position);
                        }
                    }
                }
            });
            tvSubtract.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (tListener!=null){
                        int position = getAdapterPosition();
                        if (position!=RecyclerView.NO_POSITION){
                            tListener.onSubtractItemClick(position);
                        }
                    }
                }
            });
        }
    }

    public GroceryItemAdapter(ArrayList<GroceryItem> tGroceryItems, Context tContext) {
        groceryItems = tGroceryItems;
        context = tContext;
    }

    @NonNull
    @Override
    public GroceryItemViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.grocery_item, parent, false);
        GroceryItemViewHolder glvh = new GroceryItemViewHolder(v,listener);
        return glvh;
    }

    @Override
    public void onBindViewHolder(@NonNull GroceryItemViewHolder holder, int position) {
        GroceryItem item = groceryItems.get(position);

        holder.tvItemName.setText(item.getName());
        holder.tvItemPrice.setText(String.valueOf("R" + Math.round((item.getPrice() * item.getQuantity()) * 100.0) / 100.0));
        holder.tvItemQuantity.setText(String.valueOf(item.getQuantity() + " x " + item.getPrice() + " = "));

        Glide
                .with(context)
                .load(item.getImage())
                .centerCrop()
                .placeholder(R.drawable.food)
                .into(holder.ivImage);
    }

    @Override
    public int getItemCount() {
        return groceryItems.size();
    }
}
