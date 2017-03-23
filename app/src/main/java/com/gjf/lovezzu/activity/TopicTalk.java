package com.gjf.lovezzu.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;

import com.gjf.lovezzu.R;
import com.gjf.lovezzu.entity.TopicMid;
import com.gjf.lovezzu.view.TopicMidAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by zhaox on 2017/3/22.
 */

public class TopicTalk extends AppCompatActivity {

    private List<TopicMid> topicMidList = new ArrayList<>();

    RecyclerView midRecyclerView;

    private TopicMidAdapter topicMidAdapter;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.talk_view);

    }
}
