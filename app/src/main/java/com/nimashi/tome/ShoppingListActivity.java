package com.nimashi.tome;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;
import android.widget.TextView;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

public class ShoppingListActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shopping_list);
    }
    @Override
    protected void onResume() {
        super.onResume();
        TaskHelper th = new TaskHelper(this);
        SQLiteDatabase db = th.getReadableDatabase();
        String sql = "SELECT _id,name FROM shopList";
        Cursor cursor = db.rawQuery(sql, null);

        List<String> list = new ArrayList<String>();
        cursor.moveToFirst();
        while (cursor.isAfterLast() == false) {
            String name = cursor.getString(0);

            list.add(name);
            cursor.moveToNext();
        }
        ListView lv = findViewById(R.id.item_list);
        int layout = R.layout.one_item;
        String[] columns= {"name","_id"};
        int[] labels={ R.id.item_name,R.id.item_id };
        SimpleCursorAdapter adapter=new SimpleCursorAdapter(this, layout,cursor,columns,labels);
        lv.setAdapter(adapter);

       /* lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                TextView t= findViewById(R.id.item_name);
                String note=t.getText().toString();
                Intent intent=new Intent(ShoppingListActivity.this,EditNoteActivity.class);
                intent.putExtra("NOTE",note);
                startActivity(intent);

                Toast.makeText(NotesActivity.this, "Ok", Toast.LENGTH_SHORT).show();

            }
        });*/





    }

    public void newShoppingList(View v)
    {
        Intent intent=new Intent(this,NewShoppingActivity.class);
        startActivity(intent);
    }
}
