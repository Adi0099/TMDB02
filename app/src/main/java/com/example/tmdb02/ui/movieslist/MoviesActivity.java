package com.example.tmdb02.ui.movieslist;

import android.os.Bundle;
import android.view.MenuItem;

import com.example.tmdb02.R;
import com.example.tmdb02.ui.movieslist.discover.DiscoverMoviesFragment;
import com.example.tmdb02.utils.ActivityUtils;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

public class MoviesActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if (savedInstanceState == null) {
            setupViewFragment();
        }
        setupToolbar();
    }

    private void setupViewFragment() {
        // show discover movies fragment by default
        DiscoverMoviesFragment discoverMoviesFragment = DiscoverMoviesFragment.newInstance();
        ActivityUtils.replaceFragmentInActivity(
                getSupportFragmentManager(), discoverMoviesFragment, R.id.fragment_container);
    }



    private void setupToolbar() {
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
    }
}
