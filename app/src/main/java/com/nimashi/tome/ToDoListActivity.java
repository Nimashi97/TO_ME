package com.nimashi.tome;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.AdapterView;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class ToDoListActivity extends AppCompatActivity {

   CheckBox mCheckBox;
   //SharedPreferences sharedPreferences;
   //SharedPreferences.Editor editor;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_to_do_list);
      //mCheckBox=findViewById(R.id.mCheckBox);

       /* sharedPreferences= PreferenceManager.getDefaultSharedPreferences(this);
        editor=sharedPreferences.edit();
        checkSharedPreferences();*/





    }
   /* private void checkSharedPreferences()
    {
        //String checkbox=sharedPreferences.getString(getString(R.string.checkbox), "False");

        if(mCheckBox.isChecked())
        {
            mCheckBox.setChecked(true);
        }
        else
        {
            mCheckBox.setChecked(false);
        }
    }
   /* @Override
    public void onPause()
    {
        super.onPause();
        saved(mCheckBox.isChecked());
    }*/
    @Override
    protected void onResume() {
        super.onResume();
        TaskHelper th = new TaskHelper(this);
        SQLiteDatabase db = th.getReadableDatabase();
        String sql = "SELECT _id,name,date FROM tasks";
        Cursor cursor = db.rawQuery(sql, null);

        List<String> list = new ArrayList<String>();
        cursor.moveToFirst();
        while (cursor.isAfterLast() == false) {
            String name = cursor.getString(0);
            String date = cursor.getString(1);
            list.add(name + "(" + date + ")");
            cursor.moveToNext();
        }
        ListView lv = findViewById(R.id.todo_list);
        int layout = R.layout.one_task;
        String[] columns= {"name", "date","_id"};
        int[] labels={ R.id.task_name,R.id.task_date,R.id.task_id };
        SimpleCursorAdapter adapter=new SimpleCursorAdapter(this, layout,cursor,columns,labels);
        lv.setAdapter(adapter);
        /*if(mCheckBox.isChecked())
        {
            mCheckBox.setChecked(true);
        }
        else
        {
            mCheckBox.setChecked(false);
        }*/


//mCheckBox.setChecked(load());
       // final CheckBox checkBox = findViewById(R.id.mCheckBox);
       /* SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(this);
        final SharedPreferences.Editor editor = preferences.edit();
        if(preferences.contains("checked") && preferences.getBoolean("checked",false) == true) {
            checkBox.setChecked(true);
            Toast.makeText(this, "OK", Toast.LENGTH_SHORT).show();
        }else {
            checkBox.setChecked(false);

        }
       /* checkBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if(checkBox.isChecked()) {
                    editor.putBoolean("checked", true);
                    //editor.apply();
                }else{
                    editor.putBoolean("checked", false);
                  //  editor.apply();
                }
            }
        });*/


    }
    /*private void saved(final boolean isChecked)
    {
        SharedPreferences sharedPreferences=getPreferences(Context.MODE_PRIVATE);
        SharedPreferences.Editor editor=sharedPreferences.edit();
        editor.putBoolean("check", isChecked);
        editor.commit();
    }
    private boolean load()
    {
        SharedPreferences sharedPreferences=getPreferences(Context.MODE_PRIVATE);
        return  sharedPreferences.getBoolean("check",false);
    }*/
    public void newTask(View v)
    {
        Intent intent=new Intent(this,NewToDoActivity.class);
        startActivity(intent);
    }
}
