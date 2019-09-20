package com.padc.batch9.assignment7.activity;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.AppCompatImageView;
import android.support.v7.widget.AppCompatTextView;
import android.view.View;

import com.bumptech.glide.Glide;
import com.padc.batch9.assignment7.R;
import com.padc.batch9.assignment7.data.vo.MovieVo;
import com.padc.batch9.assignment7.util.FunUtils;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MovieDetailActivity extends BaseActivity {
    public static final String IE_MOVIE_ID = "id";

    @BindView(R.id.imgv_close)
    AppCompatImageView imgvClose;
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
    @BindView(R.id.tv_overview)
    AppCompatTextView tvOverView;

    MovieVo movieVo;
    int id;

    public static Intent newIntent(Context context, int id) {
        Intent intent = new Intent(context, MovieDetailActivity.class);
        intent.putExtra(IE_MOVIE_ID, id);
        return intent;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movie_detail);
        ButterKnife.bind(this);
        FunUtils.setStatusBarColor(this, R.color.textColorMain);
        id = getIntent().getIntExtra(IE_MOVIE_ID, -1);
        movieVo = mModel.getMovieVoById(id);
        if (movieVo!=null) {
            tvMovieName.setText(movieVo.getMovieName());
            tvGenre.setText(FunUtils.convertListToString(movieVo.getGenreStringList()));
            tvImdb.setText(String.valueOf(movieVo.getImdb()));
            tvRottenTomato.setText(String.valueOf(movieVo.getRottenTomato()));
            tvMetaCentric.setText(String.valueOf(movieVo.getMetaCentric()));
            Glide.with(this).load(movieVo.getPoster()).into(imgvMovie);
            tvOverView.setText(movieVo.getOverview());
        }
        imgvClose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}
