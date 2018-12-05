package com.example.dorin.restaurant;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class CategoriesActivity extends AppCompatActivity implements CategoriesRequest.Callback {

    private ListView list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.categories_activity);
        CategoriesRequest x = new CategoriesRequest(this);
        x.getCategories(this);
        list = findViewById(R.id.listview);
        // method for click on category
        onListItemClick listener = new onListItemClick();
        list.setOnItemClickListener(listener);
    }

    @Override
    public void gotCategories(ArrayList<String> categories) {
        list = findViewById(R.id.listview);

        // New adapter for categories
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<>(this, R.layout.categorie_item, categories);
        list.setAdapter(arrayAdapter);
    }

    // catch error and give message to user
    @Override
    public void gotCategoriesError(String message) {
        Toast.makeText(this, message, Toast.LENGTH_LONG).show();
    }

    // method on category click
    private class onListItemClick implements AdapterView.OnItemClickListener {
        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

            // Go to menu when clicked on category
            Intent intent = new Intent(CategoriesActivity.this, MenuActivity.class);
            String category = (String) parent.getItemAtPosition(position);
            // give variable with intent
            intent.putExtra("category", category);
            startActivity(intent);
        }
    }
}

