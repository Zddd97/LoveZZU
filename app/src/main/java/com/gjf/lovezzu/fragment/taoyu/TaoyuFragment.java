package com.gjf.lovezzu.fragment.taoyu;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.gjf.lovezzu.R;
import com.gjf.lovezzu.entity.TaoyuResult;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by lenovo047 on 2017/3/24.
 */

public class TaoyuFragment extends Fragment {
    private View view;
    private List<TaoyuResult> taoyuResultList = new ArrayList<>();
    public static final  String TAG = "Fragment";
   // private SwipeRefreshLayout swipeRefreshLayout;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater,  ViewGroup container, Bundle savedInstanceState) {

        if (view == null) {
            view = inflater.inflate(R.layout.taoyu, container, false);

            //初始化所需数据
             inittaoyuList();
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

    private void inittaoyuList() {
        TaoyuResult taoyuResult1 = new TaoyuResult(R.drawable.ic_launcher,R.drawable.ic_launcher,"18838970227","快来买我东西啦啦啦","郑州",5,5,5,5);
        TaoyuResult taoyuResult2 = new TaoyuResult(R.drawable.ic_launcher,R.drawable.ic_launcher,"18838970227","快来买我东西啦","lala",5,5,5,5);
        TaoyuResult taoyuResult3 = new TaoyuResult(R.drawable.ic_launcher,R.drawable.ic_launcher,"18838970227","快来买我东西啦","郑州",5,5,5,5);
        taoyuResultList.add(taoyuResult1);
        taoyuResultList.add(taoyuResult2);
        taoyuResultList.add(taoyuResult3);

    }


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

}

