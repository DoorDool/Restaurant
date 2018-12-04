package com.example.dorin.restaurant;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.squareup.picasso.Picasso;
import java.util.ArrayList;

public class MenuAdapter extends ArrayAdapter<MenuItem> {

    public MenuAdapter(Context context, ArrayList<MenuItem> items) {
        super(context, 0, items);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.menu_item, parent, false);
        }

        // Get and set textViews and imageViews from item
        TextView name = convertView.findViewById(R.id.name);
        ImageView image = convertView.findViewById(R.id.imageView);
        TextView price = convertView.findViewById(R.id.price);
        MenuItem item = getItem(position);
        String priceString = String.valueOf("$ " + item.getPrice());
        name.setText(item.getName());
        price.setText(priceString);
        Picasso.with(getContext()).load(item.getImageUrl()).into(image);

        return convertView;
    }


}
