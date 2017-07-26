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
import android.widget.TextView;
import java.util.ArrayList;

import com.changhong.qiyuan.qiyuanapp.R;
import com.changhong.qiyuan.qiyuanapp.SubmitDownActivity;


public class ChooseDoorActivity extends AppCompatActivity {
    private Context m_context;
    private TextView common_toolbar_textview;
    private ImageView icon_back_toolbar;
    private RecyclerView re_items;
    private Button button;
    private ImageView icon_choosen;
    private myListAdapter adapter;
    static ArrayList<String> door = new ArrayList<String>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_busi_pass_chooseroom);
        m_context = this;
        common_toolbar_textview = (TextView)findViewById(R.id.common_toolbar_textview);
        common_toolbar_textview.setText(this.getString(R.string.business_toolbar_choosedoor));
        icon_back_toolbar = (ImageView)findViewById(R.id.common_toolbar_backicon);
        icon_back_toolbar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ChooseDoorActivity.this.finish();
            }
        });
        re_items=(RecyclerView)findViewById(R.id.rv_busi_pass_choosedoor);
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

        button=(Button)findViewById(R.id.btn_busi_pass_applynext);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(ChooseDoorActivity.this, SubmitDownActivity.class);
                startActivity(intent);

            }
        });
    }

    private void initData() {
        door.clear();
        int a=105;
        for (int i=0;i<5;i++){
            door.add("门"+a);
            a++;
        }
    }

    private static class myListAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
        Context context;
        myListAdapter(Context context) {
            this.context = context;
        }
        private interface OnItemClickListener
        {
            void onItemClick(View view,int position);
        }
        private myListAdapter.OnItemClickListener mOnItemClickListener;
        void setOnItemClickListener(myListAdapter.OnItemClickListener onItemClickListener ){
            this. mOnItemClickListener=onItemClickListener;
        }
        @Override
        public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            //根据item类别加载不同ViewHolder
            View view = LayoutInflater.from(context).inflate(R.layout.item_textimage_view, parent, false);
            ChooseDoorActivity.myListAdapter.MyViewHolder holder = new ChooseDoorActivity.myListAdapter.MyViewHolder(view);
            return holder;
        }
        @Override
        public void onBindViewHolder(final RecyclerView.ViewHolder holder, final int position) {
            if (holder instanceof ChooseDoorActivity.myListAdapter.MyViewHolder) {
                ((MyViewHolder) holder).textView.setText( door.get(position));
                ((myListAdapter.MyViewHolder) holder).imageView.setImageResource(R.mipmap.ic_common_down);
                if (mOnItemClickListener != null)
                {
                    holder.itemView.setOnClickListener(new View.OnClickListener()
                    {
                        @Override
                        public void onClick(View v)
                        {
                            mOnItemClickListener.onItemClick(((MyViewHolder) holder).imageView,position);
                        }
                    });
                }
            }
        }

        @Override
        public int getItemCount() {
            return door.size();
        }

        //自定义ViewHolder，用于加载图片
        class MyViewHolder extends RecyclerView.ViewHolder {
            private TextView textView;
            ImageView imageView;

            MyViewHolder(View view) {
                super(view);
                textView = (TextView)view.findViewById(R.id.tv_item);
                imageView=(ImageView)view.findViewById(R.id.iv_iconchoosed);
            }
        }
    }


}
