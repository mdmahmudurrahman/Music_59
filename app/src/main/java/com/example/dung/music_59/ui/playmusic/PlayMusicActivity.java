package com.example.dung.music_59.ui.playmusic;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.example.dung.music_59.R;
import com.example.dung.music_59.data.model.Track;

public class PlayMusicActivity extends AppCompatActivity {
    public static final String BUNDLE_TRACK = "bundle_track";
    private static final String EXTRA_BUNDLE_TRACK = "extra_bundle_track";
    private Track mTrack;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_play_music);

        getBundle();
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
