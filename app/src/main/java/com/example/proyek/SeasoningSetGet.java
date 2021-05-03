package com.example.proyek;

import android.os.Parcel;
import android.os.Parcelable;

public class SeasoningSetGet implements Parcelable {
    private String name;
    private int photo, harga;

    public SeasoningSetGet() {

    }

    protected SeasoningSetGet(Parcel in) {
        name = in.readString();
        photo = in.readInt();
        harga = in.readInt();
    }

    public static final Creator<SeasoningSetGet> CREATOR = new Creator<SeasoningSetGet>() {
        @Override
        public SeasoningSetGet createFromParcel(Parcel in) {
            return new SeasoningSetGet(in);
        }

        @Override
        public SeasoningSetGet[] newArray(int size) {
            return new SeasoningSetGet[size];
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
