package com.example.xin.dormitory;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class TalkAdapter extends RecyclerView.Adapter<TalkAdapter.ViewHolder> {
    private List<Talk> mtalkList;
    static class ViewHolder extends RecyclerView.ViewHolder{
        ImageView talkimage;
        TextView talkcontent;
        public ViewHolder(View view)
        {
            super(view);
            talkimage=(ImageView) view.findViewById(R.id.talk_image);
            talkcontent=(TextView) view.findViewById(R.id.talk_content);
        }
    }

    public TalkAdapter(List<Talk> talkList){
        mtalkList=talkList;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType){
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.talkcontent,parent,false);
        ViewHolder holder=new ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder,int position){
        Talk talk=mtalkList.get(position);
        holder.talkimage.setImageResource(talk.getImageId());
        holder.talkcontent.setText(talk.getName());
    }

    @Override
    public int getItemCount() {
        return mtalkList.size();
    }
}
