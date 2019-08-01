package com.example.tmdb02.utils;


import com.example.tmdb02.data.MovieRepository;
import com.example.tmdb02.ui.moviedetails.MovieDetailsViewModel;
import com.example.tmdb02.ui.movieslist.discover.DiscoverMoviesViewModel;

import androidx.annotation.NonNull;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;


public class
ViewModelFactory implements ViewModelProvider.Factory {

    private final MovieRepository repository;

    public static ViewModelFactory getInstance(MovieRepository repository) {
        return new ViewModelFactory(repository);
    }

    private ViewModelFactory(MovieRepository repository) {
        this.repository = repository;
    }

    @NonNull
    @Override
    public <T extends ViewModel> T create(@NonNull Class<T> modelClass) {
        if (modelClass.isAssignableFrom(DiscoverMoviesViewModel.class)) {
            //noinspection unchecked
            return (T) new DiscoverMoviesViewModel(repository);
        }else if (modelClass.isAssignableFrom(MovieDetailsViewModel.class)) {
            //noinspection unchecked
            return (T) new MovieDetailsViewModel(repository);
        }
        throw new IllegalArgumentException("Unknown ViewModel class: " + modelClass.getName());
    }
}
