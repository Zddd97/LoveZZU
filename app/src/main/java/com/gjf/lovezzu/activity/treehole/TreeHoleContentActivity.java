package com.gjf.lovezzu.activity.treehole;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;

import com.gjf.lovezzu.R;
import com.gjf.lovezzu.entity.TreeHoleData;
import com.gjf.lovezzu.entity.TreeHoleResult;
import com.gjf.lovezzu.network.TreeHoleMethods;
import com.gjf.lovezzu.view.TreeHoleContentAdapter;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import rx.Subscriber;

/**
 * Created by BlackBeard丶 on 2017/5/23.
 */

public class TreeHoleContentActivity  extends AppCompatActivity{
    @BindView(R.id.tree_content_view_recycleview)
    RecyclerView tree_content_view_recycleview ;

    @BindView(R.id.tree_title_back_content)
    ImageView treeTitleBack;
    @BindView(R.id.school_news_comment_text)
    EditText school_news_comment_text;
    @BindView(R.id.send_comment)
    ImageView send_comment;







    public static TreeHoleActivity treeHoleActivity;
    private Subscriber subscriber;
    private List<TreeHoleResult> treeHoleResultList = new ArrayList<>();
    TreeHoleContentAdapter treeHoleAdapter;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tree_content_view);
        ButterKnife.bind(this);
        initData();
    }


    private void initData(){
        //初始化
        LinearLayoutManager layoutManager=new LinearLayoutManager(this);
        tree_content_view_recycleview.setLayoutManager(layoutManager);
        treeHoleAdapter=new TreeHoleContentAdapter(treeHoleResultList);
        tree_content_view_recycleview.setAdapter(treeHoleAdapter);

    }
    @OnClick({R.id.tree_title_back_content,R.id.school_news_comment_text,R.id.send_comment})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.tree_title_back_content:
                finish();
                break;
        }

    }

    private void sendComment(){
        subscriber = new Subscriber<TreeHoleData>() {
            @Override
            public void onCompleted() {

            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onNext(TreeHoleData o) {

            }
        };

    }

    private void disPlayComment(){
        subscriber  = new Subscriber<TreeHoleData>() {
            @Override
            public void onCompleted() {

            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onNext(TreeHoleData treeHoleData) {

            }
        };
    }

    private void disPlayContent(){
        subscriber  = new Subscriber<TreeHoleData>() {
            @Override
            public void onCompleted() {

            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onNext(TreeHoleData treeHoleData) {

            }
        };

    }

    private void LikesComments(){

        subscriber  = new Subscriber<TreeHoleData>() {
            @Override
            public void onCompleted() {

            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onNext(TreeHoleData treeHoleData) {

            }
        };

        TreeHoleMethods.getInstance().LikesComments(subscriber,"","","");

    }
}
