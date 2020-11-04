package com.nimashi.tome;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class EditDiaryActivity extends AppCompatActivity {
    EditText etNote;
    private static final String TABLE = "diary";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_diary);
    }

    @Override
    protected void onResume() {
        super.onResume();
        etNote = findViewById(R.id.note);
        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();
        String note = bundle.getString("NOTE");
        // String date=bundle.getString("DATE");
        int x = Integer.parseInt(note);
        Toast.makeText(EditDiaryActivity.this, "Ok" + x, Toast.LENGTH_SHORT).show();

        TaskHelper th = new TaskHelper(this);
        SQLiteDatabase db = th.getReadableDatabase();

        String sql = "SELECT note FROM " + TABLE + " WHERE _id = " + x;
        Cursor cursor = db.rawQuery(sql, null);
        cursor.moveToFirst();

        String note1 = cursor.getString(0);
        etNote.setText(note1);


    }
}
   /* public void Delete(View v)
    {
        etNote= findViewById(R.id.note);
        Intent intent=getIntent();
        Bundle bundle=intent.getExtras();
        String note=bundle.getString("NOTE");
        // String date=bundle.getString("DATE");
        int x=Integer.parseInt(note);
        //Toast.makeText(EditDiaryActivity.this, "Ok"+x, Toast.LENGTH_SHORT).show();

        TaskHelper th=new TaskHelper(this);
        SQLiteDatabase db=th.getReadableDatabase();

        String sql="DELETE FROM " +TABLE + " WHERE _id = " + x;
        Cursor cursor=db.rawQuery(sql,null);
        cursor.moveToFirst();
        Toast.makeText(this, "Deleted", Toast.LENGTH_SHORT).show();

    }*/

   /* public void update(View v)
    {
        EditText etName= findViewById(R.id.note);
        String note = etName.getText().toString();
        Intent intent=getIntent();
        Bundle bundle=intent.getExtras();
        String new_note=bundle.getString("NOTE");
        // String date=bundle.getString("DATE");
        int x=Integer.parseInt(new_note);

        //String date= new SimpleDateFormat("yyyy-MM-dd", Locale.getDefault()).format(new Date());

     /*  TaskHelper th1=new TaskHelper(this);
        SQLiteDatabase db=th1.getWritableDatabase();
        ContentValues contentValues=new ContentValues();
        contentValues.put("NOTE",note);
        String whereClause =" id =?";
        String whereArgs[] = {String.valueOf(x)};

        db.update(TABLE,contentValues,whereClause,whereArgs);

*/

       /* Toast.makeText(this, "Update Successfully!", Toast.LENGTH_SHORT).show();



    }*/

