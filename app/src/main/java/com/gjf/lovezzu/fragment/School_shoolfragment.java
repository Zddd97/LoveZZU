package com.gjf.lovezzu.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.widget.SwipeRefreshLayout;
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
import com.gjf.lovezzu.activity.MainActivity;
import com.gjf.lovezzu.entity.SchoolMid;
import com.gjf.lovezzu.entity.SchoolNewsData;
import com.gjf.lovezzu.entity.SchoolNewsResult;
import com.gjf.lovezzu.network.SchoolNewsMethods;
import com.gjf.lovezzu.view.SchoolLastAdapter;
import com.gjf.lovezzu.view.SchoolMidAdapter;

import java.util.ArrayList;
import java.util.List;

import rx.Subscriber;

/**
 * Created by lenovo047 on 2017/3/9.
 */

public class School_shoolfragment extends android.app.Fragment {
    private View view;
    private FlashView flashView;
    private ArrayList<String> imageUrls = new ArrayList<String>();
    private List<SchoolMid> schoolMidList = new ArrayList<>();
    private List<SchoolNewsResult> schoolNewsResultList = new ArrayList<>();
    private int Page;
    public static final String TAG = "Fragment";
    private RecyclerView recyclerView1;
    private SwipeRefreshLayout swipeRefreshLayout;
    private Subscriber subscriber;
    private GridLayoutManager gridLayoutManager;
    SchoolLastAdapter adapter1;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        if (view == null) {
            view = inflater.inflate(R.layout.inchool_school_view, container, false);

            //初始化所需数据
            initSchoolList();
            showTopImage();
            showCenterImage();
            showEndImage();
            onRefresh();
            doUpResfresh();

        } else {
            ViewGroup viewGroup = (ViewGroup) view.getParent();
            if (viewGroup != null) {
                viewGroup.removeView(view);
            }
            onRefresh();
            doUpResfresh();
        }
        return view;
    }


    //下拉刷新操作
    private void onRefresh() {
        swipeRefreshLayout = (SwipeRefreshLayout) view.findViewById(R.id.last_school_content_flash);
        swipeRefreshLayout.setColorSchemeResources(R.color.colorPrimary);
        swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                refreshlast();
            }
        });
    }


    //上拉加载





    private void doUpResfresh() {
        if (recyclerView1 == null) {
            recyclerView1 = (RecyclerView) view.findViewById(R.id.last_school_content);
        }

    }


    private void refreshlast() {

        new Thread(new Runnable() {
            @Override
            public void run() {
                //重新加载数据并更新界面
                try {
                    Thread.sleep(2000);

                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                getActivity().runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        getSchoolNews(Page++);
                        adapter1.notifyDataSetChanged();
                        swipeRefreshLayout.setRefreshing(false);
                    }
                });


            }
        }).start();
    }

    private void initSchoolList() {
        //以下数据为测试数据，真实数据可从服务器中获取,由于要加载的数据过多，可以新建一个线程进行加载数据，并进行数据的初始化
        //首页的新闻总是要更新的，是不是可以写成一个server，在后台进行更新
        //头部轮播图片，从服务器中加载

        imageUrls.add("http://www.bz55.com/uploads1/allimg/120312/1_120312100435_8.jpg");
        imageUrls.add("http://img2.pconline.com.cn/pconline/0706/19/1038447_34.jpg");
        imageUrls.add("http://www.237.cc/uploads/pcline/712_0_1680x1050.jpg");

        //中间滑动项，从服务器中加载
        Intent intent = new Intent(getActivity().getApplicationContext(), MainActivity.class);
        SchoolMid schoolMid_1 = new SchoolMid(R.drawable.schoolintroduce, intent);
        SchoolMid schoolMid_2 = new SchoolMid(R.drawable.schoolstyle, intent);
        SchoolMid schoolMid_3 = new SchoolMid(R.drawable.schoolfamous, intent);
        SchoolMid schoolMid_4 = new SchoolMid(R.drawable.schoolnews, intent);

        schoolMidList.add(schoolMid_1);
        schoolMidList.add(schoolMid_2);
        schoolMidList.add(schoolMid_3);
        schoolMidList.add(schoolMid_4);

        //结尾新闻项（for循环从服务器读取出SchoolLast对象）

//        SchoolNewsResult schoolNewsResult3 = new SchoolNewsResult(R.drawable.life_play_img1, "新闻标题1234", "新闻详情：http://...");
//        SchoolNewsResult schoolNewsResult4 = new SchoolNewsResult(R.drawable.life_play_img2, "新闻标题tdrhsf", "新闻详情：http://...");
//        SchoolNewsResult schoolNewsResult5 = new SchoolNewsResult(R.drawable.life_play_img3, "新闻标题dghllllllllllllll", "新闻详情：http://...");
//        SchoolNewsResult schoolNewsResult6 = new SchoolNewsResult(R.drawable.life_play_img4, "新闻标题217532", "新闻详情：http://...");
//        SchoolNewsResult schoolNewsResult7 = new SchoolNewsResult(R.drawable.life_play_img5, "新闻标题1024522", "新闻详情：http://...");
//        SchoolNewsResult schoolNewsResult8 = new SchoolNewsResult(R.drawable.life_play_img6, "新闻标题455", "新闻详情：http://...");
//        SchoolNewsResult schoolNewsResult9 = new SchoolNewsResult(R.drawable.life_play_img1, "新闻标题555555555555555555555555555", "新闻详情：http://...");
//
//
//        schoolNewsResultList.add(schoolNewsResult3);
//        schoolNewsResultList.add(schoolNewsResult4);
//        schoolNewsResultList.add(schoolNewsResult5);
//        schoolNewsResultList.add(schoolNewsResult6);
//        schoolNewsResultList.add(schoolNewsResult7);
//        schoolNewsResultList.add(schoolNewsResult8);
//        schoolNewsResultList.add(schoolNewsResult9);
        getSchoolNews(Page);

    }

    private void showTopImage() {

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

    }

    private void showCenterImage() {

        //中间部分

        RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.in_mid_school);
        LinearLayoutManager layoutManager = new LinearLayoutManager(view.getContext());
        layoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
        recyclerView.setLayoutManager(layoutManager);
        SchoolMidAdapter adapter = new SchoolMidAdapter(schoolMidList);
        recyclerView.setAdapter(adapter);
    }

    private void showEndImage() {
        //结尾部分
        recyclerView1 = (RecyclerView) view.findViewById(R.id.last_school_content);
        gridLayoutManager = new GridLayoutManager(view.getContext(), 3);
        recyclerView1.setLayoutManager(gridLayoutManager);
        adapter1 = new SchoolLastAdapter(schoolNewsResultList, getContext());
        recyclerView1.setAdapter(adapter1);
    }

    private void getSchoolNews(int page) {
        subscriber = new Subscriber<SchoolNewsData>() {
            @Override
            public void onCompleted() {

            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onNext(SchoolNewsData schoolNewsData) {
                List<SchoolNewsResult> list = schoolNewsData.getResults();
                schoolNewsResultList.addAll(list);

            }
        };
        SchoolNewsMethods.getInstance().getSchoolNews(subscriber, page);
    }

}
