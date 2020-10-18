package com.example.ruichatver1_0;

import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import org.w3c.dom.Text;

import java.util.List;

public class BubbleAdapter extends RecyclerView.Adapter<BubbleAdapter.ViewHolder> {
    private List<Bubble> bubbleList;

    static class ViewHolder extends RecyclerView.ViewHolder {
        LinearLayout rheadlay;
        LinearLayout lheadlay;
        LinearLayout leftlay;
        LinearLayout rightlay;
        ImageView rhead;
        ImageView lhead;
        TextView lefttext;
        TextView righttext;

        public ViewHolder(
                View view)
        {
            super(view);

            rhead = (ImageView) view.findViewById(R.id.right_head);
            lhead = (ImageView) view.findViewById(R.id.left_head);
            rheadlay = (LinearLayout) view.findViewById(R.id.righthead_layout);
            lheadlay = (LinearLayout) view.findViewById(R.id.lefthead_layout);
            leftlay = (LinearLayout) view.findViewById(R.id.left_layout);
            rightlay = (LinearLayout) view.findViewById(R.id.right_layout);
            lefttext = (TextView) view.findViewById(R.id.left_text);
            righttext = (TextView) view.findViewById(R.id.right_text);
        }
    }

    public BubbleAdapter(List<Bubble> bubbleList){
        this.bubbleList = bubbleList;
    }

    @Override
    public BubbleAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.bubble_item,parent,false);
        return new ViewHolder(view);
    }



    @Override
    public void onBindViewHolder(@NonNull BubbleAdapter.ViewHolder holder, int position) {
        Bubble bubble = bubbleList.get(position);
        if(bubble.getType() == Bubble.TYPRE_RECEIVED){
            holder.lhead.setImageResource(R.drawable.girl);
            holder.lheadlay.setVisibility(View.VISIBLE);
            holder.leftlay.setVisibility(View.VISIBLE);
            holder.rightlay.setVisibility(View.GONE);
            holder.rheadlay.setVisibility(View.GONE);
            holder.lefttext.setText(bubble.getContent());
        }
        else if(bubble.getType() == Bubble.TYPE_SENT){
            holder.rhead.setImageResource(R.drawable.boy);
            holder.lheadlay.setVisibility(View.GONE);
            holder.leftlay.setVisibility(View.GONE);
            holder.rightlay.setVisibility(View.VISIBLE);
            holder.rheadlay.setVisibility(View.VISIBLE);
            holder.righttext.setText(bubble.getContent());
        }
    }

    @Override
    public int getItemCount() {
        return bubbleList.size();
    }
}
