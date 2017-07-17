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

public class ConversationListFragment extends Fragment {

    TextView chatText;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.conversationlist_fragement,container,false);
        chatText= (TextView) view.findViewById(R.id.chat);
        chatText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (RongIM.getInstance()!=null){
                    RongIM.getInstance().startPrivateChat(getActivity(),"18838185470","郑州移动");
                }
            }
        });
        return view;
    }
}