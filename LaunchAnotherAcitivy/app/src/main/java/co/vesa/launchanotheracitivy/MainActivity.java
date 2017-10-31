package co.vesa.launchanotheracitivy;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void buttonPressed (View view) {
        EditText nameEditText = (EditText) findViewById(R.id.nameEditText);
        String name = nameEditText.getText().toString();
        // start another activity
        Intent intent = new Intent(this, SecondActivity.class);
        intent.putExtra("name", name);
        startActivity(intent);

    }
}
