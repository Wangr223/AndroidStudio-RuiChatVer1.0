package com.example.ruichatver1_0;

public class Message {
    private String msg_name;
    private String msg_time;
    private String msg_message;
    private int msg_head;


    public  Message(int head, String name, String message, String time){
        this.msg_head = head;
        this.msg_name = name;
        this.msg_message = message;
        this.msg_time = time;
    }

    public int gethead() {
        return msg_head;
    }

    public String getname() {
        return msg_name;
    }

    public String getmessage(){
        return  msg_message;
    }

    public String gettime(){
        return msg_time;
    }
}