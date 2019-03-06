package com.example.dung.music_59.data.source;

import com.example.dung.music_59.data.model.Genre;

import java.util.List;

public interface TrackDataSource {
    interface getGenresCallBack{
        void onGetGenresCompletion(List<Genre> genres);
    }

    interface local{
        void getGenres(getGenresCallBack callBack);
    }

    interface remote{

    }
}
