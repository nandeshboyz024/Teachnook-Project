package com.example.myapplication;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import java.util.ArrayList;

public class Data extends SQLiteOpenHelper {

    // Database Version
    private static  final int DATABASE_VERSION =1;
    // Database Name
    private static final String DATABASE_NAME = "ItemManager.db";
    private  static final String Table_ITEM = "item";
        // User table columns names
    private static final String COLUMNS_ITEM_ID = "item_id";
    private static final String COLUMNS_ITEM_NAME = "item_name";
    private static final String COLUMNS_ITEM_PRICE = "item_price";
    private static final String COLUMNS_ITEM_IMAGE = "item_image";

    public Data(@Nullable Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    String CREATE_USER_TABLE2 = "CREATE TABLE " + Table_ITEM + "(" + COLUMNS_ITEM_ID + " INTEGER PRIMARY KEY AUTOINCREMENT,"+ COLUMNS_ITEM_NAME + " TEXT," + COLUMNS_ITEM_PRICE + " TEXT," + COLUMNS_ITEM_IMAGE + " INTEGER" + ")";
    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {


        sqLiteDatabase.execSQL(CREATE_USER_TABLE2);
    }


    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        String DROP_USER_TABLE2 = "DROP TABLE IF EXISTS " + Table_ITEM;
      sqLiteDatabase.execSQL(DROP_USER_TABLE2);

        onCreate(sqLiteDatabase);

    }


    public void addItem(String s_name, String r_price,int img_id){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(COLUMNS_ITEM_NAME,s_name);
        values.put(COLUMNS_ITEM_PRICE,r_price);
        values.put(COLUMNS_ITEM_IMAGE,img_id);

        db.insert(Table_ITEM,null,values);
        db.close();
    }

    public void addItems(ArrayList<CustomListPOJO> arr_bean)
    {    SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery("select * from item",null);
        if(cursor==null){

            cursor.close();;
            db.close();
            return;
        }
        while(cursor.moveToNext()){
              arr_bean.add(new CustomListPOJO(cursor.getInt(3),cursor.getString(1),cursor.getString(2)));
            }
        cursor.close();;
        db.close();

    }
    public void deleteItems()
    {    SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery("select * from item",null);
        if(cursor==null){

            cursor.close();;
            db.close();
            return;
        }
        while(cursor.moveToNext()){
           db.delete(Table_ITEM,null,null);
        }
        cursor.close();;
        db.close();

    }


    }
