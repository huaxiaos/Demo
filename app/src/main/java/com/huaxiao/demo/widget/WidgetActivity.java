package com.huaxiao.demo.widget;

import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ProgressBar;

import com.huaxiao.android.smartcore.helper.CountDownHelper;
import com.huaxiao.demo.R;

public class WidgetActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_widget);

        final ProgressBar progressBar = findViewById(R.id.progressBar);
        progressBar.setMax(10 * 1000);
        progressBar.setProgress(progressBar.getMax());

        CountDownHelper countDownHelper = new CountDownHelper();
        countDownHelper.start(10 * 1000, 1, new CountDownHelper.CountDownListener() {
            @Override
            public void onTick(long millisUntilFinished) {
                progressBar.setProgress((int) millisUntilFinished);
            }

            @Override
            public void onFinish() {
                progressBar.setProgress(0);
            }
        });

        TextRoundProgress textRoundProgress = findViewById(R.id.trp_0);
        textRoundProgress.setProgress(90);
    }
}
