package com.example.roomlab.dao;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import com.example.roomlab.beans.Word;

import java.util.List;

@Dao
public interface WordDao {

    @Query("SELECT * from word_table ORDER BY word ASC")
    LiveData<List<Word>> getAlphabetizedWords();

    @Insert (onConflict = OnConflictStrategy.IGNORE)
    void insert(Word word);

    @Query("DELETE FROM word_table")
    void deleteAll();
}
