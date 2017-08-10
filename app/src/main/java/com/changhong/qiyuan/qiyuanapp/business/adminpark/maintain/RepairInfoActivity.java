package com.changhong.qiyuan.qiyuanapp.business.adminpark.maintain;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.changhong.qiyuan.qiyuanapp.R;

public class RepairInfoActivity extends AppCompatActivity {
    private Context m_context;
    private RecyclerView re_items;
    private myListAdapter adapater;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_busi_admp_repair_info);
        m_context = this;
        re_items = (RecyclerView)findViewById(R.id.rv_busi_admp_repair_infos);
        re_items.setLayoutManager(new LinearLayoutManager(m_context));
        adapater = new myListAdapter(m_context);
        re_items.setAdapter(adapater);
        adapater.setOnItemClickListener(new myListAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {
                Intent intent=new Intent(RepairInfoActivity.this,RepairDetailActivity.class);
                startActivity(intent);

            }
        });
        adapater.notifyDataSetChanged();
    }


    private static class myListAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
        Context context;
        myListAdapter(Context context) {
            this.context = context;
        }

        @Override
        public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            //根据item类别加载不同ViewHolder
            View view = LayoutInflater.from(context).inflate(R.layout.item_busi_admp_repair, parent, false);
            RepairInfoActivity.myListAdapter.MyViewHolder holder = new RepairInfoActivity.myListAdapter.MyViewHolder(view);
            return holder;
        }

        interface OnItemClickListener
        {
            void onItemClick(View view,int position);
        }
        private myListAdapter.OnItemClickListener mOnItemClickListener;
        void setOnItemClickListener(myListAdapter.OnItemClickListener onItemClickListener ){
            this. mOnItemClickListener=onItemClickListener;
        }

        @Override
        public void onBindViewHolder(final RecyclerView.ViewHolder holder, int position) {
            if (holder instanceof RepairInfoActivity.myListAdapter.MyViewHolder) {
                if(Data.repair_status==1){
                    ((MyViewHolder)holder).tv_passornot.setText(context.getString(R.string.passed));
                    ((MyViewHolder)holder).tv_passornot.setTextColor(context.getResources().getColor(R.color.blue));
                }
                if(Data.repair_status==2){
                    ((MyViewHolder)holder).tv_passornot.setText(context.getString(R.string.not_entertained));
                    ((MyViewHolder)holder).tv_passornot.setTextColor(context.getResources().getColor(R.color.light_red));
                }

                if (mOnItemClickListener != null)
                {
                    holder.itemView.setOnClickListener(new View.OnClickListener()
                    {
                        @Override
                        public void onClick(View v)
                        {
                            int position = holder.getLayoutPosition();
                            mOnItemClickListener.onItemClick(((MyViewHolder) holder).tv_passornot,position);
                        }
                    });
                }
            }
        }

        @Override
        public int getItemCount() {
            return 4;
        }

        //自定义ViewHolder，用于加载图片
        class MyViewHolder extends RecyclerView.ViewHolder {
            private TextView tv_name;
            private TextView tv_phone;
            private TextView tv_time;
            private ImageView iv_head;
            private TextView tv_passornot;

            MyViewHolder(View view) {
                super(view);
                tv_name = (TextView)view.findViewById(R.id.tv_item_busi_admp_repir_name);
                tv_phone=(TextView)view.findViewById(R.id.tv_item_busi_admp_repir_phone);
                tv_time=(TextView)view.findViewById(R.id.tv_item_busi_admp_repir_time);
                iv_head = (ImageView)view.findViewById(R.id.iv_item_busi_admp_repir_admin);
                tv_passornot=(TextView)view.findViewById(R.id.tv_item_busi_admp_repir_passornot);
            }
        }
    }
}
