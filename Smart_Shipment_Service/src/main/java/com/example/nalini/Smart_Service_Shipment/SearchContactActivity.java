package com.example.nalini.Smart_Service_Shipment;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;

import android.support.v7.app.AppCompatActivity;

import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class SearchContactActivity extends AppCompatActivity {

    TextView dislpay_Email,dislpay_mobile;
    EditText search_Name;
    UserDbHelper userDbHelper;
    SQLiteDatabase sqLiteDatabase;
    String search_name;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.search_contact_layout);

        search_Name=(EditText)findViewById(R.id.editText);
        dislpay_Email=(TextView)findViewById(R.id.textView3);
        dislpay_mobile=(TextView)findViewById(R.id.textView4);

        dislpay_Email.setVisibility(View.GONE);
        dislpay_mobile.setVisibility(View.GONE);

    }

    public void searchContact(View view)
    {
        search_name=search_Name.getText().toString();
        userDbHelper=new UserDbHelper(getApplicationContext());
        sqLiteDatabase=userDbHelper.getReadableDatabase();
        Cursor cursor=userDbHelper.getContact(search_name,sqLiteDatabase);
        if(cursor.moveToFirst())
        {
            String MOBILE=cursor.getString(0);
            String EMAIL=cursor.getString(1);
            dislpay_mobile.setText(MOBILE);
            dislpay_Email.setText(EMAIL);

            dislpay_mobile.setVisibility(View.VISIBLE);
            dislpay_Email.setVisibility(View.VISIBLE);

        }

    }

    public void deleteContact(View view)
    {
        userDbHelper=new UserDbHelper(getApplicationContext());
        sqLiteDatabase=userDbHelper.getReadableDatabase();
        userDbHelper.deleteInformation(search_name,sqLiteDatabase);
        Toast.makeText(getBaseContext(),"Contact deleted",Toast.LENGTH_LONG).show();
    }

}
