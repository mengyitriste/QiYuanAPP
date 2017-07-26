package com.changhong.qiyuan.qiyuanapp.business.monitor;


import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.changhong.qiyuan.qiyuanapp.R;

public class myListAdapter extends RecyclerView.Adapter<myListAdapter.MyViewHolder> {

    private Context m_context;

    public myListAdapter(Context context){
        this.m_context=context;
    }

    @Override
    public int getItemCount() {

        return Data.find.size();
    }
    interface OnItemClickListener
    {
        void onItemClick(View view,int position);
    }
    private myListAdapter.OnItemClickListener mOnItemClickListener;
    void setOnItemClickListener(myListAdapter.OnItemClickListener onItemClickListener ){
        this. mOnItemClickListener=onItemClickListener;
    }

    //填充onCreateViewHolder方法返回的holder中的控件
    @Override
    public void onBindViewHolder(final MyViewHolder holder, final int position) {

        holder.textView.setText( Data.find.get(position));
        ((myListAdapter.MyViewHolder) holder).imageView.setImageResource(R.mipmap.ic_common_down);
        if (mOnItemClickListener != null)
        {
            holder.itemView.setOnClickListener(new View.OnClickListener()
            {
                @Override
                public void onClick(View v)
                {
                    mOnItemClickListener.onItemClick(holder.imageView,position);
                }
            });
        }
    }

    //重写onCreateViewHolder方法，返回一个自定义的ViewHolder
    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(m_context).inflate(R.layout.item_textimage_view, parent, false);
        return new myListAdapter.MyViewHolder(view);
    }

    class MyViewHolder extends ViewHolder{

        TextView textView;
        ImageView imageView;

        public MyViewHolder(View view) {
            super(view);
            textView=(TextView) view.findViewById(R.id.tv_item);
            imageView=(ImageView)view.findViewById(R.id.iv_iconchoosed);
        }

    }


}