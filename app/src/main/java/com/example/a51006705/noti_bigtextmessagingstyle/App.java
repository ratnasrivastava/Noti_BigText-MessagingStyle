package com.example.a51006705.noti_bigtextmessagingstyle;

import android.app.Application;
import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.os.Build;
import android.support.v4.app.NotificationCompat;

/**
 * Created by 51006705 on 03-06-2019.
 */

public class App extends Application {

    public static final String CHANNEL_1_ID = "Channel 1";
    public static final String CHANNEL_2_ID = "Channel 2";

    @Override
    public void onCreate() {
        super.onCreate();
        createNotificationChannels();
    }

    private void createNotificationChannels() {
        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.O){
            NotificationChannel notificationChannel1 = new NotificationChannel(CHANNEL_1_ID, "Channel1", NotificationManager.IMPORTANCE_HIGH);
            notificationChannel1.setDescription("This is Channel 1");

            NotificationChannel notificationChannel2 = new NotificationChannel(CHANNEL_2_ID, "Channel2", NotificationManager.IMPORTANCE_HIGH);
            notificationChannel2.setDescription("This is Channel 2");

            NotificationManager notificationManager = getSystemService(NotificationManager.class);

            notificationManager.createNotificationChannel(notificationChannel1);
            notificationManager.createNotificationChannel(notificationChannel2);
        }
    }
}
