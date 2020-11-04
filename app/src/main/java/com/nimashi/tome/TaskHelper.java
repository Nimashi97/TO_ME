package com.nimashi.tome;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class TaskHelper extends SQLiteOpenHelper {

    public TaskHelper(Context context)
    {
        super(context,"dbtasks",null,1);

    }
    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String sqlTwo="CREATE TABLE notes (_id INTEGER PRIMARY KEY AUTOINCREMENT, note TEXT, date DATE)";
        String sqlThree="CREATE TABLE shopList (_id INTEGER PRIMARY KEY AUTOINCREMENT, name TEXT)";
        String sqlFour="CREATE TABLE diary (_id INTEGER PRIMARY KEY AUTOINCREMENT, note TEXT, date DATE)";
        String sqlFive="CREATE TABLE recipe (_id INTEGER PRIMARY KEY AUTOINCREMENT, name TEXT, ingredients TEXT)";
        String sqlOne="CREATE TABLE tasks (_id INTEGER PRIMARY KEY AUTOINCREMENT, name TEXT, date DATE)";



        sqLiteDatabase.execSQL(sqlOne);
        sqLiteDatabase.execSQL(sqlTwo);
        sqLiteDatabase.execSQL(sqlThree);
        sqLiteDatabase.execSQL(sqlFour);
        sqLiteDatabase.execSQL(sqlFive);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int oldVersion, int newVersion)//vertion eke movement athara wenaskam
    {

    }

}
