package com.padc.batch9.assignment7.activity;

import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.padc.batch9.assignment7.R;
import com.padc.batch9.assignment7.data.model.MovieModelmpl;

public class BaseActivity extends AppCompatActivity {

    MovieModelmpl mModel;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mModel = MovieModelmpl.getObjInstance();
    }

    protected void showIdefiniteSnakBar(String message) {
        final Snackbar snackbar =  Snackbar.make(getWindow().getDecorView(), message,
                Snackbar.LENGTH_INDEFINITE);
        snackbar.setAction(getString(R.string.label_okay), new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                snackbar.dismiss();
            }
        });
    }
}
