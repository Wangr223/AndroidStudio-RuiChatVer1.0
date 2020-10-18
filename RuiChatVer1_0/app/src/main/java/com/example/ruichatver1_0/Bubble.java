package com.example.ruichatver1_0;

public class Bubble
{
    public static final int TYPRE_RECEIVED = 0;
    public static final int TYPE_SENT = 1;

    private  String content;
    private int type;

    public Bubble(String content, int type){
        this.content = content;
        this.type = type;
    }

    public String getContent(){
        return content;
    }

    public int getType(){
        return type;
    }
}
