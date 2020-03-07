package com.woon.memopad;

import android.app.AlertDialog;
import android.app.Application;
import android.content.Context;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.woon.memopad.Recycler.RecyclerAdapter;
import com.woon.memopad.Room.AppDatabase;
import com.woon.memopad.Room.User;

public class SaveMemoActivity extends AppCompatActivity {

    private EditText description;
    private TextView result;
    private AppDatabase db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_save_memo);

        initialized();
    }

    private void initialized() {
        description = findViewById(R.id.description);
        result = findViewById(R.id.result);

        db = AppDatabase.getInstance(this);

    }

    //메모저장하는 버튼
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.add_memo_menu, menu);
        return true;
    }

    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle item selection
        switch (item.getItemId()) {
            case R.id.save:
                // db에 저장하기
                db.userDao().insert(new User(description.getText().toString()));
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}
