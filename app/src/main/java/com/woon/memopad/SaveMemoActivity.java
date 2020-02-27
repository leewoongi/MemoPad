package com.woon.memopad;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import com.woon.memopad.databinding.ActivitySaveMemoBinding;


public class SaveMemoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivitySaveMemoBinding saveMemoBinding = DataBindingUtil.setContentView(this, R.layout.activity_save_memo);
    }

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
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}
