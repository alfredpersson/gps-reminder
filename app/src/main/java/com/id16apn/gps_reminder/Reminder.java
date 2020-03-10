package com.id16apn.gps_reminder;

import android.os.Parcel;
import android.os.Parcelable;

public class Reminder implements Parcelable {

    private int mLat, mLng, mTime;
    private String mTitle, mDes;

    public static final Parcelable.Creator CREATOR = new Parcelable.Creator<Reminder>() {
        public Reminder createFromParcel(Parcel in) {
            return new Reminder(in);
        }

        @Override
        public Reminder[] newArray(int size) {
            return new Reminder[size];
        }
    };

    /**
     * Creates a new reminder from instance in saved in parcel.
     * @param in the parcel.
     */
    private Reminder(Parcel in) {
        mLat = in.readInt();
        mLng = in.readInt();
        mTime = in.readInt();
        mTitle = in.readString();
        mDes = in.readString();
    }

    public Reminder(int lat, int lng, int time, String title, String des) {
        mLat = lat;
        mLng = lng;
        mTime = time;
        mTitle = title;
        mDes = des;
    }

    public void editReminder(int lat, int lng, int time, String title, String des) {
        mLat = lat;
        mLng = lng;
        mTime = time;
        mTitle = title;
        mDes = des;
    }

    public int getLatitude() {
        return mLat;
    }

    public int getLongitude() {
        return mLng;
    }

    public int getTime() {
        return mTime;
    }

    public String getTitle() {
        return mTitle;
    }

    public String getDes() {
        return mDes;
    }

    /**
     * Method needed to implement Parcelable.
     * @return 0.
     */
    @Override
    public int describeContents() {
        return 0;
    }


    /**
     * Saves the data of this instance to the parcel.
     * @param parcel the parcel.
     * @param i flags.
     */
    @Override
    public void writeToParcel(Parcel parcel, int i) {
       parcel.writeInt(mLat);
       parcel.writeInt(mLng);
       parcel.writeInt(mTime);
       parcel.writeString(mTitle);
       parcel.writeString(mDes);
    }
}
