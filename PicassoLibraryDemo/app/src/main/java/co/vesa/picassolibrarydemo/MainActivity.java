package co.vesa.picassolibrarydemo;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

public class MainActivity extends AppCompatActivity {

    private ImageView imageView = (ImageView) findViewById(R.id.imageView);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Context context = imageView.getContext();


        Picasso.with(this).load("http://i.imgur.com/DvpvklR.png").into(imageView);
    }


}
