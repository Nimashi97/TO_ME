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

public class NewShoppingActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_shopping);
    }
    public void save(View v)
    {
        EditText etName= findViewById(R.id.item_name);
        String name = etName.getText().toString();

        if (name.isEmpty())
        {
            Toast.makeText(this, "Please add item", Toast.LENGTH_SHORT).show();
            return;
        }



        TaskHelper th2=new TaskHelper(this);
        SQLiteDatabase db=th2.getWritableDatabase();
        String sql ="INSERT INTO shopList(name) VALUES ('"+name+"')";
        db.execSQL(sql);
        Toast.makeText(this, "Saved Successfully!", Toast.LENGTH_SHORT).show();


    }
    public void clear(View v)
    {
        EditText etName= findViewById(R.id.item_name);
        etName.setText("");
    }
}
