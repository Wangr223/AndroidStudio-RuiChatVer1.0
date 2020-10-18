package com.example.ruichatver1_0;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Notification;
import android.content.Intent;
import android.os.Bundle;

import java.util.Timer;
import java.util.TimerTask;

public class StartActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);
        ActionBar acbar = getSupportActionBar();
        if(acbar!=null){
            acbar.hide();
        }
        Timer timer=new Timer();
        TimerTask timerTask=new TimerTask() {
            @Override
            public void run() {
                Intent intent1=new Intent(StartActivity.this,Log_in.class);
                startActivity(intent1);//调用启动函数
                StartActivity.this.finish();
            }
        };
        timer.schedule(timerTask,1000*2);
    }
}