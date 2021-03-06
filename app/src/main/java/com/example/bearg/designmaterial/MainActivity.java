package com.example.bearg.designmaterial;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.os.Build;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.ActivityOptionsCompat;
import android.support.v7.graphics.Palette;
import android.support.v7.widget.CardView;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    private CardView mBabyGirlCard;
    private CardView mRockoCard;
    private ImageView mBabyGirlImage;
    private ImageView mRockoImage;
    public static final String CAT_KEY = "com.example.bearg.designmaterial.CAT_ID";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        ///////////////      BEGIN CODE ADDED BY ME     ///////////////////

        mBabyGirlImage = (ImageView) findViewById(R.id.babyGirlImage);
        mRockoImage = (ImageView) findViewById(R.id.rockoImage);

        mBabyGirlCard = (CardView) findViewById(R.id.babygirlCard);
        mBabyGirlCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, CatDetailActivity.class);
                intent.putExtra(CAT_KEY, 0);

                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                    ActivityOptionsCompat options = ActivityOptionsCompat
                            .makeSceneTransitionAnimation(MainActivity.this,
                                    mBabyGirlImage, getString(R.string.transition_image_view_name));

                    startActivity(intent, options.toBundle());
                }

                else {
                    startActivity(intent);
                }

            }
        });

        mRockoCard = (CardView) findViewById(R.id.rockoCard);
        mRockoCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, CatDetailActivity.class);
                intent.putExtra(CAT_KEY, 1);

                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                    ActivityOptionsCompat options = ActivityOptionsCompat
                            .makeSceneTransitionAnimation(MainActivity.this,
                                    mRockoImage, getString(R.string.transition_image_view_name));

                    startActivity(intent, options.toBundle());
                }

                else {
                    startActivity(intent);
                }

            }
        });

        BitmapDrawable babyGirlImageDrawable = (BitmapDrawable) mBabyGirlImage.getDrawable();
        Bitmap babyGirlPhoto = babyGirlImageDrawable.getBitmap();
        colorize(babyGirlPhoto, R.id.babyGirlImage);

        BitmapDrawable rockoImageDrawable = (BitmapDrawable) mRockoImage.getDrawable();
        Bitmap rockoPhoto = rockoImageDrawable.getBitmap();
        colorize(rockoPhoto, R.id.rockoImage);

    }

    private void colorize(final Bitmap photo, final int whichPhoto) {
        Palette.from(photo).generate(new Palette.PaletteAsyncListener() {
            @Override
            public void onGenerated(Palette palette) {
                applyPalette(palette, whichPhoto);
            }
        });
    }

    private void applyPalette(Palette palette, int whichPhoto) {

        // get the theme primary color. will be used as a fallback if good palette match
        // can't be found
        final int primaryColor = ColorUtils.getThemeColor(this, R.attr.colorPrimary);

        if (whichPhoto == R.id.babyGirlImage) {
            TextView babyGirlNameText = (TextView) findViewById(R.id.babyGirlNameText);
            babyGirlNameText.setTextColor(palette.getDarkMutedColor(primaryColor));

        }

        else if (whichPhoto == R.id.rockoImage) {
            TextView rockoNameText = (TextView) findViewById(R.id.rockoNameText);
            rockoNameText.setTextColor(palette.getLightMutedColor(primaryColor));
        }

        else {
            throw new IllegalStateException("whichPhoto was of neither cat");
        }

    }



    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_camera) {
            // Handle the camera action
        } else if (id == R.id.nav_gallery) {

        } else if (id == R.id.nav_slideshow) {

        } else if (id == R.id.nav_manage) {

        } else if (id == R.id.nav_share) {

        } else if (id == R.id.nav_send) {

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
