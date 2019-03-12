package com.example.dung.music_59.ui.playmusic.playfragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.example.dung.music_59.R;
import com.example.dung.music_59.data.model.Track;

public class PlayMusicFragment extends Fragment {

    private static final String ARGUMENT_TRACK = "arg_track";
    private Track mTrack;
    private ImageView mImageMusic;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        View view = inflater.inflate(R.layout.fragment_play_music, container, false);
        getBundle();
        initView(view);
        return view;
    }

    private void getBundle() {
       Bundle bundle  = getArguments();
        if (bundle != null) {
           mTrack = bundle.getParcelable(ARGUMENT_TRACK);
       }
    }

    public static PlayMusicFragment newInstance(Track track) {
        PlayMusicFragment playMusicFragment = new PlayMusicFragment();
        Bundle args = new Bundle();
        args.putParcelable(ARGUMENT_TRACK, track);
        playMusicFragment.setArguments(args);
        return playMusicFragment;
    }

    private void initView(View view) {
        mImageMusic = view.findViewById(R.id.image_track_play);
        Glide.with(getContext()).load(mTrack.getArtworkUrl())
                .apply(RequestOptions.circleCropTransform()).into(mImageMusic);
    }
}
