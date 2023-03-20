package com.example.e_tivity_3_intents;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;

import android.app.NotificationChannel;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

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

        btn3.setOnClickListener(v -> {


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
}