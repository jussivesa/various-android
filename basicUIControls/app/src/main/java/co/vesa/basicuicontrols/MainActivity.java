package co.vesa.basicuicontrols;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;
import android.widget.EditText;
import android.widget.AutoCompleteTextView;
import android.widget.ArrayAdapter;

import java.io.Console;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // AutoCompleteTextView
        ArrayAdapter<String> adapter = new ArrayAdapter<>(
                this,
                android.R.layout.simple_dropdown_item_1line,
                NAMES
        );
        AutoCompleteTextView textView = (AutoCompleteTextView) findViewById(R.id.loginGroupUsername);
        textView.setAdapter(adapter);
    }

    public void foodChoiceMade(View view) {

        // find radiogroup
        RadioGroup rg = (RadioGroup) findViewById(R.id.foodRadioGroup);
        int id = rg.getCheckedRadioButtonId();
        // find button
        RadioButton rb = (RadioButton) findViewById(id);
        // get radiobutton text
        String text = (String) rb.getText();

        if (text.length() == 0) return;

        // toast message to screen
        Toast.makeText(
                getApplicationContext(),
                text,
                Toast.LENGTH_SHORT
        ).show();
    }

    public void loginBtnClickMade(View view) {
        // get username
        AutoCompleteTextView username = (AutoCompleteTextView) findViewById(R.id.loginGroupUsername);
        // get pw
        EditText password = (EditText) findViewById(R.id.loginGroupPassword);

        String usernameText = username.getText().toString();
        String passwordText = password.getText().toString();

        if (username.length() == 0 || password.length() == 0) return;

        // toast username and password to screen
        Toast.makeText(
                getApplicationContext(),
                usernameText + ' ' + passwordText,
                Toast.LENGTH_SHORT
        ).show();
    }

    private static final String[] NAMES = new String[] {
            "Linus", "Mark", "Bill", "Steve", "Jony"
    };
}
