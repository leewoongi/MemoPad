package com.woon.memopad.Room;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "memoTable")
public class User {

    //Room에서 자동으로 id를 할당
    @PrimaryKey(autoGenerate = true)
    private int id;
    private String title;
    private String des;

    public User(String title, String des) {
        this.title = title;
        this.des = des;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDes() {
        return des;
    }

    public void setDes(String des) {
        this.des = des;
    }
}
