package com.changhong.qiyuan.qiyuanapp.business.visitor;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.changhong.qiyuan.qiyuanapp.R;
import com.changhong.qiyuan.qiyuanapp.SubmitDownActivity;

public class ApplyInfoActivity extends AppCompatActivity {
    private TextView common_toolbar_textview;
    private ImageView icon_back_toolbar;
    private Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_busi_visitor_info);
        common_toolbar_textview = (TextView)findViewById(R.id.common_toolbar_textview);
        common_toolbar_textview.setText(this.getString(R.string.business_toolbar_visitorapply));
        icon_back_toolbar = (ImageView)findViewById(R.id.common_toolbar_backicon);
        icon_back_toolbar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ApplyInfoActivity.this.finish();
            }
        });
        button=(Button)findViewById(R.id.btn_busi_vistor_applynext);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(ApplyInfoActivity.this, SubmitDownActivity.class);
                startActivity(intent);

            }
        });
    }
}
