package com.gjf.lovezzu.fragment.friends;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.gjf.lovezzu.R;

import io.rong.imkit.RongIM;

/**
 * Created by zhao on 2017/7/14.
 */

public class ContactListFragment extends Fragment {

    TextView chatlist;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.friend_sontact,container,false);
        chatlist= (TextView) view.findViewById(R.id.chatlist);
        chatlist.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(RongIM.getInstance()!=null){
                    RongIM.getInstance().startConversationList(getActivity());
                }
            }
        });
        return view;
    }
}
