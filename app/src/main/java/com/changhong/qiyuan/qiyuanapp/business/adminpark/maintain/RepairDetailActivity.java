package com.changhong.qiyuan.qiyuanapp.business.adminpark.maintain;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.changhong.qiyuan.qiyuanapp.R;

public class RepairDetailActivity extends AppCompatActivity {
    private ImageButton ibn_add;
    private ImageButton ibn_camera;
    private ImageButton ibn_photo;
    private Button bt_accpet;
    private Button bt_refuse;
    private LinearLayout llayout_add;
    private LinearLayout llayout_accpet;
    private LinearLayout llayout_refuse;
    private LinearLayout llayout_btn;
    private RelativeLayout rlayout_edit;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_busi_admp_repair_detail);
        rlayout_edit=(RelativeLayout)findViewById(R.id.rlayout_busi_admp_repair_edit);
        llayout_accpet=(LinearLayout)findViewById(R.id.llayout_item_busi_admp_repir_accpet);
        llayout_refuse=(LinearLayout)findViewById(R.id.llayout_item_busi_admp_repir_refuse);
        llayout_btn=(LinearLayout)findViewById(R.id.llayout_item_busi_admp_button);

        initlayout();
        ibn_add=(ImageButton) findViewById(R.id.ibn_busi_admp_repair_add);
        llayout_add=(LinearLayout)findViewById(R.id.llayout_item_busi_admp_repir_add);
        ibn_add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(llayout_add.getVisibility()==View.GONE){
                    llayout_add.setVisibility(View.VISIBLE);
                }else {llayout_add.setVisibility(View.GONE);
                }
            }
        });

        ibn_camera=(ImageButton)findViewById(R.id.ibn_busi_admp_repair_camera);
        ibn_camera.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(); //调用照相机
                intent.setAction("android.media.action.STILL_IMAGE_CAMERA");
                startActivity(intent);
            }
        });

        ibn_photo=(ImageButton)findViewById(R.id.ibn_busi_admp_repair_photo);
        ibn_photo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_PICK,
                        android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI);//调用图库
                startActivity(intent);

            }
        });

        bt_accpet=(Button)findViewById(R.id.btn_busi_admp_repair_accpet);
        bt_accpet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                RepairDetailActivity.this.finish();
                Intent intent = new Intent(RepairDetailActivity.this,RepairInfoActivity.class);
                startActivity(intent);
                Data.repair_status=1;
            }
        });

        bt_refuse=(Button)findViewById(R.id.btn_busi_admp_repair_refuse);
        bt_refuse.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                RepairDetailActivity.this.finish();
                Intent intent = new Intent(RepairDetailActivity.this,RepairInfoActivity.class);
                startActivity(intent);
                Data.repair_status=2;
            }
        });

    }

    private void initlayout() {
        if(Data.repair_status==1) {
            rlayout_edit.setVisibility(View.GONE);
            llayout_btn.setVisibility(View.GONE);
            llayout_accpet.setVisibility(View.VISIBLE);
        }
        if(Data.repair_status==2) {
            rlayout_edit.setVisibility(View.GONE);
            llayout_btn.setVisibility(View.GONE);
            llayout_refuse.setVisibility(View.VISIBLE);
        }
    }
}
