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
        MenuItem item = getItem(position);
        ImageView imageView = convertView.findViewById(R.id.imageView);
        Picasso.with(getContext()).load(item.getImageUrl()).into(imageView);
        TextView nameText = convertView.findViewById(R.id.name);
        nameText.setText(item.getName());
        TextView priceText = convertView.findViewById(R.id.price);
        priceText.setText("$ " +String.valueOf(item.getPrice()));

        return convertView;
    }


}
