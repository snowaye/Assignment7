package com.padc.batch9.assignment7.network.dataagent;

import com.padc.batch9.assignment7.network.response.GetMovieResponse;
import com.padc.batch9.assignment7.util.MovieConsant;

import retrofit2.Call;
import retrofit2.http.POST;

public interface MovieApi {

    @POST(MovieConsant.GET_MOVIE)
    Call<GetMovieResponse> getMovies();
}
