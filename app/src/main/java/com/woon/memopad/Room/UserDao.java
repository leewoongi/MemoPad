package com.woon.memopad.Room;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao
public interface UserDao {

    @Insert
    void insert(User user);

    @Update
    void update(User user);

    @Query("UPDATE memoTable SET user_title = :t, user_des = :d WHERE user_id =:id")
    void update(String t, String d, int id);

    @Delete
    void delete(User user);

    @Query("SELECT * FROM  memoTable")
    List<User> getAll();

    @Query("DELETE FROM memoTable")
    void deleteAll();

    @Query("SELECT COUNT(*) as cnt FROM memoTable")
    int getDataCount();
}
