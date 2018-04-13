package com.example.c16208102.parksmartdesign;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.location.Location;
import android.location.LocationManager;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.FragmentActivity;
import android.support.v4.content.ContextCompat;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GoogleApiAvailability;
import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {

            private Spinner spinner;
            private GoogleMap mMap;
            private LocationManager locationManager;
            private String provider;
            float x1, x2, y1, y2;
            Button button;

            @Override
            protected void onCreate(Bundle savedInstanceState) {
                super.onCreate(savedInstanceState);
                setContentView(R.layout.activity_maps);
                // Obtain the SupportMapFragment and get notified when the map is ready to be used.
                SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                        .findFragmentById(R.id.map);
                mapFragment.getMapAsync(this);
                getLocationPermission();
                };

            //Swipe to HomePage activity
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
                            Intent i = new Intent(MapsActivity.this, HomePage.class);
                            startActivity(i);
                            Toast.makeText(MapsActivity.this,"Swiped Left to Homepage", Toast.LENGTH_LONG).show();
                        }
                        break;
                }
                return false;
            }

            private boolean CheckGooglePlayServices() {
                GoogleApiAvailability googleAPI = GoogleApiAvailability.getInstance();
                int result = googleAPI.isGooglePlayServicesAvailable(this);
                if(result != ConnectionResult.SUCCESS) {
                    if(googleAPI.isUserResolvableError(result)) {
                        googleAPI.getErrorDialog(this, result,
                                0).show();
                    }
                    return false;
                }
                return true;
            }

            @Override
            public void onMapReady(GoogleMap googleMap) {
                Toast.makeText(this, "Map is Ready", Toast.LENGTH_SHORT).show();
                Log.d("OnMapReady", "Map is ready");
                mMap = googleMap;
                mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(new LatLng(52.673156, -8.571969),15));

                if (mLocationPermissionsGranted) {
                    getDeviceLocation();

                    if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION)
                            != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this,
                            Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
                        return;
                    }
                    mMap.setMyLocationEnabled(true);
                    mMap.getUiSettings().setMyLocationButtonEnabled(false);

                }

                Button staffBtn = (Button) findViewById(R.id.staffBtn);
                staffBtn.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Log.d("OnClick", "Staff car parks button pressed");
                        mMap.clear();
                        mMap.setOnInfoWindowClickListener(new GoogleMap.OnInfoWindowClickListener() {
                            @Override
                            public void onInfoWindowClick(Marker marker) {
                                Intent intent = new Intent(MapsActivity.this,HomePage.class);
                                startActivity(intent);
                            }
                        });

                        LatLng Ireland = new LatLng(52.6735881, -8.572437199999968);
                        mMap.addMarker(new MarkerOptions().position(new LatLng(52.674433, -8.579544)).title("Kemmy Business School Staff Parking").snippet("1.00p/h")
                                .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_YELLOW)));
                        mMap.addMarker(new MarkerOptions().position(new LatLng(52.673260, -8.567261)).title("Schrodinger Building Staff Parking").snippet("1.00p/h")
                                .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_YELLOW)));
                        mMap.addMarker(new MarkerOptions().position(new LatLng(52.673260, -8.567261)).title("Lonsdale Building Staff Parking").snippet("1.00p/h")
                                .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_YELLOW)));
                        mMap.addMarker(new MarkerOptions().position(new LatLng(52.672947, -8.567456)).title("Milford Staff Parking").snippet("1.00p/h")
                                .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_YELLOW)));

                        Toast.makeText(MapsActivity.this,"Staff Car Parks in the University of Limerick", Toast.LENGTH_LONG).show();

                    }
                });

                Button btnCarPark = (Button) findViewById(R.id.btnCarPark);
                btnCarPark.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Log.d("OnClick", "Public car parks button pressed");
                        mMap.clear();
                        mMap.setOnInfoWindowClickListener(new GoogleMap.OnInfoWindowClickListener() {
                            @Override
                            public void onInfoWindowClick(Marker marker) {
                                Intent intent = new Intent(MapsActivity.this,HomePage.class);
                                startActivity(intent);
                            }
                        });

                        LatLng Ireland = new LatLng(52.6735881, -8.572437199999968);
                        mMap.addMarker(new MarkerOptions().position(Ireland).title("Your Location"));
                        mMap.addMarker(new MarkerOptions().position(new LatLng(52.673731, -8.566569)).title("UL Gym Parking").snippet("1.99p/h")
                                .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_BLUE)));
                        mMap.addMarker(new MarkerOptions().position(new LatLng(52.674585, -8.579742)).title("Kemmy public parking").snippet("1.99p/h")
                                .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_BLUE)));
                        mMap.addMarker(new MarkerOptions().position(new LatLng(52.676007, -8.576676)).title("Dromroe Student Village Parking - Residential Only").snippet("2.00p/h")
                                .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_BLUE)));
                        mMap.addMarker(new MarkerOptions().position(new LatLng(52.673156, -8.571969)).title("Main Building Parking").snippet("2.99p/h")
                                .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_BLUE)));
                        mMap.addMarker(new MarkerOptions().position(new LatLng(52.672556, -8.569415)).title("Opposite Bus Stop Parking").snippet("2.99p/h")
                                .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_BLUE)));
                        mMap.addMarker(new MarkerOptions().position(new LatLng(52.679132, -8.568459)).title("Cappavilla Student Village Parking - Residential Only").snippet("Free")
                                .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_BLUE)));
                        mMap.addMarker(new MarkerOptions().position(new LatLng(52.675231, -8.560422)).title("Kilmurry Village - Residential Parking").snippet("Free")
                                .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_BLUE)));
                        mMap.addMarker(new MarkerOptions().position(new LatLng(52.672741, -8.571772)).title("Visitor A Parking(Reserved)").snippet("1.00")
                                .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_BLUE)));
                        mMap.addMarker(new MarkerOptions().position(new LatLng(52.672620, -8.573048)).title("Set down - short term parking only").snippet("1.00")
                                .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_BLUE)));
                        mMap.addMarker(new MarkerOptions().position(new LatLng(52.672545, -8.564906)).title("Sports Bar Parking").snippet("2.99p/h")
                                .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_BLUE)));
                        mMap.addMarker(new MarkerOptions().position(new LatLng(52.672545, -8.564906)).title("East Gates Parking").snippet("Free")
                                .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_BLUE)));
                        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(new LatLng(52.673156, -8.571969),15));

                        Toast.makeText(MapsActivity.this,"Public Car Parks in the University of Limerick", Toast.LENGTH_LONG).show();
                    }
                });

                Button paidParkingBtn = (Button) findViewById(R.id.paidParkingBtn);
                paidParkingBtn.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Log.d("OnClick", "Paid Car Parks Button Pressed");
                        mMap.clear();
                        mMap.setOnInfoWindowClickListener(new GoogleMap.OnInfoWindowClickListener() {
                            @Override
                            public void onInfoWindowClick(Marker marker) {
                                Intent intent = new Intent(MapsActivity.this,HomePage.class);
                                startActivity(intent);
                            }
                        });

                        mMap.addMarker(new MarkerOptions().position(new LatLng(52.672556, -8.569415)).title("Opposite Bus Stop Parking").snippet("2.99p/h")
                                .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_GREEN)));
                        mMap.addMarker(new MarkerOptions().position(new LatLng(52.673156, -8.571969)).title("Main Building Parking").snippet("2.99p/h")
                                .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_GREEN)));
                        mMap.addMarker(new MarkerOptions().position(new LatLng(52.672545, -8.564906)).title("Sports Bar Parking").snippet("2.99p/h")
                                .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_GREEN)));

                        Toast.makeText(MapsActivity.this,"Paid Car Parks in the University of Limerick", Toast.LENGTH_LONG).show();
                    }
                });

                Button freeParkingBtn = (Button) findViewById(R.id.freeParkingBtn);
                freeParkingBtn.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Log.d("OnClick", "Free Car Parks Button Pressed");
                        mMap.clear();
                        mMap.setOnInfoWindowClickListener(new GoogleMap.OnInfoWindowClickListener() {
                            @Override
                            public void onInfoWindowClick(Marker marker) {
                                Intent intent = new Intent(MapsActivity.this,HomePage.class);
                                startActivity(intent);
                            }
                        });

                        mMap.addMarker(new MarkerOptions().position(new LatLng(52.671504, -8.565364)).title("East Gates Parking").snippet("Free")
                                .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_CYAN)));
                        mMap.addMarker(new MarkerOptions().position(new LatLng(52.672620, -8.573048)).title("Set down - short term parking only").snippet("1.00")
                                .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_CYAN)));

                        Toast.makeText(MapsActivity.this,"Free Car Parks in the University of Limerick", Toast.LENGTH_LONG).show();
                    }
                });
            }

            private static final String TAG = "MapActivity";
            private static final String FINE_LOCATION = Manifest.permission.ACCESS_FINE_LOCATION;
            private static final String COURSE_LOCATION = Manifest.permission.ACCESS_COARSE_LOCATION;
            private static final int LOCATION_PERMISSION_REQUEST_CODE = 1234;
            private static final float DEFAULT_ZOOM = 15f;
            private Boolean mLocationPermissionsGranted = false;
            private FusedLocationProviderClient mFusedLocationProviderClient;

            private void getDeviceLocation(){
                Log.d(TAG, "getDeviceLocation: getting the devices current location");

                mFusedLocationProviderClient = LocationServices.getFusedLocationProviderClient(this);

                try{
                    if(mLocationPermissionsGranted){

                        final Task location = mFusedLocationProviderClient.getLastLocation();
                        location.addOnCompleteListener(new OnCompleteListener() {
                            @Override
                            public void onComplete(@NonNull Task task) {
                                if(task.isSuccessful()){
                                    Log.d(TAG, "onComplete: found location!");
                                    Location currentLocation = (Location) task.getResult();

                                    moveCamera(new LatLng(currentLocation.getLatitude(), currentLocation.getLongitude()),
                                            DEFAULT_ZOOM);

                                }else{
                                    Log.d(TAG, "onComplete: current location is null");
                                    Toast.makeText(MapsActivity.this, "unable to get current location", Toast.LENGTH_SHORT).show();
                                }
                            }
                        });
                    }
                }catch (SecurityException e){
                    Log.e(TAG, "getDeviceLocation: SecurityException: " + e.getMessage() );
                }
            }

            private void moveCamera(LatLng latLng, float zoom){
                Log.d(TAG, "moveCamera: moving the camera to: lat: " + latLng.latitude + ", lng: " + latLng.longitude );
                mMap.addMarker(new MarkerOptions().position(latLng));
                mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(latLng, zoom));
            }

            private void initMap(){
                Log.d(TAG, "initMap: initializing map");
                SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.map);

                mapFragment.getMapAsync(MapsActivity.this);
            }

            private void getLocationPermission(){
                Log.d(TAG, "getLocationPermission: getting location permissions");
                String[] permissions = {Manifest.permission.ACCESS_FINE_LOCATION,
                        Manifest.permission.ACCESS_COARSE_LOCATION};

                if(ContextCompat.checkSelfPermission(this.getApplicationContext(),
                        FINE_LOCATION) == PackageManager.PERMISSION_GRANTED){
                    if(ContextCompat.checkSelfPermission(this.getApplicationContext(),
                            COURSE_LOCATION) == PackageManager.PERMISSION_GRANTED){
                        mLocationPermissionsGranted = true;
                        initMap();
                    }else{
                        ActivityCompat.requestPermissions(this,
                                permissions,
                                LOCATION_PERMISSION_REQUEST_CODE);
                    }
                }else{
                    ActivityCompat.requestPermissions(this,
                            permissions,
                            LOCATION_PERMISSION_REQUEST_CODE);
                }
            }

            @Override
            public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
                Log.d(TAG, "onRequestPermissionsResult: called.");
                mLocationPermissionsGranted = false;

                switch(requestCode){
                    case LOCATION_PERMISSION_REQUEST_CODE:{
                        if(grantResults.length > 0){
                            for(int i = 0; i < grantResults.length; i++){
                                if(grantResults[i] != PackageManager.PERMISSION_GRANTED){
                                    mLocationPermissionsGranted = false;
                                    Log.d(TAG, "onRequestPermissionsResult: permission failed");
                                    return;
                                }
                            }
                            Log.d(TAG, "onRequestPermissionsResult: permission granted");
                            mLocationPermissionsGranted = true;
                            //initialize our map
                            initMap();
                        }
                    }
                }
            }
        }
