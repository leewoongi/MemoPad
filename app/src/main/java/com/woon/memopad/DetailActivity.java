package com.woon.memopad;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.woon.memopad.Room.User;

public class DetailActivity extends AppCompatActivity {

    private EditText detailTitle;
    private ImageView detailImage;
    private EditText detailDes;

    private FloatingActionButton exit;
    private FloatingActionButton update;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        initialized();

        // 수정
        update.setOnClickListener(v -> {
            
        });

        //그냥 종료
        exit.setOnClickListener(v -> {

        });
    }

    private void initialized() {

        detailTitle = findViewById(R.id.detailTitle);
        detailImage = findViewById(R.id.detailImage);
        detailDes = findViewById(R.id.detailDes);

        User detail = getIntent().getParcelableExtra("data");
        String title = detail.getTitle();
        String des = detail.getDes();

        detailTitle.setText(title);
        detailDes.setText(des);

    }


}
