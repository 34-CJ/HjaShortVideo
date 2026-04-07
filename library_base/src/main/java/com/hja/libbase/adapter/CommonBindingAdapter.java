package com.hja.libbase.adapter;

import android.widget.ImageView;

import androidx.databinding.BindingAdapter;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.bitmap.CircleCrop;
import com.bumptech.glide.request.RequestOptions;
import com.hja.libbase.R;

public class CommonBindingAdapter {

    @BindingAdapter("imageUrl")
    public static void loadImage(ImageView imageView, String url) {
        if (url != null && !url.isEmpty()) {
            Glide.with(imageView.getContext())
                    .load(url)
                    .error(R.mipmap.bg_default)
                    .into(imageView);
        }
    }

    @BindingAdapter("imageCircleUrl")
    public static void loadCircleImage(ImageView imageView, String url) {
        if (url != null && !url.isEmpty()) {
            Glide.with(imageView.getContext())
                    .load(url)
                    .placeholder(R.mipmap.icon_default_avatar)//加载过程的占位图
                    .error(R.mipmap.icon_default_avatar)//加载失败时候的占位图
                    .apply(RequestOptions.bitmapTransform(new CircleCrop()))//加载圆形图片
                    .into(imageView);
        }
    }

}
