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
import com.gjf.lovezzu.entity.PersonBuinessResult;

import java.util.List;

/**
 * Created by BlackBeard丶 on 2017/04/09.
 */

public class PersonBusinessAdapter  extends RecyclerView.Adapter<PersonBusinessAdapter.ViewHolder>{
    private Context mContext;
    private List<PersonBuinessResult> businesrecordList;
    private LayoutInflater inflater;
    public  PersonBusinessAdapter(List<PersonBuinessResult> personBuinessResultList , Context context){
///
        this.businesrecordList =  businesrecordList;
        this.mContext = context;
        inflater= LayoutInflater.from(mContext);
    }
    @Override
    public PersonBusinessAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.person_business_record, parent, false);
        final ViewHolder holder = new ViewHolder(view);
        holder.businessView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(v.getContext(), "点击事件", Toast.LENGTH_SHORT).show();
                //点击事件
            }
        });
        return holder;
    }

    @Override
    public void onBindViewHolder(PersonBusinessAdapter.ViewHolder holder, int position) {
        PersonBuinessResult personBuinessResult = businesrecordList.get(position);
        Glide.with(mContext)
                .load(personBuinessResult.getUrl())
                .centerCrop()
                .placeholder(R.drawable.__picker_ic_photo_black_48dp)
                .error(R.drawable.__picker_ic_broken_image_black_48dp)
                .into(holder.imageView_bus);

        holder.goodname.setText(personBuinessResult.getGoodname());
        holder.jianshu.setText(personBuinessResult.getJianshu());
        holder.number.setText(personBuinessResult.getNumber());
        holder.totalprice.setText(personBuinessResult.getTotalprice());

    }



    @Override
    public int getItemCount() {
        return businesrecordList.size();}

    static class ViewHolder extends  RecyclerView.ViewHolder{
        View businessView;
        ImageView imageView_bus;
        TextView totalprice;
        TextView  goodname;
        TextView jianshu;
        TextView number;
        TextView price;
        public  ViewHolder(View itemView){
            super(itemView);
            businessView = itemView;
            imageView_bus= (ImageView) itemView.findViewById(R.id.bus_image);
            totalprice = (TextView) itemView.findViewById(R.id.totalprice);
            goodname = (TextView) itemView.findViewById(R.id.goodname);
            jianshu = (TextView) itemView.findViewById(R.id.jianshu);
            number = (TextView) itemView.findViewById(R.id.number);
            price = (TextView) itemView.findViewById(R.id.price);


        }
}}
