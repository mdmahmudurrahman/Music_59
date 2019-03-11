package com.example.dung.music_59.data.model;

import android.os.Parcel;
import android.os.Parcelable;

public class Track implements Parcelable {
    private long mId;
    private int mDuration;
    private String mTitle;
    private String mStreamUrl;
    private String mArtist;
    private String mGenre;
    private String mDowloadUrl;
    private String mDescription;
    private String mArtworkUrl;
    private boolean mIsFavorite;
    private boolean mIsDowloadable;

    protected Track(Parcel in) {
        mId = in.readLong();
        mDuration = in.readInt();
        mTitle = in.readString();
        mStreamUrl = in.readString();
        mArtist = in.readString();
        mGenre = in.readString();
        mDowloadUrl = in.readString();
        mDescription = in.readString();
        mArtworkUrl = in.readString();
        mIsFavorite = in.readByte() != 0;
        mIsDowloadable = in.readByte() != 0;
    }

    public static final Creator<Track> CREATOR = new Creator<Track>() {
        @Override
        public Track createFromParcel(Parcel in) {
            return new Track(in);
        }

        @Override
        public Track[] newArray(int size) {
            return new Track[size];
        }
    };

    public long getId() {
        return mId;
    }

    public int getDuration() {
        return mDuration;
    }

    public String getTitle() {
        return mTitle;
    }

    public String getStreamUrl() {
        return mStreamUrl;
    }

    public String getArtist() {
        return mArtist;
    }

    public String getGenre() {
        return mGenre;
    }

    public String getDowloadUrl() {
        return mDowloadUrl;
    }

    public String getDescription() {
        return mDescription;
    }

    public String getArtworkUrl() {
        return mArtworkUrl;
    }

    public boolean isFavorite() {
        return mIsFavorite;
    }

    public boolean isDowloadable() {
        return mIsDowloadable;
    }

    private Track(Builder builder) {
        mId = builder.mId;
        mDuration = builder.mDuration;
        mTitle = builder.mTitle;
        mStreamUrl = builder.mStreamUrl;
        mArtist = builder.mArtist;
        mGenre = builder.mGenre;
        mDowloadUrl = builder.mDowloadUrl;
        mDescription = builder.mDescription;
        mArtworkUrl = builder.mArtworkUrl;
        mIsFavorite = builder.mIsFavorite;
        mIsDowloadable = builder.mIsDowloadable;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeLong(mId);
        parcel.writeInt(mDuration);
        parcel.writeString(mTitle);
        parcel.writeString(mStreamUrl);
        parcel.writeString(mArtist);
        parcel.writeString(mGenre);
        parcel.writeString(mDowloadUrl);
        parcel.writeString(mDescription);
        parcel.writeString(mArtworkUrl);
        parcel.writeByte((byte) (mIsFavorite ? 1 : 0));
        parcel.writeByte((byte) (mIsDowloadable ? 1 : 0));
    }

    public static class Builder {
        private long mId;
        private int mDuration;
        private String mTitle;
        private String mStreamUrl;
        private String mArtist;
        private String mGenre;
        private String mDowloadUrl;
        private String mDescription;
        private String mArtworkUrl;
        private boolean mIsFavorite;
        private boolean mIsDowloadable;

        public Builder() {

        }

        public Track build() {
            return new Track(this);
        }

        public Builder setId(long id) {
            mId = id;
            return this;
        }

        public Builder setDuration(int duration) {
            mDuration = duration;
            return this;
        }

        public Builder setTitle(String title) {
            mTitle = title;
            return this;
        }

        public Builder setStreamUrl(String streamUrl) {
            mStreamUrl = streamUrl;
            return this;
        }

        public Builder setArtist(String artist) {
            mArtist = artist;
            return this;
        }

        public Builder setGenre(String genre) {
            mGenre = genre;
            return this;
        }

        public Builder setDowloadUrl(String dowloadUrl) {
            mDowloadUrl = dowloadUrl;
            return this;
        }

        public Builder setDescription(String description) {
            mDescription = description;
            return this;
        }

        public Builder setArtworkUrl(String artworkUrl) {
            mArtworkUrl = artworkUrl;
            return this;
        }

        public Builder setFavorite(boolean favorite) {
            mIsFavorite = favorite;
            return this;
        }

        public Builder setDowloadable(boolean dowloadable) {
            mIsDowloadable = dowloadable;
            return this;
        }
    }
}
