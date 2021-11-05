package com.example.directdm;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.WindowManager;
import android.widget.Toast;

public class SplashScreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);
        getSupportActionBar().hide();
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        Thread td=new Thread(){
            @Override
            public void run() {
               try {
                   sleep(1500);
               }
               catch (Exception ex){
                   Toast.makeText(SplashScreen.this, ex.getMessage(), Toast.LENGTH_SHORT).show();
               }finally {
                   Intent intent=new Intent(SplashScreen.this,MainActivity.class);
                   startActivity(intent);
                   finish();

               }
            }
        };td.start();

    }
}