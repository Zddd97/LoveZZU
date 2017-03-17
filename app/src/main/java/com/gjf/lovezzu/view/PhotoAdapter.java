package com.gjf.lovezzu.view;

import android.content.Context;
import android.net.Uri;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.gjf.lovezzu.R;
import com.gjf.lovezzu.entity.UserInfoResult;
import com.gjf.lovezzu.network.UpLoadIconMethods;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import me.iwf.photopicker.utils.AndroidLifecycleUtils;
import okhttp3.MediaType;
import okhttp3.RequestBody;
import rx.Subscriber;

/**
 * Created by BlackBeard丶 on 2017/03/15.
 */
public class PhotoAdapter  extends RecyclerView.Adapter<PhotoAdapter.PhotoViewHolder> {
    private ArrayList<String> photoPaths = new ArrayList<String>();
    private LayoutInflater inflater;
    private  Uri uri;
    private Context mContext;
    private Subscriber subscriber;
  public   final static int TYPE_ADD = 1;
  public   final static int TYPE_PHOTO = 2;
//
  public   final static int MAX = 9;

    public PhotoAdapter(Context mContext, ArrayList<String> photoPaths) {
        this.photoPaths = photoPaths;
        this.mContext = mContext;
        inflater = LayoutInflater.from(mContext);

    }


    @Override public PhotoViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = null;
        switch (viewType) {
            case TYPE_ADD:
                itemView = inflater.inflate(R.layout.iconpick_add, parent, false);
                break;
            case TYPE_PHOTO:
                itemView = inflater.inflate(R.layout.__picker_item_photo, parent, false);
                break;
        }
        return new PhotoViewHolder(itemView);
    }


    @Override
    public void onBindViewHolder(final PhotoViewHolder holder, final int position) {

        if (getItemViewType(position) == TYPE_PHOTO) {
          uri = Uri.fromFile(new File(photoPaths.get(position)));

            Map<String, RequestBody> photos = new HashMap<>();
            File file = new File(uri.getPath());
            RequestBody requestFile = RequestBody.create(MediaType.parse("multipart/form-data"), file);
            photos.put("\"; filename=\""+file.getName(),requestFile);
            Log.d("ggggg",uri.toString());

            boolean canLoadImage = AndroidLifecycleUtils.canLoadImage(holder.ivPhoto.getContext());

            if (canLoadImage) {
                Glide.with(mContext)
                        .load(uri)
                        .centerCrop()
                        .thumbnail(0.1f)
                        .placeholder(R.drawable.__picker_ic_photo_black_48dp)
                        .error(R.drawable.__picker_ic_broken_image_black_48dp)
                        .into(holder.ivPhoto);
            }
        }
    }


    @Override public int getItemCount() {
        int count = photoPaths.size() + 1;
        if (count > MAX) {
            count = MAX;
        }
        return count;
    }

    @Override
    public int getItemViewType(int position) {
        return (position == photoPaths.size() && position != MAX) ? TYPE_ADD : TYPE_PHOTO;
    }

    public static class PhotoViewHolder extends RecyclerView.ViewHolder {
        private ImageView ivPhoto;
        private View vSelected;
        public PhotoViewHolder(View itemView) {
            super(itemView);
            ivPhoto   = (ImageView) itemView.findViewById(R.id.iv_photo);
            vSelected = itemView.findViewById(R.id.v_selected);
            if (vSelected != null) vSelected.setVisibility(View.GONE);
        }
    }

    public void upLoad(   Map<String, RequestBody> photos){
        subscriber = new Subscriber<UserInfoResult>() {
            @Override
            public void onCompleted() {

            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onNext(UserInfoResult userInfoResult) {

            }
        };
        String phone = null;
        UpLoadIconMethods.upLoadIconMethods(subscriber,photos,phone);
    }
}
