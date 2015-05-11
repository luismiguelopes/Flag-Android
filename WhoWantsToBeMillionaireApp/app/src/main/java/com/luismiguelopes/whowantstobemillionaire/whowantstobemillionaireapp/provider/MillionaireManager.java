package com.luismiguelopes.whowantstobemillionaire.whowantstobemillionaireapp.provider;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;

import com.luismiguelopes.whowantstobemillionaire.whowantstobemillionaireapp.model.Question;

import java.util.ArrayList;

/**
 * Created by luismiguelopes on 04/05/15.
 */
public class MillionaireManager {

    private Context _context;
    public MillionaireManager(Context context)
    {
        _context = context;
    }

    /**
     * Store Answers in database.
     * @param question
     */
    public void save(Question question) {
        ContentValues values = new ContentValues();
           // values.put(MillionaireContract.VALUE, question.getValue());
        _context.getContentResolver().insert(MillionaireProvider.CONTENT_URI, values);
    }



    /**
     * Get all temperatures stored in database.
     * @return list of answers
     */
    public ArrayList<Question> getAll()
    {
        Cursor cursor = _context.getContentResolver().query(MillionaireProvider.CONTENT_URI, null, null, null, null);
        ArrayList<Question> questions = new ArrayList<>();
        while(cursor.moveToNext())
        {
            questions.add(new Question(cursor.getInt(cursor.getColumnIndex(MillionaireContract._ID)),
                                        cursor.getString(cursor.getColumnIndex(MillionaireContract.VALUE))


            ));
        }
        cursor.close();
        return questions;
    }



    }

