package com.example.proyek;

import android.os.Parcel;
import android.os.Parcelable;

public class RvItemSetGet2 implements Parcelable {

    private int photo;
    private String name;
    public RvItemSetGet2(){

    }
    protected RvItemSetGet2(Parcel in) {
        photo = in.readInt();
        name = in.readString();
    }

    public static final Creator<RvItemSetGet2> CREATOR = new Creator<RvItemSetGet2>() {
        @Override
        public RvItemSetGet2 createFromParcel(Parcel in) {
            return new RvItemSetGet2(in);
        }

        @Override
        public RvItemSetGet2[] newArray(int size) {
            return new RvItemSetGet2[size];
        }
    };

    public int getPhoto() {
        return photo;
    }

    public void setPhoto(int photo) {
        this.photo = photo;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }



    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(photo);
        parcel.writeString(name);
    }
}
