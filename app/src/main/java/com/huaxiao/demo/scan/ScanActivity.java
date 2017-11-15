package com.huaxiao.demo.scan;

import android.database.Cursor;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;

import com.huaxiao.demo.R;
import com.huaxiao.demo.utils.LogUtils;

import java.util.ArrayList;
import java.util.List;

public class ScanActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scan);

        LogUtils logUtils = LogUtils.getInstance();

        logUtils.timeStart();
        List<FileItem> list = getAllPhoto();
        logUtils.timeEnd();

        logUtils.logTimeDelta();
        LogUtils.e(list.size() + "");
    }

    private List<FileItem> getAllPhoto() {

        List<FileItem> photos = new ArrayList<>();

        String[] projection = new String[]{MediaStore.Images.ImageColumns._ID, MediaStore.Images.ImageColumns.DATA, MediaStore.Images.ImageColumns.DISPLAY_NAME};


        //asc 按升序排列
        //    desc 按降序排列
        //projection 是定义返回的数据，selection 通常的sql 语句，例如  selection=MediaStore.Images.ImageColumns.MIME_TYPE+"=? " 那么 selectionArgs=new String[]{"jpg"};
//        Cursor cursor = mContentResolver.query(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, projection, null, null, MediaStore.Images.ImageColumns.DATE_MODIFIED + "  desc");
        Cursor cursor = getContentResolver().query(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, projection, null, null, MediaStore.Images.ImageColumns.DATE_MODIFIED + "  desc");


        String imageId = null;

        String fileName;

        String filePath;

        while (cursor.moveToNext()) {

            imageId = cursor.getString(cursor.getColumnIndex(MediaStore.Images.ImageColumns._ID));

            fileName = cursor.getString(cursor.getColumnIndex(MediaStore.Images.ImageColumns.DISPLAY_NAME));

            filePath = cursor.getString(cursor.getColumnIndex(MediaStore.Images.ImageColumns.DATA));

            FileItem fileItem = new FileItem(imageId, filePath, fileName);

//            Log.e("ryze_photo", imageId + " -- " + fileName + " -- " + filePath);


            photos.add(fileItem);


        }
        cursor.close();

        cursor = null;

        return photos;

    }

    private static class FileItem {

        public String imageId;
        public String filePath;
        public String fileName;

        FileItem(String imageId, String filePath, String fileName) {
            this.imageId = imageId;
            this.filePath = filePath;
            this.fileName = fileName;
        }
    }

}
