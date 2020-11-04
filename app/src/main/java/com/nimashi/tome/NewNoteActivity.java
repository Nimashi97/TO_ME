package com.nimashi.tome;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ActionBar;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class NewNoteActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_note);

    }


    public void save(View v)
    {
        EditText etName= findViewById(R.id.note);
        String note = etName.getText().toString();

        String date= new SimpleDateFormat("yyyy-MM-dd", Locale.getDefault()).format(new Date());

        TaskHelper th1=new TaskHelper(this);
        SQLiteDatabase db=th1.getWritableDatabase();
        String sql ="INSERT INTO notes(note,date) VALUES ('"+note+"','"+date+"')";
        db.execSQL(sql);
        Toast.makeText(this, "Saved Successfully!", Toast.LENGTH_SHORT).show();
        Intent intent=new Intent(NewNoteActivity.this,NotesActivity.class);
        startActivity(intent);


    }
    public void clear(View v)
    {
        EditText etName= findViewById(R.id.note);
        etName.setText("");
    }

}
