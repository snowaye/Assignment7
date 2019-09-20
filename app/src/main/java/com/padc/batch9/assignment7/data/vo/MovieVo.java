package com.padc.batch9.assignment7.data.vo;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

public class MovieVo {

    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("movie_name")
    @Expose
    private String movieName;
    @SerializedName("imdb")
    @Expose
    private Double imdb;
    @SerializedName("rotten_tomato")
    @Expose
    private Integer rottenTomato;
    @SerializedName("meta_centric")
    @Expose
    private Integer metaCentric;
    @SerializedName("genre")
    @Expose
    private List<GenreVo> genre = null;

    private List<String> genreStringList = null;
    @SerializedName("overview")
    @Expose
    private String overview;
    @SerializedName("poster")
    @Expose
    private String poster;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getMovieName() {
        return movieName;
    }

    public void setMovieName(String movieName) {
        this.movieName = movieName;
    }

    public Double getImdb() {
        return imdb;
    }

    public void setImdb(Double imdb) {
        this.imdb = imdb;
    }

    public Integer getRottenTomato() {
        return rottenTomato;
    }

    public void setRottenTomato(Integer rottenTomato) {
        this.rottenTomato = rottenTomato;
    }

    public Integer getMetaCentric() {
        return metaCentric;
    }

    public void setMetaCentric(Integer metaCentric) {
        this.metaCentric = metaCentric;
    }

    public List<GenreVo> getGenre() {
        return genre;
    }

    public List<String> getGenreStringList() {
        genreStringList = new ArrayList<>();
        for (GenreVo genreVo:getGenre()) {
            genreStringList.add(genreVo.getName());
        }
        return genreStringList;
    }

    public void setGenre(List<GenreVo> genre) {
        this.genre = genre;
    }

    public String getOverview() {
        return overview;
    }

    public void setOverview(String overview) {
        this.overview = overview;
    }

    public String getPoster() {
        return poster;
    }

    public void setPoster(String poster) {
        this.poster = poster;
    }
}
