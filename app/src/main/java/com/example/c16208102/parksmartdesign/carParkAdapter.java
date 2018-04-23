package com.example.c16208102.parksmartdesign;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by c16153774 on 16/04/2018.
 */

public class carParkAdapter extends ArrayAdapter<carPark> {
    public carParkAdapter(@NonNull Context context, ArrayList<carPark> areaObjects) {
        super(context, 0, areaObjects);
    }
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // Get the data item for this position

        carPark carParks = getItem(position);
        // Check if an existing view is being reused, otherwise inflate the view
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.carpark_layout, parent, false);
        }
        // Lookup view for data population
        TextView tvName = (TextView) convertView.findViewById(R.id.carParkNameID);
        TextView tvPrice = (TextView) convertView.findViewById(R.id.carParkPriceID);
        TextView tvDesc = (TextView) convertView.findViewById(R.id.carParkDescID);

        // Populate the data into the template view using the data object
        String prices;
        if(carParks.price==0){
            prices="  FREE!";
        }
        else{
            prices = "  €"+carParks.price+"0";
        }
        tvName.setText(carParks.name);
        tvPrice.setText(prices);
        tvDesc.setText(carParks.code);


        // Return the completed view to render on screen
        return convertView;
    }

}