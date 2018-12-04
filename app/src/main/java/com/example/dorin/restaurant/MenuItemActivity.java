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

        // Initialize all views
        TextView nameText = findViewById(R.id.name);
        ImageView imageView = findViewById(R.id.imageView);
        TextView descriptionText = findViewById(R.id.description);
        TextView priceText = findViewById(R.id.price);

        // Fill in all the views
        nameText.setText(item.getName());
        Picasso.with(this).load(item.getImageUrl()).into(imageView);
        descriptionText.setText(item.getDescription());
        priceText.setText("$ " + String.valueOf(item.getPrice()));
    }
}
