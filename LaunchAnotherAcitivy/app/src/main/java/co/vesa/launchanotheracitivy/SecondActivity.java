package co.vesa.launchanotheracitivy;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        TextView nameTextView = (TextView) findViewById(R.id.nameTextView);
        // get intent that launched the activity, and its extras
        Bundle extras = getIntent().getExtras();
        String name = extras.getString("name");
        nameTextView.setText("Hello " + name + "!");
    }
}
