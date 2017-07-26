package com.changhong.qiyuan.qiyuanapp.business.pass;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.changhong.qiyuan.qiyuanapp.R;

public class AuthoritiesActivity extends AppCompatActivity {
    private TextView common_toolbar_textview;
    private ImageView icon_back_toolbar;
    private LinearLayout llayout_doors;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_busi_pass_authority);
        common_toolbar_textview = (TextView)findViewById(R.id.common_toolbar_textview);
        common_toolbar_textview.setText(this.getString(R.string.business_toolbar_passauthority));
        icon_back_toolbar = (ImageView)findViewById(R.id.common_toolbar_backicon);
        icon_back_toolbar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AuthoritiesActivity.this.finish();
            }
        });
        llayout_doors=(LinearLayout)findViewById(R.id.llayout_busi_pass_choosedroom);
        llayout_doors.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(AuthoritiesActivity.this,ChooseDoorActivity.class);
                startActivity(intent);
            }
        });
    }
}
