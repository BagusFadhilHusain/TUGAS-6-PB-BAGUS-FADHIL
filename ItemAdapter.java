package com.belajar.tugas5recycleview;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class ItemAdapter extends RecyclerView.Adapter<ItemAdapter.ItemViewHolder> {

    private Context Context;
    private String[] ItemName;
    private String[] ItemDescription;
    private String[] ItemPrice;
    private int[] ItemImage;

    public ItemAdapter(Context Context, String[] ItemName, String[] ItemDescription, String[] ItemPrice, int[] ItemImage) {
        this.Context = Context;
        this.ItemName = ItemName;
        this.ItemDescription = ItemDescription;
        this.ItemPrice = ItemPrice;
        this.ItemImage = ItemImage;
    }

    @NonNull
    @Override
    public ItemViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item, parent, false);
        return new ItemViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ItemViewHolder holder, @SuppressLint("RecyclerView") int position) {
        holder.ImageView.setImageResource(ItemImage[position]);
        holder.TextName.setText(ItemName[position]);
        holder.TextDescription.setText(ItemDescription[position]);
        holder.TextPrice.setText(ItemPrice[position]);

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Context, ItemDetailActivity.class);
                intent.putExtra("Name", ItemName[position]);
                intent.putExtra("Description", ItemDescription[position]);
                intent.putExtra("Price", ItemPrice[position]);
                Context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return ItemName.length;
    }

    static class ItemViewHolder extends RecyclerView.ViewHolder {
        ImageView ImageView;
        TextView TextName, TextDescription, TextPrice;

        public ItemViewHolder(@NonNull View ItemView) {
            super(ItemView);
            ImageView = itemView.findViewById(R.id.ImageView);
            TextName = itemView.findViewById(R.id.TextName);
            TextDescription = itemView.findViewById(R.id.TextDescription);
            TextPrice = itemView.findViewById(R.id.TextPrice);
        }
    }
}
