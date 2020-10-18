package com.example.ruichatver1_0;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Log_in extends AppCompatActivity {

    private static String trueuser = "wsj";
    private static String truepass = "wsj";
    private EditText username;
    private EditText password;
    private Button signin;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_log_in);
        ActionBar acbar = getSupportActionBar();
        if(acbar != null ){
            acbar.hide();
        }
        username = (EditText) findViewById(R.id.account);
        password = (EditText) findViewById(R.id.password);
        signin =  (Button) findViewById(R.id.denglu);

        signin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String tempuser = username.getText().toString();
                String temppass = password.getText().toString();
                if(tempuser.equals(trueuser) && temppass.equals(truepass)){
                    Intent intent1=new Intent(Log_in.this,friendList.class);
                    startActivity(intent1);
                    Log_in.this.finish();
                }
            }
        });
    }
}