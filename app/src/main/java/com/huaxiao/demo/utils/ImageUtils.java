package com.huaxiao.demo.utils;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.support.annotation.Nullable;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.engine.GlideException;
import com.bumptech.glide.request.RequestListener;
import com.bumptech.glide.request.RequestOptions;
import com.bumptech.glide.request.target.SimpleTarget;
import com.bumptech.glide.request.target.Target;
import com.bumptech.glide.request.transition.Transition;

import java.io.File;
import java.util.concurrent.ExecutionException;

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

    /**
     * 该方法中url可以是下载链接，不需要已.png结尾
     *
     * @param context   Context
     * @param url       url
     * @param imageView imageView
     * @param errorImg  errorImg
     */
    public static void displayImgByDownload(Context context, String url, final ImageView imageView, final int errorImg) {
        RequestOptions options = new RequestOptions();
        options.error(errorImg);

        Glide.with(context).asBitmap()
                .load(url)
                .apply(options)
                .into(imageView);
    }

    /**
     * 重置图片大小
     *
     * @param context Context
     * @param url     url
     * @param width   target width
     * @param height  target height
     * @return Bitmap
     * <p>
     * 需要注意的是fitCenter属性，如果没有这个属性，则只能按照缩放至原有大小的1/2
     * 并且不能支持全部的尺寸
     */
    public static Bitmap resize(Context context, String url, int width, int height) {
        try {
            RequestOptions options = new RequestOptions();
            options.fitCenter();

            return Glide.with(context).asBitmap().load(url).apply(options).submit(width, height).get();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }

        return null;
    }

}
