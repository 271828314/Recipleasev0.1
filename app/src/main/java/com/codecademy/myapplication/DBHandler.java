package com.codecademy.myapplication;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DBHandler extends SQLiteOpenHelper {
    private static final int DB_VERSION = 1;
    private static final String DB_NAME = "RecipeData";
    public static final String TABLE_USER = "LoginInformation";

    public static final String KEY_USER = "Username";

    public DBHandler(Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String createTableString = "CREATE TABLE "
                + TABLE_USER + "("
                + KEY_USER + " TEXT PRIMARY KEY, " + KEY_PUBLISHER + " TEXT, " + KEY_AUTHOR
                + " TEXT," + KEY_YEAR + " TEXT, " + KEY_IMAGE + " TEXT" + ")";
        db.execSQL(createTableString);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVer, int newVer) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_BOOK_INVENTORY);
        onCreate(db);
    }

    void clearDatabase() {
        onUpgrade(this.getWritableDatabase(),0,0);
    }
}