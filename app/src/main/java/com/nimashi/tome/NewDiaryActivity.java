package com.nimashi.tome;

import androidx.appcompat.app.AppCompatActivity;

import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class NewDiaryActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_diary);
    }
    public void save(View v)
    {
        EditText etName= findViewById(R.id.note);

        String note = etName.getText().toString();


        String date= new SimpleDateFormat("yyyy-MM-dd", Locale.getDefault()).format(new Date());

        TaskHelper th3=new TaskHelper(this);
        SQLiteDatabase db=th3.getWritableDatabase();
        String sql ="INSERT INTO diary(note,date) VALUES ('"+note+"','"+date+"')";
        db.execSQL(sql);
        Toast.makeText(this, "Saved Successfully!", Toast.LENGTH_SHORT).show();


    }
    public void clear(View v)
    {
        EditText etName= findViewById(R.id.note);
        etName.setText("");
    }
}
