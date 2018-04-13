package com.example.c16208102.parksmartdesign;

import android.content.Intent;
import android.content.res.Resources;
import android.database.Cursor;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Parcelable;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.baoyz.swipemenulistview.SwipeMenu;
import com.baoyz.swipemenulistview.SwipeMenuCreator;
import com.baoyz.swipemenulistview.SwipeMenuItem;
import com.baoyz.swipemenulistview.SwipeMenuListView;

import org.w3c.dom.Text;

import java.util.ArrayList;

public class listCarParkView extends AppCompatActivity {
    float x1, x2, y1, y2;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        final ArrayList<carPark> carParks = new ArrayList<carPark>();
        carParks.add(new carPark("UL", "Staff", 1, 1,10));
        carParks.add(new carPark("UL", "Staff", 1, 1,10));
        carParks.add(new carPark("no", "Staff", 1, 1,10));

        ArrayAdapter<carPark> listAdapter = new ArrayAdapter<>(
                this,
                android.R.layout.simple_list_item_1,
                carPark.carParks);


        SwipeMenuListView listView = (SwipeMenuListView) findViewById(R.id.listView);
        ListView lvDrinks = findViewById(R.id.listView);
        lvDrinks.setAdapter(listAdapter);
        SwipeMenuCreator creator = new SwipeMenuCreator() {

            @Override
            public void create(SwipeMenu menu) {
                // create "open" item
                SwipeMenuItem openItem = new SwipeMenuItem(
                        getApplicationContext());
                // set item background
                openItem.setBackground(new ColorDrawable(Color.rgb(0xC9, 0xC9,
                        0xCE)));
                // set item width
                openItem.setWidth(170);
                // set item title
                openItem.setIcon(R.drawable.ic_info);
                // set item title fontsize

                openItem.setTitleColor(Color.WHITE);
                // add to menu
                menu.addMenuItem(openItem);

                // create "delete" item
                SwipeMenuItem deleteItem = new SwipeMenuItem(
                        getApplicationContext());
                // set item background
                deleteItem.setBackground(new ColorDrawable(Color.rgb(0xF9,
                        0x3F, 0x25)));
                // set item width
                deleteItem.setWidth(170);
                // set a icon
                deleteItem.setIcon(R.drawable.ic_location);
                // add to menu
                menu.addMenuItem(deleteItem);
            }
        };

// set creator
        listView.setMenuCreator(creator);

        listView.setOnMenuItemClickListener(new SwipeMenuListView.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(int position, SwipeMenu menu, int index) {
                switch (index) {
                    case 0:
                        Intent showDetailActivity = new Intent(getApplicationContext(), singleCarParkView.class);
                        showDetailActivity.putExtra("index", position);
                        showDetailActivity.putParcelableArrayListExtra("key", carParks);

                        startActivity(showDetailActivity);
                        break;
                    case 1:
                        showDetailActivity = new Intent(getApplicationContext(), singleCarParkView.class);
                        showDetailActivity.putExtra("itemss", position);
                        startActivity(showDetailActivity);
                        break;
                }
                // false : close the menu; true : not close the menu
                return false;
            }
        });
    }

    public boolean onTouchEvent(MotionEvent touchevent)
    {
        switch (touchevent.getAction()){
            case MotionEvent.ACTION_DOWN:
                x1 = touchevent.getX();
                y1 = touchevent.getY();
                break;
            case MotionEvent.ACTION_UP:
                x2 = touchevent.getX();
                y2 = touchevent.getY();
                if(x1 > x2)
                {
                    Intent i = new Intent(listCarParkView.this, HomePage.class);
                    startActivity(i);
                }
                break;
        }
        return false;
    }
}






