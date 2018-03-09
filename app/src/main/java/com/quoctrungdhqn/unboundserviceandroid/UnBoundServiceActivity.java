package com.quoctrungdhqn.unboundserviceandroid;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class UnBoundServiceActivity extends AppCompatActivity {

    Button btnPlayMusic, btnStopMusic;
    Intent playMusic;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_unbound_service);

        btnPlayMusic = findViewById(R.id.btn_play_music);
        btnStopMusic = findViewById(R.id.btn_stop_music);

        // Tạo intent khai báo service được sử dụng
        playMusic = new Intent(UnBoundServiceActivity.this, UnBoundServiceExample.class);

        initHandle();
    }

    private void initHandle() {
        btnPlayMusic.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Khởi chạy service
                startService(playMusic);
            }
        });

        btnStopMusic.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Hủy service khi không dùng nữa
                stopService(playMusic);
            }
        });
    }
}
