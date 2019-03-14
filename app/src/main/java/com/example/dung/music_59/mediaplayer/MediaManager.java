package com.example.dung.music_59.mediaplayer;

import android.media.AudioManager;
import android.media.MediaPlayer;
import android.net.Uri;

import com.example.dung.music_59.data.model.Track;
import com.example.dung.music_59.service.MusicService;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class MediaManager implements IMediaPlayer {
    private static MediaManager sInstance;
    private List<Track> mTracks;
    private MediaPlayer mMediaPlayer;
    private int mTrackPosition;
    private MusicService mMusicService;
    private boolean mIsRestartNotifi;
    private boolean mIsShuffle;
    private boolean mIsRepeat;
    private OnFailure mFailure;

    public MediaManager(MusicService musicService) {
        mMusicService = musicService;
        mTracks = new ArrayList<>();
        mMediaPlayer = new MediaPlayer();

    }

    public static MediaManager getInstance(MusicService musicService) {
        if (sInstance == null) {
            sInstance = new MediaManager(musicService);
        }
        return sInstance;
    }

    @Override
    public void create() {
        mMediaPlayer.reset();
        mMediaPlayer.setAudioStreamType(AudioManager.STREAM_MUSIC);
        try {
            mMediaPlayer.setDataSource(mMusicService, Uri.parse(mTracks.get(mTrackPosition).getStreamUrl()));
            mMediaPlayer.setOnErrorListener(mMusicService);
            mMediaPlayer.setOnCompletionListener(mMusicService);
            mMediaPlayer.setOnPreparedListener(mMusicService);
            mMediaPlayer.prepareAsync();

        } catch (IOException e) {
            mFailure.onLoadFail(e.getMessage());
        }
    }

    @Override
    public void setTracksList(List<Track> tracks) {
        mTracks = tracks;
    }

    @Override
    public void pause() {
        if (mMediaPlayer.isPlaying()) {
            mMediaPlayer.pause();
        }
    }

    @Override
    public void next() {
        if (mIsShuffle) {
            shuffle();
        } else {
            nextTrack();
        }
        create();
    }

    @Override
    public void start() {
        mMediaPlayer.start();
    }

    private void nextTrack() {
        mTrackPosition++;
        if (mTrackPosition > mTracks.size() - 1) {
            mTrackPosition = 0;
        }
    }

    private void shuffle() {
        int newPosition = mTrackPosition;
        while (newPosition == mTrackPosition) {
            Random mRandom = new Random();
            newPosition = mRandom.nextInt(mTracks.size());
        }
        mTrackPosition = newPosition;
    }

    @Override
    public void play() {
        if (mMediaPlayer.isPlaying() == false) {
            mMediaPlayer.start();
            if (mIsRestartNotifi) {

            }
        }
    }

    @Override
    public void previous() {
        mTrackPosition--;
        if (mTrackPosition < 0) {
            mTrackPosition = mTracks.size() - 1;
        }
        create();
    }

    @Override
    public void seekTo(int pons) {
        mMediaPlayer.seekTo(pons);
    }

    @Override
    public int getCurrentPosition() {
        return mMediaPlayer.getCurrentPosition();
    }

    @Override
    public Track getTrack() {
        return mTracks.get(mTrackPosition);
    }

    @Override
    public void setShuffle() {
        if (mIsShuffle) {
            mIsShuffle = false;
        } else {
            mIsShuffle = true;
        }
    }

    @Override
    public void setRepeat() {
        if (mIsRepeat) {
            mIsRepeat = false;
        } else {
            mIsRepeat = true;
        }
    }

    @Override
    public int getTrackPosition() {
        return mTrackPosition;
    }

    @Override
    public void setTrackPosition(int pos) {

    }

    @Override
    public int getTrackDuaration() {
        return 0;
    }

    @Override
    public boolean isPlaying() {
        return mMediaPlayer.isPlaying();
    }

    interface OnFailure {
        void onLoadFail(String msg);
    }
}
