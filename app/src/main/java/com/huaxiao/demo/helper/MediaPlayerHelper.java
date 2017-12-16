package com.huaxiao.demo.helper;

import android.media.MediaPlayer;

import java.io.IOException;

/**
 * Description 系统MediaPlayer
 * Author sunhuaxiao
 * Date 2017/12/16
 */

public class MediaPlayerHelper {

    private static MediaPlayerHelper mInstance;
    private MediaPlayer mMediaPlayer;
    private MediaPlayerListener mMediaPlayerListener;
    private boolean mPlayOnce;
    private static final String TAG = "MediaPlayerHelper";

    public interface MediaPlayerListener {
        void onPrepare(MediaPlayer mp);

        void onFinish(MediaPlayer mp);

        void onError(MediaPlayer mp, int what, int extra);
    }

    public static MediaPlayerHelper getInstance() {
        if (mInstance == null) {
            mInstance = new MediaPlayerHelper();
        }

        return mInstance;
    }

    public MediaPlayerHelper setPlayOnce(boolean once) {
        mPlayOnce = once;
        return this;
    }

    public MediaPlayerHelper init() {
        if (mMediaPlayer == null) {
            mMediaPlayer = new MediaPlayer();
        }

        mMediaPlayer.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
            @Override
            public void onPrepared(MediaPlayer mp) {
                if (mMediaPlayerListener != null) {
                    mMediaPlayerListener.onPrepare(mp);
                }
            }
        });

        mMediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {
                if (mMediaPlayerListener != null) {
                    mMediaPlayerListener.onFinish(mp);
                }

                if (mPlayOnce) {
                    stop();
                } else {
                    mMediaPlayer.start();
                }
            }
        });

        mMediaPlayer.setOnErrorListener(new MediaPlayer.OnErrorListener() {
            @Override
            public boolean onError(MediaPlayer mp, int what, int extra) {
                if (mMediaPlayerListener != null) {
                    mMediaPlayerListener.onError(mp, what, extra);
                }

                return false;
            }
        });

        return this;
    }

    public void play(String uri) {
        try {
            mMediaPlayer.reset();
            mMediaPlayer.setDataSource(uri);
            mMediaPlayer.prepare();
            mMediaPlayer.start();
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
        } catch (IllegalStateException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void stop() {
        if (mMediaPlayer == null) return;

        mMediaPlayer.stop();
        mMediaPlayer.release();
    }

    public MediaPlayerHelper start() {
        if (mMediaPlayer == null) return this;

        mMediaPlayer.start();

        return this;
    }

    public MediaPlayerHelper setListener(final MediaPlayerListener listener) {
        mMediaPlayerListener = listener;
        return this;
    }

}
