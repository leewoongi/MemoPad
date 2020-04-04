package com.woon.memopad;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.woon.memopad.Room.AppDatabase;
import com.woon.memopad.Room.User;

public class DetailActivity extends AppCompatActivity {

    private EditText detailTitle;
    private ImageView detailImage;
    private EditText detailDes;
    private AppDatabase db;

    private FloatingActionButton exit;
    private FloatingActionButton update;

    private int id;
    private String title;
    private String des;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        initialized();


        // 수정
        update.setOnClickListener(v -> {
            //문제점 : 그냥 그대로 저장이된다.

        });
        //그냥 종료
        exit.setOnClickListener(v -> {
            Intent intent = new Intent(getApplication(), MainActivity.class);
            startActivity(intent);
        });
    }

    private void initialized() {
        update = findViewById(R.id.update);
        exit = findViewById(R.id.exit);
        detailTitle = findViewById(R.id.detailTitle);
        detailImage = findViewById(R.id.detailImage);
        detailDes = findViewById(R.id.detailDes);
        db = AppDatabase.getInstance(this);

        User detail = getIntent().getParcelableExtra("data");

        id = detail.getId();
        title = detail.getTitle();
        des = detail.getDes();

        detailTitle.setText(title);
        detailDes.setText(des);

    }


}
