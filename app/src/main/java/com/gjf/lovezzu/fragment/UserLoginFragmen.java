package com.gjf.lovezzu.fragment;

import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.gjf.lovezzu.R;
import com.gjf.lovezzu.activity.MainActivity;
import com.gjf.lovezzu.constant.Url;
import com.gjf.lovezzu.entity.LoginResult;
import com.gjf.lovezzu.network.LoginMethods;
import com.gjf.lovezzu.network.api.LoginServer;

import rx.Subscriber;

/**
 * Created by BlackBeard丶 on 2017/03/01.
 */
public class UserLoginFragmen extends Fragment {
    private  View view;
    private TextView new_user_reg;
    private UserSingUpFragment userSingUpFragment;
    private ImageView my_title_back;
    private EditText user_reg_phone, user_reg_password;
    private Url url;
    private LinearLayout user_login;
    LoginServer loginServer;
    private Subscriber subscriber;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
       view = inflater.inflate(R.layout.userlogin_fragment,container,false);



       //返回主页
        my_title_back = (ImageView)view.findViewById(R.id.my_title_back);
        my_title_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
              returnHome();
            }
        });


        //进入注册页面
        new_user_reg = (TextView)view.findViewById(R.id.new_user_reg);
        new_user_reg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                goToreg();
            }
        });

        //登录
        user_login  =(LinearLayout)view.findViewById(R.id.user_login);
        user_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            goTologin();
            }
        });

        return view;
    }





    private void returnHome() {
        Intent intent = new Intent();
        intent.setClass(getActivity(), MainActivity.class);
        startActivity(intent);

    }

    private void goToreg() {
        FragmentManager fm = getFragmentManager();
        FragmentTransaction transaction = fm.beginTransaction();
        userSingUpFragment = new UserSingUpFragment();
        transaction.replace(R.id.singfragment, userSingUpFragment);
        transaction.commit();
    }


//    private void excuteLogin() {
//        user_reg_phone = (EditText)view.findViewById(R.id.user_reg_phone);
//        user_reg_password = (EditText)view.findViewById(R.id.user_reg_password);
//
//        String phone = user_reg_phone.getText().toString().trim();
//        String password = user_reg_password.getText().toString().trim();
//        Retrofit retrofit=new Retrofit.Builder().
//                baseUrl(Url.LOGIN_URL)
//                .addConverterFactory(ScalarsConverterFactory.create())
//                .build();
//        LoginServer loginServer =retrofit.create(LoginServer.class);
//
//        Call<String> call=  loginServer.login(phone, password);
//        call.enqueue(new Callback<String>() {
//            @Override
//            public void onResponse(Call<String> call, Response<String> response) {
//                if (response.isSuccessful()) {
//                    Toast.makeText(getContext(), response.body().toString(), Toast.LENGTH_LONG).show();
//
//                }
//            }
//
//            @Override
//            public void onFailure(Call<String> call, Throwable t) {
//                Toast.makeText(getContext(), "登录失败！", Toast.LENGTH_LONG).show();
//
//            }
//        });
//    }
//
//    public void goTologin(Subscriber<LoginServer> subscriber,String phone,String password){
//
//    }

    private void goTologin() {
        subscriber = new Subscriber<LoginResult>() {


            @Override
            public void onCompleted() {
                Toast.makeText(getContext(),"连接成功！",Toast.LENGTH_LONG).show();
            }

            @Override
            public void onError(Throwable e) {
                Toast.makeText(getContext(),e.getMessage().toString(),Toast.LENGTH_LONG).show();
            }

            @Override
            public void onNext(LoginResult loginResult) {
                Toast.makeText(getContext(),loginResult.getPhone(),Toast.LENGTH_LONG).show();
            }
        };
        user_reg_phone = (EditText)view.findViewById(R.id.user_reg_phone);
        user_reg_password = (EditText)view.findViewById(R.id.user_reg_password);

        String phone = user_reg_phone.getText().toString().trim();
        String password = user_reg_password.getText().toString().trim();
        LoginMethods.getInstance().goToLogin(subscriber,phone,password);

    }}