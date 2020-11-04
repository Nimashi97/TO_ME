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

public class NewRecipeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_recipe);
    }
    public void save(View v)
    {
        EditText etName= findViewById(R.id.name);
        String name = etName.getText().toString();
        EditText etIn= findViewById(R.id.ingredients);
        String ingredients = etIn.getText().toString();

        if (name.isEmpty())
        {
            Toast.makeText(this, "Please enter your food name", Toast.LENGTH_SHORT).show();
            return;
        }
        if (ingredients.isEmpty())
        {
            Toast.makeText(this, "Please enter your ingredients", Toast.LENGTH_SHORT).show();
            return;
        }

       // String date= new SimpleDateFormat("yyyy-MM-dd", Locale.getDefault()).format(new Date());

        TaskHelper th=new TaskHelper(this);
        SQLiteDatabase db=th.getWritableDatabase();
        String sql ="INSERT INTO recipe(name,ingredients) VALUES ('"+name+"','"+ingredients+"')";
        db.execSQL(sql);
        Toast.makeText(this, "Saved Successfully!", Toast.LENGTH_SHORT).show();


    }
    public void clear(View v)
    {
        EditText etName= findViewById(R.id.name);
        etName.setText("");
        EditText etIn= findViewById(R.id.ingredients);
        etIn.setText("");
    }
}
