package com.huaxiao.demo.utils;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.support.annotation.Nullable;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.engine.GlideException;
import com.bumptech.glide.request.RequestListener;
import com.bumptech.glide.request.target.Target;

import java.io.File;

/**
 * Description 图片工具类
 * Author sunhuaxiao
 * Date 2017/11/4
 */

public class ImageUtils {

    private static final String TAG = "ImageUtils";

    public static void displayImg(Context context, String url, ImageView imageView) {
        Glide.with(context)
                .load(url)
                .into(imageView);
    }

    public static void displayImg(Context context, String url, final ImageView imageView, final int errorImg) {
        Glide.with(context)
                .load(url)
                .listener(new RequestListener<Drawable>() {
                    @Override
                    public boolean onLoadFailed(@Nullable GlideException e, Object o, Target<Drawable> target, boolean b) {
                        imageView.setImageResource(errorImg);
                        return true;
                    }

                    @Override
                    public boolean onResourceReady(Drawable drawable, Object o, Target<Drawable> target, DataSource dataSource, boolean b) {
                        return false;
                    }
                })
                .into(imageView);
    }

    public static void displayImg(Context context, File file, ImageView imageView) {
        Glide.with(context)
                .load(file)
                .into(imageView);
    }

}
