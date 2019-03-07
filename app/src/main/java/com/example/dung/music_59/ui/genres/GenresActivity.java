package com.example.dung.music_59.ui.genres;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.widget.ImageView;

import com.example.dung.music_59.R;
import com.example.dung.music_59.data.model.Track;
import com.example.dung.music_59.ui.adapter.TracksAdapter;

import java.util.ArrayList;
import java.util.List;

public class GenresActivity extends AppCompatActivity implements TracksAdapter.onClickTrackListener {
    private ImageView mImageGenre;
    private RecyclerView mRecyclerTrack;
    private TracksAdapter mTracksAdapter;
    private List<Track> mTracks;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_genres);

        initView();
        setToolbar();
    }

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
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
    }

    public static Intent getIntent(Context context) {
        Intent intent = new Intent(context, GenresActivity.class);
        return intent;
    }

    @Override
    public void onTrackClick() {

    }

}
