package com.example.dung.music_59.ui.genres;

import com.example.dung.music_59.data.model.Genre;
import com.example.dung.music_59.data.model.Track;

import java.util.List;

public interface GenresContract {
    interface View{
        void showTracks(List<Track> tracks);
    }

    interface Presenter{
        void loadTracksByGenres(Genre genre);
    }
}
