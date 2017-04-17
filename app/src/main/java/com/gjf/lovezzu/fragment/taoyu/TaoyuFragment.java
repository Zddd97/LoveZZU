package com.gjf.lovezzu.fragment.taoyu;

import android.app.Activity;
import android.app.Fragment;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.gjf.lovezzu.R;
import com.gjf.lovezzu.entity.TaoyuDataBridging;
import com.gjf.lovezzu.entity.TaoyuGoodsData;
import com.gjf.lovezzu.network.TaoyuGoodsListMethods;
import com.gjf.lovezzu.view.TaoyuAdapter;

import java.util.ArrayList;
import java.util.List;

import rx.Subscriber;

/**
 * Created by lenovo047 on 2017/3/24.
 */

public class TaoyuFragment extends Fragment {
    private Subscriber subscriber;
    private View view;
    private List<TaoyuDataBridging> taoyuResultList = new ArrayList<>();
    public static final  String TAG = "Fragment";
    RecyclerView taoyu_list;
    private TaoyuAdapter adapter;
    // private SwipeRefreshLayout swipeRefreshLayout;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        if (view == null) {
            view = inflater.inflate(R.layout.taoyu_list, container, false);

            //初始化所需数据
            intList();
             //inittaoyuList();
            getTaoyuGoodsList();
            //onRefresh();
        } else {
            ViewGroup viewGroup = (ViewGroup) view.getParent();
            if (viewGroup != null) {
                viewGroup.removeView(view);
            }
            // onRefresh();
        }
        return view;
    }

    public void intList() {
        taoyu_list = (RecyclerView) view.findViewById(R.id.taoyu_list);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(view.getContext());
        taoyu_list.setLayoutManager(layoutManager);
        adapter = new TaoyuAdapter(taoyuResultList, getContext());
        taoyu_list.setAdapter(adapter);


    }


//    private void inittaoyuList() {
//        TaoyuResult taoyuResult1 = new TaoyuResult(R.drawable.ic_launcher,R.drawable.ic_launcher,"18838970227","快来买我东西啦啦啦","郑州",5,5,5,5);
//        TaoyuResult taoyuResult2 = new TaoyuResult(R.drawable.ic_launcher,R.drawable.ic_launcher,"18838970227","快来买我东西啦","lala",5,5,5,5);
//        TaoyuResult taoyuResult3 = new TaoyuResult(R.drawable.ic_launcher,R.drawable.ic_launcher,"18838970227","快来买我东西啦","郑州",5,5,5,5);
//        taoyuResultList.add(taoyuResult1);
//        taoyuResultList.add(taoyuResult2);
//        taoyuResultList.add(taoyuResult3);
//
//    }



//    private void onRefresh() {
//        swipeRefreshLayout = (SwipeRefreshLayout) view.findViewById(R.id.last_school_content_flash);
//        swipeRefreshLayout.setColorSchemeResources(R.color.colorPrimary);
//        swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
//            @Override
//            public void onRefresh() {
//                refreshlast();
//            }
//        });
//    }

//    private void refreshlast() {
//
//
//
//
//
//
//        new Thread(new Runnable() {
//            @Override
//            public void run() {
//                //重新加载数据并更新界面
//                try {
//                    Thread.sleep(200);
//
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
//                getActivity().runOnUiThread(new Runnable() {
//                    @Override
//                    public void run() {
//
//                        swipeRefreshLayout.setRefreshing(false);
//                    }
//                });
//
//
//            }
//        }).start();
//    }

    public void getTaoyuGoodsList(){

        subscriber = new Subscriber<TaoyuGoodsData>() {
            @Override
            public void onCompleted() {
                Log.d("ggggg","yiwancheng taoyu");
            }

            @Override
            public void onError(Throwable e) {
                Log.d("ggggg",e.getMessage().toString()+"hgggggggggggggg");
            }

            @Override
            public void onNext(TaoyuGoodsData taoyuGoodsData) {
               List<TaoyuDataBridging> list = taoyuGoodsData.getValues();
                Toast.makeText(getContext(),taoyuGoodsData.getResult(),Toast.LENGTH_LONG).show();
                taoyuResultList.addAll(list);
                adapter.notifyDataSetChanged();


            }


        };

        SharedPreferences sharedPreferences = getContext().getSharedPreferences("userinfo", Activity.MODE_APPEND);
        final SharedPreferences.Editor editor = sharedPreferences.edit();
        String SessionID = sharedPreferences.getString("SessionID", "");
        TaoyuGoodsListMethods.getInstance().getGoodsList(subscriber,"学习",1);

    }



}

