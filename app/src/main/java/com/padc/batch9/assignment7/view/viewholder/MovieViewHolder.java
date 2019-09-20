package com.padc.batch9.assignment7.view.viewholder;

import android.support.annotation.NonNull;
import android.support.v7.widget.AppCompatImageView;
import android.support.v7.widget.AppCompatTextView;
import android.view.View;

import com.bumptech.glide.Glide;
import com.padc.batch9.assignment7.delegate.MovieItemDelegate;
import com.padc.batch9.assignment7.R;
import com.padc.batch9.assignment7.data.vo.MovieVo;
import com.padc.batch9.assignment7.util.FunUtils;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MovieViewHolder extends BaseViewHolder<MovieVo> {

    MovieItemDelegate delegate;
    @BindView(R.id.imgv_movie)
    AppCompatImageView imgvMovie;
    @BindView(R.id.tv_movie_name)
    AppCompatTextView tvMovieName;
    @BindView(R.id.tv_genre)
    AppCompatTextView tvGenre;
    @BindView(R.id.tv_imdb)
    AppCompatTextView tvImdb;
    @BindView(R.id.tv_rotten_tomato)
    AppCompatTextView tvRottenTomato;
    @BindView(R.id.tv_meta_centric)
    AppCompatTextView tvMetaCentric;
    @BindView(R.id.imgv_detail)
    AppCompatImageView imgvDetail;

    public MovieViewHolder(@NonNull View itemView, final MovieItemDelegate delegate) {
        super(itemView);
        ButterKnife.bind(this, itemView);
        this.delegate = delegate;
        imgvDetail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                delegate.onTapItemEvent(mData.getId());
            }
        });
    }

    @Override
    public void bindData(MovieVo data) {
        mData = data;
        tvMovieName.setText(mData.getMovieName());
        tvGenre.setText(FunUtils.convertListToString(mData.getGenreStringList()));
        tvImdb.setText(String.valueOf(mData.getImdb()));
        tvRottenTomato.setText(String.valueOf(mData.getRottenTomato()));
        tvMetaCentric.setText(String.valueOf(mData.getMetaCentric()));
        Glide.with(itemView).load(mData.getPoster()).into(imgvMovie);
    }

}
