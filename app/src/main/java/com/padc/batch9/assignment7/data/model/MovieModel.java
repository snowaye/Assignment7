package com.padc.batch9.assignment7.data.model;

import com.padc.batch9.assignment7.data.vo.MovieVo;

import java.util.List;

public interface MovieModel {

    void getMovie(GetMovieModelFromDataLayer delegate);

    MovieVo getMovieVoById(int id);

    public interface GetMovieModelFromDataLayer {
        public void onSuccess(List<MovieVo> movieVos);
        public void onFailure(String message);
    }
}
