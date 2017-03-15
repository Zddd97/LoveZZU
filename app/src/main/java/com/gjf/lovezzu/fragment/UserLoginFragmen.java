package com.gjf.lovezzu.fragment;

import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.content.SharedPreferences;
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
import com.gjf.lovezzu.entity.CheckLoginApplication;
import com.gjf.lovezzu.entity.LoginResult;
import com.gjf.lovezzu.network.LoginMethods;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import rx.Subscriber;

/**
 * Created by BlackBeard丶 on 2017/03/01.
 */
public class UserLoginFragmen extends Fragment {
    private  View view;
    private UserSingUpFragment userSingUpFragment;
    private Url url;
    private Subscriber subscriber;
   private CheckLoginApplication checkLoginApplication;



    @BindView(R.id.new_user_reg) TextView new_user_reg;
    @BindView(R.id.my_title_back) ImageView my_title_back;
    @BindView(R.id.user_reg_phone) EditText user_reg_phone;
    @BindView(R.id.user_reg_password)   EditText user_reg_password;
    @BindView(R.id.user_login)  LinearLayout user_login;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
       view = inflater.inflate(R.layout.userlogin_fragment,container,false);
        ButterKnife.bind(this, view);

        return view;
    }
    @OnClick({R.id.my_title_back,R.id.new_user_reg,R.id.user_login})
    public void onClick(View view){
        switch (view.getId()){
            case R.id.my_title_back:
                returnHome();
                break;
            case R.id.new_user_reg:
                goToreg();
                break;
            case R.id.user_login:
               checkInput();
                break;
        }
    }



//回到主页

    private void returnHome() {
        Intent intent = new Intent();
        intent.setClass(getActivity(), MainActivity.class);
        startActivity(intent);

    }
  //进入注册页面
    private void goToreg() {
        FragmentManager fm = getFragmentManager();
        FragmentTransaction transaction = fm.beginTransaction();
        userSingUpFragment = new UserSingUpFragment();
        transaction.replace(R.id.singfragment, userSingUpFragment);
        transaction.commit();
    }




    private void goTologin() {
        subscriber = new Subscriber<LoginResult>() {


            @Override
            public void onCompleted() {
                //Toast.makeText(getContext(),"连接成功！",Toast.LENGTH_LONG).show();
            }

            @Override
            public void onError(Throwable e) {
                Toast.makeText(getContext(),e.getMessage().toString()+"网络错误！",Toast.LENGTH_LONG).show();
            }

            @Override
            public void onNext(LoginResult loginResult) {
                if (loginResult.isSuccessful()){
                    String phone = user_reg_phone.getText().toString();
                    String password = user_reg_password.getText().toString();
                    saveUserInfo(phone,password);
                }else{
                    Toast.makeText(getContext(),"账号或者密码错误！",Toast.LENGTH_LONG).show();
                    checkLoginApplication = (CheckLoginApplication)getActivity().getApplication();
                    checkLoginApplication.setIsLogin(false);
                }



            }
        };


        String phone = user_reg_phone.getText().toString().trim();
        String password = user_reg_password.getText().toString().trim();
        boolean  issuccessful = false;
        String identifier = "0";
        LoginMethods.getInstance().goToLogin(subscriber,identifier,issuccessful,phone, password);

    }
   private void saveUserInfo(String phone,String password){
       SharedPreferences sharedPreferences = getContext().getSharedPreferences("userinfo",getContext().MODE_APPEND);
       SharedPreferences.Editor editUserInfo = sharedPreferences.edit();
       editUserInfo.putString("phone",phone);
       editUserInfo.putString("password", password);
       editUserInfo.commit();
       Toast.makeText(getContext(), "登录成功！", Toast.LENGTH_LONG).show();

      checkLoginApplication = (CheckLoginApplication)getActivity().getApplication();
       checkLoginApplication.setIsLogin(true);
       Intent intent = new Intent(getContext(),MainActivity.class);
       startActivity(intent);


   }
    private void checkInput(){
        String checkphone = user_reg_password.getText().toString();
        String checkpassword = user_reg_password.getText().toString();
        if (checkphone==null||checkpassword==null){

            Toast.makeText(getContext(),"请输入用户名或者密码！",Toast.LENGTH_LONG).show();
        }else {
            goTologin();
        }


    }

}