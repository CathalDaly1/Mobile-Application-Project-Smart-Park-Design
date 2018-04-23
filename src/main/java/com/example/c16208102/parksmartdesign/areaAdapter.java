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

public class areaAdapter extends ArrayAdapter<areas> {
    public areaAdapter(@NonNull Context context, ArrayList<areas> areaObjects) {
        super(context, 0, areaObjects);
    }
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // Get the data item for this position

        areas area = getItem(position);
        // Check if an existing view is being reused, otherwise inflate the view
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.area_layouts, parent, false);
        }
        // Lookup view for data population
        TextView tvName = (TextView) convertView.findViewById(R.id.areaNameID);

        // Populate the data into the template view using the data object
        tvName.setText(area.name);

        // Return the completed view to render on screen
        return convertView;
    }
}

