package com.huaxiao.demo.helper;

import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.provider.MediaStore;

import java.io.File;

/**
 * Description 媒体库
 * Author sunhuaxiao
 * Date 2018/1/26
 */

public class MediaStoreHelper {

    public static void insert(Context context, String filePath) throws Exception {
        Intent intent = new Intent(Intent.ACTION_MEDIA_SCANNER_SCAN_FILE);
        intent.setData(Uri.fromFile(new File(filePath)));
        context.sendBroadcast(intent);
    }

    public static void update(Context context, String filePath, long duration) throws Exception {
        ContentValues values = new ContentValues();
        values.put(MediaStore.Video.VideoColumns.DATA, filePath);
        values.put(MediaStore.Video.VideoColumns.DURATION, duration);
        context.getContentResolver().update(
                MediaStore.Video.Media.EXTERNAL_CONTENT_URI,
                values,
                MediaStore.MediaColumns.DATA + "='" + filePath + "'", null);
    }

}
