package com.gjf.lovezzu.fragment.friends;

import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import android.widget.ImageView;

import android.widget.TextView;

import com.gjf.lovezzu.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;

/**
 * Created by BlackBeard丶 on 2017/03/01.
 */
public class FriendFragment extends Fragment {
    @BindView(R.id.friends_messages)
    TextView friendsMessages;
    @BindView(R.id.friends_people)
    TextView friendsPeople;
    @BindView(R.id.add_friends)
    ImageView addFriends;
    Unbinder unbinder;
    @Nullable
    private View view;
    private ContactListFragment contactListFragment;
    private ConversationListFragment conversationFragment;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        contactListFragment = new ContactListFragment();
        conversationFragment = new ConversationListFragment();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.friend_fragment, container, false);
        ButterKnife.bind(this, view);
        friendsMessages.setTextColor(Color.parseColor("#0090FD"));
        replaceFragment(conversationFragment);
        return view;

    }


    @Override
    public void onDestroyView() {
        super.onDestroyView();
        //unbinder.unbind();
    }

    @OnClick({R.id.friends_messages, R.id.friends_people, R.id.add_friends})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.friends_messages:
                if (conversationFragment == null) {
                    conversationFragment = new ConversationListFragment();
                }
                replaceFragment(conversationFragment);
                friendsMessages.setTextColor(Color.parseColor("#0090FD"));
                friendsPeople.setTextColor(Color.parseColor("#000000"));
                break;
            case R.id.friends_people:
                if (contactListFragment == null) {
                    contactListFragment = new ContactListFragment();
                }
                replaceFragment(contactListFragment);
                friendsMessages.setTextColor(Color.parseColor("#000000"));
                friendsPeople.setTextColor(Color.parseColor("#0090FD"));
                //startActivity(new Intent(getActivity(),ConversationActivity.class));
                break;
            case R.id.add_friends:
                //startActivity(new Intent(getActivity(), AddContactActivity.class));
                break;
        }
    }

    private void replaceFragment(Fragment fragment) {
        FragmentManager fragmentManager = getChildFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.friends_main, fragment);
        fragmentTransaction.commit();

    }

}
