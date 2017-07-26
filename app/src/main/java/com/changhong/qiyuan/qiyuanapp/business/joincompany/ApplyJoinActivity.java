package com.changhong.qiyuan.qiyuanapp.business.joincompany;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.changhong.qiyuan.qiyuanapp.R;
import com.changhong.qiyuan.qiyuanapp.SubmitDownActivity;


public class ApplyJoinActivity extends AppCompatActivity {
    private TextView common_toolbar_textview;
    private ImageView icon_back_toolbar;
    private Button button;
    private LinearLayout llayout_parks;
    private LinearLayout llayout_companies;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_busi_joinc_apply);
        common_toolbar_textview = (TextView)findViewById(R.id.common_toolbar_textview);
        common_toolbar_textview.setText(this.getString(R.string.business_toolbar_joincompany));
        icon_back_toolbar = (ImageView)findViewById(R.id.common_toolbar_backicon);
        icon_back_toolbar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ApplyJoinActivity.this.finish();
            }
        });

        button=(Button)findViewById(R.id.btn_busi_joinc_applynext);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(ApplyJoinActivity.this, SubmitDownActivity.class);
                startActivity(intent);

            }
        });
        llayout_parks=(LinearLayout)findViewById(R.id.llayout_busi_joinc_choosepark);
        llayout_parks.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(ApplyJoinActivity.this,ChooseParkActivity.class);
                startActivity(intent);
            }
        });
        llayout_companies=(LinearLayout)findViewById(R.id.llayout_busi_joinc_choosecomp);
        llayout_companies.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(ApplyJoinActivity.this,ChooseCompanyActivity.class);
                startActivity(intent);
            }
        });
    }

}
