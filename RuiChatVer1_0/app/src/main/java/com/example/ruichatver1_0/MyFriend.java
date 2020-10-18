package com.example.ruichatver1_0;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;
import java.util.List;

public class MyFriend extends AppCompatActivity {
    private List<AFriend> fl = new ArrayList<>();
    private Button to_mymsg;
    private Button to_myspace;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_friend);
        ActionBar acbar = getSupportActionBar();
        if(acbar != null) acbar.hide();

        initFriends();

        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.friends_list);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        AFriendAdapter adapter = new AFriendAdapter(fl);
        recyclerView.setAdapter(adapter);
        to_mymsg = (Button) findViewById(R.id.my_msg);
        to_myspace = (Button) findViewById(R.id.my_space);

        to_mymsg.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent intent = new Intent(MyFriend.this,friendList.class);
                startActivity(intent);
                MyFriend.this.finish();
            }
        });

        to_myspace.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent intent = new Intent(MyFriend.this,MySpace.class);
                startActivity(intent);
                //MyFriend.this.finish();
            }
        });
    }

    private void initFriends() {
        AFriend f1 = new AFriend(R.drawable.ma_img,"老妈");
        AFriend f2 = new AFriend(R.drawable.fa_img,"老王");
        fl.add(f1);
        fl.add(f2);

    }
}