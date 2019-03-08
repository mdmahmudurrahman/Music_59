package com.example.dung.music_59.data.model;

import android.os.Parcel;
import android.os.Parcelable;

public class Genre implements Parcelable {
    private String mKey;
    private String mGenreName;
    private int mImageId;

    public Genre(String key, String genreName, int imageId) {
        mKey = key;
        mGenreName = genreName;
        mImageId = imageId;
    }

    protected Genre(Parcel in) {
        mKey = in.readString();
        mGenreName = in.readString();
        mImageId = in.readInt();
    }

    public static final Creator<Genre> CREATOR = new Creator<Genre>() {
        @Override
        public Genre createFromParcel(Parcel in) {
            return new Genre(in);
        }

        @Override
        public Genre[] newArray(int size) {
            return new Genre[size];
        }
    };

    public String getKey() {
        return mKey;
    }

    public void setKey(String key) {
        mKey = key;
    }

    public String getGenreName() {
        return mGenreName;
    }

    public void setGenreName(String genreName) {
        mGenreName = genreName;
    }

    public int getImageId() {
        return mImageId;
    }

    public void setImageId(int imageId) {
        mImageId = imageId;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(mKey);
        parcel.writeString(mGenreName);
        parcel.writeInt(mImageId);
    }
}
