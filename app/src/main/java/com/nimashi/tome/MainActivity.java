package com.nimashi.tome;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ActionBar;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

       /* getSupportActionBar().setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);
        getSupportActionBar().setCustomView(R.layout.action_bar);*/
    }



        public void todoList(View v)
    {
        Intent intent=new Intent(this,ToDoListActivity.class);
        startActivity(intent);
    }
    public void noteList(View v)
    {
        Intent intent=new Intent(this,NotesActivity.class);
        startActivity(intent);
    }
    public void ShoppingList(View v)
    {
        Intent intent=new Intent(this,ShoppingListActivity.class);
        startActivity(intent);
    }
    public void Diary(View v)
    {
        Intent intent=new Intent(this,DiaryActivity.class);
        startActivity(intent);
    }
    public void Recipe(View v)
    {
        Intent intent=new Intent(this,RecipeActivity.class);
        startActivity(intent);
    }
}
