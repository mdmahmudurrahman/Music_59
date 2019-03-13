package com.example.dung.music_59.mediaplayer;

import com.example.dung.music_59.data.model.Track;

import java.util.List;

public interface IMediaPlayer {
    interface OnFailure {
        void onLoadFail(String msg);
    }
    void create();

    void setTracksList(List<Track> tracks);

    void pause();

    void next();

    void play();

    void previous();

    void setTrackPosition(int pos);

    void setShuffle();

    void setRepeat();

    int getTrackPosition();

    int getTrackDuaration();

    boolean isPlaying();

    void seekTo(int pons);

    int getCurrentPosition();
}
