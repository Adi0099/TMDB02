package com.example.tmdb02.data;



import com.example.tmdb02.data.local.model.Movie;
import com.example.tmdb02.data.local.model.MovieDetails;
import com.example.tmdb02.data.local.model.RepoMoviesResult;
import com.example.tmdb02.data.local.model.Resource;
import com.example.tmdb02.ui.movieslist.MoviesFilterType;

import java.util.List;

import androidx.lifecycle.LiveData;

public interface DataSource {

    LiveData<Resource<MovieDetails>> loadMovie(long movieId);

    RepoMoviesResult loadMoviesFilteredBy(MoviesFilterType sortBy);

    LiveData<List<Movie>> getAllFavoriteMovies();

    void favoriteMovie(Movie movie);

    void unfavoriteMovie(Movie movie);
}
