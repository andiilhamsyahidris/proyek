package com.example.proyek;

import android.os.Parcel;
import android.os.Parcelable;
public class VegetablesSetGet implements Parcelable{
    private String name;
    private int photo, harga;

    public VegetablesSetGet(){

    }

    protected VegetablesSetGet(Parcel in) {
        name = in.readString();
        photo = in.readInt();
        harga = in.readInt();
    }

    public static final Creator<VegetablesSetGet> CREATOR = new Creator<VegetablesSetGet>() {
        @Override
        public VegetablesSetGet createFromParcel(Parcel in) {
            return new VegetablesSetGet(in);
        }

        @Override
        public VegetablesSetGet[] newArray(int size) {
            return new VegetablesSetGet[size];
        }
    };

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPhoto() {
        return photo;
    }

    public void setPhoto(int photo) {
        this.photo = photo;
    }

    public int getHarga() {
        return harga;
    }

    public void setHarga(int harga) {
        this.harga = harga;
    }


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(name);
        parcel.writeInt(photo);
        parcel.writeInt(harga);
    }
}
