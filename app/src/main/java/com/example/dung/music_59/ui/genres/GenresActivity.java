package com.example.dung.music_59.ui.genres;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.widget.ImageView;

import com.example.dung.music_59.R;
import com.example.dung.music_59.data.model.Genre;
import com.example.dung.music_59.data.model.Track;
import com.example.dung.music_59.data.source.TrackRepository;
import com.example.dung.music_59.data.source.local.TrackLocalDataSource;
import com.example.dung.music_59.data.source.remote.TrackRemoteDataSource;
import com.example.dung.music_59.ui.adapter.TracksAdapter;

import java.util.ArrayList;
import java.util.List;

public class GenresActivity extends AppCompatActivity
        implements TracksAdapter.onClickTrackListener, GenresContract.View {
    private static final String BUNDLE_GRENRE = "bundle_genre";
    private static final String EXTRA_BUNDLE = "extra_bundle";
    private ImageView mImageGenre;
    private RecyclerView mRecyclerTrack;
    private TracksAdapter mTracksAdapter;
    private List<Track> mTracks;
    private GenresContract.Presenter mPresenter;
    private TrackRepository mRepository;
    private Genre mGenre;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_genres);
        getBundle();
        initView();
        setToolbar();
        mPresenter.loadTracksByGenres(mGenre);
    }

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }

    public void getBundle() {
        Intent intent = getIntent();
        Bundle bundle = intent.getBundleExtra(EXTRA_BUNDLE);
        if (bundle != null) mGenre = (Genre) bundle.getParcelable(BUNDLE_GRENRE);
    }

    private void setToolbar() {
        Toolbar mToolbarGenres;
        mToolbarGenres = findViewById(R.id.tool_bar_genre);
        setSupportActionBar(mToolbarGenres);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
    }

    private void initView() {
        mImageGenre = findViewById(R.id.image_track_genre);
        mRecyclerTrack = findViewById(R.id.recycler_track_genre);
        mTracks = new ArrayList<>();
        mTracksAdapter = new TracksAdapter(getApplicationContext(), mTracks);
        mRecyclerTrack.setAdapter(mTracksAdapter);
        mTracksAdapter.setTrackListener(this);
        mRepository = TrackRepository.getInstance(TrackLocalDataSource.getInstance(getApplicationContext()),
                TrackRemoteDataSource.getInstance(getApplicationContext()));
        mPresenter = new GenresPresenter(this, mRepository);
    }

    public static Intent getIntent(Context context, Genre genre) {
        Intent intent = new Intent(context, GenresActivity.class);
        Bundle bundle = new Bundle();
        bundle.putParcelable(BUNDLE_GRENRE, genre);
        intent.putExtra(EXTRA_BUNDLE, bundle);
        return intent;
    }

    @Override
    public void onTrackClick() {

    }

    @Override
    public void showTracks(List<Track> tracks) {
        mTracksAdapter.setTracks(tracks);
    }
}
