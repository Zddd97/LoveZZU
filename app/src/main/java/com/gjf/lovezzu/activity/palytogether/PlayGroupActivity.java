package com.gjf.lovezzu.activity.palytogether;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.gjf.lovezzu.R;
import com.gjf.lovezzu.entity.PlayEnd;
import com.gjf.lovezzu.view.CircleImageView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by zhaox on 2017/4/18.
 */

public class PlayGroupActivity extends AppCompatActivity {

    //销毁活动
    @BindView(R.id.back_activity)
    ImageView backActivity;
    //群组图片
    @BindView(R.id.group_image)
    ImageView groupImage;
    //群组名称
    @BindView(R.id.group_name1)
    TextView groupName1;
    //群号
    @BindView(R.id.group_number)
    TextView groupNumber;
    //群介绍
    @BindView(R.id.group_info)
    TextView groupInfo;
    //群成员数
    @BindView(R.id.group_users_number)
    TextView groupUsersNumber;
    //群成员头像
    @BindView(R.id.group_user_1)
    CircleImageView groupUser1;
    @BindView(R.id.group_user_2)
    CircleImageView groupUser2;
    @BindView(R.id.group_user_3)
    CircleImageView groupUser3;
    @BindView(R.id.group_user_4)
    CircleImageView groupUser4;
    //群成员布局
    @BindView(R.id.group_users)
    LinearLayout groupUsers;
    //群空间数目
    @BindView(R.id.group_spaces)
    TextView groupSpaces;
    //群空间图像
    @BindView(R.id.group_space_1)
    ImageView groupSpace1;
    @BindView(R.id.group_space_2)
    ImageView groupSpace2;
    @BindView(R.id.group_space_3)
    ImageView groupSpace3;
    @BindView(R.id.group_space_4)
    ImageView groupSpace4;
    //群空间布局
    @BindView(R.id.group_space)
    LinearLayout groupSpace;
    //入群条件
    @BindView(R.id.group_join_request)
    TextView groupJoinRequest;
    //群标签
    @BindView(R.id.group_tag_1)
    TextView groupTag1;
    //群主信息
    @BindView(R.id.group_master_image)
    CircleImageView groupMasterImage;
    @BindView(R.id.group_master_name)
    TextView groupMasterName;
    @BindView(R.id.group_master_time)
    TextView groupMasterTime;
    //群主信息布局
    @BindView(R.id.group_master_info)
    LinearLayout groupMasterInfo;
    @BindView(R.id.group_location)
    TextView groupLocation;
    @BindView(R.id.group_other_info)
    TextView groupOtherInfo;
    //加入群组
    @BindView(R.id.group_join)
    TextView groupJoin;

    static PlayEnd playEnd;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.play_group);
        ButterKnife.bind(this);
        Intent intent = getIntent();
        playEnd= (PlayEnd) intent.getSerializableExtra("group");
        Toast.makeText(this, playEnd.getID()+"", Toast.LENGTH_SHORT).show();

        //显示
        groupImage.setImageResource(playEnd.getGroupImage());
        groupName1.setText(playEnd.getGroupName());
        groupNumber.setText(playEnd.getID()+"");
        groupInfo.setText(playEnd.getGroupInfo()+"群介绍群介绍群介绍群介只要妹子绍群介绍群只要妹子介绍群介绍");
        groupMasterImage.setImageResource(playEnd.getGroupImage());
        groupMasterName.setText(playEnd.getGroupName());
        groupJoinRequest.setText(playEnd.getGroupInfo()+"入群条件只要妹子只要妹子只要妹子只要妹子只要妹子只要妹子只要妹子");

        //.....其他属性默认未设置。。。
    }


    @OnClick({R.id.back_activity, R.id.group_users, R.id.group_space, R.id.group_master_info, R.id.group_join})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.back_activity:
                onDestroy();
                break;
            case R.id.group_space:
                Toast.makeText(this, "群空间详情", Toast.LENGTH_SHORT).show();
                break;
            case R.id.group_users:
                Toast.makeText(this, "群成员详情", Toast.LENGTH_SHORT).show();
                break;
            case R.id.group_master_info:
                Toast.makeText(this, "群主信息", Toast.LENGTH_SHORT).show();
                break;
            case R.id.group_join:
                Toast.makeText(this, "加入群组", Toast.LENGTH_SHORT).show();
                break;
        }
    }

    //更新群组信息
    public static void lodDate() {
        //根据群组的ID，获得群组的相关信息，在对相应控件进行设置

    }

}
