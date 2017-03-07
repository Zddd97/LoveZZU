package com.gjf.lovezzu.fragment;

import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.gjf.lovezzu.R;
import com.gjf.lovezzu.activity.UserInfoActivity;
import com.gjf.lovezzu.activity.UserLoginActivity;

/**
 * Created by BlackBeard丶 on 2017/03/01.
 */
public class PersonFragment extends Fragment {
    @Nullable
    private LinearLayout linearLayout;
    private  View view;
    private LinearLayout my_info;
    @Override

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        view= inflater.inflate(R.layout.person_fragment,container,false);

        goTologin();
        goTomyinfo();
        return  view;

    }

    private void goTomyinfo() {
        my_info = (LinearLayout)view.findViewById(R.id.my_info);
        my_info.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setClass(getActivity(), UserInfoActivity.class);
                startActivity(intent) ;
            }
        });
    }

    public void goTologin() {
        linearLayout = (LinearLayout)view.findViewById(R.id.user_image);
        linearLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setClass(getActivity(),UserLoginActivity.class);
                startActivity(intent);
            }
        });
    }
}