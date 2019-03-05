package com.example.dung.music_59.ui.home.homefragment;

import com.example.dung.music_59.data.model.Genre;

import java.util.List;

public interface HomeContract {
    interface View {
        void showGenres(List<Genre> genres);
    }

    interface Presenter {
        void loadGenres();
    }
}
