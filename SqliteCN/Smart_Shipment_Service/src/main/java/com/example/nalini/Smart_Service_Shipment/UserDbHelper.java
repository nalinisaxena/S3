package com.example.nalini.Smart_Service_Shipment;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;


public class UserDbHelper extends SQLiteOpenHelper {

    private static final String DATABASE_NAME="USERINFO.DB";
    private static final int DATABASE_VERSION=1;
    private static final String CREATE_QUERY="CREATE TABLE   " + UserContact.NewUserInfo.TABLE_NAME +
            "("+UserContact.NewUserInfo.USER_NAME+"  TEXT,"+UserContact.NewUserInfo.USER_MOB+"  TEXT,"+UserContact.NewUserInfo.USER_EMAIL+" TEXT,"+UserContact.NewUserInfo.USER_PADDRESS+"  TEXT,"+UserContact.NewUserInfo.USER_TADDRESS+" TEXT);";


    public UserDbHelper(Context context) {
        super(context,DATABASE_NAME,null,DATABASE_VERSION);

        Log.e("Database operation","Database created/opened....");


    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        db.execSQL(CREATE_QUERY);
        Log.e("Database Operation","Table created...");

    }

    public  void addInformation(String name, String mob,String email,String paddress,String taddress,SQLiteDatabase db)
    {
        ContentValues cv=new ContentValues();
        cv.put(UserContact.NewUserInfo.USER_NAME,name);
        cv.put(UserContact.NewUserInfo.USER_MOB,mob);
        cv.put(UserContact.NewUserInfo.USER_EMAIL,email);
        cv.put(UserContact.NewUserInfo.USER_PADDRESS,paddress);
        cv.put(UserContact.NewUserInfo.USER_TADDRESS,taddress);


        db.insert(UserContact.NewUserInfo.TABLE_NAME, null, cv);

        Log.e("Database Operation","One row is inserted");

    }

    public Cursor getInformation(SQLiteDatabase db)
    {
        Cursor cursor;
        String[] projection={UserContact.NewUserInfo.USER_NAME,UserContact.NewUserInfo.USER_MOB,UserContact.NewUserInfo.USER_EMAIL,UserContact.NewUserInfo.USER_PADDRESS,UserContact.NewUserInfo.USER_TADDRESS};

       cursor= db.query(UserContact.NewUserInfo.TABLE_NAME,projection,null,null,null,null,null);
        return cursor;

    }

    public Cursor getContact(String user_name,SQLiteDatabase sqLiteDatabase)
    {
         String[] projection={UserContact.NewUserInfo.USER_MOB,UserContact.NewUserInfo.USER_PADDRESS,UserContact.NewUserInfo.USER_TADDRESS};
        String selection=UserContact.NewUserInfo.USER_NAME +" LIKE ?" ;
        String[] selection_args={user_name};
        Cursor cursor=sqLiteDatabase.query(UserContact.NewUserInfo.TABLE_NAME,projection,selection,selection_args,null,null,null);
        return cursor;

    }

    public void deleteInformation(String user_name,SQLiteDatabase sqLiteDatabase) {
        String selection = UserContact.NewUserInfo.USER_NAME + " LIKE ?";
        String[] selection_args = {user_name};
        sqLiteDatabase.delete(UserContact.NewUserInfo.TABLE_NAME, selection, selection_args);
    }

public int updateInformation(String old_name,String new_name,String new_mobile,String new_email,String new_paddress,String new_taddress,SQLiteDatabase sqLiteDatabase)
{
  ContentValues contentValues=new ContentValues();
    contentValues.put(UserContact.NewUserInfo.USER_NAME,new_name);
    contentValues.put(UserContact.NewUserInfo.USER_MOB,new_mobile);
    contentValues.put(UserContact.NewUserInfo.USER_EMAIL,new_email);
    contentValues.put(UserContact.NewUserInfo.USER_PADDRESS,new_paddress);
    contentValues.put(UserContact.NewUserInfo.USER_TADDRESS,new_taddress);


    String selection=UserContact.NewUserInfo.USER_NAME +" LIKE ?";
    String[] selection_args={old_name};
   int count=sqLiteDatabase.update(UserContact.NewUserInfo.TABLE_NAME,contentValues,selection,selection_args);

return count;

}



    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
