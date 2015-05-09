package com.luismiguelopes.whowantstobemillionaire.whowantstobemillionaireapp.provider;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;

/**
 * Created by luismiguelopes on 08/05/15.
 */
public class Database extends SQLiteOpenHelper {



    public Database(Context context)

    {

        super(context, "questions.db", null, 1);

    }

    @Override

    public void onCreate(SQLiteDatabase db) {

        String questions = "CREATE TABLE questions(id text,questions text)";

        db.execSQL(questions);

    }

    @Override

    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    public void insertData(String id,String questions)

    {

        SQLiteDatabase sqLiteDatabase=this.getWritableDatabase();

        ContentValues values = new ContentValues();

        values.put("id", id);

        values.put("questions", questions);

        sqLiteDatabase.insert("questions",null,values);

    }

    public ArrayList fetchData()

    {

        ArrayList<String>stringArrayList=new ArrayList<String>();

        String fetchdata="SELECT * FROM questions";

        SQLiteDatabase sqLiteDatabase=this.getReadableDatabase();

        Cursor cursor = sqLiteDatabase.rawQuery(fetchdata, null);

        if(cursor.moveToFirst()){

            do

            {

                stringArrayList.add(cursor.getString(0));

                stringArrayList.add(cursor.getString(1));

            } while (cursor.moveToNext());

        }

        return stringArrayList;

    }

}