package com.quoctrungdhqn.unboundserviceandroid;

import android.app.Service;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.IBinder;
import android.support.annotation.Nullable;

public class UnBoundServiceExample extends Service {

    MediaPlayer mMediaPlayer;

    @Override
    public void onCreate() {
        super.onCreate();
        mMediaPlayer = MediaPlayer.create(this, R.raw.see_you_again);

    }

    // Đối với UnBound Service thì hàm này chúng ta không làm gì cả
    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        mMediaPlayer.start();
        return START_STICKY; // Service sẽ chạy lại khi bị hủy bởi hệ thống hoặc người dùng
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        mMediaPlayer.release();
    }
}
