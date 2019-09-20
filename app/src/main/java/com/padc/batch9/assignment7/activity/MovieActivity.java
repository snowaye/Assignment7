package com.padc.batch9.assignment7.activity;

import android.graphics.PorterDuff;
import android.support.design.widget.TabLayout;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.AppCompatImageView;
import android.support.v7.widget.AppCompatTextView;
import android.view.View;

import com.padc.batch9.assignment7.R;
import com.padc.batch9.assignment7.adapter.MyViewPagerAdapter;
import com.padc.batch9.assignment7.data.model.MovieModel;
import com.padc.batch9.assignment7.data.vo.MovieVo;
import com.padc.batch9.assignment7.delegate.MovieDataDelegate;
import com.padc.batch9.assignment7.fragment.CinemaFragment;
import com.padc.batch9.assignment7.fragment.ComingSoonFragment;
import com.padc.batch9.assignment7.fragment.NowShowingFragment;
import com.padc.batch9.assignment7.util.FunUtils;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MovieActivity extends BaseActivity implements MovieDataDelegate {

    @BindView(R.id.tabLayout)
    TabLayout tabLayout;
    @BindView(R.id.viewpager)
    ViewPager viewPager;

    MyViewPagerAdapter adapter;
    List<MovieVo> movieVos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        FunUtils.setStatusBarColor(this, R.color.textColorMain);
        mModel.getMovie(new MovieModel.GetMovieModelFromDataLayer() {
            @Override
            public void onSuccess(List<MovieVo> movieVoList) {
                movieVos = movieVoList;
                getMovieListFromHost();
                setupViewPager(viewPager);
                tabLayout.setupWithViewPager(viewPager);
                selectFirstTab();
            }

            @Override
            public void onFailure(String message) {
                showIdefiniteSnakBar(message);
            }
        });
    }



    @Override
    public List<MovieVo> getMovieListFromHost() {
        return movieVos;
    }

    private void setupViewPager(ViewPager viewPager) {
        adapter = new MyViewPagerAdapter(getSupportFragmentManager());
        adapter.addFragment(new NowShowingFragment(), getResources().getString(R.string.label_now_showing));
        adapter.addFragment(new CinemaFragment(), getResources().getString(R.string.label_cinema));
        adapter.addFragment(new ComingSoonFragment(), getResources().getString(R.string.label_coming_soon));
        viewPager.setAdapter(adapter);
    }

    private void selectFirstTab() {
        viewPager.setCurrentItem(0);
        tabLayout.getTabAt(0).select();
    }

}
