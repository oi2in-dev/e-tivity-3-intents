// Oisin O'Sullivan
// Id 21304971


package com.example.e_tivity_3_intents;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;

public class BroadcastPing extends BroadcastReceiver{

    @Override
    public void onReceive(Context context, Intent intent) {

        NotificationCompat.Builder builder = new NotificationCompat.Builder(context, "pingme")
                .setSmallIcon(R.drawable.ic_baseline_access_time_24)
                .setContentTitle("Clock based Intent")
                .setContentText("Did it Work?")
                .setPriority(NotificationCompat.PRIORITY_HIGH);

        NotificationManagerCompat notificationMan = NotificationManagerCompat.from(context);

        notificationMan.notify(200, builder.build());


    }
}
