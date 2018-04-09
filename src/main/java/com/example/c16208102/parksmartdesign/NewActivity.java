package com.example.c16208102.parksmartdesign;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

/**
 * Created by c16208102 on 09/04/2018.
 */

public class NewActivity extends AppCompatActivity{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.new_activity);
        Button button = (Button) findViewById(R.id.button1);
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View arg0) {
                Toast.makeText(NewActivity.this,
                        "Map Displayed", Toast.LENGTH_LONG).show();

                // Start NewActivity.class
                Intent myIntent = new Intent(NewActivity.this,
                        MapsActivity.class);
                startActivity(myIntent);
            }
        });
    }


}
