package com.example.c16208102.parksmartdesign;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;


import java.util.ArrayList;

public class listViewOfAreas extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_view_of_areas);

        ArrayList<areas> arrayOfAreas = new ArrayList<areas>();

        areaAdapter adapterForAreas = new areaAdapter(this, arrayOfAreas);
        final ListView listView = (ListView) findViewById(R.id.listViewOfAreaID);
        listView.setAdapter(adapterForAreas);
        arrayOfAreas.add( new areas("University of Limerick", "UL"));
        arrayOfAreas.add( new areas("City Centre", "CC"));


        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                switch(position) {
                    case 0:
                        goToActivity(ulCarParks.class);
                        break;
                    case 1:
                        goToActivity(cityCentreCarkParks.class);
                        break;
                }
            }
        });


    }
    private void goToActivity(Class clazz) {
        Intent intent = new Intent(listViewOfAreas.this, clazz);
        startActivity(intent);
    }

}
