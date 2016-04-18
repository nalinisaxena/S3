package com.example.nalini.Smart_Service_Shipment;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import android.widget.ListView;

public class DataListActivity extends AppCompatActivity {

    ListView listView;
    SQLiteDatabase sqLiteDatabase;
    UserDbHelper userDbHelper;
    Cursor cursor;
    ListDataAdapter listDataAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.data_list_layout);

        listView = (ListView)findViewById(R.id.list_item);

        listDataAdapter=new ListDataAdapter(getApplicationContext(),R.layout.row_layout);
        listView.setAdapter(listDataAdapter);

        userDbHelper = new UserDbHelper(getApplicationContext());

        sqLiteDatabase = userDbHelper.getReadableDatabase();

        cursor = userDbHelper.getInformation(sqLiteDatabase);

        if (cursor.moveToFirst()) {
            do {
                String name,mob,email,paddress,taddress;
                name=cursor.getString(0);
                mob=cursor.getString(1);
                email=cursor.getString(2);
                paddress=cursor.getString(3);
                taddress=cursor.getString(4);


                DataProvider dataProvider=new DataProvider(name,mob,email,paddress,taddress);
                listDataAdapter.add(dataProvider);
            } while (cursor.moveToNext());
        }
    }

}