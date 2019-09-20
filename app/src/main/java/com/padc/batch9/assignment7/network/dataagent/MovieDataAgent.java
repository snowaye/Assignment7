package com.padc.batch9.assignment7.network.dataagent;

import com.padc.batch9.assignment7.data.vo.MovieVo;

import java.util.List;

public interface MovieDataAgent {

    public void getMovies(GetMovieFromNetworkDelegate delegate);

    public interface GetMovieFromNetworkDelegate {
        public void onSuccess(List<MovieVo> movieVos);
        public void onFailure(String message);
    }
}


