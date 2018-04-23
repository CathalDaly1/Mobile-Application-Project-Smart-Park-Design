package com.example.c16208102.parksmartdesign;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class ulCarParks extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_car_parks);

        final ArrayList<carPark> carParksArray = new ArrayList<carPark>();
        carParksArray.add( new carPark("  East Gates parking","Public",8,9,0,"Small car park on the left of sports building"));
        carParksArray.add( new carPark("  Set down - Short term","Public",9,9,1,"Right in the heart of UL, a large spacious car park."));
        carParksArray.add( new carPark("  Visitor A Parking (Reserved)","Residential",8,8,0,"For staff only"));
        carParksArray.add( new carPark("  Kemmy Business School","Staff",8,8,0,"Small car park for staff behind Kemmy business school"));
        carParksArray.add( new carPark("  Kemmy Business School","Staff",8,8,0,"For staff only"));
        carParksArray.add( new carPark("  Schrodinger Building Parking","Staff",8,8,0,"In front of Schrodinger building"));
        carParksArray.add( new carPark("  Lonsdale Building Parking","Staff",8,8,0,"Beside Lonsdale building"));
        carParksArray.add( new carPark("  Milford Parking","Staff",8,8,0,"Opposite Schrodinger building"));
        carParksArray.add( new carPark("  Milford Parking","Public",8,8,1,"Opposite Analog Devices building"));
        carParksArray.add( new carPark("  UL Gym Parking","Public",8,8,1,"Small car park near UL Gym"));
        carParksArray.add( new carPark("  Kemmy public parking","Public",8,0,1.2,"Behing Kemmy Business school"));
        carParksArray.add( new carPark("  Main Building Parking","Public",8,1.50,1.50,"Main car park in UL"));
        carParksArray.add( new carPark("  Opposite Bus Stop Parking","Public",8,1,1,"Small car park opposite the bus terminal in UL"));
        carParksArray.add( new carPark("  Visitor A Parking(Reserved)","Public",8,0,0,"This is a visitors car park - Reserved"));
        carParksArray.add( new carPark("  Sports Bar Parking","Public",8,8,1.10,"Small car park beside the Sports bar"));
        carParksArray.add( new carPark("  Pavilion Parking","Public",8,8,1.30,"Small car park beside the Pavilion bar - North Campus"));
        carParksArray.add( new carPark("  North Campus 4G Pitches","Public",8,8,1.20,"Large car park in front of sports fields facility"));
        carParksArray.add( new carPark("  Dromroe Village Parking","Residential",8,8,0,"Car park for residents of Dromroe student village - Cars must have a tag displayed"));
        carParksArray.add( new carPark("  Cappavilla Village Parking","Residential",8,8,0,"Car park for residents of Cappavilla student village - Cars must have a tag displayed"));
        carParksArray.add( new carPark("  Kilmurry Village Parking","Residential",8,8,0,"Car park for residents of Kilmurry student village - Cars must have a tag displayed"));
        carParksArray.add( new carPark("  Thomand Village Parking","Residential",8,8,0,"Car park for residents of Thomand student village - Cars must have a tag displayed"));


        carParkAdapter carParkAdapters = new carParkAdapter(this, carParksArray);

        final ListView listView = (ListView) findViewById(R.id.carParkListViewUL);
        listView.setAdapter(carParkAdapters);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                Intent i = new Intent(ulCarParks.this, carParkView.class);



                i.putExtra("name", carParksArray.get(position).getName());
                i.putExtra("type", carParksArray.get(position).getType());
                i.putExtra("price", carParksArray.get(position).getPrice());
                i.putExtra("desc", carParksArray.get(position).getCode());
                i.putExtra("location", "University Limerick, Limerick, Ireland");
                startActivity(i);
            }
        });


    }

}
