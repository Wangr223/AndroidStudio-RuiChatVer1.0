package com.example.ruichatver1_0;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;

public class AFriendAdapter extends RecyclerView.Adapter<AFriendAdapter.ViewHolder>{
    private List<AFriend> mFriendList;

    static class ViewHolder extends RecyclerView.ViewHolder{
        ImageView headimg;
        TextView nametxt;

        public ViewHolder(View view){
            super(view);
            headimg = (ImageView) view.findViewById(R.id.fhead);
            nametxt = (TextView) view.findViewById(R.id.fname);
        }
    }

    public AFriendAdapter(List<AFriend> friendList){
        mFriendList = friendList;
    }

    @Override
    public AFriendAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.single_friend,parent,false);
        final ViewHolder holder = new ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull AFriendAdapter.ViewHolder holder, int position) {
        AFriend friend = mFriendList.get(position);
        holder.nametxt.setText(friend.getname());
        holder.headimg.setImageResource(friend.gethead());
    }

    @Override
    public int getItemCount() {
        return mFriendList.size();
    }
}