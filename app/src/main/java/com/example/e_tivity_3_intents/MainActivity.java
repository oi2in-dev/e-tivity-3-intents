// Oisin O'Sullivan
// Id 21304971


package com.example.e_tivity_3_intents;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;
import android.app.AlarmManager;
import android.app.NotificationChannel;
import android.app.PendingIntent;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText Title;
    private EditText Content;
    private Button btn1;
    private Button btn2;

    private NotificationManager NManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        createnotifchannel();

        Title = findViewById(R.id.Title);
        Content =  findViewById(R.id.content);


        btn1 =  findViewById(R.id.btn1);
        btn2 =  findViewById(R.id.btn2);

        // alternative method of Declaration
        Button btn3  = findViewById(R.id.btn3);

        NManager = new NotificationManager(this);

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                sendonBtn1(Title.getText().toString(), Content.getText().toString());

            }
        });

        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                sendonBtn2(Title.getText().toString(), Content.getText().toString());


            }
        });

        // Decided to use lamda here to demonstate an extra use of on click listener.
        btn3.setOnClickListener(v -> {

            Toast.makeText(this, "ping sent", Toast.LENGTH_SHORT).show();

            Intent intent = new Intent(MainActivity.this,BroadcastPing.class);
            PendingIntent pendingIntent1 = PendingIntent.getBroadcast(MainActivity.this, 0, intent, 0);

            AlarmManager alarmManager = (AlarmManager) getSystemService(ALARM_SERVICE);

            long timeAtButtonPressed = System.currentTimeMillis();

            long fifteenSecs = 1000 * 15;

            alarmManager.set(AlarmManager.RTC_WAKEUP, timeAtButtonPressed + fifteenSecs, pendingIntent1);
        });

    }



    public void sendonBtn1 (String title, String message) {

        NotificationCompat.Builder nb = NManager.getchan1ping(title, message);
        NManager.getAdmin().notify(1, nb.build());


    }
    public void sendonBtn2 (String title, String message) {

        NotificationCompat.Builder nb = NManager.getchan2ping(title, message);
        NManager.getAdmin().notify(2, nb.build());

    }



    private void createnotifchannel() {

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            CharSequence name = "PingMe";
            String description = "Ping me in 15 secs";
            NotificationChannel channel3 = new NotificationChannel("pingme", name, android.app.NotificationManager.IMPORTANCE_HIGH);
            channel3.setDescription(description);

            android.app.NotificationManager notificationManager = getSystemService(android.app.NotificationManager.class);
            ((android.app.NotificationManager) notificationManager).createNotificationChannel(channel3);

        }
    }
}