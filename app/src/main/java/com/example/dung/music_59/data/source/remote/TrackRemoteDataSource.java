package com.example.dung.music_59.data.source.remote;

import android.content.Context;
import android.util.Log;

import com.example.dung.music_59.data.source.TrackDataSource;

public class TrackRemoteDataSource implements TrackDataSource.remote {
    private static TrackRemoteDataSource sInstance;
    private Context mContext;

    private TrackRemoteDataSource(Context context) {
        mContext = context;
    }

    public static TrackRemoteDataSource getInstance(Context context) {
        if (sInstance == null) {
            sInstance = new TrackRemoteDataSource(context);
        }
        return sInstance;
    }

    @Override
    public void getTrackByGenre(String url, TrackDataSource.getTrackCallBack callBack) {
        new FetchTrackAsync(callBack).execute(url);
    }
}
