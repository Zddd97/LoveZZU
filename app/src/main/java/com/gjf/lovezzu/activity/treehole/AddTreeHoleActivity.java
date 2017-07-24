package com.gjf.lovezzu.activity.treehole;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.gjf.lovezzu.R;
import com.gjf.lovezzu.entity.TreeHoleData;
import com.gjf.lovezzu.network.TreeHoleMethods;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import rx.Subscriber;

/**
 * Created by zhao on 2017/5/4.
 */

public class AddTreeHoleActivity extends AppCompatActivity {
    @BindView(R.id.tree_add_back)
    ImageView treeAddBack;
    @BindView(R.id.send_tree)
    TextView sendTree;
    @BindView(R.id.add_tree_content)
    EditText addTreeContent;
    @BindView(R.id.add_tree_textNumber)
    TextView addTreeTextNumber;
    private Subscriber subscriber;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tree_add_view);
        ButterKnife.bind(this);
        //字数监听
        addTreeContent.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                String text = addTreeContent.getText().toString();
                addTreeTextNumber.setText(text.length() + "");
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
    }

    @OnClick({R.id.tree_add_back, R.id.send_tree})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.tree_add_back:
                finish();
                break;
            case R.id.send_tree:
                sendMessage();
                break;
            default:
                break;
        }
    }

    private void sendMessage() {
        subscriber = new Subscriber<TreeHoleData>() {
            @Override
            public void onCompleted() {

            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onNext(TreeHoleData treeHoleData) {
                if (treeHoleData.getCode().equals("200")) {
                    Toast.makeText(getApplicationContext(), "发送成功！", Toast.LENGTH_LONG).show();
                } else {
                    Toast.makeText(getApplicationContext(), "发送失败！", Toast.LENGTH_SHORT).show();
                }


            }
        };
        TreeHoleMethods.getInstance().sendTUCAOContent(subscriber, "sessionid", addTreeContent.getText().toString());


    }
}
