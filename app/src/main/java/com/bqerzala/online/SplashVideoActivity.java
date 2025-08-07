package com.bqerzala.online;

import android.content.Intent;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.widget.VideoView;
import android.util.Log;
import androidx.appcompat.app.AppCompatActivity;

public class SplashVideoActivity extends AppCompatActivity {

    private static final String TAG = "SplashVideoActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_video);

        VideoView videoView = findViewById(R.id.videoView);

        // استخدم R.raw.video — اسم الملف داخل res/raw يجب أن يكون video.mp4 (لاحقة في النظام فقط)
        try {
            Uri videoUri = Uri.parse("android.resource://" + getPackageName() + "/" + R.raw.video);
            videoView.setVideoURI(videoUri);
        } catch (Exception e) {
            Log.e(TAG, "Failed to set video URI", e);
            // لو فشل فوراً، افتح الشاشة الرئيسية بدلاً من الكراش
            startMainAndFinish();
            return;
        }

        // إذا الفيديو انتهى
        videoView.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {
                startMainAndFinish();
            }
        });

        // إذا حدث خطأ بالتشغيل (format/codec/IO) — نتفادى الكراش ونكمل
        videoView.setOnErrorListener((mp, what, extra) -> {
            Log.e(TAG, "VideoView error: what=" + what + " extra=" + extra);
            startMainAndFinish();
            return true; // أخبر النظام أن الخطأ تم التعامل معه
        });

        // بدء التشغيل (قد يستغرق شوية أثناء التحميل)
        videoView.start();
    }

    private void startMainAndFinish() {
        try {
            startActivity(new Intent(SplashVideoActivity.this, MainActivity.class));
        } catch (Exception e) {
            Log.e(TAG, "Failed to start MainActivity", e);
        } finally {
            finish();
        }
    }
}
