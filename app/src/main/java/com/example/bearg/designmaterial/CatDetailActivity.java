package com.example.bearg.designmaterial;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;

public class CatDetailActivity extends AppCompatActivity {

    private ImageView mBackdropCat;
    private TextView mCatInfo;
    private TextView mCatLikes;
    private TextView mCatDislikes;
    private CollapsingToolbarLayout mCtl;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.content_cat_detail);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowTitleEnabled(false);

        mCtl = (CollapsingToolbarLayout)
                findViewById(R.id.collapsing_toolbar);

        mBackdropCat = (ImageView) findViewById(R.id.backdrop);
        mCatInfo = (TextView) findViewById(R.id.info_text);
        mCatLikes = (TextView) findViewById(R.id.likes_text);
        mCatDislikes = (TextView) findViewById(R.id.dislikes_text);

        setupContent();

    }

    private void setupContent() {
        Intent intent = getIntent();
        int choice = intent.getIntExtra(MainActivity.CAT_KEY, -1);


        if (choice == 0) {
            mBackdropCat.setImageResource(R.drawable.babygirl2);
            mCtl.setTitle("Baby Girl");
            mCatInfo.setText(R.string.baby_girl_info);
            mCatLikes.setText(R.string.baby_girl_likes);
            mCatDislikes.setText(R.string.baby_girl_dislikes);
        }

        else if (choice == 1) {
            mBackdropCat.setImageResource(R.drawable.rocko2);
            mCtl.setTitle("Rocko");
            mCatInfo.setText(R.string.rocko_info);
            mCatLikes.setText(R.string.rocko_likes);
            mCatDislikes.setText(R.string.rocko_dislikes);
        }

        else {
            throw new IllegalStateException("Neither cat was chosen.");
        }

    }

    @Override
    public void onBackPressed() {
        supportFinishAfterTransition();
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            // Respond to press of the Up/Home button
            case android.R.id.home:
                supportFinishAfterTransition();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
