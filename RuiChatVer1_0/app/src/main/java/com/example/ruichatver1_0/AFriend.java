package com.example.ruichatver1_0;

public class AFriend {
    private String frd_name;
    private int frd_head;


    public AFriend(int head, String name) {
        this.frd_head = head;
        this.frd_name = name;
    }

    public int gethead() {
        return frd_head;
    }

    public String getname() {
        return frd_name;
    }
}