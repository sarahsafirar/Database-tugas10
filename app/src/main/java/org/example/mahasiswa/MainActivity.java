package org.example.mahasiswa;

import androidx.appcompat.app.AppCompatActivity;


import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private DbHelper dbHelper;
    private EditText edittext;
    private TextView text;
    private ArrayList<String> list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        dbHelper = new DbHelper(this);
        edittext = findViewById(R.id.edit1);
        text = findViewById(R.id.text1);

    }
    public void insertData(View view) {
        String nama = edittext.getText().toString();
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        ContentValues nilai = new ContentValues();
        nilai.put(DbHelper.KEY_NAME,nama);
        long id = db.insert(DbHelper.TABLE_STUDENTS, null, nilai);
        if (nama.matches("")) {
            Toast.makeText(MainActivity.this, "Kolom harus diisi", Toast.LENGTH_SHORT).show();
            Log.d("DATABASE", "Id data " + id);
        }
        else{
            Toast.makeText(MainActivity.this, "Data berhasil disimpan", Toast.LENGTH_SHORT).show();
        }

    }

    public void tampilData(View view) {
        ArrayList<String> data = new ArrayList<String>();
        SQLiteDatabase db = dbHelper.getReadableDatabase();
        String query = "SELECT * FROM " + DbHelper.TABLE_STUDENTS;
        Cursor c = db.rawQuery(query, null);

            while (c.moveToNext()){
            data.add(c.getString(c.getColumnIndex(DbHelper.KEY_NAME)));
            }
            c.close();


            String hasil = "";
          for (int i = 0; i < data.size(); i++) {
              hasil += data.get(i) +",";
          }
          text.setText(hasil);



        }
    }
