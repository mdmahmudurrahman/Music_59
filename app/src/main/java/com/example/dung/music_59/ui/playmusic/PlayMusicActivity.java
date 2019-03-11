package com.example.dung.music_59.ui.playmusic;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import com.example.dung.music_59.R;
import com.example.dung.music_59.data.model.Track;
import com.example.dung.music_59.ui.adapter.ViewPagerPlayAdapter;
import com.example.dung.music_59.ui.playmusic.playfragment.PlayMusicFragment;
import com.example.dung.music_59.ui.playmusic.playlistfragment.PlayListFragment;

public class PlayMusicActivity extends AppCompatActivity {
    public static final String BUNDLE_TRACK = "bundle_track";
    private static final String EXTRA_BUNDLE_TRACK = "extra_bundle_track";
    private static final int PAGE_LIMIT = 2;
    private Track mTrack;
    private ViewPager mViewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_play_music);
        initView();
        setToolbar();
        getBundle();
        setUpViewPager();
    }

    private void setToolbar() {
        Toolbar mToolbarPlay;
        mToolbarPlay = findViewById(R.id.tool_bar);
        setSupportActionBar(mToolbarPlay);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    private void setUpViewPager() {
        ViewPagerPlayAdapter viewPagerPlayAdapter = new ViewPagerPlayAdapter(getSupportFragmentManager());
        viewPagerPlayAdapter.addFragment(PlayMusicFragment.newInstance(mTrack), getString(R.string.title_home));
        viewPagerPlayAdapter.addFragment(new PlayListFragment(), getString(R.string.title_user));
        mViewPager.setAdapter(viewPagerPlayAdapter);
        mViewPager.setOffscreenPageLimit(PAGE_LIMIT);
    }

    private void initView() {
        mViewPager = findViewById(R.id.view_pager_play_music);

    }

    public void getBundle() {
        Intent intent = getIntent();
        Bundle bundle = intent.getBundleExtra(EXTRA_BUNDLE_TRACK);
        if (bundle != null) mTrack = bundle.getParcelable(BUNDLE_TRACK);
    }

    public static Intent getIntent(Context context, Track track) {
        Intent intent = new Intent(context, PlayMusicActivity.class);
        Bundle bundle = new Bundle();
        bundle.putParcelable(BUNDLE_TRACK, track);
        intent.putExtra(EXTRA_BUNDLE_TRACK, bundle);
        return intent;
    }
}
