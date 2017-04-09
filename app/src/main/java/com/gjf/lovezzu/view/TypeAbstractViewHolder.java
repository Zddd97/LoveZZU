package com.gjf.lovezzu.view;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by zhaox on 2017/4/9.
 */

public abstract class TypeAbstractViewHolder extends RecyclerView.Adapter {

   public TypeAbstractViewHolder (View itemView){

   }

    public abstract void bindHolder(DataModel molder);



}
