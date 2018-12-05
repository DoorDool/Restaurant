package com.example.dorin.restaurant;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.TextView;
import com.squareup.picasso.Picasso;


public class MenuItemActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.detail_item);

        // Get menuItem from intent
        Intent intent = getIntent();
        MenuItem item = (MenuItem) intent.getSerializableExtra("item");

        // Initialize all views and fill
        TextView nameText = findViewById(R.id.name);
        nameText.setText(item.getName());
        ImageView imageView = findViewById(R.id.imageView);
        Picasso.with(this).load(item.getImageUrl()).into(imageView);
        TextView descriptionText = findViewById(R.id.description);
        descriptionText.setText(item.getDescription());
        TextView priceText = findViewById(R.id.price);
        priceText.setText("$ " + String.valueOf(item.getPrice()));
    }
}
