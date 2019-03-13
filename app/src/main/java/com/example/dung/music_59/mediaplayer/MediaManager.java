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

public class MediaManager implements IMediaPlayer, MediaPlayer.OnCompletionListener {

    private List<Track> mTracks;
    private MediaPlayer mMediaPlayer;
    private int mTrackPosition;
    private MusicService mMusicService;
    private OnFailure mFailure;
    private static MediaManager sInstance;
    private boolean mIsRestartNotifi;
    private boolean mIsShuffle;
    private boolean mIsRepeat;

    public static MediaManager getInstance(MusicService musicService) {
        if (sInstance == null) {
            sInstance = new MediaManager(musicService);
        }
        return sInstance;
    }

    private MediaManager(MusicService musicService) {
        mMusicService = musicService;
        mTracks = new ArrayList<>();
        mMediaPlayer = new MediaPlayer();
        mMediaPlayer.setAudioStreamType(AudioManager.STREAM_MUSIC);
    }

    @Override
    public void create() {
        mMediaPlayer.reset();
        try {
            mMediaPlayer.setDataSource(mMusicService, Uri.parse(mTracks.get(mTrackPosition).getStreamUrl()));
            mMediaPlayer.prepare();
        } catch (IOException e) {
            mFailure.onLoadFail(e.getMessage());
        }
        mMediaPlayer.start();
        mMediaPlayer.setOnCompletionListener(this);
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
        if (mIsRepeat) {

        } else if (mIsShuffle) {
            shuffle();
        } else {
            nextTrack();
        }
        create();
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
    public void setTrackPosition(int pos) {
        mTrackPosition = pos;
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
    public int getTrackDuaration() {
        return mMediaPlayer.getDuration();
    }

    @Override
    public boolean isPlaying() {
        return mMediaPlayer.isPlaying();
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
    public void onCompletion(MediaPlayer mediaPlayer) {
        next();
    }

}
