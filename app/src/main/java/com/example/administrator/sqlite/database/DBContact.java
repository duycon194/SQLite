package com.example.administrator.sqlite.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

import com.example.administrator.sqlite.model.Contact;

import java.util.ArrayList;
import java.util.List;
import java.util.jar.Attributes;

/**
 * Created by Administrator on 10/03/2018.
 */

public class DBContact extends SQLiteOpenHelper {
    private Context context;
    private static final String DATABASE_NAME = "contact";
    private static final String TABLE_NAME = "contact_table";
    private static final String ID = "id";
    private static final String CONTACT_NAME = "contact_name";
    private static final String CONTACT_NUMBER = "contact_number";
    private static final int version = 1;

    public DBContact(Context context) {
        super(context, DATABASE_NAME, null, version);
        this.context = context;
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String Querry_create_table = "CREATE TABLE IF NOT EXISTS "+TABLE_NAME+"( "+
                ID+" INT PRIMARY KEY, "+
                CONTACT_NAME+" TEXT, "+
                CONTACT_NUMBER+" TEXT )";
        sqLiteDatabase.execSQL(Querry_create_table);
        Toast.makeText(context, "Create Table Successfully", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }

    public void addContact(Contact contact) {
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(CONTACT_NAME,contact.getmName());
        values.put(CONTACT_NUMBER,contact.getmNumber());
        sqLiteDatabase.insert(TABLE_NAME,null,values);
        sqLiteDatabase.close();
        Toast.makeText(context, "addContact Successfully", Toast.LENGTH_SHORT).show();
    }

    public List<Contact> getAllContact() {
        List<Contact> list = new ArrayList<>();
        String Sql_select_all = "SELECT * FROM "+TABLE_NAME;
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(Sql_select_all,null);
        if (cursor.moveToFirst()){
            do{
                Contact contact = new Contact();
                contact.setmID(cursor.getInt(0));
                contact.setmName(cursor.getString(1));
                contact.setmNumber(cursor.getString(2));
                list.add(contact);
            }while (cursor.moveToNext());
        }
        db.close();
        return list;
    }
}
