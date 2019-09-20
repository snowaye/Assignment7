package com.padc.batch9.assignment7.network.response;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.padc.batch9.assignment7.data.vo.MovieVo;

import java.util.List;

public class GetMovieResponse {
    @SerializedName("code")
    @Expose
    private Integer code;
    @SerializedName("message")
    @Expose
    private String message;
    @SerializedName("data")
    @Expose
    private List<MovieVo> data = null;

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public List<MovieVo> getData() {
        return data;
    }

    public void setData(List<MovieVo> data) {
        this.data = data;
    }
}
