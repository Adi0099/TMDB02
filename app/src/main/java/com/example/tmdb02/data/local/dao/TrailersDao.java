package com.example.tmdb02.data.local.dao;


import com.example.tmdb02.data.local.model.Trailer;

import java.util.List;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;

@Dao
public interface TrailersDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    void insertAllTrailers(List<Trailer> trailers);

}
