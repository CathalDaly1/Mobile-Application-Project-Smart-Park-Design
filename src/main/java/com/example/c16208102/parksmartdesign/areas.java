package com.example.c16208102.parksmartdesign;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by c16153774 on 16/04/2018.
 */

public class areas implements Parcelable {
    public String name;
    public String code;
    public areas(String name, String code){
        this.name=name;
        this.code=code;
    }


    protected areas(Parcel in) {
        name = in.readString();
        code = in.readString();
    }

    public static final Creator<areas> CREATOR = new Creator<areas>() {
        @Override
        public areas createFromParcel(Parcel in) {
            return new areas(in);
        }

        @Override
        public areas[] newArray(int size) {
            return new areas[size];
        }
    };

    public String getName(){
        return name;
    }
    public String getCode(){
        return code;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(name);
        parcel.writeString(code);
    }
}
