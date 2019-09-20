package com.padc.batch9.assignment7.delegate;

import com.padc.batch9.assignment7.data.vo.MovieVo;

import java.util.List;

public interface MovieDataDelegate {

    List<MovieVo> getMovieListFromHost();
}
