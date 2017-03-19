package com.gjf.lovezzu.fragment;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.gjf.lovezzu.R;
import com.gjf.lovezzu.entity.NewsResult;
import com.gjf.lovezzu.entity.SchoolSociety;
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
    private List<SchoolSociety> schoolSocietyList = new ArrayList<>();
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
            initNews(null);

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
        adapter = new SocietyAdapter(schoolSocietyList,getContext());
        newsSociety.setAdapter(adapter);
    }

    private void getNews(){
  subscriber = new Subscriber<NewsResult>() {
      @Override
      public void onCompleted() {

      }

      @Override
      public void onError(Throwable e) {

      }

      @Override
      public void onNext(NewsResult newsResult) {

          Toast.makeText(getContext(),newsResult.getStart(),Toast.LENGTH_LONG).show();
      }
  };
        NewsMethods.getInstance().getTopMovie(subscriber,0,1);
    }

    //初始化新闻
    private void initNews(NewsResult newsResult) {

            for (int i = 1; i <= 2; i++) {
               SchoolSociety schoolSociety = new SchoolSociety("新闻标题", "2017-3-15", "1024",R.drawable.__picker_ic_photo_black_48dp, "http://dsxcnqzj.top/wp-content/uploads/2017/02/Screenshot_20170219-172019.png");
              schoolSocietyList.add(schoolSociety);
          }


  }

    }




