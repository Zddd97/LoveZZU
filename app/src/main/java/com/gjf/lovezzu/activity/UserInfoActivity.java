package com.gjf.lovezzu.activity;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.gjf.lovezzu.R;
import com.gjf.lovezzu.entity.UserInfoResult;
import com.gjf.lovezzu.network.DownloadIconMethods;
import com.gjf.lovezzu.network.GetUserInfoMethods;
import com.gjf.lovezzu.network.SaveUserInfoMethods;
import com.gjf.lovezzu.view.CircleImageView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import rx.Subscriber;

/**
 * Created by BlackBeard丶 on 2017/03/01.
 */
public class UserInfoActivity extends AppCompatActivity {
    private Subscriber subscriber;

    @BindView(R.id.userinfo_icon)  ImageView userinfo_icon;
    @BindView(R.id.main_my_user_icon) CircleImageView circleImageView;
    @BindView(R.id.user_info_nickname_text) TextView user_info_nickname_text;
    @BindView(R.id.user_info_phone_text) TextView user_info_phone_text;
    @BindView(R.id.user_info_sex_text) TextView user_info_sex_text;
    @BindView(R.id.user_info_hone_text) TextView user_info_hone_text;
    @BindView(R.id.user_info_school_text) TextView user_info_school_text;
    @BindView(R.id.user_info_class_text) TextView user_info_class_text;
    @BindView(R.id.user_info_major_text) TextView user_info_major_text;
    @BindView(R.id.userinfo_icon_layout) RelativeLayout userinfo_icon_layout;
    @BindView(R.id.userinfo_nickname_layout) RelativeLayout userinfo_nickname_layout;
    @BindView(R.id.userinfo_code_layout) RelativeLayout userinfo_code_layout;
    @BindView(R.id.userinfo_sex_layout) RelativeLayout userinfo_sex_layout;
    @BindView(R.id.userinfo_home_layout) RelativeLayout userinfo_home_layout;
    @BindView(R.id.userinfo_school_layout) RelativeLayout userinfo_school_layout;
    @BindView(R.id.userinfo_class_layout) RelativeLayout userinfo_class_layout;
    @BindView(R.id.userinfo_major_layout) RelativeLayout userinfo_major_layout;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_userinfo);
        ButterKnife.bind(this);
        disPlayImage();

        if (Build.VERSION.SDK_INT >= 21) {
            View decorView = getWindow().getDecorView();
            int option = View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                    | View.SYSTEM_UI_FLAG_LAYOUT_STABLE;
            decorView.setSystemUiVisibility(option);
            getWindow().setStatusBarColor(Color.TRANSPARENT);
        }
    }

    @OnClick({R.id.userinfo_icon_layout,R.id.userinfo_nickname_layout,R.id.userinfo_code_layout,R.id.userinfo_sex_layout,R.id.userinfo_home_layout,R.id.userinfo_school_layout,R.id.userinfo_class_layout,R.id.userinfo_major_layout})
    public void onClick(View view){
        switch (view.getId()){
            case R.id.userinfo_icon_layout:
                UploadIcon();
                break;
            case R.id.userinfo_nickname_layout:
                EditNickname();
                break;
            case R.id.userinfo_code_layout:
                DisPlayCode();
                break;
            case R.id.userinfo_sex_layout:
                EditSex();
                break;
            case R.id.userinfo_home_layout:
                UploadIcon();
                break;
            case R.id.userinfo_school_layout:
                EditSchool();
                break;
            case R.id.userinfo_class_layout:
                EditClass();
                break;
            case R.id.userinfo_major_layout:
                EditMjaor();
                break;
        }
    }
    //显示用户头像
    private void disPlayImage(){
        subscriber = new Subscriber<Bitmap>() {
            @Override
            public void onCompleted() {

            }

            @Override
            public void onError(Throwable e) {
                Toast.makeText(getApplicationContext(),e.toString(),Toast.LENGTH_LONG).show();
            }

            @Override
            public void onNext(Bitmap bitmap) {
              circleImageView.setImageBitmap(bitmap);
            }
        };
        DownloadIconMethods.getInstance().startDownloadIcon(subscriber);

    }
    //显示用户信息
    private void dispalyUserInfo(){
        subscriber = new Subscriber<UserInfoResult>() {
            @Override
            public void onCompleted() {

            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onNext(UserInfoResult  userInfoResult) {
                SharedPreferences sharedPreferences = getSharedPreferences("userinfo", Activity.MODE_APPEND);
                final SharedPreferences.Editor editor = sharedPreferences.edit();
                user_info_nickname_text.setText(userInfoResult.getNickname());
                user_info_phone_text.setText(userInfoResult.getPhone());
                user_info_sex_text.setText(userInfoResult.getGender());
                user_info_hone_text.setText(userInfoResult.getHometown());
                user_info_school_text.setText(userInfoResult.getAcademy());
                user_info_class_text.setText(userInfoResult.getDepartments());
                user_info_major_text.setText(userInfoResult.getProfessional());

            }
        };
        SharedPreferences sharedPreferences = getSharedPreferences("userinfo", Activity.MODE_APPEND);
        final SharedPreferences.Editor editor = sharedPreferences.edit();
        String phone = sharedPreferences.getString("phone", "");
        String password = sharedPreferences.getString("password","");
        String id = "3";
        GetUserInfoMethods.getUserInfoMethods().goToGetUserInfo(subscriber, id, phone, password);



    }
    private void DisPlayEditText(){

    }
    //上传图片
    private void UploadIcon(){

    }
    //修改昵称
    private void EditNickname(){
        LayoutInflater inflater = getLayoutInflater();
        final View layout = inflater.inflate(R.layout.userinfo_update_view, (ViewGroup) findViewById(R.id.uplayout));
        final EditText text = (EditText)findViewById(R.id.edituserinfo);


        new AlertDialog.Builder(UserInfoActivity.this).setMessage("请输入您的昵称：")
                .setView(layout).setPositiveButton("保存", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
             SaveInfoNcikNmae(text.getText().toString());
            }
        }).setNegativeButton("取消",null).show();

    }
    //显示二维码

    private void DisPlayCode(){


    }
    //修改性别
    private void EditSex(){
        LayoutInflater inflater = getLayoutInflater();
        final View layout = inflater.inflate(R.layout.userinfo_update_view, (ViewGroup) findViewById(R.id.uplayout));
        final EditText text = (EditText)findViewById(R.id.edituserinfo);


        new AlertDialog.Builder(UserInfoActivity.this).setMessage("请输入您的昵称：")
                .setView(layout).setPositiveButton("保存", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                SaveInfoSex(text.getText().toString());
            }
        }).setNegativeButton("取消",null).show();

    }
    //修改家乡
    private void EditHome(){
        LayoutInflater inflater = getLayoutInflater();
        final View layout = inflater.inflate(R.layout.userinfo_update_view, (ViewGroup) findViewById(R.id.uplayout));
        final EditText text = (EditText)findViewById(R.id.edituserinfo);


        new AlertDialog.Builder(UserInfoActivity.this).setMessage("请输入您的昵称：")
                .setView(layout).setPositiveButton("保存", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                SaveInfoHome(text.getText().toString());
            }
        }).setNegativeButton("取消",null).show();

    }
    //修改院校
    private void EditSchool(){
        LayoutInflater inflater = getLayoutInflater();
        final View layout = inflater.inflate(R.layout.userinfo_update_view, (ViewGroup) findViewById(R.id.uplayout));
        final EditText text = (EditText)findViewById(R.id.edituserinfo);


        new AlertDialog.Builder(UserInfoActivity.this).setMessage("请输入您的昵称：")
                .setView(layout).setPositiveButton("保存", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                SaveInfoSChool(text.getText().toString());
            }
        }).setNegativeButton("取消",null).show();

    }
    //修改院系
    private void EditClass(){
        LayoutInflater inflater = getLayoutInflater();
        final View layout = inflater.inflate(R.layout.userinfo_update_view, (ViewGroup) findViewById(R.id.uplayout));
        final EditText text = (EditText)findViewById(R.id.edituserinfo);


        new AlertDialog.Builder(UserInfoActivity.this).setMessage("请输入您的昵称：")
                .setView(layout).setPositiveButton("保存", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                SaveInfoClass(text.getText().toString());
            }
        }).setNegativeButton("取消",null).show();

    }
    //修改专业
    private void EditMjaor(){  LayoutInflater inflater = getLayoutInflater();
        final View layout = inflater.inflate(R.layout.userinfo_update_view, (ViewGroup) findViewById(R.id.uplayout));
        final EditText text = (EditText)findViewById(R.id.edituserinfo);


        new AlertDialog.Builder(UserInfoActivity.this).setMessage("请输入您的昵称：")
                .setView(layout).setPositiveButton("保存", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                SaveInfoMajor(text.getText().toString());
            }
        }).setNegativeButton("取消",null).show();


    }
   //修改昵称的网络操作
    private void SaveInfoNcikNmae(String nickname){

        subscriber = new Subscriber<UserInfoResult>() {
            @Override
            public void onCompleted() {

            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onNext(UserInfoResult userInfoResult) {

            }
        };
        SharedPreferences sharedPreferences = getSharedPreferences("userinfo", Activity.MODE_APPEND);
        final SharedPreferences.Editor editor = sharedPreferences.edit();
        String phone = sharedPreferences.getString("phone", "");
        String id ="";
        SaveUserInfoMethods.saveUserInfoMethods().editNickname(subscriber, id, phone, nickname);

    }
    //修改昵称的网络操作
    private void SaveInfoSex(String sex){

        subscriber = new Subscriber<UserInfoResult>() {
            @Override
            public void onCompleted() {

            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onNext(UserInfoResult userInfoResult) {

            }
        };
        SharedPreferences sharedPreferences = getSharedPreferences("userinfo", Activity.MODE_APPEND);
        final SharedPreferences.Editor editor = sharedPreferences.edit();
        String phone = sharedPreferences.getString("phone", "");
        String id ="";
        SaveUserInfoMethods.saveUserInfoMethods().editSex(subscriber, id, phone, sex);


    }
    //修改家乡的网络操作
    private void SaveInfoHome(String home){

        subscriber = new Subscriber<UserInfoResult>() {
            @Override
            public void onCompleted() {

            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onNext(UserInfoResult userInfoResult) {

            }
        };
        SharedPreferences sharedPreferences = getSharedPreferences("userinfo", Activity.MODE_APPEND);
        final SharedPreferences.Editor editor = sharedPreferences.edit();
        String phone = sharedPreferences.getString("phone", "");
        String id ="";
        SaveUserInfoMethods.saveUserInfoMethods().editHome(subscriber, id, phone, home);


    }
    //修改学校的网络操作
    private void SaveInfoSChool(String school){

        subscriber = new Subscriber<UserInfoResult>() {
            @Override
            public void onCompleted() {

            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onNext(UserInfoResult userInfoResult) {

            }
        };
        SharedPreferences sharedPreferences = getSharedPreferences("userinfo", Activity.MODE_APPEND);
        final SharedPreferences.Editor editor = sharedPreferences.edit();
        String phone = sharedPreferences.getString("phone", "");
        String id ="";
        SaveUserInfoMethods.saveUserInfoMethods().editSchool(subscriber, id, phone, school);

    }
    //修改院校的网络操作
    private void SaveInfoClass(String Class){

        subscriber = new Subscriber<UserInfoResult>() {
            @Override
            public void onCompleted() {

            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onNext(UserInfoResult userInfoResult) {

            }
        };
        SharedPreferences sharedPreferences = getSharedPreferences("userinfo", Activity.MODE_APPEND);
        final SharedPreferences.Editor editor = sharedPreferences.edit();
        String phone = sharedPreferences.getString("phone", "");
        String id ="";
        SaveUserInfoMethods.saveUserInfoMethods().editClass(subscriber, id, phone, Class);

    }
    //修改专业的网络操作
    private void SaveInfoMajor(String mjor){

        subscriber = new Subscriber<UserInfoResult>() {
            @Override
            public void onCompleted() {

            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onNext(UserInfoResult userInfoResult) {

            }
        };
        SharedPreferences sharedPreferences = getSharedPreferences("userinfo", Activity.MODE_APPEND);
        final SharedPreferences.Editor editor = sharedPreferences.edit();
        String phone = sharedPreferences.getString("phone", "");
        String id ="";
        SaveUserInfoMethods.saveUserInfoMethods().editMajor(subscriber, id, phone, mjor);

    }

}
