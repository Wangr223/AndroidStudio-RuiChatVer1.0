package com.example.ruichatver1_0;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class Chatting extends AppCompatActivity {
    private List<Bubble> bubbleList = new ArrayList<>();
    private EditText inputText;
    private Button sendBtn;
    private RecyclerView bubbleRV;
    private BubbleAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chatting);
        initBubbles();
        Intent receiver_intent = getIntent();
        String fname = receiver_intent.getStringExtra("extra_msg_peoplename");
        //Log.d("Chatting", fname);
        TextView chat_title = findViewById(R.id.title_text);
        chat_title.setText(fname);
        ActionBar acbar = getSupportActionBar();
        if(acbar != null)
            acbar.hide();

        inputText = (EditText) findViewById(R.id.input_text);
        sendBtn = (Button) findViewById(R.id.send);
        bubbleRV = (RecyclerView) findViewById(R.id.msg_recycler_view);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        bubbleRV.setLayoutManager(layoutManager);
        adapter = new BubbleAdapter(bubbleList);
        bubbleRV.setAdapter(adapter);
        sendBtn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                String content = inputText.getText().toString();
                if(! "".equals(content) ){
                    Bubble bubble = new Bubble(content,Bubble.TYPE_SENT);
                    bubbleList.add(bubble);
                    adapter.notifyItemInserted(bubbleList.size()-1);
                    bubbleRV.scrollToPosition(bubbleList.size()-1);
                    inputText.setText("");
                }
            }
        });

    }

    private void initBubbles(){
        Bubble bb1 = new Bubble("Hello Wang Rui", Bubble.TYPRE_RECEIVED);
        bubbleList.add(bb1);
        Bubble bb2 = new Bubble("Hello, who's that?", Bubble.TYPE_SENT);
        bubbleList.add(bb2);
        Bubble msg3 = new Bubble("This is Cissy!!",Bubble.TYPRE_RECEIVED);
        bubbleList.add(msg3);
    }
}