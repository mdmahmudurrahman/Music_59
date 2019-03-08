package com.example.dung.music_59.data.source;

import com.example.dung.music_59.data.model.Genre;
import com.example.dung.music_59.data.model.Track;

import java.util.List;

public interface TrackDataSource {
    interface getGenresCallBack{
        void onGetGenresCompletion(List<Genre> genres);
    }

    interface getTrackCallBack{
        void onTrackLoaded(List<Track> tracks);
        void onFailure();
    }

    interface local{
        void getGenres(getGenresCallBack callBack);
    }

    interface remote{
        void getTrackByGenre(String url,getTrackCallBack callBack);
    }
}
