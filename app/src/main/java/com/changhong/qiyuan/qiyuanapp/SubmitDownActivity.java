package com.changhong.qiyuan.qiyuanapp;


import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.changhong.qiyuan.qiyuanapp.R;

public class SubmitDownActivity extends AppCompatActivity{
    private TextView common_toolbar_textview;
    private ImageView icon_back_toolbar;
    private Button button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_submitdown);
        common_toolbar_textview = (TextView)findViewById(R.id.common_toolbar_textview);
        common_toolbar_textview.setText(this.getString(R.string.down_submit));
        icon_back_toolbar = (ImageView)findViewById(R.id.common_toolbar_backicon);
        icon_back_toolbar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SubmitDownActivity.this.finish();
            }
        });
        button=(Button)findViewById(R.id.btn_submit_down);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SubmitDownActivity.this.finish();
            }
        });

    }
}
