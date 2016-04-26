package com.example.rss32.salesman;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import org.json.JSONArray;
import org.json.JSONObject;

public class EnterAddressActivity extends AppCompatActivity {
    EditText address1,address2,address3,address4;
    TextView output;
    Button addressButton;
    JSONArray addressArray = new JSONArray();
    JSONObject addressObject = new JSONObject();
    MultipleAddressModel multipleAddressModel;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_enter_address);
        address1 = (EditText)findViewById(R.id.address1);
        address2 = (EditText)findViewById(R.id.address2);
        address3 = (EditText)findViewById(R.id.address3);
        address4 = (EditText)findViewById(R.id.address4);
        output = (TextView)findViewById(R.id.outputWithLatLng);
        addressButton = (Button) findViewById(R.id.addressButton);
//        addressButton.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                try {
//                } catch (JSONException e) {
//                    e.printStackTrace();
//                }
//            }
//        });
        GeocodingLocation locationAddress = new GeocodingLocation();
        locationAddress.getAddressFromLocation(address1.getText().toString(),
                getApplicationContext(), new GeocoderHandler());


    }

    private class GeocoderHandler extends Handler {
        @Override
        public void handleMessage(Message message) {
            String locationAddress;
            switch (message.what) {
                case 1:
                    Bundle bundle = message.getData();
                    locationAddress = bundle.getString("address");
                    break;
                default:
                    locationAddress = null;
            }

            output.setText(locationAddress);
        }
    }

}
