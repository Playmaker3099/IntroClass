package com.example.introclass;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DBHelper extends SQLiteOpenHelper {
    private static  final  String  DATABASE_NAME = "roboDB";
    private static final int DATABASE_VERSION = 1;

    /**
     * Drop Table IF Exists Robotab
     * Create Table Robotab(
     * RoboID int ,
     * RoboName varchar(50),
     * )
     *  We're going to mimic this SQL structure in Java
     **/

    private static final String TABLE_ROBOT = "robtab";//robtab = robot +table
    private static final String COLUMN_ID = "id";
    private static final String COLUMN_NAME = "roboName";
    public DBHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    /** the onCreate creates our DB
     * it will be called whenever our DBHelper class is instantiated
     *
     **/
    @Override
    public void onCreate(SQLiteDatabase db) {
        String createTable = "CREATE TABLE " + TABLE_ROBOT + "(" +
                COLUMN_ID + "INTEGER PRIMARY KEY AUTOINCREMENT," +
                COLUMN_NAME + " TEXT " + ");";

        db.execSQL(createTable);
    }

    /**onUpgrade is called when our DB is changed. THe old one is deleted and its
     recreated with the new data
     **/
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_ROBOT);
        onCreate(db);
    }

    //insert record
    /**When inserting a record, we get a writetable DB which gives us access
    to the SQLite DB object to write into
     The ContentValues object represents a row of information that will be
     inserted into the database
     **/
    public boolean insertRecord(String name){
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COLUMN_NAME,name);

        long result = sqLiteDatabase.insert(TABLE_ROBOT, null,contentValues);

        return result != -1;
    }

}
