package co.vesa.mapimplicitintents;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.location.LocationListener;
import android.location.LocationManager;
import android.location.Location;
import android.provider.Settings;
import android.support.v7.app.AppCompatActivity;
import android.content.pm.PackageManager;
import android.support.v4.content.ContextCompat;
import android.support.v4.app.ActivityCompat;
import android.os.Bundle;
import android.util.Log;
import android.widget.*;
import android.view.View;
import android.content.Intent;
import android.net.Uri;

public class MainActivity extends AppCompatActivity {

    LocationManager locationManager;
    Context mContext;
    protected static final int MY_PERMISSIONS_REQUEST_FINE_LOCATION = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mContext = this;
        locationManager = (LocationManager) mContext.getSystemService(Context.LOCATION_SERVICE);

        if ( ContextCompat.checkSelfPermission( this,
                android.Manifest.permission.ACCESS_FINE_LOCATION )
                != PackageManager.PERMISSION_GRANTED ) {
                // Should we show an explanation?
                if (ActivityCompat.shouldShowRequestPermissionRationale(this,
                        android.Manifest.permission.ACCESS_FINE_LOCATION)) {
                } else {
                    ActivityCompat.requestPermissions( this, new String[] {
                            android.Manifest.permission.ACCESS_FINE_LOCATION  },
                            MY_PERMISSIONS_REQUEST_FINE_LOCATION );
                }

            isLocationEnabled();
            try {
                locationManager.requestLocationUpdates( LocationManager.GPS_PROVIDER,
                        2000,
                        10, locationListenerGPS);
                String msg = "Permission granted to use location";
                Toast.makeText(mContext,msg,Toast.LENGTH_LONG).show();
                Log.d("MY_LOG", "Sweet permission!");
            } catch (SecurityException E) {
                Log.e("MY_ERROR", E.toString());
            }

        }
    }

    public void openMap(View view) {
        // get lat and lng values
        EditText latText = (EditText) findViewById(R.id.locationLat);
        EditText lngText = (EditText) findViewById(R.id.locationLng);
        String i = latText.getText().toString();
        String j = lngText.getText().toString();
        // show map
        if (i.length() != 0 && j.length() != 0) {
            double lat = Double.parseDouble(i);
            double lng = Double.parseDouble(j);
            Intent intent = new Intent(Intent.ACTION_VIEW);
            intent.setData(Uri.parse("geo:" + lat + "," + lng));
            startActivity(intent);
        } else {
            Toast.makeText(mContext, "Please insert coordinates first.", Toast.LENGTH_LONG).show();
        }
    }

    /*
    @Override
    public void onRequestPermissionsResult(int requestCode, String permissions[], int[] grantResults) {
        Log.d("MY_LOG", "onRequestPermissionsResult - Switch case");
        switch (requestCode) {
            case MY_PERMISSIONS_REQUEST_FINE_LOCATION: {
                // If request is cancelled, the result arrays are empty.
                if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    Log.d("MY_LOG", "onRequestPermissionsResult - Granted");
                    // permission was granted, yay! Do the
                    // location-related task you need to do.
                    /*
                    locationManager = (LocationManager) mContext.getSystemService(Context.LOCATION_SERVICE);
                    isLocationEnabled();
                    try {
                        locationManager.requestLocationUpdates( LocationManager.GPS_PROVIDER,
                                2000,
                                10, locationListenerGPS);
                        String msg = "Permission granted to use location";
                        Toast.makeText(mContext,msg,Toast.LENGTH_LONG).show();
                        Log.d("MY_LOG", "Sweet permission!");
                    } catch (SecurityException E) {
                        Log.e("MY_ERROR", E.toString());
                    }
                    */
    /*
                } else {
                    Log.d("MY_LOG", "onRequestPermissionsResult - Denied");
                    // permission denied, boo! Disable the
                    // functionality that depends on this permission.
                    Toast.makeText(mContext, "You must allow access to location in Permissions. Otherwise, input location manually.", Toast.LENGTH_LONG).show();
                }
                return;
            }
            // other 'case' lines to check for other
            // permissions this app might request
        }
    }
        */

    LocationListener locationListenerGPS = new LocationListener() {
        @Override
        public void onLocationChanged(Location location) {
            Log.d("MY_LOG", "onLocationChanged here");
            double latitude = location.getLatitude();
            double longitude = location.getLongitude();
            String msg = "New Latitude: " + latitude + " New Longitude: " + longitude;
            Log.d("MY_LOG", msg);
            Toast.makeText(mContext, msg, Toast.LENGTH_LONG).show();

            String lat = String.valueOf(latitude);
            String lng = String.valueOf(longitude);
            EditText latText = (EditText) findViewById(R.id.locationLat);
            EditText lngText = (EditText) findViewById(R.id.locationLng);
            latText.setText(lat);
            lngText.setText(lng);

        }

        @Override
        public void onStatusChanged(String provider, int status, Bundle extras) {

        }

        @Override
        public void onProviderEnabled(String provider) {

        }

        @Override
        public void onProviderDisabled(String provider) {

        }
    };


    protected void onResume(){
        super.onResume();
        isLocationEnabled();
    }

    private void isLocationEnabled() {

        if(!locationManager.isProviderEnabled(LocationManager.GPS_PROVIDER)){
            AlertDialog.Builder alertDialog = new AlertDialog.Builder(mContext);
            alertDialog.setTitle("Enable Location");
            alertDialog.setMessage("Your locations setting is not enabled. Please enabled it in settings menu.");
            alertDialog.setPositiveButton("Location Settings", new DialogInterface.OnClickListener(){
                public void onClick(DialogInterface dialog, int which){
                    Intent intent = new Intent(Settings.ACTION_LOCATION_SOURCE_SETTINGS);
                    startActivity(intent);
                }
            });
            alertDialog.setNegativeButton("Cancel", new DialogInterface.OnClickListener(){
                public void onClick(DialogInterface dialog, int which){
                    dialog.cancel();
                }
            });
            AlertDialog alert=alertDialog.create();
            alert.show();
        } else {
            /*
            AlertDialog.Builder alertDialog = new AlertDialog.Builder(mContext);
            alertDialog.setTitle("Location information");
            alertDialog.setMessage("Your Location is enabled.");
            alertDialog.setNegativeButton("Back to app", new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface dialog, int which){
                    dialog.cancel();
                }
            });
            AlertDialog alert = alertDialog.create();
            alert.show();
            */
        }
    }
}