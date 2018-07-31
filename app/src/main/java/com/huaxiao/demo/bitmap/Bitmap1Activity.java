package com.huaxiao.demo.bitmap;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.huaxiao.demo.R;
import com.huaxiao.demo.helper.ThreadHelper;
import com.huaxiao.demo.utils.ImageUtils;
import com.huaxiao.demo.utils.LogUtils;

public class Bitmap1Activity extends AppCompatActivity {

    private static final String TAG = "Bitmap1Activity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bitmap1);

        final ImageView image1 = (ImageView) findViewById(R.id.image1);

        final String url = "";
        final int size = 40;

        ThreadHelper.getInstance().getGlobalThreadPool().execute(new Runnable() {
            @Override
            public void run() {
                Bitmap bitmap = ImageUtils.resize(Bitmap1Activity.this, url, size, size);

                if (bitmap == null) {
                    LogUtils.i("resize", "bitmap is null");
                } else {
                    LogUtils.i("resize", "width " + bitmap.getWidth() + " height " + bitmap.getHeight());
                }
            }
        });
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