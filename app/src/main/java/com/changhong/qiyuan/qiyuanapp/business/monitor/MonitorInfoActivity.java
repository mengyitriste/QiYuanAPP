package com.changhong.qiyuan.qiyuanapp.business.monitor;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.changhong.qiyuan.qiyuanapp.R;
import com.changhong.qiyuan.qiyuanapp.SubmitDownActivity;

public class MonitorInfoActivity extends AppCompatActivity {
    private TextView common_toolbar_textview;
    private ImageView icon_back_toolbar;
    private Button button;
    private LinearLayout llayout_companies;
    private LinearLayout llayout_rooms;
    private LinearLayout llayout_cameras;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_busi_monitor_info);
        common_toolbar_textview = (TextView)findViewById(R.id.common_toolbar_textview);
        common_toolbar_textview.setText(this.getString(R.string.business_toolbar_monitor));
        icon_back_toolbar = (ImageView)findViewById(R.id.common_toolbar_backicon);
        icon_back_toolbar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MonitorInfoActivity.this.finish();
            }
        });
        button=(Button)findViewById(R.id.btn_busi_monitor_applynext);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MonitorInfoActivity.this, SubmitDownActivity.class);
                startActivity(intent);

            }
        });
        llayout_companies=(LinearLayout)findViewById(R.id.llayout_busi_monitor_choosecomp);
        llayout_companies.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MonitorInfoActivity.this,ChooseCompanyActivity.class);
                startActivity(intent);
            }
        });
        llayout_rooms=(LinearLayout)findViewById(R.id.llayout_busi_monitor_chooseroom);
        llayout_rooms.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MonitorInfoActivity.this,ChooseRoomActivity.class);
                startActivity(intent);
            }
        });
        llayout_cameras=(LinearLayout)findViewById(R.id.llayout_busi_monitor_choosecamera);
        llayout_cameras.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MonitorInfoActivity.this,ChooseCameraActivity.class);
                startActivity(intent);
            }
        });
    }


}
