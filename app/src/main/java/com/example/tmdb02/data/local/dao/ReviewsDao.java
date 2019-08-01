package com.example.tmdb02.data.local.dao;


import com.example.tmdb02.data.local.model.Review;

import java.util.List;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;


@Dao
public interface ReviewsDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    void insertAllReviews(List<Review> reviews);

}
