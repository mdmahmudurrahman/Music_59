package com.example.dung.music_59.service;

import android.app.Service;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Binder;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.widget.Toast;

import com.example.dung.music_59.R;
import com.example.dung.music_59.data.model.Track;
import com.example.dung.music_59.mediaplayer.MediaManager;

import java.util.List;

public class MusicService extends Service implements
        MediaPlayer.OnCompletionListener, MediaPlayer.OnPreparedListener, MediaPlayer.OnErrorListener {
    private IBinder mIBinder;
    private MediaManager mMediaManager;

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return mIBinder;
    }

    @Override
    public void onCompletion(MediaPlayer mediaPlayer) {
        nextTrack();
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        return START_STICKY;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        mIBinder = new MusicBinder();
        mMediaManager = MediaManager.getInstance(this);
    }

    @Override
    public void onPrepared(MediaPlayer mediaPlayer) {
        mMediaManager.start();
    }

    @Override
    public boolean onError(MediaPlayer mediaPlayer, int i, int i1) {
        Toast.makeText(this, getString(R.string.notify_play_track_error),
                Toast.LENGTH_SHORT).show();
        return true;
    }

    public void playMusic() {
        mMediaManager.create();
    }

    public void setTrackList(List<Track> tracks) {
        mMediaManager.setTracksList(tracks);
    }

    public void nextTrack() {
        mMediaManager.next();
    }

    public void previousTrack() {
        mMediaManager.previous();
    }

    public void pauseTrack() {
        mMediaManager.pause();
    }

    public void pauseToPlayTrack() {
        mMediaManager.play();
    }

    public void setShuffle() {
        mMediaManager.setShuffle();
    }

    public void setRepeat() {
        mMediaManager.setRepeat();
    }

    public int getPosition() {
        return mMediaManager.getCurrentPosition();
    }

    public int getTimeTotal() {
        return mMediaManager.getTrackDuaration();
    }

    public boolean isPlaying() {
        return mMediaManager.isPlaying();
    }

    public void seekTo(int pons) {
        mMediaManager.seekTo(pons);
    }

    public int getCurrentPosition() {
        return mMediaManager.getCurrentPosition();
    }

    public Track getTrack() {
        return mMediaManager.getTrack();
    }

    public void setTrack(int trackIndex) {
        mMediaManager.setTrackPosition(trackIndex);
    }

    public class MusicBinder extends Binder {
        public MusicService getService() {
            return MusicService.this;
        }
    }
}
