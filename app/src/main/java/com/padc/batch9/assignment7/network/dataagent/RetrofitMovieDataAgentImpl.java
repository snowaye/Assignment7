package com.padc.batch9.assignment7.network.dataagent;

import com.padc.batch9.assignment7.network.response.GetMovieResponse;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import static com.padc.batch9.assignment7.util.MovieConsant.BASE_URL;

public class RetrofitMovieDataAgentImpl implements MovieDataAgent{

    private static RetrofitMovieDataAgentImpl objInstance;
    MovieApi movieApi;

    private RetrofitMovieDataAgentImpl() {
        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        interceptor.level(HttpLoggingInterceptor.Level.BODY);

        OkHttpClient okHttpClient = new OkHttpClient.Builder()
                .connectTimeout(15, TimeUnit.SECONDS)
                .writeTimeout(15, TimeUnit.SECONDS)
                .readTimeout(15, TimeUnit.SECONDS)
                .addInterceptor(interceptor)
                .build();


        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .client(okHttpClient)
                .build();
        movieApi = retrofit.create(MovieApi.class);
    }

    public static RetrofitMovieDataAgentImpl getObjInstance() {
        if (objInstance==null) {
            objInstance = new RetrofitMovieDataAgentImpl();
        }
        return objInstance;
    }

    @Override
    public void getMovies(final GetMovieFromNetworkDelegate delegate) {
        Call<GetMovieResponse> call = movieApi.getMovies();

        call.enqueue(new Callback<GetMovieResponse>() {
            @Override
            public void onResponse(Call<GetMovieResponse> call, Response<GetMovieResponse> response) {
                if (response!=null) {
                    if (response.isSuccessful()) {
                        delegate.onSuccess(response.body().getData());
                    }
                    else delegate.onFailure(response.body().getMessage());
                }
            }

            @Override
            public void onFailure(Call<GetMovieResponse> call, Throwable t) {
                delegate.onFailure(t.getMessage());
            }
        });
    }
}
