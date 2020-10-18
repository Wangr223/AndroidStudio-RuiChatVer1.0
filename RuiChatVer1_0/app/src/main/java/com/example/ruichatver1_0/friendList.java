package com.example.ruichatver1_0;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class friendList extends AppCompatActivity {
    private List<Message> MessageList = new ArrayList<>();
    private Button to_myfriend;
    private Button to_myspace;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_friend_list);
        ActionBar acbar = getSupportActionBar();
        if(acbar != null)
            acbar.hide();

        initMessages();
        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.msg_list);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        MessageAdapter adapter = new MessageAdapter(MessageList, this);
        recyclerView.setAdapter(adapter);
        adapter.setOnItemClickListener(MyItemClickListener);
        to_myfriend = (Button) findViewById(R.id.my_friend);
        to_myspace = (Button) findViewById(R.id.my_space);

        to_myfriend.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent intent = new Intent(friendList.this,MyFriend.class);
                startActivity(intent);
                friendList.this.finish();
            }
        });

        to_myspace.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent intent = new Intent(friendList.this,MySpace.class);
                startActivity(intent);
                //friendList.this.finish();
            }
        });

    }

    private void initMessages() {
            Message apple = new Message(R.drawable.ma_img, "老妈", "吃饭了没有？", "12:55");
            MessageList.add(apple);
            Message banana = new Message(R.drawable.fa_img, "老王", "给老王一贯利子", "12:57");
            MessageList.add(banana);
    }

    private MessageAdapter.OnItemClickListener MyItemClickListener = new MessageAdapter.OnItemClickListener() {
        @Override
        public void onItemClick(View v, int position) {
            Intent intent = new Intent(friendList.this, Chatting.class);
            //position?
            Message msg = MessageList.get(position);
            String name_clicked = msg.getname();
            intent.putExtra("extra_msg_peoplename",name_clicked);
            startActivity(intent);
        }
    };

}