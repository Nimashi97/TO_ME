package com.nimashi.tome;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class DiaryActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_diary);
    }
    @Override
    protected void onResume() {
        super.onResume();
        TaskHelper th4 = new TaskHelper(this);
        SQLiteDatabase db = th4.getReadableDatabase();
        String sql = "SELECT _id,note,date FROM diary";
        Cursor cursor = db.rawQuery(sql, null);

        List<String> list = new ArrayList<String>();
        cursor.moveToFirst();
        while (cursor.isAfterLast() == false) {

            String note = cursor.getString(0);
            String date = cursor.getString(1);

            list.add(note + "(" + date + ")");
            cursor.moveToNext();
        }
        ListView listView = findViewById(R.id.diary_list);
        int layout = R.layout.one_diary;
        String[] columns = {"note", "date", "_id"};
        int[] labels = {R.id.note_name, R.id.note_date, R.id.note_id};
        SimpleCursorAdapter adapter = new SimpleCursorAdapter(this, layout, cursor, columns, labels);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int i, long id) {
                TextView t= findViewById(R.id.note_name);
                // String note=t.getText().toString();
                //TextView id1= findViewById(R.id.note_id);
                // String nId=id1.getText().toString();
                int x= i+1;
                //int y=i+2;
                String note=Integer.toString(x);
                // String date=Integer.toString(y);
                Intent intent=new Intent(DiaryActivity.this,EditDiaryActivity.class);
                intent.putExtra("NOTE",note);
                //intent.putExtra("DATE",date);
                startActivity(intent);

                Toast.makeText(DiaryActivity.this, "Ok", Toast.LENGTH_SHORT).show();

            }
        });

    }
    public void newDiary(View v)
    {
        Intent intent=new Intent(this,NewDiaryActivity.class);
        startActivity(intent);
    }
}
