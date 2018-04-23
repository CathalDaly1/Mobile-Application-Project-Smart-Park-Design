package com.example.c16208102.parksmartdesign;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class cityCentreCarkParks extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_car_parks);

        final ArrayList<carPark> carParksArray = new ArrayList<carPark>();
        carParksArray.add( new carPark("  Harvey's Quay","Public",8,9,1.50,"Large car park, busiest time: 2:00 - 3:30"));
        carParksArray.add( new carPark("  Q-Park Harvey's Quay","Public",9,9,1.30,"Large car park, busiest time: 1:00 - 2:00"));
        carParksArray.add( new carPark("  Euro Car Parks","Public",8,8,1.00,"Large car park, busiest time: 12:00 - 3:30"));
        carParksArray.add( new carPark("  Q-Park Henry Street","Public",8,8,2.50,"Large car park, busiest time: 12:00 - 1:30"));
        carParksArray.add( new carPark("  City Centre Car Parks","Public",8,8,2.00,"Large car park, busiest time: 1:00 - 1:10"));
        carParksArray.add( new carPark("  Summer Street Car Park","Public",8,8,3.00,"Small car park, busiest time: 2:00 - 3:30"));
        carParksArray.add( new carPark("  Cornmarket Square Car Park","Public",8,8,2.80,"Small car park, busiest time: 2:00 - 3:30"));
        carParksArray.add( new carPark("  King Johns Castle Visitor Car Park","Public",8,8,1.90,"Large car park, busiest time: 4:00 - 5:30"));
        carParksArray.add( new carPark("  Barringatons Car Park","Public",8,8,1.50,"Large car park, busiest time: 12:00 - 6:30"));
        carParksArray.add( new carPark("  Colbert Station Car Park","Public",8,8,1,"Large car park, busiest time: 11:00 - 4:30"));



        carParkAdapter carParkAdapters = new carParkAdapter(this, carParksArray);

        final ListView listView = (ListView) findViewById(R.id.carParkListViewUL);
        listView.setAdapter(carParkAdapters);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                Intent i = new Intent(cityCentreCarkParks.this, carParkView.class);



                i.putExtra("name", carParksArray.get(position).getName());
                i.putExtra("type", carParksArray.get(position).getType());
                i.putExtra("price", carParksArray.get(position).getPrice());
                i.putExtra("desc", carParksArray.get(position).getCode());
                i.putExtra("location", "City Centre, Limerick, Ireland");
                startActivity(i);
            }
        });
    }
}