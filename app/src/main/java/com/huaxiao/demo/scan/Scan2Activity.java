package com.huaxiao.demo.scan;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.huaxiao.demo.R;

import java.util.ArrayList;

import io.haydar.filescanner.FileInfo;
import io.haydar.filescanner.FileScanner;

public class Scan2Activity extends AppCompatActivity {

    private static final String TAG = "Scan2Activity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scan2);

        fileScanner();
    }

    private long mStart;
    private long mEnd;

    private void fileScanner() {
        FileScanner.getInstance(this).clear();
        FileScanner.getInstance(this).setType(".png").start(new FileScanner.ScannerListener() {
            /**
             * 扫描开始
             */
            @Override
            public void onScanBegin() {
                mStart = System.currentTimeMillis();
                Log.d(TAG, "onScanBegin: ");
            }

            /**
             * 扫描结束
             */
            @Override
            public void onScanEnd() {
                mEnd = System.currentTimeMillis();
                Log.d(TAG, "onScanEnd: ");
//                ArrayList<FileInfo> fileInfoArrayList = FileScanner.getInstance(Scan2Activity.this).getAllFiles();
//                for (FileInfo fileInfo : fileInfoArrayList) {
//                    Log.d(TAG, "fileScanner: " + fileInfo.getFilePath());
//                }

                Log.d(TAG, "time " + (mEnd - mStart));
            }

            /**
             * 扫描进行中
             * @param paramString 文件夹地址
             * @param progress  扫描进度
             */
            @Override
            public void onScanning(String paramString, int progress) {
                Log.d(TAG, "onScanning: " + progress);
            }

            /**
             * 扫描进行中，文件的更新
             * @param info
             * @param type  SCANNER_TYPE_ADD：添加；SCANNER_TYPE_DEL：删除
             */
            @Override
            public void onScanningFiles(FileInfo info, int type) {
                Log.d(TAG, "onScanningFiles: info=" + info.toString());
            }
        });

    }
}
