package com.gjf.lovezzu.fragment;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.gjf.lovezzu.R;
import com.gjf.lovezzu.entity.Data;
import com.gjf.lovezzu.entity.NewsResult;
import com.gjf.lovezzu.network.NewsMethods;
import com.gjf.lovezzu.view.SocietyAdapter;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import rx.Subscriber;

/**
 * Created by lenovo047 on 2017/3/9.
 */

public class Shool_societyfragment extends Fragment {
    private View view;
    private Subscriber subscriber;
    private SwipeRefreshLayout swipeRefreshLayout;

    private List<NewsResult> newsResultList = new ArrayList<>();
    private List<NewsResult> mlist;
    RecyclerView newsSociety;
    private SocietyAdapter adapter;
    @BindView(R.id.title_douban)  TextView doubantitle;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        if (view == null) {

            view = inflater.inflate(R.layout.inschool_society_view, container, false);
            ButterKnife.bind(this, view);
            getNews();


            showNews();
            onRegresh();
        }else {
            ViewGroup viewGroup = (ViewGroup) view.getParent();
            if (viewGroup != null) {
                viewGroup.removeView(view);
            }
            onRegresh();
        }

        return view;
    }

    private void onRegresh(){
        swipeRefreshLayout = (SwipeRefreshLayout) view.findViewById(R.id.society_refresh_layout);
        swipeRefreshLayout.setColorSchemeResources(R.color.colorPrimary);
        swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                //刷新操作
                refreshView();
            }
        });
    }

    //下拉刷新
    private void refreshView() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                getActivity().runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        //刷新数据
                        initNews(null);
                        adapter.notifyDataSetChanged();
                        swipeRefreshLayout.setRefreshing(false);
                    }
                });
            }
        }).start();
    }

    //展示新闻
    private void showNews(){
        newsSociety = (RecyclerView) view.findViewById(R.id.school_society_content);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(view.getContext());
        newsSociety.setLayoutManager(layoutManager);
        adapter = new SocietyAdapter(newsResultList,getContext());
        newsSociety.setAdapter(adapter);
    }

    private void getNews(){
  subscriber = new Subscriber<Data>() {
      @Override
      public void onCompleted() {

      }

      @Override
      public void onError(Throwable e) {
          Toast.makeText(getContext(),e.getMessage().toString(),Toast.LENGTH_LONG).show();
         // Log.d("gjf123", e.getMessage().toString());
      }

      @Override
      public void onNext(Data newsResult) {

          List<NewsResult> list = newsResult.getResults();


         Toast.makeText(getContext(),"",Toast.LENGTH_LONG).show();
         Log.d("gjf123", "");
          initNews(list);

      }
  };
        NewsMethods.getInstance().getTopMovie(subscriber,1);
    }

    //初始化新闻
    private void initNews(List<NewsResult> newsResult) {

//        SchoolSociety schoolSociety = new SchoolSociety("111nnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnn", "2017-3-15", "1024",R.drawable.__picker_ic_photo_black_48dp, "http://7xi8d6.com1.z0.glb.clouddn.com/2017-03-16-17333221_108837802984751_2789267558635667456_n.jpg");
//        schoolSocietyList.add(schoolSociety);

 newsResultList.addAll(newsResult);



    }

    }




