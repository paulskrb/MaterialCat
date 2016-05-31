package com.example.bearg.designmaterial;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;

public class CatDetailActivity extends AppCompatActivity {

    private ImageView backdropCat;
    private CollapsingToolbarLayout ctl;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.content_cat_detail);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowTitleEnabled(false);

        ctl = (CollapsingToolbarLayout)
                findViewById(R.id.collapsing_toolbar);

        setupCollapsingToolbarDisplay();

    }

    private void setupCollapsingToolbarDisplay() {
        Intent intent = getIntent();
        int choice = intent.getIntExtra(MainActivity.CAT_KEY, -1);
        backdropCat = (ImageView) findViewById(R.id.backdrop);

        if (choice == 0) {
            backdropCat.setImageResource(R.drawable.babygirl2);
            ctl.setTitle("Baby Girl");
        }

        else if (choice == 1) {
            backdropCat.setImageResource(R.drawable.rocko2);
            ctl.setTitle("Rocko");
        }

        else {
            throw new IllegalStateException("Neither cat was chosen.");
        }


    }

}
