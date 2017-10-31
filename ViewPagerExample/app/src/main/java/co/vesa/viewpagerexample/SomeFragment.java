package co.vesa.viewpagerexample;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * Created by jussivesa on 24/10/2017.
 */

public class SomeFragment extends Fragment {
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_some, container, false);
        TextView textView = (TextView) rootView.findViewById(R.id.section_label);
        textView.setText("Some Fragment Content");
        return rootView;
    }

}
