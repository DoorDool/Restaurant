package com.example.dorin.restaurant;

import android.content.Context;
import android.widget.Toast;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import org.json.JSONArray;
import org.json.JSONObject;
import java.util.ArrayList;

public class MenuItemsRequest implements Response.Listener<JSONObject>, Response.ErrorListener{
    private Context context;
    private ArrayList<MenuItem> menuItemArrayList;
    private Callback activity;

    public interface Callback {
        void gotMenu(ArrayList<MenuItem> menuItems);
        void gotMenuError(String message);
    }

    // constructor
    public MenuItemsRequest(Context aContext) {
        this.context = aContext;
    }

    @Override
    public void onResponse(JSONObject response) {
        try {
            menuItemArrayList = new ArrayList<>();
            // Get all categories
            JSONArray menuArray = response.getJSONArray("items");

            // Make for all items in menu an item object
            for (int i=0; i<menuArray.length(); i++) {
                JSONObject menuItemJSON = menuArray.getJSONObject(i);
                String name = menuItemJSON.getString("name");
                String description = menuItemJSON.getString("description");
                String category = menuItemJSON.getString("category");
                Integer price = menuItemJSON.getInt("price");
                String imageUrl = menuItemJSON.getString("image_url");
                MenuItem menuItem = new MenuItem(name, description, imageUrl, price, category);
                // add item object in ArrayList
                menuItemArrayList.add(menuItem);
            }
            activity.gotMenu(menuItemArrayList);
        }
        // Catch errors and give message to user
        catch (Exception e) {
            e.printStackTrace();
            String warningMessage = e.getMessage();
            Toast.makeText(context, warningMessage, Toast.LENGTH_LONG).show();
        }
    }

    @Override
    public void onErrorResponse(VolleyError error) {
        activity.gotMenuError(error.getMessage());
    }

    // Make a request to get the menu for inputted category
    public void getMenu(Callback activity, String category) {
        this.activity = activity;
        RequestQueue queue = Volley.newRequestQueue(context);
        String url = "https://resto.mprog.nl/";
        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.GET, url +
                "menu?category=" + category, null, this, this);
        queue.add(jsonObjectRequest);
    }

}
