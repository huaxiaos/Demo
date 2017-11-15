package com.huaxiao.demo.utils;

import android.text.TextUtils;
import android.util.Log;

import org.apache.http.util.EncodingUtils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.nio.channels.FileChannel;

public class FileUtils {

    private static final String TAG = "FileUtils";

    public static String getFileNameWithoutExtension(File file) {
        if (file == null) return "";

        String fileName = file.getName();
        int pos = fileName.lastIndexOf(".");
        if (pos > 0) {
            return fileName.substring(0, pos);
        }

        return "";
    }

    public static String getFileExtension(File file) {
        if (file == null) return "";

        String fileName = file.getName();
        int pos = fileName.lastIndexOf(".");
        if (pos > 0) {
            return fileName.substring(pos);
        }

        return "";
    }

    public static void copy(String from, String to) {
        if (TextUtils.isEmpty(from) || TextUtils.isEmpty(to)) return;

        FileChannel input;
        FileChannel output;

        try {
            input = new FileInputStream(new File(from)).getChannel();
            output = new FileOutputStream(new File(to)).getChannel();
            output.transferFrom(input, 0, input.size());

            input.close();
            output.close();
        } catch (Exception e) {
            Log.e(TAG + "copyNio", "error occur while copy", e);
        }
    }

    public static boolean isIllegal(File file) {
        return file == null || !file.exists();
    }

    public static String readSDFile(File file) {
        String res = "";
        FileInputStream fis;
        try {
            fis = new FileInputStream(file);
            int length = fis.available();
            byte[] buffer = new byte[length];
            fis.read(buffer);
            res = EncodingUtils.getString(buffer, "UTF-8");
            fis.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return res;
    }

    public static void writeSDFile(File file, String content) {
        FileOutputStream fos;
        try {
            fos = new FileOutputStream(file);
            byte[] bytes = content.getBytes();
            fos.write(bytes);
            fos.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
