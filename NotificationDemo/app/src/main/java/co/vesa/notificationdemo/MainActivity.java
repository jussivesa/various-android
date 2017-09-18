package co.vesa.notificationdemo;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private int notification_id = 1;
    private int BADGE_ICON_LARGE = 0x00000002;
    private String CATEGORY_MESSAGE = "msg";
    private View view;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        view = (View) findViewById(R.id.activity_main);

        // setNotificationReminder(view);
    }

    public void setNotificationReminder(View view){
        NotificationManager mNotificationManager =
                (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
        // The ID of the channel.
        String id = "my_channel_01";
        // The user visible name of the channel.
        CharSequence name = getString(R.string.channel_name);
        // The user visible description of the channel.
        String description = getString(R.string.channel_description);
        int importance = NotificationManager.IMPORTANCE_LOW;
        NotificationChannel mChannel = new NotificationChannel(id, name, importance);
        // Configure the notification channel.
        mChannel.setDescription(description);
        mChannel.setShowBadge(true);
        mNotificationManager.createNotificationChannel(mChannel);
        // Set a message count to associate with this notification in the long-press menu.
        int messageCount = 3;
        // Create a notification and set a number to associate with it.
        Notification notification = new Notification.Builder(MainActivity.this)
                .setContentTitle("Spotlight News Reminder")
                .setContentText("You've saved 3 new articles to read.")
                .setSmallIcon(R.drawable.spotlight)
                .setChannelId(id)
                .setBadgeIconType(BADGE_ICON_LARGE)
                .setCategory(CATEGORY_MESSAGE)
                .setNumber(messageCount)
                .build();
        // Issue the notification.
        mNotificationManager.notify(notification_id, notification);
        // toast message to screen
        Toast.makeText(
                getApplicationContext(),
                "Notification reminder set.",
                Toast.LENGTH_SHORT
        ).show();

    }
}
