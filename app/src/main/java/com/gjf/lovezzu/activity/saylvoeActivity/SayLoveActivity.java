package com.gjf.lovezzu.activity.saylvoeActivity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.LinearLayout;

import com.gjf.lovezzu.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by BlackBeard丶 on 2017/03/22.
 */
public class SayLoveActivity extends AppCompatActivity {
    @BindView(R.id.saylove_iwantsaylove) LinearLayout sayout_iwantsaylove;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.biaobai);
        ButterKnife.bind(this);
    }
   @OnClick({R.id.saylove_iwantsaylove})
    public void onClick(View view){
       switch (view.getId()){
           case R.id.saylove_iwantsaylove:
               goToSayLove();
       }

}


    private void goToSayLove(){
        Intent intent = new Intent(SayLoveActivity.this,IWantSayLoveActivity.class);
        startActivity(intent);
    }

}
