package com.example.c16208102.parksmartdesign;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

/**
 * Created by c16208102 on 13/04/2018.
 */

public class HomePage extends AppCompatActivity{
    float x1, x2, y1, y2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home_activity);
        Button button = (Button) findViewById(R.id.button3);
        Toast.makeText(HomePage.this,"Swipe Right to see Maps", Toast.LENGTH_LONG).show();
        Toast.makeText(HomePage.this,"Swipe Left to see List of Car Parks", Toast.LENGTH_LONG).show();
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View arg0) {
                findViewById(R.id.bar).setVisibility(View.GONE);
                Toast.makeText(HomePage.this,
                        "Map Displayed", Toast.LENGTH_LONG).show();

                // Start NewActivity.class
                Intent myIntent = new Intent(HomePage.this,
                        MapsActivity.class);
                startActivity(myIntent);
            }
        });

        Button button4 = (Button) findViewById(R.id.button4);
        button4.setOnClickListener(new View.OnClickListener() {
            public void onClick(View arg0) {
                findViewById(R.id.bar).setVisibility(View.GONE);
                Toast.makeText(HomePage.this,
                        "Map Displayed", Toast.LENGTH_LONG).show();

                // Start NewActivity.class
                Intent myIntent = new Intent(HomePage.this,
                        MapsActivity2.class);
                startActivity(myIntent);
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
                if(x1 < x2)
                {
                    Intent i = new Intent(HomePage.this, MapsActivity.class);
                    startActivity(i);
                }
                else if(x1 > x2) {
                    Intent i = new Intent(HomePage.this, listCarParkView.class);
                    startActivity(i);
                }
                break;
        }
        return false;
    }
}
