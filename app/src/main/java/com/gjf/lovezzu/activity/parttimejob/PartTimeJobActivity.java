package com.gjf.lovezzu.activity.parttimejob;

import android.annotation.TargetApi;
import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.gjf.lovezzu.R;
import com.gjf.lovezzu.fragment.parttimejob.InSchoolFragment;
import com.gjf.lovezzu.fragment.parttimejob.OutSchoolFragment;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by zhaox on 2017/5/24.
 */

public class PartTimeJobActivity extends AppCompatActivity {
    public static PartTimeJobActivity partTimeJobActivity;
    @BindView(R.id.job_title_back)
    ImageView jobTitleBack;
    @BindView(R.id.part_in_school)
    TextView partInSchool;
    @BindView(R.id.part_out_school)
    TextView partOutSchool;

    private InSchoolFragment inSchoolFragment;
    private OutSchoolFragment outSchoolFragment;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.parttimejob_view);
        ButterKnife.bind(this);
        partTimeJobActivity = this;
        inSchoolFragment=new InSchoolFragment();
        outSchoolFragment=new OutSchoolFragment();
        partInSchool.setTextColor(Color.parseColor("#0090FD"));
        replaceFragment(inSchoolFragment);

    }

    @OnClick({R.id.job_title_back, R.id.part_in_school, R.id.part_out_school})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.job_title_back:
                finish();
                break;
            case R.id.part_in_school:
                if (inSchoolFragment==null){
                    inSchoolFragment=new InSchoolFragment();
                }
                partInSchool.setTextColor(Color.parseColor("#0090FD"));
                partOutSchool.setTextColor(Color.parseColor("#000000"));
                replaceFragment(inSchoolFragment);
                break;
            case R.id.part_out_school:
                if (outSchoolFragment==null){
                    outSchoolFragment=new OutSchoolFragment();
                }
                partInSchool.setTextColor(Color.parseColor("#000000"));
                partOutSchool.setTextColor(Color.parseColor("#0090FD"));
                replaceFragment(outSchoolFragment);
                break;
        }
    }

    @TargetApi(Build.VERSION_CODES.JELLY_BEAN_MR1)
    private void replaceFragment(Fragment fragment) {
        FragmentManager fragmentManager=getFragmentManager();
        FragmentTransaction fragmentTransaction=fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.part_job, fragment);
        fragmentTransaction.commit();
    }

}
