package com.gjf.lovezzu.view;

import android.app.Activity;
import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.gjf.lovezzu.entity.SocietyNewsResult;
import com.gjf.lovezzu.network.HttpClientUtils;

import java.util.List;

/**
 * Created by BlackBeard丶 on 2017/5/9.
 */

public class DownloadAdapter  extends RecyclerView.Adapter<SocietyAdapter.ViewHolder>{

    private List<SocietyNewsResult> societyNewsResultList;
    HttpClientUtils httpClientUtils;

    private SocietyNewsResult societyNewsResult;

    private Context mContext;
    private Activity activity;
    private LayoutInflater inflater;


    public DownloadAdapter(List<SocietyNewsResult> societyNewsResults, Context mContext) {
        this.societyNewsResultList = societyNewsResults;

        this.mContext = mContext;
        inflater = LayoutInflater.from(mContext);
    }

    @Override
    public SocietyAdapter.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        return null;
    }

    @Override
    public void onBindViewHolder(SocietyAdapter.ViewHolder viewHolder, int i) {
        societyNewsResult = societyNewsResultList.get(i);
        httpClientUtils = new HttpClientUtils(societyNewsResult.getUrl(),"gjf",societyNewsResult.get_id()+".jpg");
        httpClientUtils.downloadFile();

    }

    @Override
    public int getItemCount() {
        return societyNewsResultList.size();
    }
}
