package com.example.nalini.Smart_Service_Shipment;

import android.content.Intent;
import android.os.Bundle;

import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


    }

    public void signUp(View view) {

        Intent intent = new Intent(this, Add.class);
        startActivity(intent);
    }

    public void adLogin(View view) {
        Intent intent = new Intent(this, Admin.class);
        startActivity(intent);
    }

    public void selLogin(View view) {
        Intent intent = new Intent(this,Salesman.class);
        startActivity(intent);
    }



    public void mapLogin(View view)
    {
        Intent intent=new Intent(this,MapsActivity.class);
        startActivity(intent);
    }






}

