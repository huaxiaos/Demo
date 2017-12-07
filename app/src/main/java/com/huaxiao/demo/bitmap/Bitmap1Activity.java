package com.huaxiao.demo.bitmap;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.huaxiao.demo.R;
import com.huaxiao.demo.utils.LogUtils;

public class Bitmap1Activity extends AppCompatActivity {

    private static final String TAG = "Bitmap1Activity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bitmap1);

        final ImageView image1 = (ImageView) findViewById(R.id.image1);


        image1.post(new Runnable() {
            @Override
            public void run() {

                long a = System.currentTimeMillis();

                Bitmap bitmap1 = test(image1);

                LogUtils.d(TAG, (System.currentTimeMillis() - a) + "");
            }
        });

//        Bitmap bitmap2 = getBitmapByView(image1);

        LogUtils.d("111");
    }

    public static Bitmap getBitmapByView(View view) {
        try {
            Bitmap bitmap;
            // 创建对应大小的bitmap
            bitmap = Bitmap.createBitmap(view.getWidth(), view.getHeight(),
                    Bitmap.Config.ARGB_8888);
            final Canvas canvas = new Canvas(bitmap);
            view.draw(canvas);
            return bitmap;
        } catch (OutOfMemoryError e) {
            return null;
        }
    }

    public static Bitmap test(View view) {
        view.buildDrawingCache();
        Bitmap bitmap = view.getDrawingCache();
        return bitmap;
    }
}