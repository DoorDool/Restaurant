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
        MenuItem menuItem = (MenuItem) intent.getSerializableExtra("menu_item");

        // Initialize all views
        TextView name = findViewById(R.id.name);
        ImageView imageView = findViewById(R.id.imageView);
        TextView description = findViewById(R.id.description);
        TextView price = findViewById(R.id.price);

        // Fill in all the views
        name.setText(menuItem.getName());
        Picasso.with(this).load(menuItem.getImageUrl()).into(imageView);
        description.setText(menuItem.getDescription());
        String priceString = "$ " + String.valueOf(menuItem.getPrice());
        price.setText(priceString);
    }
}
