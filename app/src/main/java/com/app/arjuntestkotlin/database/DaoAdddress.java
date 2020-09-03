package com.app.arjuntestkotlin.database;


import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao
public interface DaoAdddress {

    @Insert
    public void addNote(EntityAddress note);

    @Query("SELECT * FROM address")
    LiveData<List<EntityAddress>> getAllNotes();

    @Update
    void updateNote(EntityAddress note);

    @Query("DELETE FROM address")
    public void deleteAll();

}