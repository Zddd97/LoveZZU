package com.gjf.lovezzu.fragment;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.gjf.lovezzu.R;

/**
 * Created by BlackBeard丶 on 2017/03/01.
 */
public class FriendFragment extends Fragment {
    @Nullable
  private   LinearLayout linearLayout;
   private  View view;
    @Override

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        view= inflater.inflate(R.layout.friend_fragment,container,false);
        return  view;

    }


}
