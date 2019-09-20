package com.padc.batch9.assignment7.data.model;

import com.padc.batch9.assignment7.network.dataagent.MovieDataAgent;
import com.padc.batch9.assignment7.network.dataagent.RetrofitMovieDataAgentImpl;

public abstract class BaseModel {

    protected MovieDataAgent mDataAgent;

    public BaseModel() {
        mDataAgent = RetrofitMovieDataAgentImpl.getObjInstance();
    }
}
