package com.gjf.lovezzu.activity.taoyu;

import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import com.gjf.lovezzu.R;
import com.gjf.lovezzu.fragment.taoyu.TaoyuGoodsEnjoyTypeFragment;
import com.gjf.lovezzu.fragment.taoyu.TaoyuGoodsStudyTypeFragment;
import com.gjf.lovezzu.fragment.taoyu.TaoyuGoodsTrafficTypeFragment;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by lenovo047 on 2017/3/25.
 */

public class TaoyuActivity extends AppCompatActivity {

    private TaoyuGoodsEnjoyTypeFragment taoyuGoodsEnjoyTypeFragment;
    private TaoyuGoodsStudyTypeFragment taoyuGoodsStudyTypeFragment;
    private TaoyuGoodsTrafficTypeFragment taoyuGoodsTrafficTypeFragment;
    @BindView(R.id.taoyu_study)
    TextView taoyu_study;
    @BindView(R.id.taoyu_traffic)
    TextView taoyu_traffic;
    @BindView(R.id.taoyu_enjoy)
    TextView taoyu_enjoy;
    @BindView(R.id.taoyu_activity_search)
    TextView taoyu_activity_search;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.taoyu_activity);
        ButterKnife.bind(this);

        if (Build.VERSION.SDK_INT >= 21) {
            View decorView = getWindow().getDecorView();
            int option = View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                    | View.SYSTEM_UI_FLAG_LAYOUT_STABLE;
            decorView.setSystemUiVisibility(option);
            getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN | View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR);
            getWindow().setStatusBarColor(Color.TRANSPARENT);
        }
        setDefaultFragment();

    }

    private void setDefaultFragment() {
        FragmentManager fm = getFragmentManager();
        FragmentTransaction transaction = fm.beginTransaction();
        taoyuGoodsStudyTypeFragment = new TaoyuGoodsStudyTypeFragment();
        transaction.replace(R.id.id_taoyuactivity, taoyuGoodsStudyTypeFragment);
        transaction.commit();
        taoyu_enjoy.setTextColor(Color.parseColor("#000000"));
        taoyu_study.setTextColor(Color.BLUE);
        taoyu_traffic.setTextColor(Color.parseColor("#000000"));
    }

    @OnClick({R.id.taoyu_study, R.id.taoyu_traffic, R.id.taoyu_enjoy,R.id.taoyu_activity_search})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.taoyu_enjoy:
                taoyuGoodsEnjoyTypeFragment = new TaoyuGoodsEnjoyTypeFragment();
                showFragmen(taoyuGoodsEnjoyTypeFragment);
                taoyu_enjoy.setTextColor(Color.BLUE);
                taoyu_study.setTextColor(Color.parseColor("#000000"));
                taoyu_traffic.setTextColor(Color.parseColor("#000000"));
                break;
            case R.id.taoyu_study:
                taoyuGoodsStudyTypeFragment = new TaoyuGoodsStudyTypeFragment();
                showFragmen(taoyuGoodsStudyTypeFragment);
                taoyu_enjoy.setTextColor(Color.parseColor("#000000"));
                taoyu_study.setTextColor(Color.BLUE);
                taoyu_traffic.setTextColor(Color.parseColor("#000000"));

                break;
            case R.id.taoyu_traffic:
                taoyuGoodsTrafficTypeFragment = new TaoyuGoodsTrafficTypeFragment();
                showFragmen(taoyuGoodsTrafficTypeFragment);
                taoyu_enjoy.setTextColor(Color.parseColor("#000000"));
                taoyu_study.setTextColor(Color.parseColor("#000000"));
                taoyu_traffic.setTextColor(Color.BLUE);
                break;
            case R.id.taoyu_activity_search:
                Intent intent = new Intent(getApplicationContext(),TaoyuSearchActivity.class);
                startActivity(intent);
                break;
        }

    }

    private void showFragmen(Fragment fragment) {
        FragmentManager fm = getFragmentManager();
        FragmentTransaction transaction = fm.beginTransaction();
        transaction.replace(R.id.id_taoyuactivity, fragment);
        transaction.commit();
    }
}


