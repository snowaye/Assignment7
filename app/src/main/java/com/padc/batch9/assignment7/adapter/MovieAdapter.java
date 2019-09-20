package com.padc.batch9.assignment7.adapter;

import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.padc.batch9.assignment7.delegate.MovieItemDelegate;
import com.padc.batch9.assignment7.R;
import com.padc.batch9.assignment7.data.vo.MovieVo;
import com.padc.batch9.assignment7.view.viewholder.MovieViewHolder;

public class MovieAdapter extends BaseRecyclerViewAdapter<MovieViewHolder, MovieVo> {

    MovieItemDelegate delegate;

    public MovieAdapter(MovieItemDelegate delegate) {
        this.delegate = delegate;
    }

    @NonNull
    @Override
    public MovieViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.listitem_movie, viewGroup, false);
        return new MovieViewHolder(view, delegate);
    }
}
