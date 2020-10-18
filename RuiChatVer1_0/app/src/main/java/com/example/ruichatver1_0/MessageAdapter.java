package com.example.ruichatver1_0;

import android.content.Context;
import android.content.Intent;
import android.security.identity.CipherSuiteNotSupportedException;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;

public class MessageAdapter extends RecyclerView.Adapter<MessageAdapter.ViewHolder>{
    private List<Message> mMessageList;
    private Context mContext;

    public void setOnItemClickListener(OnItemClickListener listener) {
        this.mOnItemClickListener = listener;
    }

    static class ViewHolder extends RecyclerView.ViewHolder implements  View.OnClickListener{
        View fullView;
        ImageView headimg;
        TextView nametxt;
        TextView messagetxt;
        TextView timetxt;

        public ViewHolder(View view){
            super(view);
            fullView = view;
            headimg = (ImageView) view.findViewById(R.id.head);
            nametxt = (TextView) view.findViewById(R.id.name);
            messagetxt = (TextView) view.findViewById(R.id.message);
            timetxt = (TextView) view.findViewById(R.id.time);
            fullView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            if (mOnItemClickListener != null) {
                mOnItemClickListener.onItemClick(v,getAdapterPosition());
            }
        }
    }

    public MessageAdapter(List<Message> messageList, Context mcontext){
        mMessageList = messageList;
        mContext = mcontext;

    }

    @Override
    public MessageAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.single_message,parent,false);
        final ViewHolder holder = new ViewHolder(view);


        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull MessageAdapter.ViewHolder holder, int position) {
        Message fruit = mMessageList.get(position);
        holder.nametxt.setText(fruit.getname());
        holder.headimg.setImageResource(fruit.gethead());
        holder.messagetxt.setText(fruit.getmessage());
        holder.timetxt.setText(fruit.gettime());
    }

    @Override
    public int getItemCount() {
        return mMessageList.size();
    }

    public interface OnItemClickListener{
        void onItemClick(View v, int position);
    }

    public static OnItemClickListener mOnItemClickListener;
}
