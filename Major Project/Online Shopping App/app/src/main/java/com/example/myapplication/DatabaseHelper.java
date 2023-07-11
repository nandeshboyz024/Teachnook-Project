package com.example.myapplication;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.Objects;

public class DatabaseHelper extends SQLiteOpenHelper {

    // Database Version
    private static  final int DATABASE_VERSION =1;
    // Database Name
    private static final String DATABASE_NAME = "UserManager.db";
    // Database table name
    private  static final String Table_USER = "user";
    // User table columns names
    private static final String COLUMNS_USER_ID = "user_id";
    private static final String COLUMNS_USER_NAME = "user_name";
    private static final String COLUMNS_USER_EMAIL = "user_email";
    private static final String COLUMNS_USER_PASSWORD = "password";

//    private  static final String Table_ITEM = "item";
//    // User table columns names
//    private static final String COLUMNS_ITEM_ID = "item_id";
//    private static final String COLUMNS_ITEM_NAME = "item_name";
//    private static final String COLUMNS_ITEM_PRICE = "item_price";
//    private static final String COLUMNS_ITEM_IMAGE = "item_image";





    // CREATE TABLE user(user_id INTEGER,user_name TEXT,user_email TEXT,user_password TEXT);



    public DatabaseHelper(Context context){
        super(context,DATABASE_NAME,null,DATABASE_VERSION);
    }

    String CREATE_USER_TABLE = "CREATE TABLE " + Table_USER + "(" + COLUMNS_USER_ID + " INTEGER PRIMARY KEY AUTOINCREMENT," + COLUMNS_USER_NAME + " TEXT," + COLUMNS_USER_EMAIL + " TEXT," + COLUMNS_USER_PASSWORD + " TEXT" + ")";

   // String CREATE_USER_TABLE2 = "CREATE TABLE " + Table_ITEM + "(" + COLUMNS_ITEM_ID + " INTEGER PRIMARY KEY AUTOINCREMENT,"+ COLUMNS_ITEM_NAME + " TEXT," + COLUMNS_ITEM_PRICE + " TEXT," + COLUMNS_ITEM_IMAGE + " INTEGER" + ")";


    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {

        sqLiteDatabase.execSQL(CREATE_USER_TABLE);
       // sqLiteDatabase.execSQL(CREATE_USER_TABLE2);

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        String DROP_USER_TABLE = "DROP TABLE IF EXISTS " + Table_USER;
        sqLiteDatabase.execSQL(DROP_USER_TABLE);
//        String DROP_USER_TABLE2 = "DROP TABLE IF EXISTS " + Table_ITEM;
//        sqLiteDatabase.execSQL(DROP_USER_TABLE2);

          onCreate(sqLiteDatabase);


    }
    public  boolean checkUser(String email){
        String[] columns = {
                COLUMNS_USER_ID
        };
        SQLiteDatabase db = this.getReadableDatabase();
        String selection = COLUMNS_USER_EMAIL + " = ?" ;

        String[] selectionArgs ={email};

        Cursor cursor = db.query(Table_USER,columns,selection,selectionArgs,null,null,null);
        int cursorCount = cursor.getCount();
        cursor.close();
        db.close();
        return cursorCount > 0;
     }

     public void addUser(User user){
        SQLiteDatabase db = this.getWritableDatabase();
         ContentValues values = new ContentValues();
         values.put(COLUMNS_USER_NAME,user.getName());
         values.put(COLUMNS_USER_EMAIL,user.getEmail());
         values.put(COLUMNS_USER_PASSWORD,user.getPassword());

         db.insert(Table_USER,null,values);
         db.close();
    }
//    public void addItem(String s_name, String r_price,int img_id){
//        SQLiteDatabase db = this.getWritableDatabase();
//        ContentValues values = new ContentValues();
//        values.put(COLUMNS_ITEM_NAME,s_name);
//        values.put(COLUMNS_ITEM_PRICE,r_price);
//        values.put(COLUMNS_ITEM_IMAGE,img_id);
//
//        db.insert(Table_ITEM,null,values);
//        db.close();
//    }

//    public void addItems(ArrayList<CustomListPOJO> arr_bean)
//    {    SQLiteDatabase db = this.getReadableDatabase();
//        Cursor cursor = db.rawQuery("select * from item",null);
//        if(cursor==null){
//
//            cursor.close();;
//            db.close();
//            return;
//        }
//        while(cursor.moveToNext()){
//              arr_bean.add(new CustomListPOJO(cursor.getInt(3),cursor.getString(1),cursor.getString(2)));
//            }
//        cursor.close();;
//        db.close();
//
//    }



    public boolean checkUserData(String email,String password){
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery("select * from user where user_email = ? and password = ?",new String[]{email,password});
        int cursorCount = cursor.getCount();
        cursor.close();;
        db.close();
        return cursorCount > 0;
    }

    public String findUserName(String email,String password){
        SQLiteDatabase db = this.getReadableDatabase();
        String str = null;
        Cursor cursor = db.rawQuery("select * from "+Table_USER,null);
        while(cursor.moveToNext()){
            if( (Objects.equals(cursor.getString(2), email)) &&(Objects.equals(cursor.getString(3), password))){
                str = cursor.getString(1);
                break;
            }

        }
        cursor.close();
        db.close();
        return str;
    }

}
