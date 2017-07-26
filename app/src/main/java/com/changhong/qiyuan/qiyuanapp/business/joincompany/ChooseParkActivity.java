package com.changhong.qiyuan.qiyuanapp.business.joincompany;


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

public class ChooseParkActivity extends AppCompatActivity {
    private ImageView icon_back_toolbar;
    private Context m_context;
    private TextView common_toolbar_textview;
    private RecyclerView re_items;
    @Override
    protected void onCreate( Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_busi_joinc_choosepark);
        icon_back_toolbar = (ImageView)findViewById(R.id.common_toolbar_backicon);
        icon_back_toolbar.setOnClickListener(mClickListener);
        m_context = this;
        common_toolbar_textview = (TextView)findViewById(R.id.common_toolbar_textview);
        common_toolbar_textview.setText(this.getString(R.string.business_toolbar_selectpark));
        re_items = (RecyclerView)findViewById(R.id.rv_busi_joinc_parks);
        setRecyclerView();
    }
    View.OnClickListener mClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            ChooseParkActivity.this.finish();
        }
    };
    private void setRecyclerView(){
        re_items.setLayoutManager(new LinearLayoutManager(m_context));
        re_items.setAdapter(new ChooseParkActivity.myListAdapter(m_context));
    }

    private class myListAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
        Context context;
        myListAdapter(Context context) {
            this.context = context;
        }

        @Override
        public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            //根据item类别加载不同ViewHolder
            View view = LayoutInflater.from(context).inflate(R.layout.item_textview, parent, false);
            ChooseParkActivity.myListAdapter.MyViewHolder holder = new ChooseParkActivity.myListAdapter.MyViewHolder(view);
            return holder;
        }
        @Override
        public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
            if (holder instanceof ChooseParkActivity.myListAdapter.MyViewHolder) {
                ((ChooseParkActivity.myListAdapter.MyViewHolder)holder).tvItems.setText(context.getString(R.string.business_qiyuanpark));
            }
        }

        @Override
        public int getItemCount() {
            return 12;
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
