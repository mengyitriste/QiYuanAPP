package com.changhong.qiyuan.qiyuanapp.usercenter.Setting;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;

import com.changhong.qiyuan.qiyuanapp.R;
import com.changhong.qiyuan.qiyuanapp.view.UISwitchButton;

public class SettingActivity extends Activity {
    private UISwitchButton ios_switch;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ucent_setting);
        initView();
    }

    private void initView() {
        ios_switch = (UISwitchButton) findViewById(R.id.ios_swith);
        ios_switch.setOnCheckedChangeListener(new OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView,
                                         boolean isChecked) {
                if (isChecked) {
                    Log.i("open","开启");
                } else {
                    Log.i("close", "关闭");
                }
            }
        });
    }
}