package com.gjf.lovezzu.fragment.friends;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.gjf.lovezzu.R;


/**
 * Created by zhao on 2017/7/14.
 */

public class ConversationFragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.friend_coversation,container,false);



        return view;
    }
}
