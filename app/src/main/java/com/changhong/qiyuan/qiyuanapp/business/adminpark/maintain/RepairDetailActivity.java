package com.changhong.qiyuan.qiyuanapp.business.adminpark.maintain;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.LinearLayout;

import com.changhong.qiyuan.qiyuanapp.R;

public class RepairDetailActivity extends AppCompatActivity {
    private ImageButton bt_add;
    private ImageButton bt_camera;
    private ImageButton bt_photo;
    private LinearLayout llayout_add;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_busi_admp_repair_detail);
        bt_add=(ImageButton) findViewById(R.id.ibn_busi_admp_repair_add);
        llayout_add=(LinearLayout)findViewById(R.id.llayout_item_busi_admp_repir_add);
        bt_add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(llayout_add.getVisibility()==View.GONE){
                    llayout_add.setVisibility(View.VISIBLE);
                }else {llayout_add.setVisibility(View.GONE);
                }
            }
        });

        bt_camera=(ImageButton)findViewById(R.id.ibn_busi_admp_repair_camera);
        bt_camera.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(); //调用照相机
                intent.setAction("android.media.action.STILL_IMAGE_CAMERA");
                startActivity(intent);
            }
        });

        bt_photo=(ImageButton)findViewById(R.id.ibn_busi_admp_repair_photo);
        bt_photo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

    }
}
