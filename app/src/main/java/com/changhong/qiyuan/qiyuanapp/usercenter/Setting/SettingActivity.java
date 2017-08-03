package com.changhong.qiyuan.qiyuanapp.usercenter.Setting;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.changhong.qiyuan.qiyuanapp.R;
import com.changhong.qiyuan.qiyuanapp.view.UISwitchButton;

public class SettingActivity extends AppCompatActivity implements View.OnClickListener{
    private UISwitchButton ios_switch;
    private View inflate;
    private Button bt_ok;
    private Button bt_cancle;
    private Dialog dialog;
    private TextView tv_reset;
    private TextView tv_clearcache;
    private TextView tv_quit;
    private LinearLayout llayout_help;
    private LinearLayout llayout_about;


    private Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ucent_setting);
        context = this;
        initView();
        llayout_help=(LinearLayout)findViewById(R.id.llayout_ucent_setting_help);
        llayout_help.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(SettingActivity.this,HelpActivity.class);
                startActivity(intent);
            }
        });

        llayout_about=(LinearLayout)findViewById(R.id.llayout_ucent_setting_about);
        llayout_about.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(SettingActivity.this,AboutActivity.class);
                startActivity(intent);
            }
        });

        tv_reset=(TextView)findViewById(R.id.tv_ucent_admp_reset);
        tv_reset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                initDialog();
                bt_ok.setText(R.string.reset);
            }
        });


        tv_clearcache=(TextView)findViewById(R.id.tv_ucent_admp_clearcache);
        tv_clearcache.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                initDialog();
                bt_ok.setText(R.string.clear_cache);
            }
        });


        tv_quit=(TextView)findViewById(R.id.tv_ucent_admp_quit);
        tv_quit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                initDialog();
                bt_ok.setText(R.string.quit);
            }
        });


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

    private void initDialog(){
        dialog = new Dialog(context,R.style.ActionSheetDialogStyle);
        //填充对话框的布局
        inflate = LayoutInflater.from(context).inflate(R.layout.item_dialog, null);
        //初始化控件
        bt_ok = (Button) inflate.findViewById(R.id.bt_ucent_admp_ok);
        bt_cancle = (Button) inflate.findViewById(R.id.bt_ucent_admp_cancel);
        bt_ok.setOnClickListener(this);
        bt_cancle.setOnClickListener(this);
        //将布局设置给Dialog
        dialog.setContentView(inflate);
        //获取当前Activity所在的窗体
        Window dialogWindow = dialog.getWindow();
        //设置Dialog从窗体底部弹出
        dialogWindow.setGravity( Gravity.BOTTOM);
        //获得窗体的属性
        WindowManager.LayoutParams lp = dialogWindow.getAttributes();
        lp.y = 0;//设置Dialog距离底部的距离
        lp.width =  WindowManager.LayoutParams.MATCH_PARENT;
        //将属性设置给窗体
        dialogWindow.setAttributes(lp);
        dialog.show();//显示对话框

    }


    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.bt_ucent_admp_ok:
                Log.i("","");
                break;
            case R.id.bt_ucent_admp_cancel:
                Log.i("","");
                break;
        }
        dialog.dismiss();
    }

}