package com.huaxiao.android.smartcore.helper;

import android.os.CountDownTimer;

/**
 * Created by sunhuaxiao on 2019-09-30.
 */
public class CountDownHelper {

    private CountDownTimer countDownTimer;
    private long remain;
    private long interval;
    private CountDownListener countDownListener;

    public interface CountDownListener {
        void onTick(long millisUntilFinished);

        void onFinish();
    }

    public void start(long millisInFuture, long countDownInterval, final CountDownListener listener) {
        stop();

        remain = millisInFuture;
        interval = countDownInterval;
        countDownListener = listener;

        countDownTimer = new CountDownTimer(millisInFuture, countDownInterval) {
            @Override
            public void onTick(long millisUntilFinished) {
                remain = millisUntilFinished;
                if (listener != null) {
                    listener.onTick(millisUntilFinished);
                }
            }

            @Override
            public void onFinish() {
                remain = 0;
                if (listener != null) {
                    listener.onFinish();
                }
            }
        };

        countDownTimer.start();
    }

    public void stop() {
        if (countDownTimer != null) {
            countDownTimer.cancel();
            countDownTimer = null;
        }
    }

    public void resume() {
        if (isRunning() || remain <= 0) {
            return;
        }

        start(remain, interval, countDownListener);
    }

    public void pause() {
        stop();
    }

    private boolean isRunning() {
        return countDownTimer != null;
    }

}
