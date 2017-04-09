package com.gjf.lovezzu.view;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;

import com.gjf.lovezzu.entity.PlayTop;

/**
 * Created by zhaox on 2017/4/9.
 */

public class TypeOneViewViewHolder extends TypeAbstractViewHolder {

    private PlayTop playTop;




    public TypeOneViewViewHolder(View itemView) {
        super(itemView);
    }

    @Override
    public void bindHolder(DataModel molder) {

    }


    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }
}
