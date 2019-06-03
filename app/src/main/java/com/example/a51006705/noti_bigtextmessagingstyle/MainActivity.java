package com.example.a51006705.noti_bigtextmessagingstyle;

import android.app.Notification;
import android.app.NotificationManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.v4.app.NotificationCompat;
import android.support.v4.app.NotificationManagerCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import static com.example.a51006705.noti_bigtextmessagingstyle.App.CHANNEL_1_ID;
import static com.example.a51006705.noti_bigtextmessagingstyle.App.CHANNEL_2_ID;

public class MainActivity extends AppCompatActivity {

    private EditText mEditTextTitle;
    private EditText mEditTextMessage;

    private Button mButtonSendOnChannel1;
    private Button mButtonSendOnChannel2;

    private NotificationManagerCompat notificationManagerCompat;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mEditTextTitle = findViewById(R.id.edit_text_title);
        mEditTextMessage = findViewById(R.id.edit_text_message);

        mButtonSendOnChannel1 = findViewById(R.id.button_send_on_channel1);
        mButtonSendOnChannel2 = findViewById(R.id.button_send_on_channel2);

        notificationManagerCompat = NotificationManagerCompat.from(this);

        mButtonSendOnChannel1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sendOnChannel1();
            }
        });

        mButtonSendOnChannel2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sendOnChannel2();
            }
        });
    }

    private void sendOnChannel1() {
        String title = mEditTextTitle.getText().toString();
        String message = mEditTextMessage.getText().toString();

        Bitmap bitmapImage = BitmapFactory.decodeResource(getResources(), R.drawable.dog);

        Notification notification = new NotificationCompat.Builder(this, CHANNEL_1_ID)
                .setSmallIcon(R.drawable.ic_one)
                .setContentTitle(title)
                .setContentText(message)
                .setLargeIcon(bitmapImage)
                .setCategory(Notification.CATEGORY_MESSAGE)
                .setStyle(new NotificationCompat.BigTextStyle()
                        .bigText(getString(R.string.bigtext))
                        .setBigContentTitle("Big Content Title")
                        .setSummaryText("Summary Test"))
                .setPriority(NotificationCompat.PRIORITY_HIGH)
                .build();

        notificationManagerCompat.notify(1, notification);

    }

    private void sendOnChannel2() {

        String title = mEditTextTitle.getText().toString();
        String message = mEditTextMessage.getText().toString();

        Notification notification = new NotificationCompat.Builder(this, CHANNEL_2_ID)
                .setSmallIcon(R.drawable.ic_two)
                .setContentTitle(title)
                .setContentText(message)
                .setCategory(Notification.CATEGORY_MESSAGE)
                .setStyle(new NotificationCompat.InboxStyle()
                        .addLine("This is line 1")
                        .addLine("This is line 1")
                        .addLine("This is line 1")
                        .addLine("This is line 1")
                        .addLine("This is line 1")
                        .addLine("This is line 1")
                        .addLine("This is line 1")
                        .addLine("This is line 1")
                        .setSummaryText("Summary Text")
                        .setBigContentTitle("Title")
                )
                .setPriority(NotificationCompat.PRIORITY_HIGH)
                .build();

        notificationManagerCompat.notify(1, notification);
    }
}
