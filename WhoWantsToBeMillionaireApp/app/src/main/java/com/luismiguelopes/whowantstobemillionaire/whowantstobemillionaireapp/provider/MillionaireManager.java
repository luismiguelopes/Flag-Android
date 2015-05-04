package com.luismiguelopes.whowantstobemillionaire.whowantstobemillionaireapp.provider;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;

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
     * Store temperature in database.
     * @param temperature
     */
    public void save(Answers answers)
    {
        ContentValues values = new ContentValues();
        values.put(MillionaireContract.VALUE, answers.getValue());
        _context.getContentResolver().insert(MillionaireProvider.CONTENT_URI, values);
    }

    /**
     * Get all temperatures stored in database.
     * @return list of temperatures
     */
    public ArrayList<Answers> getAll()
    {
        Cursor cursor = _context.getContentResolver().query(MillionaireProvider.CONTENT_URI, null, null, null, null);
        ArrayList<Answers> temperatures = new ArrayList<>();
        while(cursor.moveToNext())
        {
            temperatures.add(new Answers(cursor.getDouble(cursor.getColumnIndex(MillionaireContract.VALUE))));
        }
        cursor.close();
        return temperatures;
    }

}
