package com.gjf.lovezzu.fragment.parttimejob;

import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.gjf.lovezzu.R;
import com.gjf.lovezzu.activity.parttimejob.AddJopActivity;
import com.gjf.lovezzu.activity.parttimejob.PartTimeJobActivity;
import com.gjf.lovezzu.entity.JobItem;
import com.gjf.lovezzu.view.SchoolJobAdapter;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by zhaox on 2017/5/23.
 */

public class OutSchoolFragment extends Fragment {


    @BindView(R.id.school_job_list)
    RecyclerView schoolJobList;
    @BindView(R.id.job_refresh)
    SwipeRefreshLayout jobRefresh;
    @BindView(R.id.add_job)
    ImageView addJob;

    private View view;
    private List<JobItem> JobItemList = new ArrayList<>();
    private SchoolJobAdapter outSchoolJobAdapter;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        if (view == null) {
            view = inflater.inflate(R.layout.part_time_job_list, container, false);
            ButterKnife.bind(this, view);
            getJobItem();
            shwowJobs();
            refreshJob();
        } else {
            ViewGroup viewGroup = (ViewGroup) view.getParent();
            if (viewGroup != null) {
                viewGroup.removeView(view);
            }
        }
        return view;
    }

    //获取兼职数据
    private void getJobItem(){
        if (JobItemList.size()>=6){
            JobItemList.clear();
        }
        for (int i=1;i<=3;i++){
            com.gjf.lovezzu.entity.JobItem jobItem=new JobItem(0,"校外兼职","发传单喽","2015-5-9");
            JobItemList.add(jobItem);
        }
    }
    //显示数据
    private void shwowJobs(){
        LinearLayoutManager layoutManager=new LinearLayoutManager(view.getContext());
        schoolJobList.setLayoutManager(layoutManager);
        outSchoolJobAdapter=new SchoolJobAdapter(JobItemList);
        schoolJobList.setAdapter(outSchoolJobAdapter);

    }
    private void refreshJob(){
        jobRefresh.setColorSchemeResources(R.color.colorPrimary);
        jobRefresh.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                //刷新
                doRefreshJob();
            }
        });
    }

    private void doRefreshJob(){
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(200);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                getActivity().runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        getJobItem();
                        outSchoolJobAdapter.notifyDataSetChanged();
                        jobRefresh.setRefreshing(false);
                    }
                });
            }
        }).start();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();

    }

    @OnClick(R.id.add_job)
    public void onViewClicked() {
        Intent intent=new Intent(PartTimeJobActivity.partTimeJobActivity, AddJopActivity.class);
        PartTimeJobActivity.partTimeJobActivity.startActivity(intent);
    }
}
