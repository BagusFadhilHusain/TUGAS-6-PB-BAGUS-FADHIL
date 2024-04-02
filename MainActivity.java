package com.belajar.tugas5recycleview;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class MainActivity extends AppCompatActivity {

    private RecyclerView RecyclerView;
    private ItemAdapter Adapter;

    private String[] ItemName = {"ALPHARD", "AVANZA", "CRV", "FORTUNER", "SUPRA CAR", "CBR", "BEAT", "SUPRA", "NMAX", "VEGA", "WIMCYCLE", "SPECIALIZED", "UNITED", "TREK", "POLYGON"};
    private String[] ItemDescription = {"MESIN : 2498cc    TENAGA : 180hp        TORSI : 235nm", "MESIN : 1993cc    TENAGA : 145hp        TORSI : 181nm", "MESIN : 2498cc    TENAGA : 180hp        TORSI : 235nm", "MESIN : 2393cc    TENAGA : 148hp        TORSI : 400nm", "MESIN : 2498cc    TENAGA : 180hp        TORSI : 235nm", "MESIN : 150cc    TENAGA : 16,8hp        TORSI : 13,7nm", "MESIN : 110cc     TENAGA : 8,89hp        TORSI : 9,3nm", "MESIN : 125cc     TENAGA : 9,92hp        TORSI : 9,3nm", "MESIN : 155cc     TENAGA : 15hp        TORSI : 15nm", "MESIN : 113cc     TENAGA : 8,58hp        TORSI : 8,3nm", "FRAME : HI-TEN STEEL    WHEEL SIZE : 27,5        COLORS : GREEN", "FRAME : LC008    WHEEL SIZE : 27        COLOUR : SKY BLUE", "FRAME : ALLOY       WHEEL SIZE : 27,5        COLORS : RED BLCKWHTE", "FRAME : LW ALUMINIUM    WHEEL SIZE : 27,5        COLOUR : BLACK" , "FRAME : ALUTECH XC SPORT    WHEEL SIZE : 27,5        COLOUR : GREY"};
    private String[] ItemPrice = {"Rp1.369.000.000", "Rp237.000.000", "Rp749.000.000", "Rp564.000.000", "Rp2.238.000.000", "Rp37.783.000", "Rp18.050.000", "Rp19.100.000", "Rp31.925.000", "Rp18.175.000",
            "Rp1.700.000", "Rp11.500.000", "Rp7.550.000", "Rp36.000.000", "Rp4.300.000"};
    private int[] ItemImage = {R.drawable.alphard, R.drawable.avanza, R.drawable.crv, R.drawable.fortuner, R.drawable.supramobil, R.drawable.cbr, R.drawable.beat, R.drawable.supra, R.drawable.nmax,  R.drawable.vega, R.drawable.wimcycle, R.drawable.specialized, R.drawable.united, R.drawable.trek, R.drawable.polygon};

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RecyclerView = findViewById(R.id.recycler_view);
        RecyclerView.setLayoutManager(new LinearLayoutManager(this));
        Adapter = new ItemAdapter();
        RecyclerView.setAdapter(Adapter);
    }

    class ItemAdapter extends RecyclerView.Adapter<ItemAdapter.ItemViewHolder> {

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
                    Intent intent = new Intent(MainActivity.this, ItemDetailActivity.class);
                    intent.putExtra("Name", ItemName[position]);
                    intent.putExtra("Image", ItemImage[position]);
                    intent.putExtra("Description", ItemDescription[position]);
                    intent.putExtra("Price", ItemPrice[position]);

                    startActivity(intent);
                }
            });
        }

        @Override
        public int getItemCount() {
            return ItemName.length;
        }

        class ItemViewHolder extends RecyclerView.ViewHolder {
            ImageView ImageView;
            TextView TextName, TextDescription, TextPrice;

            public ItemViewHolder(@NonNull View itemView) {
                super(itemView);
                ImageView = itemView.findViewById(R.id.ImageView);
                TextName = itemView.findViewById(R.id.TextName);
                TextDescription = itemView.findViewById(R.id.TextDescription);
                TextPrice = itemView.findViewById(R.id.TextPrice);
            }
        }
    }
}
