package com.huaxiao.demo.scan;

import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.provider.MediaStore;

/**
 * Description 扫描
 * Author sunhuaxiao
 * Date 2017/12/5
 */

public class ScanHelper {

    public static void scanVideo(Context context) {
        Uri uri = MediaStore.Video.Media.EXTERNAL_CONTENT_URI;
        String[] mediaColumns = {
                MediaStore.Video.Media.DATA,
                MediaStore.Video.Media.SIZE,
                MediaStore.Video.Media.DATE_MODIFIED};
        Cursor c = context.getContentResolver().query(uri, mediaColumns, null, null,
                MediaStore.Video.Media.DATE_MODIFIED + " desc");

        if (c != null) {
            while (c.moveToNext()) {
                String path = c.getString(c.getColumnIndexOrThrow(MediaStore.Video.Media.DATA));
                long size = c.getLong(c.getColumnIndexOrThrow(MediaStore.Video.Media.SIZE));
                long lastModified = c.getLong(c.getColumnIndexOrThrow(MediaStore.Video.Media.DATE_MODIFIED));
            }
            c.close();
        }
    }

    public static void scanImage(Context context) {
        Uri uri = MediaStore.Images.Media.EXTERNAL_CONTENT_URI;
        String[] mediaColumns = {
                MediaStore.Images.Media.DATA,
                MediaStore.Images.Media.SIZE,
                MediaStore.Images.Media.DATE_MODIFIED};
        Cursor c = context.getContentResolver().query(uri, mediaColumns, null, null,
                MediaStore.Video.Media.DATE_MODIFIED + " desc");

        if (c != null) {
            while (c.moveToNext()) {
                String path = c.getString(c.getColumnIndexOrThrow(MediaStore.Images.Media.DATA));
                long size = c.getLong(c.getColumnIndexOrThrow(MediaStore.Images.Media.SIZE));
                long lastModified = c.getLong(c.getColumnIndexOrThrow(MediaStore.Images.Media.DATE_MODIFIED));
            }
            c.close();
        }
    }

}
