package com.example.dung.music_59.data.model;

public class Genre {
    private String mKey;
    private String mGenreName;
    private int mImageId;

    public Genre(String key, String genreName, int imageId) {
        mKey = key;
        mGenreName = genreName;
        mImageId = imageId;
    }

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
}
