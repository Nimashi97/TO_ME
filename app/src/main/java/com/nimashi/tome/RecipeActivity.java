package com.nimashi.tome;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;

import java.util.ArrayList;
import java.util.List;

public class RecipeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recipe);
    }
    @Override
    protected void onResume() {
        super.onResume();
        TaskHelper th4 = new TaskHelper(this);
        SQLiteDatabase db = th4.getReadableDatabase();
        String sql = "SELECT _id,name,ingredients FROM recipe";
        Cursor cursor = db.rawQuery(sql, null);

        List<String> list = new ArrayList<String>();
        cursor.moveToFirst();
        while (cursor.isAfterLast() == false) {

            String name = cursor.getString(0);
            String ingredients = cursor.getString(1);

            list.add(name + "(" + ingredients + ")");
            cursor.moveToNext();
        }
        ListView listView = findViewById(R.id.recipe_list);
        int layout = R.layout.one_recipe;
        String[] columns = {"name", "ingredients", "_id"};
        int[] labels = {R.id.name, R.id.ingredients, R.id.recipe_id};
        SimpleCursorAdapter adapter = new SimpleCursorAdapter(this, layout, cursor, columns, labels);
        listView.setAdapter(adapter);

       /* listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                TextView t = findViewById(R.id.note_name);
                String note = t.getText().toString();
                TextView i = findViewById(R.id.note_id);
                String nId = i.getText().toString();
                Intent intent = new Intent(DiaryActivity.this, EditNoteActivity.class);
                intent.putExtra("NOTE", note);
                intent.putExtra("ID", nId);
                startActivity(intent);

                Toast.makeText(DiaryActivity.this, "Ok", Toast.LENGTH_SHORT).show();

            }
        });

*/

    }

    public void newRecipe(View v)
    {
        Intent intent=new Intent(RecipeActivity.this,NewRecipeActivity.class);
        startActivity(intent);
    }
}
