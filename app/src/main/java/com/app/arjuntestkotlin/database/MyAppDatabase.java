
package com.app.arjuntestkotlin.database;


import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

@Database(entities = {EntityAddress.class}, version = 1)
public abstract class MyAppDatabase extends RoomDatabase {
    public static MyAppDatabase INSTANCE;

    public abstract DaoAdddress daoAdddress();

    public static MyAppDatabase getInstance(Context context) {
        if (INSTANCE == null) {
            INSTANCE = Room.databaseBuilder(context, MyAppDatabase.class, "noteapp").allowMainThreadQueries().build();
        }
        return INSTANCE;
    }

}