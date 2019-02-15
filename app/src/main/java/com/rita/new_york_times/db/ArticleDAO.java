package com.rita.new_york_times.db;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;

import com.rita.new_york_times.model.ArticleEntity;

import java.util.List;

@Dao
public interface ArticleDAO {
    @Query("SELECT * FROM articles")
    List<ArticleEntity> getAll();

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    void insertAll(ArticleEntity... articles);

    @Delete
    void delete(ArticleEntity article);

}
