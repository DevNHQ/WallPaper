package com.quang.wallpaper;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

public class ScreenActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_screen);
        Thread bamgio = new Thread() {
            public void run() {
                try {
                    sleep(3000);
                } catch (Exception e) {

                } finally {
                    Intent intent = new Intent(ScreenActivity.this,MainActivity.class);
                    startActivity(intent);
                }
            }
        };
        bamgio.start();
    }
}
