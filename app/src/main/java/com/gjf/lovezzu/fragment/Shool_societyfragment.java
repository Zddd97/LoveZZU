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
import com.gjf.lovezzu.entity.SocietyNewsData;
import com.gjf.lovezzu.entity.SocietyNewsResult;
import com.gjf.lovezzu.network.NewsMethods;
import com.gjf.lovezzu.view.SocietyAdapter;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import cn.bingoogolapple.refreshlayout.BGARefreshLayout;
import rx.Subscriber;

/**
 * Created by lenovo047 on 2017/3/9.
 */

public class Shool_societyfragment extends Fragment implements BGARefreshLayout.BGARefreshLayoutDelegate{
    private BGARefreshLayout mRefreshLayout;

    private View view;
    private Subscriber subscriber;
    private SwipeRefreshLayout swipeRefreshLayout;

    private List<SocietyNewsResult> societyNewsResultList = new ArrayList<>();
    private List<SocietyNewsResult> mlist;
    private int Page = 0;
    RecyclerView newsSociety;
    private SocietyAdapter adapter;
    @BindView(R.id.title_douban)
    TextView doubantitle;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        if (view == null) {

            view = inflater.inflate(R.layout.inschool_society_view, container, false);
            ButterKnife.bind(this, view);




            showNews();
            onRegresh();
            refreshView();
        } else {
            ViewGroup viewGroup = (ViewGroup) view.getParent();
            if (viewGroup != null) {
               viewGroup.removeView(view);
            }

        }

        return view;
    }

    private void onRegresh() {
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
                        getNews(Page++);
                        adapter.notifyDataSetChanged();
                        swipeRefreshLayout.setRefreshing(false);
                    }
                });
            }
        }).start();
    }

    //展示新闻
    private void showNews() {
        newsSociety = (RecyclerView) view.findViewById(R.id.school_society_content);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(view.getContext());
        newsSociety.setLayoutManager(layoutManager);
        adapter = new SocietyAdapter(societyNewsResultList,getContext());
        newsSociety.setAdapter(adapter);
    }

    private void getNews(int page){

  subscriber = new Subscriber<SocietyNewsData>() {
      @Override
      public void onCompleted() {


            }

            @Override
            public void onError(Throwable e) {
                Toast.makeText(getContext(), e.getMessage().toString(), Toast.LENGTH_LONG).show();
                // Log.d("gjf123", e.getMessage().toString());
            }


      @Override
      public void onNext(SocietyNewsData newsResult) {

          List<SocietyNewsResult> list = newsResult.getResults();


         //Toast.makeText(getContext(),list.toString(),Toast.LENGTH_LONG).show();
          //Log.d("gjf123", "");
          //加载新闻
          societyNewsResultList.addAll(list);
          adapter.notifyDataSetChanged();


      }
  };
        NewsMethods.getInstance().getTopMovie(subscriber, page);

    }




    private void initRefreshLayout(){
    
    }


    @Override
    public void onBGARefreshLayoutBeginRefreshing(BGARefreshLayout refreshLayout) {

    }

    @Override
    public boolean onBGARefreshLayoutBeginLoadingMore(BGARefreshLayout refreshLayout) {
        return false;
    }
}







