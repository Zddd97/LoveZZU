package com.gjf.lovezzu.activity.parttimejob;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.gjf.lovezzu.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by zhaox on 2017/5/24.
 */

public class AddJopActivity extends AppCompatActivity {

    @BindView(R.id.job_add_back)
    ImageView jobAddBack;
    @BindView(R.id.add_part_job)
    EditText addPartJob;
    @BindView(R.id.add_job_textNumber)
    TextView addJobTextNumber;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.part_add_job);
        ButterKnife.bind(this);
        addPartJob.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                String text=addPartJob.getText().toString();
                addJobTextNumber.setText(text+"");
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
    }

    @OnClick({R.id.job_add_back, R.id.send_job})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.job_add_back:
                finish();
                break;
            case R.id.send_job:
                if (addJobs()){
                    Toast.makeText(this,"发布成功！",Toast.LENGTH_SHORT).show();
                }else{
                    Toast.makeText(this,"发布失败！",Toast.LENGTH_SHORT).show();
                }
                break;
        }
    }

    //插入兼职信息
    private boolean addJobs(){
        //do something
        return false;
    }
}
