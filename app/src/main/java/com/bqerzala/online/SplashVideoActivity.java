package com.bqerzala.online;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.widget.VideoView;
import android.media.MediaPlayer;
import androidx.appcompat.app.AppCompatActivity;

public class SplashVideoActivity extends AppCompatActivity {

    private VideoView videoView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // إنشاء VideoView برمجيًا أو يمكن تعريفه في xml
        videoView = new VideoView(this);
        setContentView(videoView);

        // تعريف مسار الفيديو داخل الـ raw
        Uri videoUri = Uri.parse("android.resource://" + getPackageName() + "/" + R.raw.video);

        // تعيين مصدر الفيديو للـ VideoView
        videoView.setVideoURI(videoUri);

        // تشغيل الفيديو تلقائيًا
        videoView.start();

        // الاستماع لانتهاء الفيديو للانتقال إلى MainActivity
        videoView.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {
                startActivity(new Intent(SplashVideoActivity.this, MainActivity.class));
                finish();
            }
        });
    }
}
