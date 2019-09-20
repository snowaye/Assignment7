package com.padc.batch9.assignment7.fragment;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.padc.batch9.assignment7.R;
import com.padc.batch9.assignment7.activity.MovieDetailActivity;
import com.padc.batch9.assignment7.adapter.MovieAdapter;
import com.padc.batch9.assignment7.data.vo.MovieVo;
import com.padc.batch9.assignment7.delegate.MovieDataDelegate;
import com.padc.batch9.assignment7.delegate.MovieItemDelegate;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class NowShowingFragment extends BaseFragment implements MovieItemDelegate {

    @BindView(R.id.recv_movie)
    RecyclerView recvMovie;
    LinearLayoutManager layoutManager;

    List<MovieVo> list;
    MovieDataDelegate delegate;
    MovieAdapter adapter;

    public NowShowingFragment() {
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_now_showing, container, false);
        ButterKnife.bind(this, view);
        layoutManager = new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL,
                false);
        recvMovie.setLayoutManager(layoutManager);
        adapter = new MovieAdapter(this);
        recvMovie.setAdapter(adapter);
        adapter.setViewData(list);
        recvMovie.setAdapter(adapter);
        return view;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        try {
            delegate = (MovieDataDelegate) context;
            list = delegate.getMovieListFromHost();
        }
        catch (ClassCastException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onTapItemEvent(int id) {
        Intent intent = MovieDetailActivity.newIntent(getContext(), id);
        startActivity(intent);
    }
}
