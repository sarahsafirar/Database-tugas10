package org.example.mahasiswa;


import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DbHelper extends SQLiteOpenHelper {

    static final String KEY_NAME = "nama";
    static final String TABLE_STUDENTS = "student";
    private static final String DATABASE_NAME = "mahasiswa.db";
    private static final int DATABASE_VERSION = 1;
    private static final String KEY_ID = "id";

    private static final  String CREATE_TABLE_STUDENTS = "CREATE TABLE " +  TABLE_STUDENTS + " (" +
            KEY_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " + KEY_NAME + " TEXT);";

    public DbHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) { db.execSQL(CREATE_TABLE_STUDENTS);}

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS '" + TABLE_STUDENTS + "'");
        onCreate(db);

    }
}
