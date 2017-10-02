package co.vesa.saverestoreactivitystate;

import android.app.Activity;
import android.app.DialogFragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity implements TextInputDialog.TextEntryDialogListener {
    private final String TEXTINPUT_STATEKEY = "TEXTINPUT_STATEKEY";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        TextView textView = (TextView) findViewById(R.id.textView1);
        if (savedInstanceState != null) {
            if (savedInstanceState.containsKey(TEXTINPUT_STATEKEY)) {
                String text = savedInstanceState.getString(TEXTINPUT_STATEKEY);
                textView.setText(text);
            }
        }
    }

    @Override
    public void onSaveInstanceState(Bundle saveInstanceState) {
        Toast.makeText(getBaseContext(), "MainActivity - onSaveInstanceState", Toast.LENGTH_SHORT).show();
        // get text view
        TextView textView = (TextView) findViewById(R.id.textView1);
        // save state
        saveInstanceState.putString(TEXTINPUT_STATEKEY, textView.getText().toString());
    }

    @Override
    public void onDialogPositiveClick(DialogFragment dialog, String text) {
        TextView textView = (TextView) findViewById(R.id.textView1);
        textView.setText(text);
    }
    @Override
    public void onDialogNegativeClick(DialogFragment dialog) {
        Toast.makeText(getApplicationContext(), "Cancel",
                Toast.LENGTH_SHORT).show();
    }

    public void buttonClicked(View view) {
        TextInputDialog eDialog = new TextInputDialog();
        eDialog.show(getFragmentManager(), "Text Dialog");
    }

}