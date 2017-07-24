package com.gjf.lovezzu.activity.palytogether;

import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;

import com.gjf.lovezzu.R;
import com.gjf.lovezzu.entity.PlayEnd;
import com.gjf.lovezzu.view.DividerItemDecoration;
import com.gjf.lovezzu.view.PlayGroupListAdapter;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by zhaox on 2017/4/19.
 */

public class PlayGroupListActivity extends AppCompatActivity {
    public static PlayGroupListActivity playGroupListActivity;
    PlayGroupListAdapter adapter;
    @BindView(R.id.group_back)
    ImageView groupBack;
    @BindView(R.id.group_list)
    RecyclerView groupList;
    @BindView(R.id.refresh_group)
    SwipeRefreshLayout refreshGroup;

    private List<PlayEnd> playEndList=new ArrayList<>();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.play_group_list);
        ButterKnife.bind(this);
        playGroupListActivity = this;
        initDate();
        LinearLayoutManager layoutManager=new LinearLayoutManager(this);
        groupList.setLayoutManager(layoutManager);
        groupList.addItemDecoration(new DividerItemDecoration(this,
                DividerItemDecoration.VERTICAL_LIST));
        adapter=new PlayGroupListAdapter(playEndList);
        groupList.setAdapter(adapter);
        refreshGroup.setColorSchemeResources(R.color.colorPrimary);
        refreshGroup.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                refreshDate();
            }
        });


        if (Build.VERSION.SDK_INT >= 21) {
            View decorView = getWindow().getDecorView();
            int option = View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                    | View.SYSTEM_UI_FLAG_LAYOUT_STABLE;
            decorView.setSystemUiVisibility(option);
            getWindow().getDecorView().setSystemUiVisibility( View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN|View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR);
            getWindow().setStatusBarColor(Color.TRANSPARENT);

        }

    }

    //刷新操作
    private void refreshDate() {
        new Thread(new Runnable() {
            @Override
            public void run() {

                try{
                    Thread.sleep(2000);
                }catch(InterruptedException e){
                    e.printStackTrace();
                }
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        //刷新操作
                        adapter.notifyDataSetChanged();
                        refreshGroup.setRefreshing(false);
                    }
                });
            }
        }).start();
    }


    private void initDate() {

        //加载数据的网络操作
        for (int i = 0; i <= 3; i++) {
            PlayEnd playEnd = new PlayEnd(i, R.drawable.life_beautiful_girl, "PlayBoy", "Android小组", R.drawable.new_group,
                    R.drawable.new_add, "小漠国服第一系列的第一螳螂丶第一大眼,国服最高排名第八,曾任CC战队教练击败OMG战队,现为国服第一金牌讲师长驻斗鱼..",
                    R.drawable.test_person_03, R.drawable.test_person_03, R.drawable.test_person_03,
                    R.drawable.test_person_03, R.drawable.test_person_03, R.drawable.test_person_03, R.drawable.test_person_03);
            playEndList.add(playEnd);
        }

    }

    @OnClick(R.id.group_back)
    public void onViewClicked() {
        finish();
    }
}
