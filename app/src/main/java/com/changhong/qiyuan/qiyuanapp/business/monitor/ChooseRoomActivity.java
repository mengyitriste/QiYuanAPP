package com.changhong.qiyuan.qiyuanapp.business.monitor;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.changhong.qiyuan.qiyuanapp.R;

public class ChooseRoomActivity extends AppCompatActivity {
    private ImageView icon_back_toolbar;
    private ImageView icon_choosen;
    private TextView toolbar_title;
    private RecyclerView re_items;
    private Context m_context;
    private myListAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_busi_monitor_chooseroom);
        m_context = this;
        icon_back_toolbar = (ImageView)findViewById(R.id.common_toolbar_backicon);
        toolbar_title = (TextView)findViewById(R.id.common_toolbar_textview);
        icon_choosen=(ImageView)findViewById(R.id.iv_iconchoosed);
        toolbar_title.setText(this.getString(R.string.business_choose_room));
        icon_back_toolbar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ChooseRoomActivity.this.finish();
            }
        });
        //设置recyclerView，初始化数据
        re_items = (RecyclerView)findViewById(R.id.rv_busi_monitor_rooms);
        re_items.setLayoutManager(new LinearLayoutManager(m_context));
        adapter = new myListAdapter(m_context);
        re_items.setAdapter(adapter);
        adapter.setOnItemClickListener(new myListAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(View view,int position) {
                icon_choosen = (ImageView)view.findViewById(R.id.iv_iconchoosed);
                if (icon_choosen.getVisibility() == View.VISIBLE) {
                    icon_choosen.setVisibility(View.INVISIBLE);
                } else {
                    icon_choosen.setVisibility(View.VISIBLE);
                }
            }
        });
        initData();

    }

    private void initData() {
        Data.room.clear();
        char a='A';
        for (int i=0;i<5;i++){
            Data.room.add("房间"+a);
            a++;
        }
        Data.find.clear();
        Data.find.addAll(Data.room);
    }

}
