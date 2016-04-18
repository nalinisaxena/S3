package com.example.nalini.Smart_Service_Shipment;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;

import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;


public class Add extends AppCompatActivity {

    EditText ContactName,ContactMobile,ContactEmail,ContactPaddress,ContactTaddress;
    Context context=this;
    SQLiteDatabase sqLiteDatabase;
    UserDbHelper userDbHelper;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);

        ContactName=(EditText)findViewById(R.id.newn);
        ContactMobile=(EditText)findViewById(R.id.newm);
        ContactEmail=(EditText)findViewById(R.id.newe);
        ContactPaddress=(EditText)findViewById(R.id.newp);
        ContactTaddress=(EditText)findViewById(R.id.newt);




    }


    public void addContact(View view)

    {
        String name=ContactName.getText().toString();
        String mob=ContactMobile.getText().toString();
        String email=ContactEmail.getText().toString();
        String paddress=ContactPaddress.getText().toString();
        String taddress=ContactTaddress.getText().toString();



        userDbHelper =new UserDbHelper(context);
        sqLiteDatabase=userDbHelper.getWritableDatabase();
        userDbHelper.addInformation(name,mob,email,paddress,taddress,sqLiteDatabase);

        Toast.makeText(getBaseContext(),"Data Saved",Toast.LENGTH_LONG).show();

        userDbHelper.close();
    }

    }


