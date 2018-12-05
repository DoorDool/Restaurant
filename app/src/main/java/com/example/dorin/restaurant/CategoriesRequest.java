package com.example.dorin.restaurant;

import android.content.Context;
import android.util.Log;
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

public class CategoriesRequest implements Response.Listener<JSONObject>, Response.ErrorListener {

    private Context context;
    private ArrayList<String> arrayList;
    private Callback activity;

    //constructor
    public CategoriesRequest(Context aContext) {
        this.context = aContext;
    }

    public interface Callback {
        void gotCategories(ArrayList<String> categories);
        void gotCategoriesError(String message);
    }

    @Override
    public void onResponse(JSONObject response) {
        try {
            arrayList = new ArrayList<>();
            // Get categories from the JSONObject
            JSONArray categories = response.getJSONArray("categories");

            // Store it in an arrayList
            for (int i=0; i<categories.length(); i++) {
                arrayList.add(categories.getString(i));
                System.out.println(categories.getString(i));
            }
            // set arrayList in activity
            activity.gotCategories(arrayList);
        }
        // Catch errors and give message to user
        catch (Exception e) {
            e.printStackTrace();
            String warningMessage =  e.getMessage();
            Toast.makeText(context, warningMessage, Toast.LENGTH_LONG).show();
        }
    }

    // catch errors
    @Override
    public void onErrorResponse(VolleyError error) {
        activity.gotCategoriesError(error.getMessage());
    }

    // Get categories from the site
    public void getCategories(Callback activity) {
        this.activity = activity;
        RequestQueue queue = Volley.newRequestQueue(context);
        String url = "https://resto.mprog.nl/";
        try {
            // make new jsonObjectRequest with url category
            JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.GET, url +
                    "categories", null, this, this);
            queue.add(jsonObjectRequest);
        }
        // error message
        catch(Exception e) {
            Log.d("onResponse Error", e.toString());
        }
    }
}
