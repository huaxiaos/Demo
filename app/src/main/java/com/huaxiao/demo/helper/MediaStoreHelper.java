package com.huaxiao.demo.helper;

import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.media.MediaScannerConnection;
import android.net.Uri;
import android.os.Environment;
import android.provider.MediaStore;

import com.huaxiao.demo.utils.LogUtils;

import java.io.File;

/**
 * Description 媒体库
 * Author sunhuaxiao
 * Date 2018/1/26
 */

public class MediaStoreHelper {

    private static final String TAG = "MediaStoreHelper";

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

    public static void insert(Context context, String[] paths, String[] types) {
        MediaScannerConnection.scanFile(
                context,
                paths,
                types,
                new MediaScannerConnection.OnScanCompletedListener() {
                    @Override
                    public void onScanCompleted(String path, Uri uri) {
                        LogUtils.i(TAG, "insert onScanCompleted path " + path + " uri " + uri);
                    }
                });
    }

}
