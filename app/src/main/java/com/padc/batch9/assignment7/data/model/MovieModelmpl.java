package com.padc.batch9.assignment7.data.model;

import android.content.Context;

import com.padc.batch9.assignment7.data.vo.MovieVo;
import com.padc.batch9.assignment7.network.dataagent.MovieDataAgent;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MovieModelmpl extends BaseModel implements MovieModel {
    public static MovieModelmpl objInstance;
    private Map<Integer, MovieVo> houseDataReposistory;

    private MovieModelmpl() {
        houseDataReposistory = new HashMap<>();
    }

    public static MovieModelmpl getObjInstance() {
        if (objInstance==null) {
            objInstance = new MovieModelmpl();
        }
        return objInstance;
    }

    @Override
    public void getMovie(final GetMovieModelFromDataLayer delegate) {
        mDataAgent.getMovies(new MovieDataAgent.GetMovieFromNetworkDelegate() {
            @Override
            public void onSuccess(List<MovieVo> movieVos) {
                for (MovieVo movieVo:movieVos) {
                    houseDataReposistory.put(movieVo.getId(), movieVo);
                }
                delegate.onSuccess(movieVos);
            }

            @Override
            public void onFailure(String message) {
                delegate.onFailure(message);
            }
        });
    }

    @Override
    public MovieVo getMovieVoById(int id) {
        final MovieVo movieVo;
        movieVo = houseDataReposistory.get(id);
        return movieVo;
    }
}
