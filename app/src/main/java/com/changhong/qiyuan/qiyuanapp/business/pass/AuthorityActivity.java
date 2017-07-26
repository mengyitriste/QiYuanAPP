package com.changhong.qiyuan.qiyuanapp.business.pass;


import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.changhong.qiyuan.qiyuanapp.R;

import java.util.ArrayList;

public class AuthorityActivity extends AppCompatActivity {
    private TextView common_toolbar_textview;
    private ImageView icon_back_toolbar;
    private LinearLayout llayout_doors;
    private Context m_context;
    private RecyclerView re_items;
    static ArrayList<String> time = new ArrayList<String>();
    static ArrayList<String> door = new ArrayList<String>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_busi_pass_authority);
        m_context=this;
        common_toolbar_textview = (TextView)findViewById(R.id.common_toolbar_textview);
        common_toolbar_textview.setText(this.getString(R.string.business_toolbar_passauthority));
        icon_back_toolbar = (ImageView)findViewById(R.id.common_toolbar_backicon);
        icon_back_toolbar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AuthorityActivity.this.finish();
            }
        });
        llayout_doors=(LinearLayout)findViewById(R.id.llayout_busi_pass_chooseroom);
        llayout_doors.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(AuthorityActivity.this,ChooseDoorActivity.class);
                startActivity(intent);
            }
        });
        //设置recylerview
        re_items=(RecyclerView)findViewById(R.id.rv_busi_pass_pending_authority);
        re_items.setLayoutManager(new LinearLayoutManager(m_context));
        re_items.setAdapter(new AuthorityActivity.myListAdapter(m_context));
        initData();

    }

    private void initData() {
        time.clear();
        time.add("2017-4-30 15:36");
        time.add("2017-4-30 15:36");
        door.clear();
        door.add("104");
        door.add("105、106、107");
    }

    private class myListAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
        Context context;
        myListAdapter(Context context) {
            this.context = context;
        }

        @Override
        public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            //根据item类别加载不同ViewHolder
            View view = LayoutInflater.from(context).inflate(R.layout.item_busi_pass_reviewing, parent, false);
            AuthorityActivity.myListAdapter.MyViewHolder holder = new AuthorityActivity.myListAdapter.MyViewHolder(view);
            return holder;
        }
        @Override
        public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
            if (holder instanceof AuthorityActivity.myListAdapter.MyViewHolder) {
                ((MyViewHolder)holder).tvTime.setText(time.get(position));
                ((MyViewHolder)holder).tvDoor.setText(door.get(position));

            }
        }

        @Override
        public int getItemCount() {
            return time.size();
        }

        //自定义ViewHolder，用于加载图片
        class MyViewHolder extends RecyclerView.ViewHolder {
            private TextView tvTime;
            private TextView tvDoor;

            MyViewHolder(View view) {
                super(view);
                tvTime = (TextView)view.findViewById(R.id.tv_busi_pass_reviewingtime);
                tvDoor = (TextView)view.findViewById(R.id.tv_busi_pass_reviewingdoor);
            }
        }
    }
}

