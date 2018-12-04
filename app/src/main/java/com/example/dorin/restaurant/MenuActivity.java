package com.example.dorin.restaurant;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;
import java.util.ArrayList;

public class MenuActivity extends AppCompatActivity implements  MenuItemsRequest.Callback {

    ListView list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.menu_activity);

        Intent intent = getIntent();
        String category = intent.getStringExtra("category");

        MenuItemsRequest menuItemsRequest = new MenuItemsRequest(this);
        menuItemsRequest.getMenu(this, category);

        list = findViewById(R.id.listView);
        // method for on item click
        onListItemClick listener = new onListItemClick();
        list.setOnItemClickListener(listener);
    }

    @Override
    public void gotMenu(ArrayList<MenuItem> menuItems) {
        list = findViewById(R.id.listView);
        MenuAdapter adapter = new MenuAdapter(this, menuItems);
        list.setAdapter(adapter);
    }

    // catch error and give message to user
    @Override
    public void gotMenuError(String message) {
        Toast.makeText(this, message, Toast.LENGTH_LONG).show();
    }

    private class onListItemClick implements AdapterView.OnItemClickListener {
        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
            // Get menu item and save them in intent
            MenuItem item = (MenuItem) parent.getItemAtPosition(position);
            Intent intent = new Intent(MenuActivity.this, MenuItemActivity.class);
            intent.putExtra("item", item);
            startActivity(intent);
        }
    }

}
