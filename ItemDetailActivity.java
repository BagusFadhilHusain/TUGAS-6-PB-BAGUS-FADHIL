package com.belajar.tugas5recycleview;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class ItemDetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_item_detail);

        Intent intent = getIntent();
        if (intent != null) {
            String name = intent.getStringExtra("Name");
            String description = intent.getStringExtra("Description");
            String price = intent.getStringExtra("Price");
            int imageId = intent.getIntExtra("Image", 0);

            TextView textName = findViewById(R.id.tvDetail);
            ImageView imageView = findViewById(R.id.ivDetail);
            TextView textDescription = findViewById(R.id.tvDescriptionDetail);
            TextView textPrice = findViewById(R.id.tvPriceDetail);

            textName.setText(name);
            textDescription.setText(description);
            textPrice.setText(price);
            imageView.setImageResource(imageId);


            Button btnShare = findViewById(R.id.btnShare);
            btnShare.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    String shareText = "SILAHKAN CEK ITEM :\n\nNAME: " + name + "\nDESCRIPTION: " + description + "\nPRICE: " + price ;

                    Intent shareIntent = new Intent(Intent.ACTION_SEND);
                    shareIntent.setType("text/plain");
                    shareIntent.putExtra(Intent.EXTRA_TEXT, shareText);
                    startActivity(Intent.createChooser(shareIntent, "Share Melalui"));
                }
            });
        } else {
            Toast.makeText(this, "No Data Available", Toast.LENGTH_SHORT).show();
            finish();
        }
    }
}
