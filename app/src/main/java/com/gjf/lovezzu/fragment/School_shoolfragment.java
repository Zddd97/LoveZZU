package com.gjf.lovezzu.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.GridLayoutManager;
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
import com.gjf.lovezzu.SchoolLast;
import com.gjf.lovezzu.SchoolLastAdapter;
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
    private ArrayList<String> imageUrls = new ArrayList<String>();
    private List<SchoolMid> schoolMidList = new ArrayList<>();
    private List<SchoolLast> schoolLastList = new ArrayList<>();

    public static final String TAG = "Fragment";

/*
    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        Log.d(TAG, "onAttach");
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Log.d(TAG, "onCreate");

    }*/

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        final View view = inflater.inflate(R.layout.inchool_school_view, container, false);
        //初始化所需数据

        initSchoolList();

        //Log.d(TAG, "onCreateView");
        //头部轮播
        flashView = (FlashView) view.findViewById(R.id.flash_view);
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

        RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.in_mid_school);
        LinearLayoutManager layoutManager = new LinearLayoutManager(view.getContext());
        layoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
        recyclerView.setLayoutManager(layoutManager);
        SchoolMidAdapter adapter = new SchoolMidAdapter(schoolMidList);
        recyclerView.setAdapter(adapter);

        //结尾部分
        RecyclerView recyclerView1 = (RecyclerView) view.findViewById(R.id.last_school_content);
        GridLayoutManager gridLayoutManager = new GridLayoutManager(view.getContext(), 3);
        recyclerView1.setLayoutManager(gridLayoutManager);
        SchoolLastAdapter adapter1 = new SchoolLastAdapter(schoolLastList);
        recyclerView1.setAdapter(adapter1);
        return view;
    }

    private void initSchoolList() {
        //以下数据为测试数据，真实数据可从服务器中获取,由于要加载的数据过多，可以新建一个线程进行加载数据，并进行数据的初始化
        //首页的新闻总是要更新的，是不是可以写成一个server，在后台进行更新
        //头部轮播图片，从服务器中加载

        imageUrls.add("http://www.bz55.com/uploads1/allimg/120312/1_120312100435_8.jpg");
        imageUrls.add("http://img2.pconline.com.cn/pconline/0706/19/1038447_34.jpg");
        imageUrls.add("http://www.237.cc/uploads/pcline/712_0_1680x1050.jpg");

        //中间滑动项，从服务器中加载
        Intent intent = new Intent(getContext(), MainActivity.class);
        SchoolMid schoolMid_1 = new SchoolMid(R.drawable.schoolintroduce, intent);
        SchoolMid schoolMid_2 = new SchoolMid(R.drawable.schoolstyle, intent);
        SchoolMid schoolMid_3 = new SchoolMid(R.drawable.schoolfamous, intent);
        SchoolMid schoolMid_4 = new SchoolMid(R.drawable.schoolnews, intent);

        schoolMidList.add(schoolMid_1);
        schoolMidList.add(schoolMid_2);
        schoolMidList.add(schoolMid_3);
        schoolMidList.add(schoolMid_4);

        //结尾新闻项（for循环从服务器读取出SchoolLast对象）

        SchoolLast schoolLast3 = new SchoolLast(R.drawable.life_play_img1, "新闻标题1234", "新闻详情：http://...");
        SchoolLast schoolLast4 = new SchoolLast(R.drawable.life_play_img2, "新闻标题tdrhsf", "新闻详情：http://...");
        SchoolLast schoolLast5 = new SchoolLast(R.drawable.life_play_img3, "新闻标题dghllllllllllllll", "新闻详情：http://...");
        SchoolLast schoolLast6 = new SchoolLast(R.drawable.life_play_img4, "新闻标题217532", "新闻详情：http://...");
        SchoolLast schoolLast7 = new SchoolLast(R.drawable.life_play_img5, "新闻标题1024522", "新闻详情：http://...");
        SchoolLast schoolLast8 = new SchoolLast(R.drawable.life_play_img6, "新闻标题455", "新闻详情：http://...");
        SchoolLast schoolLast9 = new SchoolLast(R.drawable.life_play_img1, "新闻标题555555555555555555555555555", "新闻详情：http://...");


        schoolLastList.add(schoolLast3);
        schoolLastList.add(schoolLast4);
        schoolLastList.add(schoolLast5);
        schoolLastList.add(schoolLast6);
        schoolLastList.add(schoolLast7);
        schoolLastList.add(schoolLast8);
        schoolLastList.add(schoolLast9);

    }

     /*
        * 设置向服务器请求图片--返回jison--{json:图片的URL和点击图片跳转的的URL}（有格式）--本地解析json--
        * 将图片的URL和点击的URL解析 匹配，用于设置相应的点击事件
        *
        * */

 /*   @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        Log.d(TAG, "onActivityCreated");
    }

    @Override
    public void onStart() {
        super.onStart();
        Log.d(TAG, "onStart");
    }

    @Override
    public void onResume() {
        super.onResume();
        Log.d(TAG, "onResume");
    }

    @Override
    public void onPause() {
        super.onPause();
        Log.d(TAG, "onPause");
    }

    @Override
    public void onStop() {
        super.onStop();
        Log.d(TAG, "onStop");
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        Log.d(TAG, "onDestroyView");

    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.d(TAG, "onDestroy");
    }

    @Override
    public void onDetach() {
        super.onDetach();
        Log.d(TAG, "onDetach");
    }*/
}
