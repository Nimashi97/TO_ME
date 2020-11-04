package com.nimashi.tome;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;
import android.widget.TextView;
import android.widget.Toast;



import java.util.ArrayList;
import java.util.List;

public class NotesActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notes);

    }
    @Override
    protected void onResume() {
        super.onResume();
        TaskHelper th = new TaskHelper(this);
        SQLiteDatabase db = th.getReadableDatabase();
        String sql = "SELECT _id,note,date FROM notes";
        Cursor cursor = db.rawQuery(sql, null);

        List<String> list = new ArrayList<String>();
        cursor.moveToFirst();
        while (cursor.isAfterLast() == false) {
            String note = cursor.getString(0);
            String date = cursor.getString(1);
            list.add(note + "(" + date + ")");
            cursor.moveToNext();
        }
        ListView listView  =  findViewById(R.id.note_list);
        int layout = R.layout.one_note;
        String[] columns= {"note", "date","_id"};
        int[] labels={ R.id.note_name,R.id.note_date,R.id.note_id };
        SimpleCursorAdapter adapter=new SimpleCursorAdapter(this, layout,cursor,columns,labels);
        listView.setAdapter(adapter);
        listView.setDivider(null);

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
                Intent intent=new Intent(NotesActivity.this,EditNoteActivity.class);
                intent.putExtra("NOTE",note);
                //intent.putExtra("DATE",date);
                startActivity(intent);

                Toast.makeText(NotesActivity.this, "Ok", Toast.LENGTH_SHORT).show();

            }
        });


     /*   SwipeMenuCreator creator = new SwipeMenuCreator() {

            @Override
            public void create(SwipeMenu menu) {
                // create "open" item
                SwipeMenuItem openItem = new SwipeMenuItem(
                        getApplicationContext());
                // set item background
                openItem.setBackground(new ColorDrawable(Color.rgb(0xC9, 0xC9,
                        0xCE)));
                // set item width
                openItem.setWidth(170);
                // set item title
                openItem.setTitle("Open");
                // set item title fontsize
                openItem.setTitleSize(18);
                // set item title font color
                openItem.setTitleColor(Color.WHITE);
                // add to menu
                menu.addMenuItem(openItem);

                // create "delete" item
                SwipeMenuItem deleteItem = new SwipeMenuItem(
                        getApplicationContext());
                // set item background
                deleteItem.setBackground(new ColorDrawable(Color.rgb(0xF9,
                        0x3F, 0x25)));
                // set item width
                deleteItem.setWidth(170);
                // set a icon
                deleteItem.setIcon(R.drawable.recipe);
                // add to menu
                menu.addMenuItem(deleteItem);
            }
        };

// set creator
        listView.setMenuCreator(creator);
        listView.setOnMenuItemClickListener(new SwipeMenuListView.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(int position, SwipeMenu menu, int index) {
                switch (index) {
                    case 0:
                        Toast.makeText(this,"Ok",Toast.L)
                        break;
                    case 1:
                        // delete
                        break;
                }
                // false : close the menu; true : not close the menu
                return false;
            }
        });*/


    }
    public void newNote(View v)
    {
        Intent intent=new Intent(this,NewNoteActivity.class);
        startActivity(intent);
    }
}
