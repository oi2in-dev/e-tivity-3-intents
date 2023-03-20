// Oisin O'Sullivan
// Id 21304971


package com.example.e_tivity_3_intents;

import android.app.Notification;
import android.app.NotificationChannel;
import android.content.Context;
import android.content.ContextWrapper;
import android.app.PendingIntent;
import android.content.Intent;
import android.os.Build;
import androidx.annotation.RequiresApi;
import androidx.core.app.NotificationCompat;

public class NotificationManager extends ContextWrapper{

    public static final String chan1 = "chan1";
    public static final  String chan1name = "Channel 1";

    public static final String chan2 = "chan2";
    public static final  String chan2name = "Channel 2";

    private android.app.NotificationManager Admin;


    public NotificationManager(Context base) {

        super(base);
        if (Build.VERSION.SDK_INT >=  Build.VERSION_CODES.O) {
            makeChannels();
        }
    }
    @RequiresApi(api = Build.VERSION_CODES.O)
    public void makeChannels() {

        NotificationChannel channel1 = new NotificationChannel(chan1, chan1name, android.app.NotificationManager.IMPORTANCE_DEFAULT);

        channel1.enableLights(true);
        channel1.enableVibration(true);
        channel1.setLightColor(com.google.android.material.R.color.design_default_color_primary);
        channel1.setLockscreenVisibility(Notification.VISIBILITY_PRIVATE);

        getAdmin().createNotificationChannel(channel1);

        NotificationChannel channel2 = new NotificationChannel(chan2, chan2name, android.app.NotificationManager.IMPORTANCE_HIGH);

        channel2.enableLights(false);
        channel2.enableVibration(true);
        channel2.setLightColor(com.google.android.material.R.color.design_default_color_primary);
        channel2.setLockscreenVisibility(Notification.VISIBILITY_PUBLIC);

        getAdmin().createNotificationChannel(channel2);
    }

    public android.app.NotificationManager getAdmin() {
        if (Admin == null) {
            Admin = (android.app.NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
        }

        return  Admin;
    }

    public NotificationCompat.Builder getchan1ping(String title, String message){

        Intent resultIntent = new Intent(this, MainActivity.class);
        PendingIntent  pendingIntent = PendingIntent.getActivity(this, 1, resultIntent, PendingIntent.FLAG_ONE_SHOT);
        return new NotificationCompat.Builder(getApplicationContext(), chan1)
                .setContentTitle(title)
                .setContentText(message)
                .setSmallIcon(R.drawable.ic_icon)
                .setAutoCancel(true)
                .setContentIntent(pendingIntent);
    }

    public NotificationCompat.Builder getchan2ping(String title, String message){

        return new NotificationCompat.Builder(getApplicationContext(), chan2)
                .setContentTitle(title)
                .setContentText(message)
                .setSmallIcon(R.drawable.ic_icon2);
    }
}
