package com.changhong.qiyuan.qiyuanapp.usercenter.Setting;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.LinearLayout;

import com.changhong.qiyuan.qiyuanapp.R;

public class AboutActivity extends AppCompatActivity {
    private LinearLayout llayout_goscore;
    private LinearLayout llayout_function;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ucent_setting_about);
        llayout_goscore=(LinearLayout)findViewById(R.id.llayout_ucent_setting_goscore);
        llayout_goscore.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Uri uri = Uri.parse("market://details?id=" + getPackageName());
                Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(intent);

            }
        });

        llayout_function=(LinearLayout) findViewById(R.id.llayout_ucent_setting_function);
        llayout_function.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(AboutActivity.this,FunctionActivity.class);
                startActivity(intent);
            }
        });
    }



}
