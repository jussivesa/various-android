package co.vesa.mapimplicitintents;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.*;
import android.view.View;
import android.content.Intent;
import android.net.Uri;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void openMap(View view) {
        // get lat and lng values
        EditText latText = (EditText) findViewById(R.id.locationLat);
        EditText lngText = (EditText) findViewById(R.id.locationLng);
        String i = latText.getText().toString();
        String j = lngText.getText().toString();
        double lat = Double.parseDouble(i);
        double lng = Double.parseDouble(j);
        // show map
        Intent intent = new Intent(Intent.ACTION_VIEW); intent.setData(Uri.parse("geo:"+lat+","+lng)); startActivity(intent);
    }

}
