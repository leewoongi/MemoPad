package com.woon.memopad.Room;


import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

@Database(entities = {User.class}, version = 1, exportSchema = false)
public abstract class AppDatabase extends RoomDatabase {

    public abstract UserDao userDao();
    private static AppDatabase instance = null;


    //싱글톤
    private AppDatabase() {   }

    public static synchronized  AppDatabase getInstance(Context context){
        if(instance == null){
            instance =  Room.databaseBuilder(context.getApplicationContext(),
                    AppDatabase.class, "memo_Database")
                    .allowMainThreadQueries()
                    .build();
        }
        return instance;
    }
}
