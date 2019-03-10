package com.example.dung.music_59.data.model;

public class Track  {
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
