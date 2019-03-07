package com.example.dung.music_59.ui.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.dung.music_59.R;
import com.example.dung.music_59.data.model.Genre;

import java.util.List;

public class GenresAdapter extends RecyclerView.Adapter<GenresAdapter.ViewHolder> {
    private Context mContext;
    private List<Genre> mGenres;
    private LayoutInflater mInflater;
    private onClickGenreListener mGenreListener;

    public GenresAdapter(Context context, List<Genre> genres) {
        mContext = context;
        mGenres = genres;
        mInflater = LayoutInflater.from(mContext);
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = mInflater.inflate(R.layout.custom_item_genres, viewGroup, false);
        return new ViewHolder(view, mGenreListener);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
        viewHolder.onBindView(mGenres.get(i));
    }

    @Override
    public int getItemCount() {
        return mGenres == null ? 0 : mGenres.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        private ImageView mImageGenres;
        private TextView mTextNameGenres;
        private onClickGenreListener mGenreListener;

        public ViewHolder(@NonNull View itemView, onClickGenreListener listener) {
            super(itemView);
            mImageGenres = itemView.findViewById(R.id.image_genres);
            mTextNameGenres = itemView.findViewById(R.id.text_name_genres);
            mGenreListener = listener;
        }

        public void onBindView(Genre genre) {
            mTextNameGenres.setText(genre.getGenreName());
            Glide.with(itemView.getContext()).load(genre.getImageId()).into(mImageGenres);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            mGenreListener.onGenreClick();
        }
    }

    public interface onClickGenreListener{
        void onGenreClick();
    }

    public void setGenreListener(onClickGenreListener listener){
        mGenreListener = listener;
    }

    public void setGenres(List<Genre> genres) {
        mGenres = genres;
        notifyDataSetChanged();
    }
}
