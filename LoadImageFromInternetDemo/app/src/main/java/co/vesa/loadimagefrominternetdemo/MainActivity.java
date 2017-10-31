package co.vesa.loadimagefrominternetdemo;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.media.Image;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;

import java.io.InputStream;
import java.io.StringBufferInputStream;
import java.net.URL;

public class MainActivity extends AppCompatActivity {

    private ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        imageView = (ImageView) findViewById(R.id.imageView);

        String imageUrl = "https://i.imgur.com/6zQapw4.jpg";

        DownloadImageTask task = new DownloadImageTask();
        task.execute(imageUrl);

    }

    // sisäänmeno String, progress Voidia, palauttaa bitmap
    private class DownloadImageTask extends AsyncTask<String, Void, Bitmap> {

        @Override
        protected Bitmap doInBackground(String... urls) {
            URL imageUrl;
            Bitmap bitmap = null;

            try {
                // Check url, open stream, read stream
                imageUrl = new URL(urls[0]);
                InputStream in = imageUrl.openStream();
                bitmap = BitmapFactory.decodeStream(in);
            } catch (Exception e) {
                Log.d("MY_LOG", e.getMessage());
            }
            return bitmap;
        }

        @Override
        protected void onPostExecute(Bitmap bitmap) {
            if (bitmap != null) {
                imageView.setImageBitmap(bitmap);
            } else {
                // Toast, error in image load.
            }
        }
    } // ...task
}
