package com.example.nalini.Smart_Service_Shipment;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;

import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import android.widget.Toast;


public class UpdateContactActivity extends AppCompatActivity {

    EditText name_search, new_name, new_mobile, new_email,new_paddress,new_taddress;


    String SearchName, NewName, NewMobile, NewEmail,NewPaddress,NewTaddress;
    UserDbHelper userDbHelper;
    SQLiteDatabase sqLiteDatabase;
    Button update;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.update_contact_activity);

        name_search = (EditText) findViewById(R.id.searchn);
        new_name = (EditText) findViewById(R.id.newn);
        new_mobile = (EditText) findViewById(R.id.newm);
        new_email = (EditText) findViewById(R.id.newe);
        new_paddress=(EditText)findViewById(R.id.newp);
        new_taddress=(EditText)findViewById(R.id.newt);



        update = (Button) findViewById(R.id.updaten);

        new_name.setVisibility(View.GONE);
        new_mobile.setVisibility(View.GONE);
        new_email.setVisibility(View.GONE);
        new_paddress.setVisibility(View.GONE);
        new_taddress.setVisibility(View.GONE);


        update.setVisibility(View.GONE);
    }

    public void searchContact(View view) {
        SearchName = name_search.getText().toString();
        userDbHelper = new UserDbHelper(getApplicationContext());
        sqLiteDatabase = userDbHelper.getReadableDatabase();
        Cursor cursor = userDbHelper.getContact(SearchName, sqLiteDatabase);
        if (cursor.moveToFirst()) {
            NewMobile = cursor.getString(0);
            NewEmail = cursor.getString(1);
            NewPaddress=cursor.getString(2);
            NewTaddress=cursor.getString(3);


            NewName = SearchName;
            new_name.setText(NewName);
            new_mobile.setText(NewMobile);
            new_email.setText(NewEmail);
            new_paddress.setText(NewPaddress);
            new_taddress.setText(NewTaddress);



            new_name.setVisibility(View.VISIBLE);
            new_mobile.setVisibility(View.VISIBLE);
            new_email.setVisibility(View.VISIBLE);
            new_paddress.setVisibility(View.VISIBLE);
            new_taddress.setVisibility(View.VISIBLE);

            update.setVisibility(View.VISIBLE);


        }
    }

    public void updateContact(View view) {
        userDbHelper = new UserDbHelper(getApplicationContext());
        sqLiteDatabase = userDbHelper.getWritableDatabase();
        String name, mobile, email,paddress,taddress;
        name = new_name.getText().toString();
        mobile = new_mobile.getText().toString();
        email = new_email.getText().toString();
        paddress=new_paddress.getText().toString();
        taddress=new_taddress.getText().toString();


        int count = userDbHelper.updateInformation(SearchName, name, mobile, email,paddress,taddress, sqLiteDatabase);
        Toast.makeText(getApplicationContext(), count + " Contact updated", Toast.LENGTH_LONG).show();
        finish();
    }
}
