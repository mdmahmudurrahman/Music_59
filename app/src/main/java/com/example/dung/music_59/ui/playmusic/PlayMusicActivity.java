package com.example.dung.music_59.ui.playmusic;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcelable;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import com.example.dung.music_59.R;
import com.example.dung.music_59.data.model.Track;
import com.example.dung.music_59.service.MusicService;
import com.example.dung.music_59.ui.adapter.ViewPagerPlayAdapter;
import com.example.dung.music_59.ui.playmusic.playfragment.PlayMusicFragment;
import com.example.dung.music_59.ui.playmusic.playlistfragment.PlayListFragment;

import java.util.ArrayList;
import java.util.List;

public class PlayMusicActivity extends AppCompatActivity {
    public static final String BUNDLE_TRACK = "BUNDLE_TRACK ";
    public static final String BUNDLE_LIST_TRACK = "BUNDLE_LIST_TRACK ";
    private static final String EXTRA_BUNDLE_TRACK = "EXTRA_BUNDLE_TRACK";
    private static final int PAGE_LIMIT = 2;
    public static MusicService sMusicService;
    private Track mTrack;
    private List<Track> mTracks;
    private ViewPager mViewPager;
    private Intent mPlayIntent;
    private boolean mIsBound = false;
    public ServiceConnection serviceConnection = new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            MusicService.MusicBinder binder = (MusicService.MusicBinder) iBinder;
            if (sMusicService == null) {
                sMusicService = binder.getService();
            }
            setUpViewPager();
            mIsBound = true;
        }

        @Override
        public void onServiceDisconnected(ComponentName componentName) {
            mIsBound = false;
        }
    };

    public static Intent getIntent(Context context, Track track, List<Track> tracks) {
        Intent intent = new Intent(context, PlayMusicActivity.class);
        Bundle bundle = new Bundle();
        bundle.putParcelable(BUNDLE_TRACK, track);
        bundle.putParcelableArrayList(BUNDLE_LIST_TRACK, (ArrayList<? extends Parcelable>) tracks);
        intent.putExtra(EXTRA_BUNDLE_TRACK, bundle);
        return intent;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_play_music);
        if (mPlayIntent == null) {
            mPlayIntent = new Intent(PlayMusicActivity.this, MusicService.class);
            bindService(mPlayIntent, serviceConnection, Context.BIND_AUTO_CREATE);
            startService(mPlayIntent);
        }
        initView();
        setToolbar();
        getBundle();

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
        viewPagerPlayAdapter.addFragment(PlayMusicFragment.newInstance(mTrack, mTracks), getString(R.string.title_home));
        viewPagerPlayAdapter.addFragment(new PlayListFragment(), getString(R.string.title_user));
        mViewPager.setAdapter(viewPagerPlayAdapter);
        mViewPager.setOffscreenPageLimit(PAGE_LIMIT);
    }

    private void initView() {
        mViewPager = findViewById(R.id.view_pager_play_music);

    }

    public MusicService getService() {
        return sMusicService;
    }

    public void getBundle() {
        Intent intent = getIntent();
        Bundle bundle = intent.getBundleExtra(EXTRA_BUNDLE_TRACK);
        if (bundle != null) {
            mTrack = bundle.getParcelable(BUNDLE_TRACK);
            mTracks = bundle.getParcelableArrayList(BUNDLE_LIST_TRACK);
        }
    }
}
