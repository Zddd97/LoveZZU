package com.gjf.lovezzu.fragment;

import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.gjf.lovezzu.R;
import com.gjf.lovezzu.entity.ResultReturn;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import rx.Subscriber;

/**
 * Created by BlackBeard丶 on 2017/03/01.
 */
public class UserSingUpFragment extends Fragment {

    @BindView(R.id.login_now)  TextView login_now;
    private UserLoginFragmen userLoginFragmen;
    private  View view;
    private Subscriber subscriber;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
       view = inflater.inflate(R.layout.usersingup_fragment,container,false);
        ButterKnife.bind(this,view);
        return  view;
    }

    private void goTologin() {
        FragmentManager fm = getFragmentManager();
        FragmentTransaction transaction = fm.beginTransaction();
        userLoginFragmen = new UserLoginFragmen();
        transaction.replace(R.id.singfragment,userLoginFragmen);
        transaction.commit();
    }
    private void goTosingup(){
        subscriber = new Subscriber<ResultReturn>() {
            @Override
            public void onCompleted() {

            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onNext(ResultReturn resultReturn) {

            }


        };

    }
    @OnClick({R.id.login_now})
    public void onClick(View view){
        switch (view.getId()){
            case R.id.login_now:
               goTologin();
                break;
        }
    }
}
