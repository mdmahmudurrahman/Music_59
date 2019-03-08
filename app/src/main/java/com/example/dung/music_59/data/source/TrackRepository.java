package com.example.dung.music_59.data.source;

public class TrackRepository implements TrackDataSource.local, TrackDataSource.remote {
    private static TrackRepository sInstance;
    private TrackDataSource.local mLocal;
    private TrackDataSource.remote mRemote;

    public static TrackRepository getInstance(TrackDataSource.local local, TrackDataSource.remote remote) {
        if (sInstance == null) {
            sInstance = new TrackRepository(local, remote);
        }
        return sInstance;
    }

    private TrackRepository(TrackDataSource.local local, TrackDataSource.remote remote) {
        mLocal = local;
        mRemote = remote;
    }

    @Override
    public void getGenres(TrackDataSource.getGenresCallBack callBack) {
        mLocal.getGenres(callBack);
    }

    @Override
    public void getTrackByGenre(String url, TrackDataSource.getTrackCallBack callBack) {
        mRemote.getTrackByGenre(url,callBack);
    }
}
