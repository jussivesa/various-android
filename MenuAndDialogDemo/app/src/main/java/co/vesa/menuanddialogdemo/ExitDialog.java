package co.vesa.menuanddialogdemo;

import android.app.AlertDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.content.DialogInterface;
import android.os.Bundle;
import android.widget.Toast;

import co.vesa.menuanddialogdemo.R;

/**
 * Created by jussivesa on 18/09/2017.
 */
public class ExitDialog extends DialogFragment {
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        // New dialog with builder
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        // Use res/string
        builder.setTitle(R.string.exit_dialog_title)
                .setMessage(R.string.exit_dialog_msg)
                .setPositiveButton(R.string.exit_dialog_yes, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        Toast.makeText(getActivity(), "See you!", Toast.LENGTH_SHORT).show();
                        // android.os.Process.killProcess(android.os.Process.myPid());
                        // System.exit(1);
                    }
                })
                .setNegativeButton(R.string.exit_dialog_cancel, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        Toast.makeText(getActivity(), "Happy that you stayed.", Toast.LENGTH_SHORT).show();
                    }
                });
        // Create the AlertDialog object and return it
        return builder.create();
    }
}
