package com.nimashi.tome;

import androidx.appcompat.app.AppCompatActivity;

import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

public class NewToDoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_to_do);
    }
    public void save(View v)
    {
        EditText etName= findViewById(R.id.task_name);
        String name = etName.getText().toString();

        if (name.isEmpty())
        {
            Toast.makeText(this, "Please enter your task", Toast.LENGTH_SHORT).show();
            return;
        }

        String date= new SimpleDateFormat("yyyy-MM-dd", Locale.getDefault()).format(new Date());

        TaskHelper th=new TaskHelper(this);
        SQLiteDatabase db=th.getWritableDatabase();
        String sql ="INSERT INTO tasks(name,date) VALUES ('"+name+"','"+date+"')";
        db.execSQL(sql);
        Toast.makeText(this, "Saved Successfully!", Toast.LENGTH_SHORT).show();


    }
    public void clear(View v)
    {
        EditText etName= findViewById(R.id.task_name);
        etName.setText("");
    }

}
