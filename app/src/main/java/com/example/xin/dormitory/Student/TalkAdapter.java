package com.example.xin.dormitory.Student;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.xin.dormitory.R;

import java.util.List;

public class TalkAdapter extends RecyclerView.Adapter<TalkAdapter.ViewHolder> {

    private List<Talk> mtalkList;

    static class ViewHolder extends RecyclerView.ViewHolder{

        ImageView talkimage;
        TextView talkcontent;

        public ViewHolder(View view)
        {
            super(view);
            talkimage= view.findViewById(R.id.talk_image);
            talkcontent= view.findViewById(R.id.talk_content);
        }
    }


    public TalkAdapter(List<Talk> talkList){
        mtalkList=talkList;
    }


    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType){
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.talkcontent,parent,false);
        return new ViewHolder(view);
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