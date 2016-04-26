package com.example.rss32.salesman;

import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.location.Criteria;
import android.location.Location;
import android.location.LocationManager;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.provider.Settings;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.android.gms.location.LocationListener;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.maps.model.PolylineOptions;

public class MainActivity extends AppCompatActivity implements OnMapReadyCallback, LocationListener {
    GoogleMap m_map;
    boolean mapReady = false;
    private LocationManager locationManager;
    private String provider;

    EditText address1;
    MarkerOptions a;
    MarkerOptions b;
    MarkerOptions c;
    MarkerOptions d;
    MarkerOptions e;
    MarkerOptions harshshah;

    LatLng first1;
    LatLng first2;
    LatLng first3;
    LatLng first4;
    LatLng first5;
    int latitude, longitude;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        startActivity(new Intent(MainActivity.this,EnterAddressActivity.class));
        LocationManager service = (LocationManager) getSystemService(LOCATION_SERVICE);
        boolean enabled = service
                .isProviderEnabled(LocationManager.GPS_PROVIDER);
        // check if enabled and if not send user to the GSP settings
// Better solution would be to display a dialog and suggesting to
// go to the settings
        if (!enabled) {
            Intent intent = new Intent(Settings.ACTION_LOCATION_SOURCE_SETTINGS);
            startActivity(intent);
        }
        // Get the location manager
        locationManager = (LocationManager) getSystemService(Context.LOCATION_SERVICE);
        // Define the criteria how to select the locatioin provider -> use
        // default
        Criteria criteria = new Criteria();
        provider = locationManager.getBestProvider(criteria, false);
        Location location = locationManager.getLastKnownLocation(provider);
        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            // TODO: Consider calling
            //    ActivityCompat#requestPermissions
            // here to request the missing permissions, and then overriding
            //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
            //                                          int[] grantResults)
            // to handle the case where the user grants the permission. See the documentation
            // for ActivityCompat#requestPermissions for more details.
            return;
        }
        // Initialize the location fields
        if (location != null) {
            System.out.println("Provider " + provider + " has been selected.");
            onLocationChanged(location);
        } else {
            Log.d("MAP", "Latlong not found");
//            latituteField.setText("Location not available");
//            longitudeField.setText("Location not available");
        }
//        first1 = new LatLng(19.113796, 72.892806);
//        first2 = new LatLng(19.120427, 72.899473);
//        first3 = new LatLng(19.134372, 72.897705);
//        first4 = new LatLng(19.128064, 72.870820);
//        first5 = new LatLng(19.107913, 72.880095);
//        startActivity(new Intent(MainActivity.this,GetLatLng.class));
        address1 = (EditText) findViewById(R.id.address1);
//        GetAddressPositionTask get = new GetAddressPositionTask();
//        get.execute("gateway of india,mumbai");
//        double harsh = convertAddress();
//        System.out.print(harsh);
//        LatLng address = getLocationFromAddress(getApplicationContext(), "Garware house,mumbai");
//        if (address != null) {
//            System.out.print(address);
//        }
//        harsh = getLocationFromAddress(MainActivity.this,address1.getText().toString());
//        Log.d("Latlng",harsh.toString());
        a = new MarkerOptions().position(new LatLng(67.489805, -122.120502)).title("A");
        b = new MarkerOptions().position(new LatLng(97.489805, -122.120502)).title("B");
        c = new MarkerOptions().position(new LatLng(147.489805, -122.120502)).title("C");
        d = new MarkerOptions().position(new LatLng(247.489805, -122.120502)).title("D");
        e = new MarkerOptions().position(new LatLng(347.489805, -122.120502)).title("E");
//            harshshah = new MarkerOptions().position(harsh);

        Button satellite = (Button) findViewById(R.id.btn1);
        satellite.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mapReady) {
                    m_map.setMapType(GoogleMap.MAP_TYPE_SATELLITE);
//                    harsh = getLocationFromAddress(MainActivity.this, address1.getText().toString());
//                    harshshah = new MarkerOptions().position(harsh);
//                    Log.d("Latlng", harsh.toString());

                }
            }
        });
        Button hybrid = (Button) findViewById(R.id.btn2);
        hybrid.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mapReady) {
                    m_map.setMapType(GoogleMap.MAP_TYPE_HYBRID);

                }
            }
        });
        Button normal = (Button) findViewById(R.id.btn3);
        normal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mapReady) {
                    m_map.setMapType(GoogleMap.MAP_TYPE_NORMAL);

                }
            }
        });
        MapFragment mapFragment = (MapFragment) getFragmentManager().findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }


    @Override
    public void onMapReady(GoogleMap googleMap) {
        mapReady = true;
        m_map = googleMap;

        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            // TODO: Consider calling
            //    ActivityCompat#requestPermissions
            // here to request the missing permissions, and then overriding
            //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
            //                                          int[] grantResults)
            // to handle the case where the user grants the permission. See the documentation
            // for ActivityCompat#requestPermissions for more details.
            return;
        }
        m_map.setMyLocationEnabled(true);
//        m_map.addMarker(new MarkerOptions().position(first1).title("First"));
//        m_map.addMarker(new MarkerOptions().position(first2).title("Second"));
//        m_map.addMarker(new MarkerOptions().position(first3).title("Third"));
//        m_map.addMarker(new MarkerOptions().position(first4).title("Fourth"));
//        m_map.addMarker(new MarkerOptions().position(first5).title("Fifth"));

//        LatLng newYork = new LatLng(40.7484, -73.9857);
//        CameraPosition target = CameraPosition.builder().target(newYork).zoom(14).build();
//        m_map.moveCamera(CameraUpdateFactory.newCameraPosition(target));
//        m_map.addMarker(harshshah);
        m_map.addPolyline(new PolylineOptions().geodesic(true).add(first1).add(first2).add(first3).add(first4).add(first5));

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
            m_map.addMarker(new MarkerOptions().position())
        }
    }

    @Override
    public void onLocationChanged(Location location) {
        int lat = (int) (location.getLatitude());
        latitude = lat;
        int lng = (int) (location.getLongitude());
        longitude = lng;
        first1 = new LatLng(19.113796, 72.892806);
        first2 = new LatLng(19.120427, 72.899473);
        first3 = new LatLng(19.134372, 72.897705);
        first4 = new LatLng(19.128064, 72.870820);
        first5 = new LatLng(19.107913, 72.880095);
//        m_map.addMarker(new MarkerOptions().position(new LatLng(lat,lng)).title("First"));

    }

    @Override
    protected void onResume() {
        super.onResume();
//        locationManager.requestLocationUpdates(provider, 400, 1, this);
    }

    @Override
    protected void onPause() {
        super.onPause();
//        locationManager.removeUpdates();
    }






}

