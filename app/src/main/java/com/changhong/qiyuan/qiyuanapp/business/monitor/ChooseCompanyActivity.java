package com.changhong.qiyuan.qiyuanapp.business.monitor;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.changhong.qiyuan.qiyuanapp.R;

public class ChooseCompanyActivity extends AppCompatActivity {
    private ImageView icon_back_toolbar;
    private ImageView icon_choosen;
    private TextView toolbar_title;
    private RecyclerView re_items;
    private Context m_context;
    private myListAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_busi_monitor_choosecomp);
        m_context = this;
        icon_back_toolbar = (ImageView)findViewById(R.id.common_toolbar_backicon);
        toolbar_title = (TextView)findViewById(R.id.common_toolbar_textview);
        toolbar_title.setText(this.getString(R.string.business_choose_enterprise));
        icon_back_toolbar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ChooseCompanyActivity.this.finish();
            }
        });
        //设置recyclerView，初始化数据
        re_items = (RecyclerView)findViewById(R.id.rv_busi_monitor_comps);
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

    private void initData(){
        Data.company.clear();
        char a='A';
        for (int i=0;i<5;i++){
            Data.company.add("公司"+a);
            a++;
        }
        Data.find.clear();
        Data.find.addAll(Data.company);
    }

}

