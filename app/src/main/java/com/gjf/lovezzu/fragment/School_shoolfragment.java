package com.gjf.lovezzu.fragment;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.gc.flashview.FlashView;
import com.gc.flashview.constants.EffectConstants;
import com.gc.flashview.listener.FlashViewListener;
import com.gjf.lovezzu.R;
import com.gjf.lovezzu.SchoolMid;
import com.gjf.lovezzu.SchoolMidAdapter;
import com.gjf.lovezzu.activity.MainActivity;


import java.util.ArrayList;
import java.util.List;

/**
 * Created by lenovo047 on 2017/3/9.
 */

public class School_shoolfragment extends android.app.Fragment {

    private FlashView flashView;
    private ArrayList<String> imageUrls;
    private List<SchoolMid> schoolMidList = new ArrayList<>();

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        final View view = inflater.inflate(R.layout.inchool_school_view, container, false);
        flashView = (FlashView) view.findViewById(R.id.flash_view);
        imageUrls = new ArrayList<String>();
        imageUrls.add("http://www.bz55.com/uploads1/allimg/120312/1_120312100435_8.jpg");
        imageUrls.add("http://img2.pconline.com.cn/pconline/0706/19/1038447_34.jpg");
        imageUrls.add("http://www.237.cc/uploads/pcline/712_0_1680x1050.jpg");
        flashView.setImageUris(imageUrls);
        flashView.setEffect(EffectConstants.DEFAULT_EFFECT);//更改图片切换的动画效果
        flashView.setOnPageClickListener(new FlashViewListener() {
            @Override
            public void onClick(int position) {
                Toast.makeText(view.getContext(), "你的点击的是第" + (position + 1) + "张图片！",
                        Toast.LENGTH_SHORT).show();

            }
        });

        //中间部分
        initSchoolMidList();
        RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.in_mid_school);
        LinearLayoutManager layoutManager = new LinearLayoutManager(view.getContext());
        layoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
        recyclerView.setLayoutManager(layoutManager);
        SchoolMidAdapter adapter = new SchoolMidAdapter(schoolMidList);
        recyclerView.setAdapter(adapter);


        return view;
    }

    private void initSchoolMidList() {
        Intent intent = new Intent(getContext(),MainActivity.class);
        SchoolMid schoolMid_1 = new SchoolMid(R.drawable.schoolintroduce, intent);
        SchoolMid schoolMid_2 = new SchoolMid(R.drawable.schoolstyle, intent);
        SchoolMid schoolMid_3 = new SchoolMid(R.drawable.schoolfamous, intent);
        SchoolMid schoolMid_4 = new SchoolMid(R.drawable.schoolnews, intent);

        schoolMidList.add(schoolMid_1);
        schoolMidList.add(schoolMid_2);
        schoolMidList.add(schoolMid_3);
        schoolMidList.add(schoolMid_4);
    }

     /*
        * 设置向服务器请求图片--返回jison--{json:图片的URL和点击图片跳转的的URL}（有格式）--本地解析json--
        * 将图片的URL和点击的URL解析 匹配，用于设置相应的点击事件
        *
        * */


}
