package com.gjf.lovezzu.activity.parttimejob;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.TextView;

import com.gjf.lovezzu.R;
import com.gjf.lovezzu.entity.JobItem;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by zhaox on 2017/5/24.
 */

public class JobInfoActivity extends AppCompatActivity {
    @BindView(R.id.job_info_back)
    ImageView jobInfoBack;
    @BindView(R.id.info_title)
    TextView infoTitle;
    @BindView(R.id.job_info_title)
    TextView jobInfoTitle;
    @BindView(R.id.job_info_content)
    TextView jobInfoContent;
    @BindView(R.id.job_time)
    TextView jobTime;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.part_job_info);
        ButterKnife.bind(this);
        JobItem jobItem = (JobItem) getIntent().getSerializableExtra("JobItem");
        if (jobItem.getJobType()==1){
            infoTitle.setText("校内兼职");
        }else{
            infoTitle.setText("校外兼职");
        }
        jobInfoTitle.setText(jobItem.getJobTitle());
        jobInfoContent.setText(jobItem.getJobContent());
        jobTime.setText(jobItem.getJobTime());
    }

    @OnClick(R.id.job_info_back)
    public void onViewClicked() {
        finish();
    }
}
