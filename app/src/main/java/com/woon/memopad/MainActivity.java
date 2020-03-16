package com.woon.memopad;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.content.Intent;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.woon.memopad.Recycler.RecyclerAdapter;
import com.woon.memopad.Room.AppDatabase;


public class MainActivity extends AppCompatActivity {

    private FloatingActionButton add;

    //리사이클러 뷰
    private RecyclerView recyclerView;
    private LinearLayoutManager linearLayoutManager;
    private RecyclerAdapter adapter;
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

        int size = AppDatabase.getInstance(this).userDao().getAll().size();
        for(int i = 0; i < size; i++){
            adapter.addItems(AppDatabase.getInstance(this).userDao().getAll().get(i));
            System.out.println("####" + AppDatabase.getInstance(this).userDao().getAll().get(i));
        }

    }

    private void move() {
        Intent intent = new Intent(getApplicationContext(), SaveMemoActivity.class);
        startActivity(intent);
    }
}
