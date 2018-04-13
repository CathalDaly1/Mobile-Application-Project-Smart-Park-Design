package com.example.c16208102.parksmartdesign;


import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by c16153774 on 11/04/2018.
 */

public class carPark implements Parcelable{
    public String name;
    public String type;
    public double lon;
    public double lat;
    public double price;
    public carPark(String name, String type, double lon, double lat, double price){
        this.lat=lat;
        this.lon=lon;
        this.name=name;
        this.type=type;
        this.price=price;
    }
    public carPark(){

    }
    public static final carPark[] carParks={
        new carPark("UL","Free",8,9,0),
        new carPark("City","Free",9,9,80),
        new carPark("Annacotyy","Free",8,8,4.50)
    };

    protected carPark(Parcel in) {
        name = in.readString();
        type = in.readString();
        lon = in.readDouble();
        lat = in.readDouble();
        price = in.readDouble();
    }

    public static final Creator<carPark> CREATOR = new Creator<carPark>() {
        @Override
        public carPark createFromParcel(Parcel in) {
            return new carPark(in);
        }

        @Override
        public carPark[] newArray(int size) {
            return new carPark[size];
        }
    };

    public String getName(){
        return name;
    }
    public String getType(){
        return type;
    }
    public double getLat(){
        return lat;
    }
    public double getLong() {
        return lon;
    }
    public String toString(){
        return name;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(name);
        parcel.writeString(type);
        parcel.writeDouble(lon);
        parcel.writeDouble(lat);
        parcel.writeDouble(price);
    }
}
