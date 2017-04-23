package com.gjf.lovezzu.view;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.gjf.lovezzu.R;
import com.gjf.lovezzu.entity.TaoyuDataBridging;

import java.util.List;

/**
 * Created by lenovo047 on 2017/3/24.
 */

public class TaoyuAdapter extends RecyclerView.Adapter<TaoyuAdapter.ViewHolder> {
    private List<TaoyuDataBridging> taoyuResultList;
    private Context context;
    private TaoyuDataBridging taoyuResult;
    private LayoutInflater inflater;

    public TaoyuAdapter(List<TaoyuDataBridging> taoyuResultList, Context context) {
        this.taoyuResultList = taoyuResultList;
        this.context = context;
        inflater = LayoutInflater.from(context);
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.taoyu, parent, false);
        final ViewHolder holder = new ViewHolder(view);
        holder.taoyuView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(v.getContext(), "点击事件", Toast.LENGTH_SHORT).show();
            }
        });
        return holder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        taoyuResult = taoyuResultList.get(position);
        // holder.touxiang.setImageResource(taoyuResult.getUserinfo().getImageUrl());
        Glide.with(context)
                .load(taoyuResult.getUserinfo().getImageUrl())
                .centerCrop().dontAnimate()
                .placeholder(R.drawable.__picker_ic_photo_black_48dp)
                .error(R.drawable.__picker_ic_broken_image_black_48dp)
                .into(holder.taoyuimag);
        //holder.taoyuimag.setImageResource(taoyuResult.getImageID2());
        holder.describe.setText(taoyuResult.getGoods().getGdescribe());
        holder.comment.setText(taoyuResult.getGoods().getGname());
        holder.position.setText(taoyuResult.getUserinfo().getAcademy());
        holder.price.setText(taoyuResult.getGoods().getGprice());
        holder.phone.setText(taoyuResult.getUserinfo().getPhone());
        holder.time.setText(taoyuResult.getGoods().getGdate());
        holder.zan.setText(taoyuResult.getGoods().getGname());


    }

    @Override
    public int getItemCount() {
        return taoyuResultList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        View taoyuView;
        ImageView touxiang;
        ImageView taoyuimag;
        TextView phone;
        TextView time;
        TextView price;
        TextView position;
        TextView zan;
        TextView comment;
        TextView describe;


        public ViewHolder(View itemView) {
            super(itemView);
            taoyuView = itemView;
            taoyuimag = (ImageView) itemView.findViewById(R.id.taoyuimag);
            touxiang = (ImageView) itemView.findViewById(R.id.taoyuimag);
            phone = (TextView) itemView.findViewById(R.id.phone);
            time = (TextView) itemView.findViewById(R.id.time);
            price = (TextView) itemView.findViewById(R.id.price);
            position = (TextView) itemView.findViewById(R.id.position);
            zan = (TextView) itemView.findViewById(R.id.zan);
            comment = (TextView) itemView.findViewById(R.id.comment);
            describe = (TextView) itemView.findViewById(R.id.goods_des);


        }
    }

}
