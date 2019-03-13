package com.example.dung.music_59.data.source;

public class TrackRepository implements TrackDataSource.Local, TrackDataSource.Remote {
    private static TrackRepository sInstance;
    private TrackDataSource.Local mLocal;
    private TrackDataSource.Remote mRemote;

    public static TrackRepository getInstance(TrackDataSource.Local local, TrackDataSource.Remote remote) {
        if (sInstance == null) {
            sInstance = new TrackRepository(local, remote);
        }
        return sInstance;
    }

    private TrackRepository(TrackDataSource.Local local, TrackDataSource.Remote remote) {
        mLocal = local;
        mRemote = remote;
    }

    @Override
    public void getGenres(TrackDataSource.onGetGenresCallBack callBack) {
        mLocal.getGenres(callBack);
    }

    @Override
    public void getTrackByGenre(String url, TrackDataSource.onGetTrackCallBack callBack) {
        mRemote.getTrackByGenre(url,callBack);
    }
}
