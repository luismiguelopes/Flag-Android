package com.luismiguelopes.whowantstobemillionaire.whowantstobemillionaireapp.provider;

import android.content.ContentProvider;
import android.content.ContentResolver;
import android.content.ContentUris;
import android.content.ContentValues;
import android.content.Context;
import android.content.UriMatcher;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.net.Uri;

public class MillionaireProvider extends ContentProvider {

    // provider identifier
    private static final String AUTHORITY = "com.luismiguelopes.whowantstobemillionaire.whowantstobemillionaireapp.provider;";

    // The content: scheme identifies the URI as a content URI pointing to an Android content provider.
    public static final Uri CONTENT_URI = Uri.parse(ContentResolver.SCHEME_CONTENT + "://" + AUTHORITY);

    // Matcher for see if the type is one element or all elements.
    private static UriMatcher URIMATCHER = new UriMatcher(UriMatcher.NO_MATCH);
    private static final int TEMPERATURE_ID  = 1;
    private static final int TEMPERATURE_ALL = 2;

    private static final String MIME_ALL = "vnd.android.cursor.dir/vnd.android.flag.pt.challenge_it.temperatureapp.provider." + MillionaireContract.TABLE;
    private static final String MIME_ONE = "vnd.android.cursor.item/vnd.android.flag.pt.challenge_it.temperatureapp.provider." + MillionaireContract.TABLE;

    // DB Helper instance for access to SQLite DB.
    private SQLiteOpenHelper helper;

    static
    {
        URIMATCHER.addURI(AUTHORITY, MillionaireContract.TABLE+"/#", TEMPERATURE_ID);
        URIMATCHER.addURI(AUTHORITY, MillionaireContract.TABLE, TEMPERATURE_ALL);
    }

    @Override
    public boolean onCreate() {
        helper = new TemperatureHelper(getContext());
        return true;
    }

    @Override
    public String getType(Uri uri)
    {
        return URIMATCHER.match(uri) == TEMPERATURE_ALL ? MIME_ALL : MIME_ONE;
    }

    @Override
    public Uri insert(Uri uri, ContentValues values)
    {
        SQLiteDatabase db = helper.getWritableDatabase();
        try
        {
            long row = db.insert(MillionaireContract.TABLE, null, values);
            return (row != -1) ? null : ContentUris.withAppendedId(uri, row);
        }
        finally
        {
            db.close();
        }
    }

    @Override
    public Cursor query(Uri uri, String[] projection, String selection,
                        String[] selectionArgs, String sortOrder)
    {
        SQLiteDatabase db = helper.getReadableDatabase();
        return db.query(MillionaireContract.TABLE, projection, selection, selectionArgs, null, null, sortOrder);
    }

    @Override
    public int update(Uri uri, ContentValues values, String selection,
                      String[] selectionArgs)
    {
        SQLiteDatabase db = helper.getWritableDatabase();
        try
        {
            return db.update(MillionaireContract.TABLE, values, selection, selectionArgs);
        }
        finally
        {
            db.close();
        }
    }

    @Override
    public int delete(Uri uri, String selection, String[] selectionArgs)
    {
        SQLiteDatabase db = helper.getWritableDatabase();
        try
        {
            return db.delete(MillionaireContract.TABLE, selection, selectionArgs);
        }
        finally
        {
            db.close();
        }
    }

    /**
     * DB helper for Temperatures. The DB is an SQLite data base.
     *
     * @pt Criação da base de dados com a tabela TEMPERATURE.
     * @author Challenge.IT
     */
    private static class TemperatureHelper extends SQLiteOpenHelper
    {
        public TemperatureHelper(Context context)
        {
            super(context, "temperature.sql", null, 1);
        }

        @Override
        public void onCreate(SQLiteDatabase sqLiteDatabase)
        {
            String columns = MillionaireContract._ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                    MillionaireContract.VALUE + " REAL NOT NULL";

            String sql = "CREATE TABLE IF NOT EXISTS " + MillionaireContract.TABLE + " (" + columns + ")";
            sqLiteDatabase.execSQL(sql);
        }

        @Override
        public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i2)
        {
            // no need to implement this method, just when we want to update the database
        }
    }
}