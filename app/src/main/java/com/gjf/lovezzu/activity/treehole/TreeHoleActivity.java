package com.gjf.lovezzu.activity.treehole;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.PopupMenu;
import android.support.v7.widget.RecyclerView;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.gjf.lovezzu.R;
import com.gjf.lovezzu.entity.TreeHole;
import com.gjf.lovezzu.view.TreeHoleAdapter;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by zhao on 2017/5/4.
 */

public class TreeHoleActivity extends AppCompatActivity implements PopupMenu.OnMenuItemClickListener{

    public static TreeHoleActivity treeHoleActivity;
    @BindView(R.id.tree_title_back)
    ImageView treeTitleBack;
    @BindView(R.id.tree_menu)
    ImageView treeMenu;
    @BindView(R.id.tree_item_view)
    RecyclerView treeItemView;
    @BindView(R.id.tree_refresh)
    SwipeRefreshLayout treeRefresh;
    @BindView(R.id.tree_fab)
    ImageView treeFab;

    private List<TreeHole> treeHoleList = new ArrayList<>();
    TreeHoleAdapter treeHoleAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tree_hole_view);
        ButterKnife.bind(this);
        treeHoleActivity = this;
        initDate();
        LinearLayoutManager layoutManager=new LinearLayoutManager(this);
        treeItemView.setLayoutManager(layoutManager);
        treeHoleAdapter=new TreeHoleAdapter(treeHoleList);
        treeItemView.setAdapter(treeHoleAdapter);

        treeRefresh.setColorSchemeColors(Color.GREEN);
        treeRefresh.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                //刷新菜单
                treeRefresh();
            }
        });

    }

    private void treeRefresh() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        //刷新数据
                        initDate();
                        treeHoleAdapter.notifyDataSetChanged();
                        treeRefresh.setRefreshing(false);
                    }
                });
            }
        }).start();
    }

    @OnClick({R.id.tree_title_back, R.id.tree_menu, R.id.tree_refresh, R.id.tree_fab})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.tree_title_back:
                finish();
                break;
            case R.id.tree_menu:
                getMenu();
                break;
            case R.id.tree_refresh:
                break;
            case R.id.tree_fab:
                Intent intent=new Intent(TreeHoleActivity.this,AddTreeHoleActivity.class);
                startActivity(intent);
                break;
        }
    }
    private void getMenu(){
        PopupMenu popupMenu=new PopupMenu(this,treeMenu);
        MenuInflater inflater=popupMenu.getMenuInflater();
        inflater.inflate(R.menu.tree_menu,popupMenu.getMenu());
        popupMenu.setOnMenuItemClickListener(this);
        popupMenu.show();
    }

    @Override
    public boolean onMenuItemClick(MenuItem item) {
        switch (item.getItemId()){
            case R.id.tree_publish:
                Toast.makeText(this,"发布我的树洞",Toast.LENGTH_SHORT).show();
                break;
            case R.id.tree_comment:
                Toast.makeText(this,"我评论的",Toast.LENGTH_SHORT).show();
                break;
            default:
                break;
        }
        return false;
    }

    private void initDate(){
        //服务器获取
        //测试数据
        for (int i = 1; i <= 5; i++){
            TreeHole treeHole=new TreeHole("发布我的树洞主体美容","啥用？","100","101");
            treeHoleList.add(treeHole);
        }
    }
}
