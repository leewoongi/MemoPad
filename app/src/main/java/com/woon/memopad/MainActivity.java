package com.woon.memopad;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.woon.memopad.Recycler.RecyclerAdapter;
import com.woon.memopad.Room.AppDatabase;
import com.woon.memopad.Room.User;

import java.util.ArrayList;
import java.util.List;


public class MainActivity extends AppCompatActivity {

    private final int SAVE_MEMO_ACTIVITY = 1;
    private FloatingActionButton add;

    //리사이클러 뷰
    private RecyclerView recyclerView;
    private LinearLayoutManager linearLayoutManager;
    private RecyclerAdapter adapter;
    private List<User> users;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initialized();

        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setAdapter(adapter);


        add.setOnClickListener(v -> {
            move();
        });
    }


    private void initialized() {
        add = findViewById(R.id.addMemo);

        recyclerView = findViewById(R.id.mainRecyclerView);
        linearLayoutManager = new LinearLayoutManager(this);
        adapter = new RecyclerAdapter();

        users = AppDatabase.getInstance(this).userDao().getAll();
        int size = users.size();
        for(int i = 0; i < size; i++){
            adapter.addItem(users.get(i));
        }
    }

    private void move() {
        Intent intent = new Intent(getApplicationContext(), SaveMemoActivity.class);
        startActivityForResult(intent,SAVE_MEMO_ACTIVITY);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(requestCode == SAVE_MEMO_ACTIVITY){
            if(resultCode == RESULT_OK){

                //리사이클러뷰 update
                users = AppDatabase.getInstance(this).userDao().getAll();
                adapter.addItems((ArrayList) users);

            }
        }
    }
}
