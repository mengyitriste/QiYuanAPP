package com.changhong.qiyuan.qiyuanapp.usercenter.Setting;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.changhong.qiyuan.qiyuanapp.R;

import java.util.ArrayList;

public class HelpActivity extends AppCompatActivity {
    private Context m_context;
    private RecyclerView re_items;
    static ArrayList<String> problem = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ucent_setting_help);
        m_context = this;
        re_items=(RecyclerView)findViewById(R.id.rv_ucent_setting_problems);
        setRecyclerView();
        initData();
    }

    private void initData() {
        problem.add("问题一");
        problem.add("问题二");
        problem.add("问题三");
        problem.add("问题四");
        problem.add("问题五");
        problem.add("问题六");

    }

    private void setRecyclerView(){
        re_items.setLayoutManager(new LinearLayoutManager(m_context));
        re_items.setAdapter(new HelpActivity.myListAdapter(m_context));
    }

    private class myListAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
        Context context;
        myListAdapter(Context context) {
            this.context = context;
        }

        @Override
        public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            //根据item类别加载不同ViewHolder
            View view = LayoutInflater.from(context).inflate(R.layout.item_textimage_view1, parent, false);
            HelpActivity.myListAdapter.MyViewHolder holder = new HelpActivity.myListAdapter.MyViewHolder(view);
            return holder;
        }
        @Override
        public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
            if (holder instanceof HelpActivity.myListAdapter.MyViewHolder) {
                ((MyViewHolder)holder).tvItems.setText(problem.get(position));
            }
        }

        @Override
        public int getItemCount() {
            return problem.size();
        }

        //自定义ViewHolder，用于加载图片
        class MyViewHolder extends RecyclerView.ViewHolder {
            private TextView tvItems;

            MyViewHolder(View view) {
                super(view);
                tvItems = (TextView)view.findViewById(R.id.tv_item);
            }
        }
    }



}
