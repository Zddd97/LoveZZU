package com.gjf.lovezzu.fragment;

import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.gjf.lovezzu.R;
import com.gjf.lovezzu.activity.MainActivity;
import com.gjf.lovezzu.entity.LoginResult;
import com.gjf.lovezzu.network.SingInMethods;


import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import rx.Subscriber;

/**
 * Created by BlackBeard丶 on 2017/03/01.
 */
public class UserSingUpFragment extends Fragment {

    @BindView(R.id.login_now)
    TextView login_now;
    @BindView(R.id.user_singup_button)
    TextView user_singuo_button;
    @BindView(R.id.user_reg_phone)
    EditText getuser_reg_phone;
    @BindView(R.id.user_reg_password)
    EditText getUser_reg_password;
    @BindView(R.id.reg_title_back)
    ImageView reg_title_back;
    private UserLoginFragmen userLoginFragmen;
    private View view;
    private Subscriber subscriber;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.usersingup_fragment, container, false);
        ButterKnife.bind(this, view);
        return view;
    }

    private void goTologin() {
        FragmentManager fm = getFragmentManager();
        FragmentTransaction transaction = fm.beginTransaction();
        userLoginFragmen = new UserLoginFragmen();
        transaction.replace(R.id.singfragment, userLoginFragmen);
        transaction.commit();
    }

    private void goTosingup() {
        subscriber = new Subscriber<LoginResult>() {
            @Override
            public void onCompleted() {
//
            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onNext(LoginResult loginResult) {
                if (loginResult.isSuccessful()) {
                    Toast.makeText(getContext(), "注册成功", Toast.LENGTH_LONG).show();
                    goTologin();
                } else {
                    Toast.makeText(getContext(), "注册失败！", Toast.LENGTH_LONG).show();
                }
            }


        };
        String phone = getuser_reg_phone.getText().toString();
        String password = getUser_reg_password.getText().toString();

        boolean issuccessful = false;
        String identifier = "1";
        SingInMethods.getInstance().goToSingup(subscriber, identifier, issuccessful, phone, password);

    }

    @OnClick({R.id.login_now, R.id.user_singup_button, R.id.reg_title_back})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.login_now:
                goTologin();
                break;
            case R.id.user_singup_button:
                goTosingup();
                break;
            case R.id.reg_title_back:
                returnHome();
                break;
        }
    }
    //回到主页



    private void returnHome() {
        Intent intent = new Intent();
        intent.setClass(getActivity(), MainActivity.class);
        startActivity(intent);
    }
}
